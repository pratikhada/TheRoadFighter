
package game3dcomponents;

import javax.media.j3d.BranchGroup;
import javax.media.j3d.TransformGroup;
import javax.media.j3d.Transform3D;
import javax.media.j3d.Appearance;
import javax.media.j3d.ColoringAttributes;
import javax.media.j3d.Material;
import javax.media.j3d.Font3D;
import javax.media.j3d.Text3D;
import javax.media.j3d.FontExtrusion;
import javax.media.j3d.Shape3D;
import javax.media.j3d.Alpha;
import javax.media.j3d.RotationInterpolator;
import javax.media.j3d.BoundingSphere;
import javax.media.j3d.Canvas3D;
import javax.vecmath.Vector3d;
import javax.vecmath.Vector3f;
import javax.vecmath.Color3f;
import com.sun.j3d.utils.universe.ViewingPlatform;
import java.awt.Font;
import com.sun.j3d.utils.geometry.Text2D;
import com.sun.j3d.utils.geometry.Primitive;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import com.sun.j3d.utils.picking.PickCanvas;
import com.sun.j3d.utils.picking.PickResult;


public class TextWriter
{

    private static PickResult result;
    private static PickCanvas pickCanvas;
    private static boolean attached;
    private static BranchGroup optionBG;

    TextWriter()
    {
        attached=false;}

        public static TransformGroup textTitle()
        {
            Transform3D t3D = new Transform3D();
            t3D.setTranslation(new Vector3f(0.0f, 1.5f, -50.0f));
            TransformGroup objMove = new TransformGroup(t3D);

            TransformGroup objSpin = new TransformGroup();
            objSpin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
            objMove.addChild(objSpin);

            Appearance textAppear = new Appearance();
            ColoringAttributes textColor = new ColoringAttributes();
            textColor.setColor(1.0f, 0.0f, 0.0f);
            textAppear.setColoringAttributes(textColor);
            textAppear.setMaterial(new Material());

            Font3D font3D = new Font3D(new Font("Helvetica", Font.PLAIN, 1),
                new FontExtrusion());
            Text3D textGeom = new Text3D(font3D, new String("The Road Fighter"));
            textGeom.setAlignment(Text3D.ALIGN_CENTER);
            Shape3D textShape = new Shape3D();
            textShape.setGeometry(textGeom);
            textShape.setAppearance(textAppear);
            objSpin.addChild(textShape);
            Alpha rotationAlpha = new Alpha(-1, 10000);
            RotationInterpolator rotator = new RotationInterpolator(rotationAlpha,
                objSpin);
            BoundingSphere bounds = new BoundingSphere();
           rotator.setSchedulingBounds(bounds);
            objSpin.addChild(rotator);
            return objMove;
       }

     public static TransformGroup startSignal(String counts,Vector3f vec)
       {
            Transform3D t3D = new Transform3D();
            t3D.setTranslation(vec);
            TransformGroup objMove = new TransformGroup(t3D);

            Appearance textAppear = new Appearance();
            ColoringAttributes textColor = new ColoringAttributes();
            textColor.setColor(1.0f, 0.0f, 0.0f);
            textAppear.setColoringAttributes(textColor);
            textAppear.setMaterial(new Material());

            Font3D font3D = new Font3D(new Font("Helvetica", Font.PLAIN, 1),
                new FontExtrusion());
            Text3D textGeom = new Text3D(font3D, new String(counts));
            textGeom.setAlignment(Text3D.ALIGN_FIRST);
            Shape3D textShape = new Shape3D();
            textShape.setGeometry(textGeom);
            textShape.setAppearance(textAppear);
            objMove.addChild(textShape);
            return objMove;
    }

    public static void chooseOption(ViewingPlatform platform,BranchGroup bg,
            Canvas3D canvas,final int option[])
    {
        option[0]=0;
        optionBG=new BranchGroup();
        optionBG.setCapability(BranchGroup.ALLOW_DETACH);
        pickCanvas = new PickCanvas(canvas, optionBG);
        pickCanvas.setMode(PickCanvas.BOUNDS);
        Color3f color=new Color3f(0.27f,0.22f,0.55f);
        Text2D text[] =new Text2D[4];
        text[0]= new Text2D("RESUME",color,"SansSerif",100,Font.BOLD);
        text[1]= new Text2D("DROP THE GAME",color,"SansSerif",100,Font.BOLD);
        text[2]= new Text2D("OPTION",color,"SansSerif",100,Font.BOLD);
        text[3]= new Text2D("QUIT",color,"SansSerif",100,Font.BOLD);

       for(int i=0;i<4;i++)
       {
             Transform3D t3d=new Transform3D();
             t3d.setScale(0.2f);
             t3d.setTranslation(new Vector3d(-0.8f,(3-i)*0.1f, 2.5f));
             TransformGroup tg1 = new TransformGroup();
             tg1.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
             tg1.setTransform(t3d);
             tg1.addChild(text[i]);
             optionBG.addChild(tg1);
        }
       
             if(attached==false)
             {
                bg.addChild(optionBG);
                attached=true;
             }
            canvas.addMouseListener(
                new MouseAdapter()
             {
                public void mouseClicked(MouseEvent e)
                {

                    try{
                        pickCanvas.setShapeLocation(e);
                        result = pickCanvas.pickClosest();

                            Primitive p = (Primitive)result.getNode(PickResult.PRIMITIVE);
                            Shape3D s = (Shape3D)result.getNode(PickResult.SHAPE3D);
                            if (p != null) {
                                    System.out.println(p.getClass().getName());
                            } 
                            else if (s != null)
                            {
                                    System.out.println(s.getClass().getName());
                                    System.out.println("simple name"+s.getClass().getSimpleName());
                                    System.out.println("signers"+s.getClass().getSigners());
                                    try{
                                    System.out.println("signers"+s.getClass().getField("name"));
                              }
                                    catch(NoSuchFieldException exc){}

                            } else{
                                    System.out.println("null");
                            }
                        }catch(NullPointerException ex)
                        {
                            System.out.println("Nothing picked");
                        }
                        option[0]=1;
                        optionBG.detach();
                        attached=false;
                }
        }
      );
        try {
            Thread.sleep(200);
        } catch (InterruptedException ex) {}
    }

}
