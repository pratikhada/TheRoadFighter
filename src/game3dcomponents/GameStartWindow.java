package game3dcomponents;

import theroadfighter.*;
import java.io.IOException;
import javax.swing.JButton;
import java.awt.event.*;
import javax.swing.Timer;
import com.sun.j3d.utils.picking.*;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GraphicsConfiguration;
import com.sun.j3d.utils.geometry.*;
import com.sun.j3d.utils.applet.MainFrame;
import com.sun.j3d.utils.universe.*;
import javax.media.j3d.*;
import javax.vecmath.*;
import java.awt.image.BufferedImage;
import javax.swing.JApplet;
import java.applet.AudioClip;


public class GameStartWindow extends JApplet implements ActionListener, KeyListener
{
    MainFrame fm;
    SimpleUniverse universe;
    BranchGroup scene;
    //for our car
    private TransformGroup myCarTransformG;
    //BranchGroup that contains all the road scenes except my car
    private BranchGroup roadScene;
    roadobjects.RoadObjects roadObjects;
    //to add other cars in the scene
    private TransformGroup otherCarsTransformG[];
    private BranchGroup otherCarsFather[];
    private BranchGroup otherCarsSon[];
    private BranchGroup otherCars[];
    boolean isCarInScene[];

    //for objects in meter
    private BranchGroup meterFather,meterSon,meterText;
    boolean isMeterInScene=false;
    int speedC=0;
    
    //for objects in map       
    private BranchGroup mapFather,mapSon;
    private TransformGroup carInMapG[];
    boolean isMapInScene=false;
    //mirror
    private BranchGroup mirrorFather,mirrorSon;
    private Mirror mirror;
  //  private TransformGroup mirrorTrans;
    //control variables
    private float maxVel,velocity,acc,rotAngle=0.0f,roatSensitivity;
    private int forwardPressed,rightPressed,signalCount=3;
    private PickTool picker;
    private PickResult picked;
    private Point3d pickStart;
    private Vector3d down;
    private boolean starting,frontView,isOption;
    private StartingInfo startInfo[];
    private BranchGroup optionBG;
    private  Text2D text[];
    private PickCanvas pickCanvas;
    private Canvas3D eyeCanvas,mirrorCanvas;
    private ViewingPlatform mirrorPlatform,cameraPlatform;    
    private TransformGroup staticTrans;
    private Vector3f cDir=new Vector3f();
    private OutsideBoundary collision[]; 
    private int countC=10;
    private Timer mirrorRender,timer;
    private ChooseOptions chooseOptions;
    private AudioClip startSound, slowSound,
            fastSound,idleSound, collisionSound,otherCarSound;
    private boolean isFastSound=false,isOtherCarSound=false,
            isCollisionSound=false;
    //for lap
    private BranchGroup lapB,lapFather;
    private int prev_lap=-1;
    public int lap=-1;
    private boolean isGoingForward;


    public GameStartWindow(StartingInfo [] sInfo) {
        System.gc();
        roadObjects = new roadobjects.RoadObjects();
        starting=false;
        frontView=false;
        rotAngle=0.0f;
        startInfo=sInfo;
        startInfo[0].collided=false;
        chooseOptions=new ChooseOptions();
        for(int i=0; i<4; i++)
            chooseOptions.capabilities[i]=sInfo[0].chooseOptions.capabilities[i];
        if(startInfo[0].difficulty.equals("EASY"))
            {
                roatSensitivity =3.0f;
                acc=0.01f;
                maxVel=0.1f;
            }
        else if(startInfo[0].difficulty.equals("MEDIUM"))
        {
            roatSensitivity =2.5f;
            acc=0.04f;
            maxVel=0.6f;
        }
        else
        {
            roatSensitivity =3.0f;
            acc=0.04f;
            maxVel=0.88f;
        }
        velocity=0.0f;
        forwardPressed=0;
        rightPressed=0;
        pickStart=new Point3d(0.0,0.2,0.0);
        down=new Vector3d(0.0, -1.0f, 0.0) ;
        mirrorPlatform =new ViewingPlatform();
        prepareOptions();
        initiateOutsideBoundary();
        //load the sounds                  
        startSound=newAudioClip(getClass().getResource("Sounds/startSound.wav"));
        slowSound=newAudioClip(getClass().getResource("Sounds/slowSound.wav"));
        fastSound=newAudioClip(getClass().getResource("Sounds/fastSound.wav"));
        idleSound=newAudioClip(getClass().getResource("Sounds/idle.wav"));
        collisionSound=newAudioClip(getClass().getResource("Sounds/crash.wav"));
        otherCarSound=newAudioClip(getClass().getResource("Sounds/otherCarSound.wav"));
    }


   public void prepareOptions()
    {
       optionBG=new BranchGroup();
       optionBG.setCapability(BranchGroup.ALLOW_DETACH);

       Color3f color=new Color3f(0.27f,0.22f,0.55f);
       text =new Text2D[5];
       text[0]= new Text2D("RESUME",color,"SansSerif",100,Font.BOLD);
       text[1]= new Text2D("DROP THE GAME",color,"SansSerif",100,Font.BOLD);
       text[2]= new Text2D("OPTION",color,"SansSerif",100,Font.BOLD);
     //  text[3]= new Text2D("QUIT",color,"SansSerif",100,Font.BOLD);
       if(startInfo[0].whoAmI.equals("SERVER"))
           text[3]= new Text2D("RESTART GAME",color,"SansSerif",100,Font.BOLD);
       else
           text[3]=null;

       for(int i=0;i<=3;i++)
       {
            if(i==3 && startInfo[0].whoAmI.equals("CLIENT"))
                break;
            Transform3D t3d=new Transform3D();
            t3d.setScale(0.2f);
            t3d.setTranslation(new Vector3d(-0.8f,(3-i)*0.1f, 2.5f));
            TransformGroup tg1 = new TransformGroup();
            tg1.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
            tg1.setTransform(t3d);
            tg1.addChild(text[i]);
            optionBG.addChild(tg1);
         }
    }

    
      private void setCameraView()
     {
        Transform3D locator = new Transform3D();
        Vector3d dir=new Vector3d();
        double k=4.0,x1,y1,z1,a,b,c;
        x1=startInfo[0].mePlayer.position.x;
        y1=startInfo[0].mePlayer.position.y;
        z1=startInfo[0].mePlayer.position.z;
        a=startInfo[0].mePlayer.direction.x;
        b=startInfo[0].mePlayer.direction.y;
        c=startInfo[0].mePlayer.direction.z;
        double u=Math.sqrt(a*a+b*b+c*c);
        a/=u;
        b/=u;
        c/=u;
        a=(a+2*cDir.x)/3;
        b=(b+2*cDir.y)/3;
        c=(c+2*cDir.z)/3;
        Point3d eye_pos=new Point3d();
        Point3d view_pos=new Point3d();
        if(isOption==true)
        {
            a=b=0.0f; c=-1f;
            x1=-0.9f; y1=-0.28f;z1=1.0f;
        }
        if(frontView ==true && isOption==false)
        {
            eye_pos.set(x1-a*0.8,y1+0.4-b,z1-c*0.8);
            view_pos.set(x1+k*a-a,y1+k*b-b,z1+k*c-c);
        }
        else
        {
            eye_pos.set(x1-k*a,y1-k*b+0.7,z1-k*c);
            view_pos.set(x1,y1+0.1f,z1);
        }
        dir.set(a,b,c);
        locator.lookAt(eye_pos,view_pos, dir);
        try{
            locator.invert();
            cameraPlatform.getViewPlatformTransform().setTransform(locator);
            staticTrans.setTransform(locator);
        }catch(SingularMatrixException ex){}
        if(countC>3 && isOption==false)
        {
            cDir.set(new Vector3f(dir));
            countC=0;
        }
        countC++;
    }

    
    public void setMirrorCameraView()
    {
        mirrorRender=new Timer(600,
            new ActionListener()
            {
                public void actionPerformed(ActionEvent evt)
                {
                    if(signalCount>0)
                        return;
                    Point3d eye_pos=new Point3d();
                    Point3d view_pos=new Point3d();
                    Vector3d dir=new Vector3d();
                    double k=4.0,x1,y1,z1,a,b,c;
                    x1=startInfo[0].mePlayer.position.x;
                    y1=startInfo[0].mePlayer.position.y;
                    z1=startInfo[0].mePlayer.position.z;
                    a=startInfo[0].mePlayer.direction.x;
                    b=startInfo[0].mePlayer.direction.y;
                    c=startInfo[0].mePlayer.direction.z;
                    double u=Math.sqrt(a*a+b*b+c*c);
                    a/=u; b/=u; c/=u;
                 //   a=-a;b=-b; c=-c;
                    dir.set(a,b,c);
                    eye_pos.set(x1+k*a,y1-0.25+k*b,z1+k*c);
                    view_pos.set(x1,y1-0.3,z1);
                    dir.negate();
                    Transform3D locator=new Transform3D();
                    locator.invert();
                    locator.lookAt(eye_pos, view_pos, dir);
                    mirrorPlatform.getViewPlatformTransform().setTransform(locator);
                    mirrorCanvas.renderOffScreenBuffer();
                    mirrorCanvas.waitForOffScreenRendering();
                    mirror.changeGraphics(mirrorCanvas);
                    try{
                        Thread.sleep(5);
                    }catch(InterruptedException ex){}
                }
            }
        );
            mirrorRender.start();
    }
    private BranchGroup createSceneGraph() {

        BranchGroup objRoot = new BranchGroup();

        roadScene=new BranchGroup();
        roadScene.setCapability(BranchGroup.ALLOW_CHILDREN_EXTEND);
        roadScene.setCapability(BranchGroup.ALLOW_CHILDREN_WRITE);
        objRoot.addChild(roadScene);
        
        roadScene.addChild(roadObjects.road); //add road to scenegraph
        roadScene.addChild(roadObjects.roadSide);
        roadScene.addChild(roadObjects.roadStart);
        roadScene.addChild(roadObjects.roadBridge);
        roadScene.addChild(roadObjects.roadBoundary);
        roadScene.addChild(roadObjects.roadtree);
      //  roadScene.addChild(TextWriter.textTitle());
        roadScene.addChild(roadObjects.roadillu);
        roadScene.addChild(roadObjects.roadcoke);
        roadScene.addChild(roadObjects.roadbase);
        roadScene.addChild(roadObjects.roadhill);
        roadScene.addChild(roadObjects.roadaud);
        roadScene.addChild(roadObjects.roadpole);
        roadScene.addChild(roadObjects.roadslope);
        roadScene.addChild(roadObjects.roadbush);


        //scene for other cars
        sceneForOtherCars();

        //for our car
        myCarTransformG= new TransformGroup();
        myCarTransformG.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        objRoot.addChild(myCarTransformG);

        BoundingSphere bounds = new BoundingSphere(new Point3d(0.0f, 0.0f, 0.0f), 
                Double.MAX_VALUE);
        
        Group myCar=new LoadTheCarShape("TSUPRA/tsupra.obj");
        myCarTransformG.addChild(myCar);

        //set initial transformation of  myCar
        Vector3f vect=new Vector3f(startInfo[0].mePlayer.direction);
        Point3f pos=new Point3f(startInfo[0].mePlayer.position);
        try{
            myCarTransformG.setTransform(TransformHelpClass.performTransform(vect, pos));
          }
        catch(BadTransformException exc){}

        //light
        //ambient light
        Color3f ambientColor = new Color3f(1.0f, 1.0f, 0.9f);//(0.1f, 0.1f, 0.1f);
        AmbientLight ambientLightNode = new AmbientLight(ambientColor);
        ambientLightNode.setInfluencingBounds(bounds);
        objRoot.addChild(ambientLightNode);
        Color3f lightColor = new Color3f(1.0f, 0.0f, 0.2f);
        Vector3f lightDirection = new Vector3f(0.0f, 1.0f, -1.0f);
        DirectionalLight drLight = new DirectionalLight(lightColor, lightDirection);
        drLight.setInfluencingBounds(bounds);
        objRoot.addChild(drLight);

        objRoot.setPickable(true);
        objRoot.setCapability(BranchGroup.ALLOW_PICKABLE_READ);
        objRoot.setCapability(BranchGroup.ALLOW_COLLIDABLE_READ);        

        BackGround bg=new BackGround();
        Background bkg=bg.createBackGround();
        bkg.setApplicationBounds(bounds);
        objRoot.addChild(bkg);
        return objRoot;
      }

    private void sceneForOtherCars()
    {
        otherCarsTransformG=new TransformGroup[startInfo[0].maxNoOfPlayer];
        otherCarsFather=new BranchGroup[startInfo[0].maxNoOfPlayer];
        otherCarsSon=new BranchGroup[startInfo[0].maxNoOfPlayer];
        otherCars=new BranchGroup[startInfo[0].maxNoOfPlayer];
        isCarInScene=new boolean[startInfo[0].maxNoOfPlayer];
        for(int i=0; i<isCarInScene.length; i++)
            isCarInScene[i]=false;

        for(int i=0; i<startInfo[0].maxNoOfPlayer;i++)
        {
            if(i!=startInfo[0].id)
            {
                otherCarsTransformG[i]=new TransformGroup();
                otherCarsTransformG[i].setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
                roadScene.addChild(otherCarsTransformG[i]);
             
                otherCarsFather[i]=new BranchGroup();
                otherCarsFather[i].setCapability(BranchGroup.ALLOW_PICKABLE_READ);
                otherCarsFather[i].setCapability(BranchGroup.ALLOW_CHILDREN_EXTEND);
                otherCarsFather[i].setCapability(BranchGroup.ALLOW_CHILDREN_WRITE);
                otherCarsTransformG[i].addChild(otherCarsFather[i]);                
            }
        }
    }


    private void createPlayerCars(int i)
    {        
        otherCars[i]=new LoadTheCarShape("TSUPRA/tsupra.obj");
        otherCarsSon[i]=new BranchGroup();
        otherCarsSon[i].setCapability(BranchGroup.ALLOW_DETACH);
        otherCarsSon[i].setCapability(BranchGroup.ALLOW_CHILDREN_WRITE);
        otherCarsSon[i].setCapability(BranchGroup.ALLOW_CHILDREN_EXTEND);
        otherCarsSon[i].addChild(otherCars[i]);
        otherCarsFather[i].addChild(otherCarsSon[i]);
        isCarInScene[i]=true;

        //set initial transforms
        Transform3D temp1=new Transform3D();
        temp1.setTranslation(new Vector3f(startInfo[0].player[i].position));
        otherCarsTransformG[i].setTransform(temp1);
        
    }
    
    private boolean isOnlyOnePlayer()
    {
        boolean one=true;
        for(int i=1; i<startInfo[0].maxNoOfPlayer; i++)
            if(startInfo[0].player[i].isParticipated==true)
            {
                one=false;
                break;
            }
        return one;
    }

    private void initialSetup()
    {
            for(int i=0; i<startInfo[0].maxNoOfPlayer; i++)
            {
                 if(i!=startInfo[0].id && isCarInScene[i]==false
                        && startInfo[0].player[i].isReady==true)
                 {
                      createPlayerCars(i);
                 }
            }

            if(startInfo[0].player[startInfo[0].id].isStart==false)
                startInfo[0].player[startInfo[0].id].isStart=true;
            if(isOnlyOnePlayer())
                startInfo[0].isGameStarted=true;
            if(startInfo[0].isGameStarted==true)
            {
                starting=true;
                setMirrorCameraView();
            }
    }

   
    public void startGame()
    {
        setLayout(new BorderLayout());
        GraphicsConfiguration config =
        SimpleUniverse.getPreferredConfiguration();

        //create online camera and simpleuniverse
        eyeCanvas = new Canvas3D(config);
        Viewer viewer = new Viewer(eyeCanvas);
        cameraPlatform=new ViewingPlatform(ViewingPlatform.ALLOW_CHILDREN_WRITE);
        cameraPlatform.setCapability(ViewingPlatform.ALLOW_CHILDREN_EXTEND);
        cameraPlatform.getViewPlatformTransform().setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);        
        staticTrans=new TransformGroup();
        staticTrans.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        mapFather=new BranchGroup();                              
        mapFather.setCapability(BranchGroup.ALLOW_CHILDREN_EXTEND);
        mapFather.setCapability(BranchGroup.ALLOW_CHILDREN_WRITE);
        staticTrans.addChild(mapFather);
        mirrorFather=new BranchGroup();
        mirrorFather.setCapability(BranchGroup.ALLOW_CHILDREN_EXTEND);
        mirrorFather.setCapability(BranchGroup.ALLOW_CHILDREN_WRITE);        
        staticTrans.addChild(mirrorFather);
        meterFather=new BranchGroup();                                //;;;;;;;;;
        meterFather.setCapability(BranchGroup.ALLOW_CHILDREN_EXTEND);
        meterFather.setCapability(BranchGroup.ALLOW_CHILDREN_WRITE);
        staticTrans.addChild(meterFather);
        lapFather=new BranchGroup();
        lapFather.setCapability(BranchGroup.ALLOW_CHILDREN_EXTEND);
        lapFather.setCapability(BranchGroup.ALLOW_CHILDREN_WRITE);
        staticTrans.addChild(lapFather);
        cameraPlatform.addChild(staticTrans);
        universe = new SimpleUniverse(cameraPlatform,viewer);
        add( eyeCanvas);
        
        
        mirrorCanvas= new Canvas3D(config,true); // true is off-line
        BufferedImage bImage=new BufferedImage(200,170,BufferedImage.TYPE_INT_RGB);
               ImageComponent2D imComp=new ImageComponent2D(ImageComponent2D.FORMAT_RGB,
                     bImage,true, false);
        imComp.setCapability(ImageComponent2D.ALLOW_IMAGE_READ);
        mirrorCanvas.getScreen3D().setSize(1280, 1024);
        mirrorCanvas.getScreen3D().setPhysicalScreenWidth(0.36124);
        mirrorCanvas.getScreen3D().setPhysicalScreenHeight(0.28899555);
        mirrorCanvas.setOffScreenBuffer(imComp);  
        eyeCanvas.addKeyListener(this);

        pickCanvas = new PickCanvas(eyeCanvas, optionBG);
        pickCanvas.setMode(PickCanvas.BOUNDS);

         eyeCanvas.addMouseListener(
                new MouseListener()                
                {
                    public void  mouseClicked(MouseEvent e)
                    {
                        if(isOption==true)
                        {
                            PickResult result;
                            try{
                                pickCanvas.setShapeLocation(e);
                                result = pickCanvas.pickClosest();
                                Shape3D s = (Shape3D)result.getNode(PickResult.SHAPE3D);
                                if (s != null)
                                    if((s.getClass().getSimpleName()).equals("Text2D"))
                                    {
                                        int y=(int)(e.getY()*758.0/fm.getHeight());
                                        if(y<=225)
                                            fm.setTitle("game resumed");
                                        else if(y>225 && y<=270)
                                        {
                                            fm.setTitle("dropped");
                                            startInfo[0].mePlayer.isDropped=true;
                                        }
                                        else if(y>270 && y<=325)
                                        {
                                            chooseOptions.clickOk();
                                        }
                                        else if(y>325 && y<=375)
                                        {
                                            if(startInfo[0].whoAmI.equals("SERVER"))
                                                startInfo[0].player[startInfo[0].id].isReady=false;
                                            //startInfo[0].mePlayer.isParticipated=false;
                                        }
                                        else
                                        {
                                            if(startInfo[0].whoAmI.equals("SERVER"))
                                                startInfo[0].player[startInfo[0].id].isReady=false;
                                        }
                                        isOption=false;
                                        optionBG.detach();
                                    }
                            }catch(NullPointerException ex) { }
                       }
                    }

                    public void mousePressed( MouseEvent event ){}
                    public void mouseReleased( MouseEvent event ){}
                    public void mouseEntered( MouseEvent event )
                    {
                        if(fm.getWidth()!=1.38889*fm.getHeight())
                            fm.setSize((int)(fm.getHeight()*1.38889), fm.getHeight());
                    }
                    public void mouseExited( MouseEvent event ){}
        });


        JButton but = new JButton("Control Keys: a,s,d,f,c,o");
        add("North", but);
        timer = new Timer(60, this);
        timer.start();
        but.addActionListener(this);
        but.addKeyListener(this);

        View uView=universe.getViewer().getView();
        View view=new View();
        view.setPhysicalBody(uView.getPhysicalBody());
        view.setPhysicalEnvironment(uView.getPhysicalEnvironment());
        Viewer mirrorViewer =new Viewer(mirrorCanvas);
        mirrorViewer.setViewingPlatform(mirrorPlatform);
        
        Locale locale=new Locale(universe);
        scene = createSceneGraph();
        scene.setPickable(true);
        scene.setCapability(BranchGroup.ALLOW_PICKABLE_READ);
        scene.setCapability(BranchGroup.ALLOW_CHILDREN_EXTEND);
        scene.setCapability(BranchGroup.ALLOW_CHILDREN_WRITE);
        //picking the road coordinates
        picker = new PickTool(scene);
        picker.setMode(PickTool.GEOMETRY_INTERSECT_INFO);
        picker.setCapabilities(roadObjects.road, PickTool.INTERSECT_FULL);
        picker.setShapeRay(pickStart, down);

        locale.addBranchGraph(scene);
        locale.addBranchGraph(mirrorPlatform);
        cDir.set(new Vector3f(startInfo[0].player[startInfo[0].id].direction));
        setCameraView();
        fm=new MainFrame(this, 1000,720);
        fm.setTitle(startInfo[0].whoAmI);
        //   fm.setResizable(false);
       // fm.setAlwaysOnTop(true);
    }


     private void giveSignalToStart()
      {
        BranchGroup text=new BranchGroup();
        text.setCapability(BranchGroup.ALLOW_DETACH);
        switch(signalCount)
        {
            case 3:
                text.addChild(TextWriter.startSignal("READY",
                new Vector3f(0.0f,0.4f,-5.0f)));
                break;
            case 2:
                text.addChild(TextWriter.startSignal(String.valueOf(signalCount),
                new Vector3f(0.0f,0.4f,-5.0f)));
                break;
            case 1:
                text.addChild(TextWriter.startSignal(String.valueOf(signalCount),
                new Vector3f(0.0f,0.4f,-5.0f)));
                break;
            case 0:
                text.addChild(TextWriter.startSignal("GO", new Vector3f(0.0f,0.4f,-5.0f)));
                break;
        }
        if(signalCount==3)
        {
           try{Thread.currentThread().sleep(3000);}catch(InterruptedException exc){}
           if(chooseOptions.capabilities[3])
           {
                startSound.loop();
           }
        }
        scene.addChild(text);
        try{Thread.currentThread().sleep(1000);}catch(InterruptedException exc){}
        text.detach();
        if(signalCount==0)
            startSound.stop();
        signalCount--;
    }

      private void moveMyCar()
       {
        //compute direction and previous points
         if(startInfo[0].mePlayer.prev_position.distance(startInfo[0].mePlayer.position)>0.1f
                && velocity!=0.0f)
          {
            float sign= velocity/Math.abs(velocity);
            sign=sign/Math.abs(sign);
            startInfo[0].mePlayer.direction=new Vector3f(
                    sign*(startInfo[0].mePlayer.position.x-startInfo[0].mePlayer.prev_position.x),
                    sign*(startInfo[0].mePlayer.position.y-startInfo[0].mePlayer.prev_position.y),
                    sign*(startInfo[0].mePlayer.position.z-startInfo[0].mePlayer.prev_position.z)
           );
            startInfo[0].mePlayer.prev_position.x=startInfo[0].mePlayer.position.x;
            startInfo[0].mePlayer.prev_position.y=startInfo[0].mePlayer.position.y;
            startInfo[0].mePlayer.prev_position.z=startInfo[0].mePlayer.position.z;
        }

         //detect depth of the road
         pickStart.x=startInfo[0].mePlayer.position.x;
         pickStart.y=startInfo[0].mePlayer.position.y;
         pickStart.z=startInfo[0].mePlayer.position.z;
         if(pickStart.z > 100 && pickStart.z<425
                 && pickStart.x>-2.0 && pickStart.x<2.0)
           {
                picker.setShapeRay(pickStart, down);
                try{
                    picked=picker.pickClosest();
                    PickIntersection intersect = picked.getIntersection(0);
                    Point3d nextpoint = intersect.getPointCoordinatesVW();
                    double pickY = (pickStart.y)-0.12;
                    if (nextpoint != null)
                    {
                        if(nextpoint.y != pickY && Math.abs(nextpoint.y-pickY)< 0.1f
                            && Math.abs(nextpoint.y-pickY)> 0.05f)
                            startInfo[0].mePlayer.position.y= (float)nextpoint.y+0.12f;
                    }
                } catch( NullPointerException exc){}
         }
         else startInfo[0].mePlayer.position.y=-0.28f;


            //calculate velocity
            if(forwardPressed==0)
            {
                if(velocity>0.1f)
                    velocity-=acc/4.0f;
                else if(velocity<-0.1f)
                    velocity+=acc/2.0f;
                else velocity=0.0f;
            }
            else if(Math.abs(velocity)<maxVel)
            {
                if(forwardPressed==1)
                {
                    if(velocity>0)
                        velocity+= forwardPressed*acc;
                    else
                       velocity+= forwardPressed*acc*1.5;
                }
                if(forwardPressed==-1)
                {
                    if(velocity>0)
                        velocity+= forwardPressed*acc*1.5;
                    else if(Math.abs(velocity) < maxVel/1.5f)
                       velocity+= forwardPressed*acc*0.5;
                }
            }

            //calculate new position
            if(Math.abs(velocity)>0.05f)
            {
                rotAngle -= rightPressed*velocity*roatSensitivity/Math.abs(velocity);
                if(rotAngle>360) rotAngle-=360.0f;
                if(rotAngle<-360.0f) rotAngle+=360.0f;
                startInfo[0].mePlayer.position.x-=velocity*Math.sin(Math.toRadians(rotAngle));
                startInfo[0].mePlayer.position.z-=velocity*Math.cos(Math.toRadians(rotAngle));
            }
            if(startInfo[0].mePlayer.isDropped==false)
            {
                collisionDetectCorrect();
                startInfo[0].player[startInfo[0].id]=startInfo[0].mePlayer;
                Vector3f vect=new Vector3f(startInfo[0].mePlayer.direction);
                Point3f pos=new Point3f(startInfo[0].mePlayer.position);
                myCarTransformG.setTransform(TransformHelpClass.performTransform(vect, pos));
            }
            setCameraView();

     }
     
     
    private void moveOtherCars()
    {
        for(int i=0; i<startInfo[0].maxNoOfPlayer; i++)
        {
            if(i!=startInfo[0].id && startInfo[0].player[i].isReady==true)
              {
                if(startInfo[0].player[i].isDropped==true || startInfo[0].player[i].isParticipated ==false)
                 {
                    otherCarsSon[i].detach();
                    startInfo[0].player[i].isReady=false;
                    isCarInScene[i]=false;
                    if(startInfo[0].player[i].isParticipated ==false)
                        startInfo[0].player[i]=null;
                  }
                  else
                {
                Vector3f direct=new Vector3f(startInfo[0].player[i].direction);
                Point3f pos=new Point3f(startInfo[0].player[i].position);
                otherCarsTransformG[i].setTransform(TransformHelpClass
                        .performTransform(direct,pos));
                
                if(pos.distance(startInfo[0].mePlayer.position)<30
                        && chooseOptions.capabilities[3]==true && isOtherCarSound==false)
                    {
                        otherCarSound.loop();
                        isOtherCarSound=true;
                    }
                    else
                    {
                        otherCarSound.stop();
                        isOtherCarSound=false;
                    }
                }
            }
        }
    }

       public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == e.VK_LEFT || e.getKeyChar()=='a')
            rightPressed=-1;
        if (e.getKeyChar() == e.VK_RIGHT || e.getKeyChar()=='d')
            rightPressed=1;
        if (e.getKeyChar() == e.VK_UP || e.getKeyChar()=='w')
            forwardPressed=1;
        if (e.getKeyChar() == e.VK_DOWN || e.getKeyChar()=='s')
            forwardPressed=-1;
        if (e.getKeyChar() == 'c' )
        {
             if(frontView==false)
                 frontView=true;
             else frontView=false;
             setCameraView();
        }
        if(e.getKeyChar() == 'o')
        {
            if(isOption==false)
            {
                scene.addChild(optionBG);
                isOption=true;
                setCameraView();
            }
        }
    }

    public void keyReleased(KeyEvent e)
    {
        if((e.getKeyChar()=='w' || e.getKeyChar()=='s'))
            forwardPressed=0;
        if((e.getKeyChar()=='a' || e.getKeyChar()=='d') )
            rightPressed=0;
    }

    public void keyTyped(KeyEvent e) {}

   public void actionPerformed(ActionEvent e) {
        System.gc();
        if(!timer.isRunning())
        {
            return;
        }
       // if(starting==true && startInfo[0].player[startInfo[0].id].isParticipated==false)
          //  quitGame();
       // else
        if(starting==true && startInfo[0].player[startInfo[0].id].isReady==false)
            restartGame();
        else if(starting==false)
            initialSetup();
        else if(signalCount>=0)
        {
            giveSignalToStart();
            if(chooseOptions.capabilities[0]==true && mirrorRender.isRunning()==false)
                mirrorRender.restart();
            else if(chooseOptions.capabilities[0]==false && mirrorRender.isRunning()==true)
                mirrorRender.stop();
        }
        else
        {
             for(int i=0; i<startInfo[0].maxNoOfPlayer; i++)
            {
                if(i!=startInfo[0].id && isCarInScene[i]==false
                        && startInfo[0].player[i].isReady==true)
                {
                    createPlayerCars(i);
                }
            }
            moveOtherCars();
            moveMyCar();
            lapcount();

            //manage sound
            if(chooseOptions.capabilities[3]==true)
            {
                if(Math.abs(velocity)>maxVel/2.0f && isFastSound==false)
                {
                    fastSound.loop();
                    slowSound.stop();
                    isFastSound=true;
                }
                else if(Math.abs(velocity)==0)
                {
                    fastSound.stop();
                    slowSound.stop();
                    idleSound.play();
                }
                else if(Math.abs(velocity)<=maxVel/2.0f && isFastSound==true)
                {
                    slowSound.loop();
                    fastSound.stop();
                    isFastSound=false;
                }
            }

                //manage map
            if(isMapInScene==false && chooseOptions.capabilities[1]==true)
            {
                behaveMap('c');
                isMapInScene=true;
            }
            else if(isMapInScene==true && chooseOptions.capabilities[1]==false)
            {
                behaveMap('d');
                isMapInScene=false;
            }
            else if(chooseOptions.capabilities[1]==true)
                behaveMap('m');
                
                 //manage mirror
            if(chooseOptions.capabilities[0]==true && mirrorRender.isRunning()==false)
                behaveMirror('c');
            else if(chooseOptions.capabilities[0]==false && mirrorRender.isRunning()==true)
                behaveMirror('d');

            //for showing meter
            if(isMeterInScene==true && chooseOptions.capabilities[2]==true)
            {
                behaveMeter('m');
            }
            else if(isMeterInScene==false && chooseOptions.capabilities[2]==true)
            {
                behaveMeter('c');
                isMeterInScene=true;
            }
            else if(isMeterInScene==true && chooseOptions.capabilities[2]==false)
            {
                behaveMeter('d');
                isMeterInScene=false;
            }
        }

    }

    private void quitGame()
    {
        System.gc();
        fm.setTitle("quiting");
        try{
            if(isOnlyOnePlayer() && startInfo[0].server[0].isClosed()==false)
                try {
                    startInfo[0].server[0].close();
                } catch (IOException ex) { }
        }catch(NullPointerException ex){}
        startInfo[0].mePlayer.isParticipated=false;
        timer.stop();
        mirrorRender.stop();
        try {
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException ex) {}

        starting=false;
        for(int i=0; i<startInfo[0].maxNoOfPlayer; i++)
            startInfo[0].player[i]=null;
        RoadFighter roadFighter=new RoadFighter();
        roadFighter.mainFrame= new MainFrame(roadFighter,1000,720);
        roadFighter.mainFrame.setAlwaysOnTop(true);
        roadFighter.mainFrame.setResizable(false);
        roadFighter.mainFrame.setTitle("The Road Fighter - a car race");
        fm.dispose();
    }

    private void restartGame()
    {
        System.gc();
        if(isOnlyOnePlayer())
        {
            startInfo[0].mePlayer.direction=new javax.vecmath.Vector3f(0.0f,0.0f,-1.0f);
            startInfo[0].mePlayer.position=new
                javax.vecmath.Point3f(-0.9f,-0.28f,1);
            startInfo[0].mePlayer.prev_position=new
                javax.vecmath.Point3f(-0.9f,-0.28f,2);
            startInfo[0].player[0].isParticipated=true;
            startInfo[0].player[0].isDropped=false;
        }
        signalCount=3;
        countC=10;
        starting=false;
        frontView=false;
        rotAngle=0.0f;
        velocity=0.0f;
        forwardPressed=0;
        rightPressed=0;
        isOption=false;
        cDir.set(new Vector3f(startInfo[0].player[startInfo[0].id].direction));
        startInfo[0].mePlayer.isReady=true;
        fm.setTitle("restarted");
        setCameraView();
    }


    //class defining boundary at which the car shouldn't go
    private class OutsideBoundary
    {
        public float minX,maxX, minZ, maxZ;

        public OutsideBoundary()
        {
            minX=minZ=-200;
            maxX=maxZ=500;
        }
    }

   private void initiateOutsideBoundary()
    {
        collision=new OutsideBoundary[14];
        for(int i=0; i<14;i++) collision[i]=new OutsideBoundary();
        //first boundary
        collision[0].maxZ=-115;
        //second
        collision[1].minX=321;
        //third
        collision[2].maxX=-54;
        //fourth
        collision[3].minZ=430;
        //fifth
        collision[4].minX=1.8f;
        collision[4].minZ=211.5f;
        //sixth
        collision[5].maxX=-3.6f;
        collision[5].maxZ=205;
        //seventh
        collision[6].maxX=-1.8f;
        collision[6].minZ=95;
        collision[6].maxZ=205;
        //eighth
        collision[7].minX=3.6f;
        collision[7].maxX=315;
        collision[7].minZ=-103f;
        collision[7].maxZ=95;
        //ninth
        collision[8].minX=1.8f;
        collision[8].maxX=305;
        collision[8].minZ=95;
        collision[8].maxZ=205;
        //tenth
        collision[9].minX=-44;
        collision[9].maxX=-1.8f;
        collision[9].minZ=212;
        collision[9].maxZ=423;
        //eleventh
        collision[10].minX=-1.8f;
        collision[10].maxX=1.8f;
        collision[10].minZ=200;
        collision[10].maxZ=207.09f;
        //twelvth
        collision[11].minX=-1.8f;
        collision[11].maxX=1.8f;
        collision[11].minZ=210.68f;
        collision[11].maxZ=212;
        //thirteenth
        collision[12].maxX=-1.8f;
        //fourteenth
        collision[13].minX=1.8f;

    }

    private void collisionDetectCorrect()
    {
        boolean collided=false;
        float x_comp[]=new float[4],z_comp[]=new float[4];
        float xMe=startInfo[0].mePlayer.position.x;
        float zMe=startInfo[0].mePlayer.position.z;
        float aMe=(float)(startInfo[0].mePlayer.direction.x/
                Math.sqrt(Math.pow(startInfo[0].mePlayer.direction.x, 2)+
                Math.pow(startInfo[0].mePlayer.direction.y, 2)+
                Math.pow(startInfo[0].mePlayer.direction.z, 2)));
        float cMe=(float)(startInfo[0].mePlayer.direction.z/
                Math.sqrt(Math.pow(startInfo[0].mePlayer.direction.x, 2)+
                Math.pow(startInfo[0].mePlayer.direction.y, 2)+
                Math.pow(startInfo[0].mePlayer.direction.z, 2)));
        float w=0.5f,l=1f;

        x_comp[0]=xMe-(w+l)/4;
        z_comp[0]=zMe-(w+l)/4;
        x_comp[1]=xMe+(w+l)/4;
        z_comp[1]=zMe-(w+l)/4;
        x_comp[2]=xMe+(w+l)/4;
        z_comp[2]=zMe+(w+l)/4;
        x_comp[3]=xMe-(w+l)/4;
        z_comp[3]=zMe+(w+l)/4;

        //check Boundaries
        if(startInfo[0].mePlayer.position.y!=-0.28f)
            for(int i=12; i<=13; i++)
            {
                for(int c=0; c<4; c++)
                    if(x_comp[c]>=collision[i].minX && x_comp[c]<=collision[i].maxX )
                        if(z_comp[c]>=collision[i].minZ && z_comp[c]<=collision[i].maxZ )
                        {
                            collided=true;
                            break;
                        }
                if(collided==true)
                    break;
            }
        else
            for(int i=0; i<=11; i++)
            {
                for(int c=0; c<4; c++)
                    if(x_comp[c]>=collision[i].minX && x_comp[c]<=collision[i].maxX )
                        if(z_comp[c]>=collision[i].minZ && z_comp[c]<=collision[i].maxZ )
                        {
                            collided=true;
                            break;
                        }
                if(collided==true)
                    break;
            }

        //check other moving cars
        if(collided==false)
            for(int v=0; v<startInfo[0].maxNoOfPlayer; v++)
            {
                float temp=(w+l)/4;

                if(v!=startInfo[0].id && isCarInScene[v]==true)
                    for(int c=0; c<4; c++)
                        if(x_comp[c]>=(startInfo[0].player[v].position.x-temp)
                        && x_comp[c]<=(startInfo[0].player[v].position.x+temp) )
                            if(z_comp[c]>=(startInfo[0].player[v].position.z-temp)
                            && z_comp[c]<=(startInfo[0].player[v].position.z+temp))
                            { collided=true; break;}

                if(collided==true)
                    break;
            }

        if(collided==true)
        {
            if(chooseOptions.capabilities[3] && isCollisionSound==false)
            {
                collisionSound.play();
                isCollisionSound=true;
            }
            startInfo[0].mePlayer.position.x=startInfo[0].mePlayer.prev_position.x;
            startInfo[0].mePlayer.position.y=startInfo[0].mePlayer.prev_position.y;
            startInfo[0].mePlayer.position.z=startInfo[0].mePlayer.prev_position.z;
        }
        else
        {
            collisionSound.stop();
            isCollisionSound=false;
        }
    }

    private void behaveMap(char c)
    {
        if(c=='c')     //that is to create map
        {
            mapSon=new BranchGroup();
            carInMapG=new TransformGroup[startInfo[0].maxNoOfPlayer];
            mapSon.setCapability(BranchGroup.ALLOW_DETACH);
            for(int i=0; i<startInfo[0].maxNoOfPlayer; i++)
            {
                if(startInfo[0].player[i].isReady==true)
                {
                    carInMapG[i]=new TransformGroup();
                    carInMapG[i].setCapability(TransformGroup.ALLOW_CHILDREN_WRITE);
                    carInMapG[i].setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
                    carInMapG[i].addChild(new ColorCube(0.005f));
                    Transform3D t3d=new Transform3D();
                    t3d.setTranslation(new Vector3f
                            (0.42f+startInfo[0].player[i].position.x*0.06f/121,
                            0.34f-startInfo[0].player[i].position.z*0.06f/121,
                            -1.5005f));
                    carInMapG[i].setTransform(t3d);
                    mapSon.addChild(carInMapG[i]);
                }
            }
            Mirror mirr=new Mirror();
            mapSon.addChild(mirr.roadMapPlot());
            mapFather.addChild(mapSon);
        }
        else if(c=='m' &&
                chooseOptions.capabilities[1]==true) //that is to move the cars
        {
            for(int i=0; i<startInfo[0].maxNoOfPlayer; i++)
            {
                if(startInfo[0].player[i].isReady==true)
                {
                    Transform3D t3d=new Transform3D();
                    t3d.setTranslation(new Vector3f
                            (0.42f+startInfo[0].player[i].position.x*0.06f/121,
                            0.34f-startInfo[0].player[i].position.z*0.06f/121,
                            -1.5005f));
                    carInMapG[i].setTransform(t3d);
                }
            }
        }
        else if(c=='d') //destroy the map
        {
            for(int i=0; i<startInfo[0].maxNoOfPlayer; i++)
            {
                if(startInfo[0].player[i].isReady==true)
                {
                    carInMapG[i]=null;
                }
            }
            mapSon.detach();
        }
    }


    private void behaveMirror(char c)
    {
        if(c=='c')
        {
            if(!mirrorRender.isRunning())
            {
            mirrorSon=new BranchGroup();
            mirrorSon.setCapability(BranchGroup.ALLOW_DETACH);
            mirror=new Mirror(mirrorCanvas);
         //   mirrorSon.addChild(mirror);            
            mirrorSon.addChild(mirror);
            mirrorSon.addChild(mirror.mirrorCover());
            mirrorFather.addChild(mirrorSon);
            mirrorRender.restart();


            }
        }
        else if(c=='d' && mirrorRender.isRunning())
        {
            mirrorRender.stop();
            mirrorSon.detach();
          //  mirrorSon=null;
          //  mirror=null;
        }
    }



    private void behaveMeter(char c)
    {
        if(c=='c')     //that is to create meter
        {
            meterSon=new BranchGroup();
            meterSon.setCapability(BranchGroup.ALLOW_CHILDREN_EXTEND);
            meterSon.setCapability(BranchGroup.ALLOW_CHILDREN_WRITE);
            meterSon.setCapability(BranchGroup.ALLOW_DETACH);
            meterFather.addChild(meterSon);
            //code to load map and add to mapSon
            BranchGroup bg=new BranchGroup();
           // tg.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
            Mirror mrr=new Mirror();
            bg.addChild(mrr.speedCover());
            meterSon.addChild(bg);

        }
        else if(c=='m' &&
                chooseOptions.capabilities[2]==true) //that is to move the cars
        {
            if(speedC<=4)
            {
                speedC++;
                return;
            }
            speedC=0;
            if(meterText!=null)
            {
                if(meterText.isLive())
                {
                    meterText.detach();
                }
                 meterText=null;
            }
            int speed=(int)Math.abs((velocity*200)/0.88);
            String speeddisplay=Integer.toString(speed);
            System.out.println(speeddisplay);
            Color3f col=new Color3f(0.0f,1.0f,0.0f);
            Text2D text1=new Text2D(speeddisplay+"kph",col,"SansSerif",12,Font.BOLD);
            Transform3D t3d=new Transform3D();
            //t3d.setScale(0.6f);
            t3d.setTranslation(new Vector3d(-0.08f,-0.41f,-1.5005f));
            TransformGroup tg1 = new TransformGroup();
            tg1.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
            tg1.setTransform(t3d);
            tg1.addChild(text1);
            meterText=new BranchGroup();
            meterText.setCapability(BranchGroup.ALLOW_CHILDREN_WRITE);
            meterText.setCapability(BranchGroup.ALLOW_DETACH);
            meterText.addChild(tg1);
            meterSon.addChild(meterText);

        }
        else if(c=='d') //hide the map
        {
            meterSon.detach();
          //  meterText=null;
          //  meterSon=null;
        }
    }

    public void lapcount()
    {
        if(startInfo[0].mePlayer.position.x>=-3.6f &&  startInfo[0].mePlayer.position.x<=3.6f)
        {
            if(startInfo[0].mePlayer.prev_position.z>0 && startInfo[0].mePlayer.position.z<=0)
            {
                lap++;
                isGoingForward=true;
                if(lap!=prev_lap)
                {
                    if(lapB!=null)
                    {
                        lapB.detach();
                    }
                    lapB=new BranchGroup();
                    lapB.setCapability(BranchGroup.ALLOW_DETACH);
                    lapB.setCapability(BranchGroup.ALLOW_CHILDREN_WRITE);
                    String str=Integer.toString(lap);
                    Color3f color=new Color3f(0.0f,0.0f,1.0f);
                    Text2D text1= new Text2D("LAP "+str,color,"SansSerif",100,Font.BOLD);
                    Transform3D t3d=new Transform3D();
                    t3d.setScale(0.2f);
                    t3d.setTranslation(new Vector3d(-0.8f,0.6f, -2.5f));
                    TransformGroup tg1 = new TransformGroup();
                    tg1.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
                    tg1.setTransform(t3d);
                    tg1.addChild(text1);
                    lapB.addChild(tg1);
                    lapFather.addChild(lapB);
                    prev_lap=lap;
                }

                if(lap==1)
                {
                    Color3f color=new Color3f(1.0f,0.0f,0.0f);
                    Text2D text1= new Text2D("Game Over!",color,"SansSerif",100,Font.BOLD);
                    Transform3D t3d=new Transform3D();
                    t3d.setScale(0.5f);
                    t3d.setTranslation(new Vector3d(-0.5f,0.2f, -2.5f));
                    TransformGroup tg1 = new TransformGroup();
                    tg1.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
                    tg1.setTransform(t3d);
                    tg1.addChild(text1);
                    if(lapB.isLive())
                        lapB.detach();
                    lapB=null;
                    lapB=new BranchGroup();
                    lapB.setCapability(BranchGroup.ALLOW_DETACH);
                    lapB.setCapability(BranchGroup.ALLOW_CHILDREN_WRITE);
                    lapB.addChild(tg1);
                    lapFather.addChild(lapB);
                    if(mirrorRender.isRunning())
                        mirrorRender.stop();
                    if(timer.isRunning())
                        timer.stop();
                    startInfo[0].mePlayer.gameOver=true;
                }
            }
            else if(startInfo[0].mePlayer.prev_position.z<0 && startInfo[0].mePlayer.position.z>=0)
            {
                if(isGoingForward==true)
                {
                    lap--;
                    isGoingForward=false;
                }

            }
        }

    }
    
}


