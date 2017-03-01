

package roadobjects;

import com.sun.j3d.utils.image.TextureLoader;
import java.awt.Container;
import javax.media.j3d.QuadArray;
import javax.media.j3d.Shape3D;
import javax.media.j3d.Texture;
import javax.media.j3d.Material;
import javax.media.j3d.TextureAttributes;
import javax.media.j3d.Appearance;
import javax.media.j3d.GeometryArray;
import javax.vecmath.Point2f;
import javax.vecmath.Point3f;
import javax.vecmath.Color4f;
import javax.vecmath.Color3f;


public class RoadObjects extends  javax.swing.JApplet
{
    
    private QuadArray roadMap,grass,chess;
    private QuadArray bridge,boundary,tree;
    private QuadArray illu,coke,base,hill;
    private QuadArray aud,pole,hill1,bush;

    public Shape3D road,roadSide,roadStart,roadBridge;
    public Shape3D roadBoundary,roadtree,roadillu;
    public Shape3D roadpole,roadcoke,roadbase,roadhill;
    public Shape3D roadaud,roadslope,roadbush;

        private int box1(float x1,float x2,
        float y1,float y2,float z1,float z2,int a)
       {
          bridge.setCoordinate (a, new Point3f (x1,y1,z1 ));
          bridge.setTextureCoordinate(a, new Point2f(0.0f,0.0f));a++;

          bridge.setCoordinate (a, new Point3f (x2,y1,z1 ));
          bridge.setTextureCoordinate(a, new Point2f(0.0f,0.0f));a++;

          bridge.setCoordinate (a, new Point3f (x2,y2,z1 ));
          bridge.setTextureCoordinate(a, new Point2f(1.0f,1.0f));a++;

          bridge.setCoordinate (a, new Point3f (x1,y2,z1));
          bridge.setTextureCoordinate(a, new Point2f(0.0f,1.0f));a++;
         
          bridge.setCoordinate (a, new Point3f (x1,y2,z1 ));
          bridge.setTextureCoordinate(a, new Point2f(0.0f,0.0f));a++;

          bridge.setCoordinate (a, new Point3f (x2,y2,z1 ));
          bridge.setTextureCoordinate(a, new Point2f(0.0f,0.0f));a++;

          bridge.setCoordinate (a, new Point3f (x2,y2,z2 ));
          bridge.setTextureCoordinate(a, new Point2f(1.0f,1.0f));a++;

          bridge.setCoordinate (a, new Point3f (x1,y2,z2));
          bridge.setTextureCoordinate(a, new Point2f(0.0f,1.0f));a++;
         
          bridge.setCoordinate (a, new Point3f (x2,y1,z2 ));
          bridge.setTextureCoordinate(a, new Point2f(0.0f,0.0f));a++;

          bridge.setCoordinate (a, new Point3f (x1,y1,z2 ));
          bridge.setTextureCoordinate(a, new Point2f(0.0f,0.0f));a++;

          bridge.setCoordinate (a, new Point3f (x1,y2,z2 ));
          bridge.setTextureCoordinate(a, new Point2f(1.0f,1.0f));a++;

          bridge.setCoordinate (a, new Point3f (x2,y2,z2));
          bridge.setTextureCoordinate(a, new Point2f(0.0f,1.0f));a++;
         
          bridge.setCoordinate (a, new Point3f (x1,y1,z2 ));
          bridge.setTextureCoordinate(a, new Point2f(0.0f,0.0f));a++;

          bridge.setCoordinate (a, new Point3f (x1,y1,z1 ));
          bridge.setTextureCoordinate(a, new Point2f(0.0f,0.0f));a++;

          bridge.setCoordinate (a, new Point3f (x1,y2,z1 ));
          bridge.setTextureCoordinate(a, new Point2f(1.0f,1.0f));a++;

          bridge.setCoordinate (a, new Point3f (x1,y2,z2));
          bridge.setTextureCoordinate(a, new Point2f(0.0f,1.0f));a++;
         
          bridge.setCoordinate (a, new Point3f (x2,y1,z1 ));
          bridge.setTextureCoordinate(a, new Point2f(0.0f,0.0f));a++;

          bridge.setCoordinate (a, new Point3f (x2,y1,z2 ));
          bridge.setTextureCoordinate(a, new Point2f(0.0f,0.0f));a++;

          bridge.setCoordinate (a, new Point3f (x2,y2,z2 ));
          bridge.setTextureCoordinate(a, new Point2f(1.0f,1.0f));a++;

          bridge.setCoordinate (a, new Point3f (x2,y2,z1));
          bridge.setTextureCoordinate(a, new Point2f(0.0f,1.0f));a++;

          return a;

     }


    private int box2(float x1,float x2,
            float y1,float y2,float z1,float z2,int a)
    {
        illu.setCoordinate (a, new Point3f (x1,y1,z1 ));
        illu.setTextureCoordinate(a, new Point2f(0.0f,0.0f));a++;

        illu.setCoordinate (a, new Point3f (x2,y1,z1 ));
        illu.setTextureCoordinate(a, new Point2f(0.0f,0.0f));a++;

        illu.setCoordinate (a, new Point3f (x2,y2,z1 ));
        illu.setTextureCoordinate(a, new Point2f(1.0f,1.0f));a++;

        illu.setCoordinate (a, new Point3f (x1,y2,z1));
        illu.setTextureCoordinate(a, new Point2f(0.0f,1.0f));a++;
         
        illu.setCoordinate (a, new Point3f (x1,y2,z1 ));
        illu.setTextureCoordinate(a, new Point2f(0.0f,0.0f));a++;

        illu.setCoordinate (a, new Point3f (x2,y2,z1 ));
        illu.setTextureCoordinate(a, new Point2f(0.0f,0.0f));a++;

        illu.setCoordinate (a, new Point3f (x2,y2,z2 ));
        illu.setTextureCoordinate(a, new Point2f(1.0f,1.0f));a++;

        illu.setCoordinate (a, new Point3f (x1,y2,z2));
        illu.setTextureCoordinate(a, new Point2f(0.0f,1.0f));a++;

        
        illu.setCoordinate (a, new Point3f (x2,y1,z2 ));
        illu.setTextureCoordinate(a, new Point2f(0.0f,0.0f));a++;

        illu.setCoordinate (a, new Point3f (x1,y1,z2 ));
        illu.setTextureCoordinate(a, new Point2f(0.0f,0.0f));a++;

        illu.setCoordinate (a, new Point3f (x1,y2,z2 ));
        illu.setTextureCoordinate(a, new Point2f(1.0f,1.0f));a++;

        illu.setCoordinate (a, new Point3f (x2,y2,z2));
        illu.setTextureCoordinate(a, new Point2f(0.0f,1.0f));a++;

       
        illu.setCoordinate (a, new Point3f (x1,y1,z2 ));
        illu.setTextureCoordinate(a, new Point2f(0.0f,0.0f));a++;

        illu.setCoordinate (a, new Point3f (x1,y1,z1 ));
        illu.setTextureCoordinate(a, new Point2f(0.0f,0.0f));a++;

        illu.setCoordinate (a, new Point3f (x1,y2,z1 ));
        illu.setTextureCoordinate(a, new Point2f(1.0f,1.0f));a++;

        illu.setCoordinate (a, new Point3f (x1,y2,z2));
        illu.setTextureCoordinate(a, new Point2f(0.0f,1.0f));a++;

        
        illu.setCoordinate (a, new Point3f (x2,y1,z1 ));
        illu.setTextureCoordinate(a, new Point2f(0.0f,0.0f));a++;

        illu.setCoordinate (a, new Point3f (x2,y1,z2 ));
        illu.setTextureCoordinate(a, new Point2f(0.0f,0.0f));a++;

        illu.setCoordinate (a, new Point3f (x2,y2,z2 ));
        illu.setTextureCoordinate(a, new Point2f(1.0f,1.0f));a++;

        illu.setCoordinate (a, new Point3f (x2,y2,z1));
        illu.setTextureCoordinate(a, new Point2f(0.0f,1.0f));a++;

        return a;
      }


    public int builds(float x1,float x2,
            float y1,float y2,float z1,float z2,int a)
      {
        tree.setCoordinate (a,new Point3f (x1,y1,z1 ));
        tree.setTextureCoordinate(a, new Point2f(0.0f,0.0f));a++;

        tree.setCoordinate (a, new Point3f (x2,y1,z2 ));
        tree.setTextureCoordinate(a, new Point2f(1.0f,0.0f));a++;

        tree.setCoordinate (a, new Point3f (x2,y2,z2 ));
        tree.setTextureCoordinate(a, new Point2f(1.0f,1.0f));a++;

        tree.setCoordinate (a, new Point3f (x1,y2,z1 ));
        tree.setTextureCoordinate(a, new Point2f(0.0f,1.0f));a++;
        
        return a;
      }


    public int box3(float x1,float x2,
            float y1,float y2,float z1,float z2,int a)
      {
          pole.setCoordinate (a, new Point3f (x1,y1,z1 ));
          pole.setTextureCoordinate(a, new Point2f(0.0f,0.0f));a++;

          pole.setCoordinate (a, new Point3f (x2,y1,z1 ));
          pole.setTextureCoordinate(a, new Point2f(0.0f,0.0f));a++;

          pole.setCoordinate (a, new Point3f (x2,y2,z1 ));
          pole.setTextureCoordinate(a, new Point2f(1.0f,1.0f));a++;

          pole.setCoordinate (a, new Point3f (x1,y2,z1));
          pole.setTextureCoordinate(a, new Point2f(0.0f,1.0f));a++;
         
          pole.setCoordinate (a, new Point3f (x1,y2,z1 ));
          pole.setTextureCoordinate(a, new Point2f(0.0f,0.0f));a++;

          pole.setCoordinate (a, new Point3f (x2,y2,z1 ));
          pole.setTextureCoordinate(a, new Point2f(0.0f,0.0f));a++;

          pole.setCoordinate (a, new Point3f (x2,y2,z2 ));
           pole.setTextureCoordinate(a, new Point2f(1.0f,1.0f));a++;

           pole.setCoordinate (a, new Point3f (x1,y2,z2));
           pole.setTextureCoordinate(a, new Point2f(0.0f,1.0f));a++;
           
          pole.setCoordinate (a, new Point3f (x2,y1,z2 ));
           pole.setTextureCoordinate(a, new Point2f(0.0f,0.0f));a++;

           pole.setCoordinate (a, new Point3f (x1,y1,z2 ));
           pole.setTextureCoordinate(a, new Point2f(0.0f,0.0f));a++;

           pole.setCoordinate (a, new Point3f (x1,y2,z2 ));
           pole.setTextureCoordinate(a, new Point2f(1.0f,1.0f));a++;

           pole.setCoordinate (a, new Point3f (x2,y2,z2));
          pole.setTextureCoordinate(a, new Point2f(0.0f,1.0f));a++;
          
          pole.setCoordinate (a, new Point3f (x1,y1,z2 ));
           pole.setTextureCoordinate(a, new Point2f(0.0f,0.0f));a++;

           pole.setCoordinate (a, new Point3f (x1,y1,z1 ));
           pole.setTextureCoordinate(a, new Point2f(0.0f,0.0f));a++;

           pole.setCoordinate (a, new Point3f (x1,y2,z1 ));
           pole.setTextureCoordinate(a, new Point2f(1.0f,1.0f));a++;

           pole.setCoordinate (a, new Point3f (x1,y2,z2));
           pole.setTextureCoordinate(a, new Point2f(0.0f,1.0f));a++;
           
           pole.setCoordinate (a, new Point3f (x2,y1,z1 ));
           pole.setTextureCoordinate(a, new Point2f(0.0f,0.0f));a++;

           pole.setCoordinate (a, new Point3f (x2,y1,z2 ));
           pole.setTextureCoordinate(a, new Point2f(0.0f,0.0f));a++;

           pole.setCoordinate (a, new Point3f (x2,y2,z2 ));
           pole.setTextureCoordinate(a, new Point2f(1.0f,1.0f));a++;

           pole.setCoordinate (a, new Point3f (x2,y2,z1));
           pole.setTextureCoordinate(a, new Point2f(0.0f,1.0f));a++;

           return a;
     }


    public int shop(float x1,float x2,
            float y1,float y2,float z1,float z2,int a)
      {
          coke.setCoordinate (a,new Point3f (x1,y1,z1 ));
          coke.setTextureCoordinate(a, new Point2f(0.0f,0.0f));a++;

          coke.setCoordinate (a, new Point3f (x2,y1,z2 ));
          coke.setTextureCoordinate(a, new Point2f(1.0f,0.0f));a++;


          coke.setCoordinate (a, new Point3f (x2,y2,z2 ));
          coke.setTextureCoordinate(a, new Point2f(1.0f,1.0f));a++;

          coke.setCoordinate (a, new Point3f (x1,y2,z1 ));
          coke.setTextureCoordinate(a, new Point2f(0.0f,1.0f));a++;
          return a;
    }


    public int bush1(float x1,float x2,float y1,float y2,float z1,float z2,int a)
       {
          bush.setCoordinate (a,new Point3f (x1,y1,z1 ));
          bush.setTextureCoordinate(a, new Point2f(0.0f,0.0f));a++;

          bush.setCoordinate (a, new Point3f (x2,y1,z2 ));
          bush.setTextureCoordinate(a, new Point2f(1.0f,0.0f));a++;


          bush.setCoordinate (a, new Point3f (x2,y2,z2 ));
          bush.setTextureCoordinate(a, new Point2f(1.0f,1.0f));a++;

          bush.setCoordinate (a, new Point3f (x1,y2,z1 ));
          bush.setTextureCoordinate(a, new Point2f(0.0f,1.0f));a++;
          return a;
     }


    public int base2(float x1,float x2,
            float y1,float y2,float z1,float z2,int a)
      {
          aud.setCoordinate (a,new Point3f (x1,y1,z1 ));
          aud.setTextureCoordinate(a, new Point2f(0.0f,0.0f));a++;

          aud.setCoordinate (a, new Point3f (x2,y1,z2 ));
          aud.setTextureCoordinate(a, new Point2f(1.0f,0.0f));a++;


          aud.setCoordinate (a, new Point3f (x2,y2,z2 ));
          aud.setTextureCoordinate(a, new Point2f(1.0f,1.0f));a++;

          aud.setCoordinate (a, new Point3f (x1,y2,z1 ));
          aud.setTextureCoordinate(a, new Point2f(0.0f,1.0f));a++;
          return a;
      }


    public int grass1(float x1,float x2,
            float y1,float y2,float z1,float z2,int a)
    {
            grass.setCoordinate (a,new Point3f (x1,y1,z1 ));
            grass.setTextureCoordinate(a, new Point2f(0.0f,0.0f));a++;

            grass.setCoordinate (a, new Point3f (x2,y1,z1 ));
            grass.setTextureCoordinate(a, new Point2f(1.0f,0.0f));a++;


            grass.setCoordinate (a, new Point3f (x2,y1,z2 ));
            grass.setTextureCoordinate(a, new Point2f(1.0f,1.0f));a++;

            grass.setCoordinate (a, new Point3f (x1,y1,z2 ));
            grass.setTextureCoordinate(a, new Point2f(0.0f,1.0f));a++;
            return a;
    }


    public int base1(float x1,float x2,
            float y1,float y2,float z1,float z2,int a)
    {
            base.setCoordinate (a,new Point3f (x1,y1,z1 ));
            base.setTextureCoordinate(a, new Point2f(0.0f,0.0f));a++;

            base.setCoordinate (a, new Point3f (x2,y1,z1 ));
            base.setTextureCoordinate(a, new Point2f(1.0f,0.0f));a++;


            base.setCoordinate (a, new Point3f (x2,y2,z2 ));
            base.setTextureCoordinate(a, new Point2f(1.0f,1.0f));a++;

            base.setCoordinate (a, new Point3f (x1,y2,z2 ));
            base.setTextureCoordinate(a, new Point2f(0.0f,1.0f));a++;
            return a;
    }


    public int hill1(float x1,float x2,float x3, float x4,
            float y1,float y2,float z1,float z2,float z3,float z4,int a)
    {
            hill.setCoordinate (a,new Point3f (x1,y1,z1 ));
            hill.setTextureCoordinate(a, new Point2f(0.0f,0.0f));a++;

            hill.setCoordinate (a, new Point3f (x2,y1,z2 ));
            hill.setTextureCoordinate(a, new Point2f(1.0f,0.0f));a++;


            hill.setCoordinate (a, new Point3f (x3,y2,z3 ));
            hill.setTextureCoordinate(a, new Point2f(1.0f,1.0f));a++;

            hill.setCoordinate (a, new Point3f (x4,y2,z4));
            hill.setTextureCoordinate(a, new Point2f(0.0f,1.0f));a++;
            return a;
    }


    public int hill2(float x1,float x2,float x3, float x4,
            float y1,float y2,float z1,float z2,float z3,float z4,int a)
    {
            hill1.setCoordinate (a,new Point3f (x1,y1,z1 ));
            hill1.setTextureCoordinate(a, new Point2f(0.0f,0.0f));a++;

            hill1.setCoordinate (a, new Point3f (x2,y1,z2 ));
            hill1.setTextureCoordinate(a, new Point2f(1.0f,0.0f));a++;


            hill1.setCoordinate (a, new Point3f (x3,y2,z3 ));
            hill1.setTextureCoordinate(a, new Point2f(1.0f,1.0f));a++;

            hill1.setCoordinate (a, new Point3f (x4,y2,z4));
            hill1.setTextureCoordinate(a, new Point2f(0.0f,1.0f));a++;
            return a;
    }


    public int sign(float x1,float x2,
            float y1,float y2,float z1,float z2,int a)
    {
            boundary.setCoordinate (a,new Point3f (x1,y1,z1 ));
            boundary.setTextureCoordinate(a, new Point2f(0.0f,0.0f));a++;

            boundary.setCoordinate (a, new Point3f (x2,y1,z2 ));
            boundary.setTextureCoordinate(a, new Point2f(1.0f,0.0f));a++;


            boundary.setCoordinate (a, new Point3f (x2,y2,z2 ));
            boundary.setTextureCoordinate(a, new Point2f(1.0f,1.0f));a++;

            boundary.setCoordinate (a, new Point3f (x1,y2,z1 ));
            boundary.setTextureCoordinate(a, new Point2f(0.0f,1.0f));a++;
            return a;
    }


      public RoadObjects()
         {

        //Set up the texture map
            TextureLoader loader1=new TextureLoader(getClass().getResource
                    ("roadimages/roadtexture.jpg"),"LUMINANCE", new Container());
            TextureLoader loader2=new TextureLoader(getClass().
                      getResource("roadimages/grass.jpg"), this);
            TextureLoader loader3=new TextureLoader(getClass().
                      getResource("roadimages/chess.jpg"), this);
            TextureLoader loader4=new TextureLoader(getClass().
                      getResource("roadimages/brick2.jpg"), this);
            TextureLoader loader5=new TextureLoader(getClass().
                      getResource("roadimages/sign.jpg"), this);
            TextureLoader loader6=new TextureLoader(getClass().
                      getResource("roadimages/wood.jpg"), this);
            TextureLoader loader7=new TextureLoader(getClass().
                      getResource("roadimages/brick.jpg"), this);
            TextureLoader loader8=new TextureLoader(getClass().
                      getResource("roadimages/coke.jpg"), this);
            TextureLoader loader9=new TextureLoader(getClass().
                      getResource("roadimages/pool.jpg"), this);
            TextureLoader loader10=new TextureLoader(getClass().
                      getResource("roadimages/hilltile.jpg"), this);
            TextureLoader loader11=new TextureLoader(getClass().
                      getResource("roadimages/audience.bmp"), this);
            TextureLoader loader12=new TextureLoader(getClass().
                      getResource("roadimages/chinatile.jpg"), this);
            TextureLoader loader13=new TextureLoader(getClass().
                      getResource("roadimages/hill.jpg"), this);
            TextureLoader loader14=new TextureLoader(getClass().
                      getResource("roadimages/trees.bmp"), this);

            //get the texture
            Texture texture1 = loader1.getTexture();
            Texture texture2 = loader2.getTexture();
            Texture texture3 = loader3.getTexture();
            Texture texture4 = loader4.getTexture();
            Texture texture5 = loader5.getTexture();
            Texture texture6 = loader6.getTexture();
            Texture texture7 = loader7.getTexture();
            Texture texture8 = loader8.getTexture();
            Texture texture9 = loader9.getTexture();
            Texture texture10 = loader10.getTexture();
            Texture texture11 = loader11.getTexture();
            Texture texture12 = loader12.getTexture();
            Texture texture13 = loader13.getTexture();
            Texture texture14= loader14.getTexture();
              if(texture1==null)
                  System.out.println("error in loading");
            texture1.setBoundaryModeS(Texture.WRAP);
            texture1.setBoundaryModeT(Texture.WRAP);
            texture1.setBoundaryColor( new Color4f( 0.0f, 1.0f, 0.0f, 0.0f ) );

             if(texture2==null)
                 System.out.println("error in loading");
            texture2.setBoundaryModeS(Texture.WRAP);
            texture2.setBoundaryModeT(Texture.WRAP);
            texture2.setBoundaryColor( new Color4f( 0.0f, 1.0f, 0.0f, 0.0f ) );
            if(texture3==null)
               System.out.println("error in loading");
            texture3.setBoundaryModeS(Texture.WRAP);
            texture3.setBoundaryModeT(Texture.WRAP);
            texture3.setBoundaryColor( new Color4f( 0.0f, 1.0f, 0.0f, 0.0f ) );
           if(texture4==null)
              System.out.println("error in loading");
            texture4.setBoundaryModeS(Texture.WRAP);
            texture4.setBoundaryModeT(Texture.WRAP);
            texture4.setBoundaryColor( new Color4f( 0.0f, 1.0f, 0.0f, 0.0f ) );
         if(texture5==null)
            System.out.println("error in loading");
        texture5.setBoundaryModeS(Texture.WRAP);
        texture5.setBoundaryModeT(Texture.WRAP);
        texture5.setBoundaryColor( new Color4f( 0.0f, 1.0f, 0.0f, 0.0f ) );
         if(texture6==null)
            System.out.println("error in loading");
        texture6.setBoundaryModeS(Texture.WRAP);
        texture6.setBoundaryModeT(Texture.WRAP);
        texture6.setBoundaryColor( new Color4f( 0.0f, 1.0f, 0.0f, 0.0f ) );
         if(texture7==null)
            System.out.println("error in loading");
        texture7.setBoundaryModeS(Texture.WRAP);
        texture7.setBoundaryModeT(Texture.WRAP);
        texture7.setBoundaryColor( new Color4f( 0.0f, 1.0f, 0.0f, 0.0f ) );

        if(texture8==null)
            System.out.println("error in loading");
        texture8.setBoundaryModeS(Texture.WRAP);
        texture8.setBoundaryModeT(Texture.WRAP);
        texture8.setBoundaryColor( new Color4f( 0.0f, 1.0f, 0.0f, 0.0f ) );
        if(texture9==null)
            System.out.println("error in loading");
        texture9.setBoundaryModeS(Texture.WRAP);
        texture9.setBoundaryModeT(Texture.WRAP);
        texture9.setBoundaryColor( new Color4f( 0.0f, 1.0f, 0.0f, 0.0f ) );
        if(texture10==null)
            System.out.println("error in loading");
        texture10.setBoundaryModeS(Texture.WRAP);
        texture10.setBoundaryModeT(Texture.WRAP);
        texture10.setBoundaryColor( new Color4f( 0.0f, 1.0f, 0.0f, 0.0f ) );
        if(texture11==null)
            System.out.println("error in loading");
        texture11.setBoundaryModeS(Texture.WRAP);
        texture11.setBoundaryModeT(Texture.WRAP);
        texture11.setBoundaryColor( new Color4f( 0.0f, 1.0f, 0.0f, 0.0f ) );

        if(texture12==null)
            System.out.println("error in loading");
        texture12.setBoundaryModeS(Texture.WRAP);
        texture12.setBoundaryModeT(Texture.WRAP);
        texture12.setBoundaryColor( new Color4f( 0.0f, 1.0f, 0.0f, 0.0f ) );

        if(texture13==null)
            System.out.println("error in loading");
        texture13.setBoundaryModeS(Texture.WRAP);
        texture13.setBoundaryModeT(Texture.WRAP);
        texture13.setBoundaryColor( new Color4f( 0.0f, 1.0f, 0.0f, 0.0f ) );
        if(texture14==null)
            System.out.println("error in loading");
        texture14.setBoundaryModeS(Texture.WRAP);
        texture14.setBoundaryModeT(Texture.WRAP);
        texture14.setBoundaryColor( new Color4f( 0.0f, 1.0f, 0.0f, 0.0f ) );
        
        //set the texture attributes
        TextureAttributes texAttr = new TextureAttributes();
        texAttr.setTextureMode(TextureAttributes.MODULATE);
        
        //create appearance and add texture to it
        Appearance ap1 = new Appearance();
        ap1.setTexture(texture1);
        ap1.setTextureAttributes(texAttr);
        
        Appearance ap2 = new Appearance();
        ap2.setTexture(texture2);
        ap2.setTextureAttributes(texAttr);

        Appearance ap3 = new Appearance();
        ap3.setTexture(texture3);
        ap3.setTextureAttributes(texAttr);

        Appearance ap4 = new Appearance();
        ap4.setTexture(texture4);
        ap4.setTextureAttributes(texAttr);
        
        Appearance ap5 = new Appearance();
        ap5.setTexture(texture5);
        ap5.setTextureAttributes(texAttr);

        Appearance ap6 = new Appearance();
        ap6.setTexture(texture6);
        ap6.setTextureAttributes(texAttr);

        Appearance ap7 = new Appearance();
        ap7.setTexture(texture7);
        ap7.setTextureAttributes(texAttr);

        Appearance ap8 = new Appearance();
        ap8.setTexture(texture8);
        ap8.setTextureAttributes(texAttr);

        Appearance ap9 = new Appearance();
        ap9.setTexture(texture9);
        ap9.setTextureAttributes(texAttr);
        
        Appearance ap10 = new Appearance();
        ap10.setTexture(texture10);
        ap10.setTextureAttributes(texAttr);

        Appearance ap11 = new Appearance();
        ap11.setTexture(texture11);
        ap11.setTextureAttributes(texAttr);

        Appearance ap12 = new Appearance();
        ap12.setTexture(texture12);
        ap12.setTextureAttributes(texAttr);

        Appearance ap13 = new Appearance();
        ap13.setTexture(texture13);
        ap13.setTextureAttributes(texAttr);

        Appearance ap14 = new Appearance();
        ap14.setTexture(texture14);
        ap14.setTextureAttributes(texAttr);
        
        //add material to appearance
        Color3f black = new Color3f(0.0f, 0.0f, 0.0f);
        Color3f red = new Color3f(0.7f, .15f, .15f);
        ap1.setMaterial(new Material(red, black, red, black, 1.0f));
        ap2.setMaterial(new Material(red, black, red, black, 1.0f));
        ap3.setMaterial(new Material(red, black, red, black, 1.0f));
        ap4.setMaterial(new Material(red, black, red, black, 1.0f));
        ap5.setMaterial(new Material(red, black, red, black, 1.0f));
        ap6.setMaterial(new Material(red, black, red, black, 1.0f));
        ap7.setMaterial(new Material(red, black, red, black, 1.0f));
        ap8.setMaterial(new Material(red, black, red, black, 1.0f));
        ap9.setMaterial(new Material(red, black, red, black, 1.0f));
        ap10.setMaterial(new Material(red, black, red, black, 1.0f));
        ap11.setMaterial(new Material(red, black, red, black, 1.0f));
        ap12.setMaterial(new Material(red, black, red, black, 1.0f));
        ap13.setMaterial(new Material(red, black, red, black, 1.0f));
        ap14.setMaterial(new Material(red, black, red, black, 1.0f));

        //define quadarrays
        roadMap=new QuadArray (3000,
                QuadArray.COORDINATES | GeometryArray.TEXTURE_COORDINATE_2);
         grass=new QuadArray (2000,
                QuadArray.COORDINATES | GeometryArray.TEXTURE_COORDINATE_2);
         chess=new QuadArray (40,
                QuadArray.COORDINATES | GeometryArray.TEXTURE_COORDINATE_2);
         bridge=new QuadArray (110000,
                QuadArray.COORDINATES | GeometryArray.TEXTURE_COORDINATE_2);
        boundary=new QuadArray (500,
                QuadArray.COORDINATES | GeometryArray.TEXTURE_COORDINATE_2);
         tree=new QuadArray (2000,
                QuadArray.COORDINATES | GeometryArray.TEXTURE_COORDINATE_2);
        illu=new QuadArray (70000,
                QuadArray.COORDINATES | GeometryArray.TEXTURE_COORDINATE_2);
        coke=new QuadArray (10000,
                QuadArray.COORDINATES | GeometryArray.TEXTURE_COORDINATE_2);
        base=new QuadArray (100,
                QuadArray.COORDINATES | GeometryArray.TEXTURE_COORDINATE_2);
        hill=new QuadArray (100,
                QuadArray.COORDINATES | GeometryArray.TEXTURE_COORDINATE_2);
        aud=new QuadArray (20000,
                QuadArray.COORDINATES | GeometryArray.TEXTURE_COORDINATE_2);
        pole=new QuadArray (10000,
                QuadArray.COORDINATES | GeometryArray.TEXTURE_COORDINATE_2);
        hill1=new QuadArray (1000,
                QuadArray.COORDINATES | GeometryArray.TEXTURE_COORDINATE_2);
        bush=new QuadArray (1000,
                QuadArray.COORDINATES | GeometryArray.TEXTURE_COORDINATE_2);


        //give coordinates and texture coordinates to roadMap
        float b=0;
        float e=0;
        float g=0;
        float x1=0;
        int c=0;
        float x2=0;
        float h=0;
        float x=0;
        int c4=0;

        for(int i=0;i<4;i++)
        {
          float z1=100-50*i;
          roadMap.setCoordinate (c, new Point3f (-1.8f,-0.4f,z1 ));
          roadMap.setTextureCoordinate(c, new Point2f(0.0f,0.0f));c++;

          roadMap.setCoordinate (c, new Point3f (1.8f,-0.4f,z1 ));
          roadMap.setTextureCoordinate(c, new Point2f(1.0f,0.0f));c++;

          float z2=z1-50;
          roadMap.setCoordinate (c, new Point3f (1.8f,-0.4f,z2 ));
          roadMap.setTextureCoordinate(c, new Point2f(1.0f,1.0f));c++;

          roadMap.setCoordinate (c, new Point3f (-1.8f,-0.4f,z2 ));
          roadMap.setTextureCoordinate(c, new Point2f(0.0f,1.0f));c++;
        }

       
        for(float i=0;i<7.2;i+=0.1)
        {
              x1=-1.8f+i;  x2=1.8f+i;
              float z1= (float)(Math.sqrt(116.6401-(x1-9.0f)*(x1-9.0f))+100.0);
            
              roadMap.setCoordinate (c, new Point3f (x1,-0.4f,-z1 ));
              roadMap.setTextureCoordinate(c, new Point2f(0.0f,0.0f));c++;
              float z2=(float)(Math.sqrt(51.84-(x2-9)*(x2-9))+100);
            
              roadMap.setCoordinate (c, new Point3f (x2,-0.4f,-z2 ));
              roadMap.setTextureCoordinate(c, new Point2f(1.0f,0.0f));c++;
              float a2=(x2+0.1f);
              z2=(float)(Math.sqrt(51.84-(a2-9)*(a2-9))+100);
             
              roadMap.setCoordinate (c, new Point3f (a2,-0.4f,-z2 ));
              roadMap.setTextureCoordinate(c, new Point2f(1.0f,1.0f));c++;
              float a1=(x1+0.1f);
              z1=(float)(Math.sqrt(116.6401-(a1-9.0f)*(a1-9.0f))+100);
             
              roadMap.setCoordinate (c, new Point3f (a1,-0.4f,-z1));
              roadMap.setTextureCoordinate(c, new Point2f(0.0f,1.0f));c++;
               
               b=x2;
               e=z2;
               
        }

        while(x1<8.90f)
        {
             x1+=0.1f;  x2=b;
             float z1= (float)(Math.sqrt(116.6401-(x1-9.0f)*(x1-9.0f))+100.0);
             roadMap.setCoordinate (c, new Point3f (x1,-0.4f,-z1 ));
             roadMap.setTextureCoordinate(c, new Point2f(0.0f,0.0f));c++;
             float z2=e;

              roadMap.setCoordinate (c, new Point3f (x2,-0.4f,-z2 ));
              roadMap.setTextureCoordinate(c, new Point2f(1.0f,0.0f));c++;

              roadMap.setCoordinate (c, new Point3f (x2,-0.4f,-z2 ));
              roadMap.setTextureCoordinate(c, new Point2f(1.0f,1.0f));c++;
              float a1=(x1+0.1f);
              z1=(float)(Math.sqrt(116.6401-(a1-9.0f)*(a1-9.0f))+100);

              roadMap.setCoordinate (c, new Point3f (a1, -0.4f, -z1));
              roadMap.setTextureCoordinate(c, new Point2f(0.0f,1.0f));c++;
              g=z1;
        }

        
        for(int i=0;i<6;i++)
        {
           x=b+50*i;
          float z=e;

          roadMap.setCoordinate (c, new Point3f (x,-0.4f,-g ));
          roadMap.setTextureCoordinate(c, new Point2f(0.0f,0.0f));c++;

          roadMap.setCoordinate (c, new Point3f (x,-0.4f,-z ));
          roadMap.setTextureCoordinate(c, new Point2f(1.0f,0.0f));c++;
           x2=x+50;
          roadMap.setCoordinate (c, new Point3f (x2,-0.4f,-z ));
          roadMap.setTextureCoordinate(c, new Point2f(1.0f,1.0f));c++;
     
          roadMap.setCoordinate (c, new Point3f (x2,-0.4f,-g ));
          roadMap.setTextureCoordinate(c, new Point2f(0.0f,1.0f));c++;
        }

        
        for(float i=0;i<7.2;i+=0.1)
        {
              float z1=-g+i; float z2=-e+i;
              
              x1=(float)(Math.sqrt(116.6401-(z1+100)*(z1+100))+x2-0.1);
     
              roadMap.setCoordinate (c, new Point3f (x1,-0.4f,z1 ));
              roadMap.setTextureCoordinate(c, new Point2f(0.0f,0.0f));c++;

              x=(float)(Math.sqrt(51.84f-(z2+100)*(z2+100))+x2-0.1);
              roadMap.setCoordinate (c, new Point3f (x,-0.4f,z2 ));
              roadMap.setTextureCoordinate(c, new Point2f(1.0f,0.0f));c++;

              float a2=(z2+0.1f);
              x=(float)(Math.sqrt(51.84f-(a2+100.0f)*(a2+100.0f))+x2-0.1);
              roadMap.setCoordinate (c, new Point3f (x,-0.4f,a2 ));
              roadMap.setTextureCoordinate(c, new Point2f(1.0f,1.0f));c++;
              
              float a1=(z1+0.1f);
              x1=(float)(Math.sqrt(116.6401-(a1+100.0)*(a1+100))+x2-0.1);
              roadMap.setCoordinate (c, new Point3f (x1, -0.4f, a1));
              roadMap.setTextureCoordinate(c, new Point2f(0.0f,1.0f));c++;

              b=z1;
             h=a2;
        }

        float z1=b;
        float z2=0;
        float z=0;

        while(z1<-100)
        {
             z1+=0.1f;
             x1= (float)(Math.sqrt(116.6401-(z1+100)*(z1+100))+x2-0.1);
             roadMap.setCoordinate (c, new Point3f (x1,-0.4f,b ));
             roadMap.setTextureCoordinate(c, new Point2f(0.0f,0.0f));c++;
             

              roadMap.setCoordinate (c, new Point3f (x,-0.4f,h ));
              roadMap.setTextureCoordinate(c, new Point2f(1.0f,0.0f));c++;

              roadMap.setCoordinate (c, new Point3f (x,-0.4f,h ));
              roadMap.setTextureCoordinate(c, new Point2f(1.0f,1.0f));c++;

              float a1=(z1+0.1f);
              x1=(float)(Math.sqrt(116.6401-(a1+100)*(a1+100))+x2-0.1);
              roadMap.setCoordinate (c, new Point3f (x1, -0.4f, a1));
              roadMap.setTextureCoordinate(c, new Point2f(0.0f,1.0f));c++;
              b=z1;
              e=x1;

        }

        /////////////////////////////////////////////////////////////////
        for(int i=0;i<6;i++)
        {
           z1=b+50*i;
          roadMap.setCoordinate (c, new Point3f (e,-0.4f,z1 ));
          roadMap.setTextureCoordinate(c, new Point2f(0.0f,0.0f));c++;

          roadMap.setCoordinate (c, new Point3f (x,-0.4f,z1 ));
          roadMap.setTextureCoordinate(c, new Point2f(1.0f,0.0f));c++;
           z2=z1+50;
          roadMap.setCoordinate (c, new Point3f (x,-0.4f,z2 ));
          roadMap.setTextureCoordinate(c, new Point2f(1.0f,1.0f));c++;

          roadMap.setCoordinate (c, new Point3f (e,-0.4f,z2 ));
          roadMap.setTextureCoordinate(c, new Point2f(0.0f,1.0f));c++;
        }

        ////////////////////////////////////////////////////////////
        for(float i=0;i<7.2;i+=0.1)
        {
              x1=e-i;  x2=x-i;
              z1=(float)(Math.sqrt(116.6401-(x1-e+10.8)*(x1-e+10.8))+z2-0.1);
              roadMap.setCoordinate (c, new Point3f (x1,-0.4f,z1 ));
              roadMap.setTextureCoordinate(c, new Point2f(0.0f,0.0f));c++;

              z=(float)(Math.sqrt(51.844-(x2-e+10.8)*(x2-e+10.8))+z2-0.1);
              roadMap.setCoordinate (c, new Point3f (x2,-0.4f,z ));
              roadMap.setTextureCoordinate(c, new Point2f(1.0f,0.0f));c++;

              float a2=(x2-0.1f);
              z=(float)(Math.sqrt(51.844-(a2-e+10.8)*(a2-e+10.8))+z2-0.1);
              roadMap.setCoordinate (c, new Point3f (a2,-0.4f,z ));
              roadMap.setTextureCoordinate(c, new Point2f(1.0f,1.0f));c++;

              float a1=(x1-0.1f);
              z1=(float)(Math.sqrt(116.6401-(a1-e+10.8)*(a1-e+10.8))+z2-0.1);
              roadMap.setCoordinate (c, new Point3f (a1,-0.4f,z1));
              roadMap.setTextureCoordinate(c, new Point2f(0.0f,1.0f));c++;
              b=a2;
        }

        while(x1>b)
        {
             x1-=0.1f;  x2=b;
             z1= (float)(Math.sqrt(116.6401-(x1-e+10.8)*(x1-e+10.8))+z2-0.1);
             roadMap.setCoordinate (c, new Point3f (x1,-0.4f,z1 ));
             roadMap.setTextureCoordinate(c, new Point2f(0.0f,0.0f));c++;


             roadMap.setCoordinate (c, new Point3f (x2,-0.4f,z ));
             roadMap.setTextureCoordinate(c, new Point2f(1.0f,0.0f));c++;

             roadMap.setCoordinate (c, new Point3f (x2,-0.4f,z ));
             roadMap.setTextureCoordinate(c, new Point2f(1.0f,1.0f));c++;
              float a1=(x1-0.1f);
              z1=(float)(Math.sqrt(116.6401-(a1-e+10.8)*(a1-e+10.8))+z2-0.1);
              roadMap.setCoordinate (c, new Point3f (a1, -0.4f, z1));
              roadMap.setTextureCoordinate(c, new Point2f(0.0f,1.0f));c++;
              g=z1;
              h=x2;
        }

        ////////////////////////////////////////////////////////////////
        float j=0;
        float k=0;
        for(float i=0;i<7;i++)
        {
          
           x=h-50*i;
          roadMap.setCoordinate (c, new Point3f (x,-0.4f,g ));
          roadMap.setTextureCoordinate(c, new Point2f(0.0f,0.0f));c++;

          roadMap.setCoordinate (c, new Point3f (x,-0.4f,z ));
          roadMap.setTextureCoordinate(c, new Point2f(1.0f,0.0f));c++;
           x2=x-50;
          // k=j+0.1f;
          roadMap.setCoordinate (c, new Point3f (x2,-0.4f,z ));
          roadMap.setTextureCoordinate(c, new Point2f(1.0f,1.0f));c++;

          roadMap.setCoordinate (c, new Point3f (x2,-0.4f,g ));
          roadMap.setTextureCoordinate(c, new Point2f(0.0f,1.0f));c++;
         // j+=0.1f;
        }

        z2=0;
        z1=0;

        //////////////////////////////////////////////////////////
        for(float i=0;i<7.2;i+=0.1)
        {
               z1=g+i; z2=z+i;
              
               x1=(float)(Math.sqrt(51.861f-(z1-z-10.8)*(z1-z-10.8))-x2-0.1);
              
              roadMap.setCoordinate (c, new Point3f (-x1,-0.4f,z1 ));
              roadMap.setTextureCoordinate(c, new Point2f(0.0f,0.0f));c++;

              x=(float)(Math.sqrt(116.6401-(z2-z-10.8)*(z2-z-10.8))-x2-0.1);
              roadMap.setCoordinate (c, new Point3f (-x,-0.4f,z2 ));
              roadMap.setTextureCoordinate(c, new Point2f(1.0f,0.0f));c++;

              float a2=(z2+0.1f);
              x=(float)(Math.sqrt(116.6401-(a2-z-10.8)*(a2-z-10.8))-x2-0.1);
              roadMap.setCoordinate (c, new Point3f (-x,-0.4f,a2 ));
              roadMap.setTextureCoordinate(c, new Point2f(1.0f,1.0f));c++;

              float a1=(z1+0.1f);
              x1=(float)(Math.sqrt(51.86f-(a1-z-10.8)*(a1-z-10.8))-x2-0.1);
              roadMap.setCoordinate (c, new Point3f (-x1, -0.4f, a1));
              roadMap.setTextureCoordinate(c, new Point2f(0.0f,1.0f));c++;
        }

        while(z2<z1)
        {
            z2+=0.1f;
             roadMap.setCoordinate (c, new Point3f (-x1,-0.4f,z1 ));
             roadMap.setTextureCoordinate(c, new Point2f(0.0f,0.0f));c++;

              x=(float)(Math.sqrt(116.6401f-(z2-z-10.8)*(z2-z-10.8))-x2-0.1);
              roadMap.setCoordinate (c, new Point3f (-x,-0.4f,z2 ));
              roadMap.setTextureCoordinate(c, new Point2f(1.0f,0.0f));c++;

              float a1=(z2+0.1f);
              x=(float)(Math.sqrt(116.6401f-(a1-z-10.8)*(a1-z-10.8))-x2-0.1);
              roadMap.setCoordinate (c, new Point3f (-x,-0.4f,a1 ));
              roadMap.setTextureCoordinate(c, new Point2f(1.0f,1.0f));c++;

              roadMap.setCoordinate (c, new Point3f (-x1, -0.4f, z1));
              roadMap.setTextureCoordinate(c, new Point2f(0.0f,1.0f));c++;
              
              b=z1;
              //e=x1;
        }

        ////////////////////////////////////////////////////////////////

        for(int i=0;i<4;i++)
        {
           z1=b+50*i;
          roadMap.setCoordinate (c, new Point3f (-x1,-0.4f,z1 ));
          roadMap.setTextureCoordinate(c, new Point2f(0.0f,0.0f));c++;

          roadMap.setCoordinate (c, new Point3f (-x,-0.4f,z1 ));
          roadMap.setTextureCoordinate(c, new Point2f(1.0f,0.0f));c++;
           z2=z1+50;
          roadMap.setCoordinate (c, new Point3f (-x,-0.4f,z2 ));
          roadMap.setTextureCoordinate(c, new Point2f(1.0f,1.0f));c++;

          roadMap.setCoordinate (c, new Point3f (-x1,-0.4f,z2 ));
          roadMap.setTextureCoordinate(c, new Point2f(0.0f,1.0f));c++;
          g=-x1;
          e=-x;
          h=z2;
        }

        //////////////////////////////////////////////////////////////
        for(float i=0;i<7.2;i+=0.1)
        {
              x1=g+i;  x2=e+i;
              z1=(float)(Math.sqrt(51.861-(x1-e-10.8)*(x1-e-10.8))+h-0.1);
              
              roadMap.setCoordinate (c, new Point3f (x1,-0.4f,z1 ));
              roadMap.setTextureCoordinate(c, new Point2f(0.0f,0.0f));c++;

              z2=(float)(Math.sqrt(116.6401-(x2-e-10.8)*(x2-e-10.8))+h-0.1);
              roadMap.setCoordinate (c, new Point3f (x2,-0.4f,z2 ));
              roadMap.setTextureCoordinate(c, new Point2f(1.0f,0.0f));c++;

              float a2=(x2+0.1f);
              z2=(float)(Math.sqrt(116.6401-(a2-e-10.8)*(a2-e-10.8))+h-0.1);
              roadMap.setCoordinate (c, new Point3f (a2,-0.4f,z2 ));
              roadMap.setTextureCoordinate(c, new Point2f(1.0f,1.0f));c++;
              float a1=(x1+0.1f);
              z1=(float)(Math.sqrt(51.861-(a1-e-10.8)*(a1-e-10.8))+h-0.1);
              roadMap.setCoordinate (c, new Point3f (a1,-0.4f,z1));
              roadMap.setTextureCoordinate(c, new Point2f(0.0f,1.0f));c++;
              
        }
        
        while(x2<x1)
        {
             x2+=0.1;
             roadMap.setCoordinate (c, new Point3f (x1+0.1f,-0.4f,z1 ));
             roadMap.setTextureCoordinate(c, new Point2f(0.0f,0.0f));c++;


             z2= (float)(Math.sqrt(116.6401-(x2-e-10.8)*(x2-e-10.8))+h-0.1);
             roadMap.setCoordinate (c, new Point3f (x2,-0.4f,z2 ));
             roadMap.setTextureCoordinate(c, new Point2f(1.0f,0.0f));c++;
             float a2=(x2+0.1f);
             z2=(float)(Math.sqrt(116.6401-(a2-e-10.8f)*(a2-e-10.8f))+h-0.1);
             roadMap.setCoordinate (c, new Point3f (a2, -0.4f, z2));
             roadMap.setTextureCoordinate(c, new Point2f(1.0f,1.0f));c++;

             roadMap.setCoordinate (c, new Point3f (x1+0.1f,-0.4f,z1));
             roadMap.setTextureCoordinate(c, new Point2f(0.0f,1.0f));c++;
             
              g=x2;
           
        }
      

        ///////////////////////////////////////////////////////////////////
        float i=0;
        g=-41.0f;
 
        {
          x=g;
          roadMap.setCoordinate (c, new Point3f (x,-0.4f,z1 ));
          roadMap.setTextureCoordinate(c, new Point2f(0.0f,0.0f));c++;

          roadMap.setCoordinate (c, new Point3f (x,-0.4f,z2 ));
          roadMap.setTextureCoordinate(c, new Point2f(1.0f,0.0f));c++;
           x2=-1.8f;
          // k=j+0.1f;
          roadMap.setCoordinate (c, new Point3f (x2,-0.4f,z2 ));
          roadMap.setTextureCoordinate(c, new Point2f(1.0f,1.0f));c++;

          roadMap.setCoordinate (c, new Point3f (x2,-0.4f,z1 ));
          roadMap.setTextureCoordinate(c, new Point2f(0.0f,1.0f));c++;
         // j+=0.1f;
        }

        h=z2;
        i=0;
        while(z2>=z1)
        {
            z2=h-i;
         roadMap.setCoordinate (c, new Point3f (x2,-0.4f,z1 ));
         roadMap.setTextureCoordinate(c, new Point2f(0.0f,0.0f));c++;
         x= (float)(Math.sqrt(12.962-(z2-z1)*(z2-z1))+x2-0.1);
         roadMap.setCoordinate (c, new Point3f (x,-0.4f,z2 ));
         roadMap.setTextureCoordinate(c, new Point2f(1.0f,0.0f));c++;
          float a2=z2-0.1f;
           x= (float)(Math.sqrt(12.962-(a2-z1)*(a2-z1))+x2-0.1);
         roadMap.setCoordinate (c, new Point3f (x,-0.4f,a2 ));
         roadMap.setTextureCoordinate(c, new Point2f(1.0f,1.0f));c++;

         roadMap.setCoordinate (c, new Point3f (x2,-0.4f,z1 ));
         roadMap.setTextureCoordinate(c, new Point2f(0.0f,1.0f));c++;
         i+=0.1;
         b=z1;
        }

        i=0;
        j=0;
        /////////////////////////////////////////////////////////////
        int c3=0;
        while(z2>300)
        {
            z1=b-15*i;z2=z1-15;
          roadMap.setCoordinate (c, new Point3f (x2,-0.4f+j,z1 ));
          roadMap.setTextureCoordinate(c, new Point2f(0.0f,0.0f));c++;
          bridge.setCoordinate (c3, new Point3f (x,-0.4f,z1 ));
          bridge.setTextureCoordinate(c3, new Point2f(0.0f,0.0f));c3++;
          
          roadMap.setCoordinate (c, new Point3f (x,-0.4f+j,z1 ));
          roadMap.setTextureCoordinate(c, new Point2f(1.0f,0.0f));c++;
          bridge.setCoordinate (c3, new Point3f (x,-0.4f,z2 ));
          bridge.setTextureCoordinate(c3, new Point2f(0.0f,0.0f));c3++;
          
           k=j+0.15f;
          roadMap.setCoordinate (c, new Point3f (x,-0.4f+k,z2 ));
          roadMap.setTextureCoordinate(c, new Point2f(1.0f,1.0f));c++;
          bridge.setCoordinate (c3, new Point3f (x,-0.4f+k,z2 ));
          bridge.setTextureCoordinate(c3, new Point2f(1.0f,1.0f));c3++;
         
          roadMap.setCoordinate (c, new Point3f (x2,-0.4f+k,z2 ));
          roadMap.setTextureCoordinate(c, new Point2f(0.0f,1.0f));c++;
          bridge.setCoordinate (c3, new Point3f (x,-0.4f+j,z1 ));
          bridge.setTextureCoordinate(c3, new Point2f(0.0f,1.0f));c3++;
        
          i++;
          j+=0.15f;
          e=z2;                
        }

        i=0;
        /////////////////////////////////////////////////////////////

        while(z2>=150)
        {
            z1=e-50*i;z2=z1-50;
          roadMap.setCoordinate (c, new Point3f (x2,-0.4f+k,z1 ));
          roadMap.setTextureCoordinate(c, new Point2f(0.0f,0.0f));c++;
          

          roadMap.setCoordinate (c, new Point3f (x,-0.4f+k,z1 ));
          roadMap.setTextureCoordinate(c, new Point2f(1.0f,0.0f));c++;
          

          roadMap.setCoordinate (c, new Point3f (x,-0.4f+k,z2 ));
          roadMap.setTextureCoordinate(c, new Point2f(1.0f,1.0f));c++;
          

          roadMap.setCoordinate (c, new Point3f (x2,-0.4f+k,z2 ));
          roadMap.setTextureCoordinate(c, new Point2f(0.0f,1.0f));c++;
        
          i++;        
        }

        //*********************************************************
        i=0;
        z=300;
        while(z>213)
        {
            z1=e-i;z=z1-1;
          bridge.setCoordinate (c3, new Point3f (x,-0.4f,z1 ));
          bridge.setTextureCoordinate(c3, new Point2f(0.0f,0.0f));c3++;


          bridge.setCoordinate (c3, new Point3f (x,-0.4f,z ));
          bridge.setTextureCoordinate(c3, new Point2f(1.0f,0.0f));c3++;


          bridge.setCoordinate (c3, new Point3f (x,-0.4f+k,z ));
          bridge.setTextureCoordinate(c3, new Point2f(1.0f,1.0f));c3++;


          bridge.setCoordinate (c3, new Point3f (x,-0.4f+k,z1));
          bridge.setTextureCoordinate(c3, new Point2f(0.0f,1.0f));c3++;
            i++;
        }

          bridge.setCoordinate (c3, new Point3f (x,-0.4f,z ));
          bridge.setTextureCoordinate(c3, new Point2f(0.0f,0.0f));c3++;


          bridge.setCoordinate (c3, new Point3f (x,-0.4f,210.69f ));
          bridge.setTextureCoordinate(c3, new Point2f(1.0f,0.0f));c3++;


          bridge.setCoordinate (c3, new Point3f (x,-0.4f+k,210.69f ));
          bridge.setTextureCoordinate(c3, new Point2f(1.0f,1.0f));c3++;


          bridge.setCoordinate (c3, new Point3f (x,-0.4f+k,z));
          bridge.setTextureCoordinate(c3, new Point2f(0.0f,1.0f));c3++;
          i=0;

          while(z>=139.993)
          {
            z1=207.09f-i;
            z=z1-1.0f;
          bridge.setCoordinate (c3, new Point3f (x,-0.4f,z1 ));
          bridge.setTextureCoordinate(c3, new Point2f(0.0f,0.0f));c3++;


          bridge.setCoordinate (c3, new Point3f (x,-0.4f,z ));
          bridge.setTextureCoordinate(c3, new Point2f(1.0f,0.0f));c3++;


          bridge.setCoordinate (c3, new Point3f (x,-0.4f+k,z ));
          bridge.setTextureCoordinate(c3, new Point2f(1.0f,1.0f));c3++;


          bridge.setCoordinate (c3, new Point3f (x,-0.4f+k,z1));
          bridge.setTextureCoordinate(c3, new Point2f(0.0f,1.0f));c3++;
            i++;
        }

        //////////////////////////////////////////////////////////////
         bridge.setCoordinate (c3, new Point3f (x2,-0.4f,210.69f ));
          bridge.setTextureCoordinate(c3, new Point2f(0.0f,0.0f));c3++;
         
          bridge.setCoordinate (c3, new Point3f (x2,-0.4f,e));
          bridge.setTextureCoordinate(c3, new Point2f(0.0f,0.0f));c3++;

          bridge.setCoordinate (c3, new Point3f (x2,-0.4f+k,e ));
          bridge.setTextureCoordinate(c3, new Point2f(1.0f,1.0f));c3++;

          bridge.setCoordinate (c3, new Point3f (x2,-0.4f+k,210.69f));
          bridge.setTextureCoordinate(c3, new Point2f(0.0f,1.0f));c3++;

          ////////////////////////////////////////////////////////////////
          bridge.setCoordinate (c3, new Point3f (x2,-0.4f,z2 ));
          bridge.setTextureCoordinate(c3, new Point2f(0.0f,0.0f));c3++;

          bridge.setCoordinate (c3, new Point3f (x2,-0.4f,207.09f ));
          bridge.setTextureCoordinate(c3, new Point2f(0.0f,0.0f));c3++;

          bridge.setCoordinate (c3, new Point3f (x2,-0.4f+k,207.09f));
          bridge.setTextureCoordinate(c3, new Point2f(1.0f,1.0f));c3++;

          bridge.setCoordinate (c3, new Point3f (x2,-0.4f+k,z2 ));
          bridge.setTextureCoordinate(c3, new Point2f(0.0f,1.0f));c3++;

          ////////////////////////////////////////////////////////
         z1=z2;
          roadMap.setCoordinate (c, new Point3f (x2,-0.4f+k,z1 ));
          roadMap.setTextureCoordinate(c, new Point2f(0.0f,0.0f));c++;
          bridge.setCoordinate (c3, new Point3f (x,-0.4f,z1 ));
          bridge.setTextureCoordinate(c3, new Point2f(0.0f,0.0f));c3++;
           
          roadMap.setCoordinate (c, new Point3f (x,-0.4f+k,z1 ));
          roadMap.setTextureCoordinate(c, new Point2f(1.0f,0.0f));c++;
          bridge.setCoordinate (c3, new Point3f (x,-0.4f,100 ));
          bridge.setTextureCoordinate(c3, new Point2f(1.0f,0.0f));c3++;
            
          roadMap.setCoordinate (c, new Point3f (1.8f,-0.4f,100 ));
          roadMap.setTextureCoordinate(c, new Point2f(1.0f,1.0f));c++;
          bridge.setCoordinate (c3, new Point3f (x,-0.4f,100 ));
          bridge.setTextureCoordinate(c3, new Point2f(1.0f,1.0f));c3++;
           
          roadMap.setCoordinate (c, new Point3f (-1.8f,-0.4f,100 ));
          roadMap.setTextureCoordinate(c, new Point2f(0.0f,1.0f));c++;
          bridge.setCoordinate (c3, new Point3f (x,-0.4f+k,z1));
          bridge.setTextureCoordinate(c3, new Point2f(0.0f,1.0f));c3++;
            
          

            bridge.setCoordinate (c3, new Point3f (-1.8f,-0.4f,100 ));
            bridge.setTextureCoordinate(c3, new Point2f(0.0f,0.0f));c3++;
            bridge.setCoordinate (c3, new Point3f (x2,-0.4f,z1 ));
            bridge.setTextureCoordinate(c3, new Point2f(1.0f,0.0f));c3++;
            bridge.setCoordinate (c3, new Point3f (x2,-0.4f+k,z1 ));
            bridge.setTextureCoordinate(c3, new Point2f(1.0f,1.0f));c3++;
            bridge.setCoordinate (c3, new Point3f (-1.8f,-0.4f,100));
            bridge.setTextureCoordinate(c3, new Point2f(0.0f,1.0f));c3++;

            ///////////////////////////////////////////////////////////
            //Starting Point
           int c2=0;
          chess.setCoordinate (c2, new Point3f (-1.8f,-0.399f,5 ));
          chess.setTextureCoordinate(c2, new Point2f(0.0f,0.0f));c2++;

          chess.setCoordinate (c2, new Point3f (0,-0.399f,5 ));
          chess.setTextureCoordinate(c2, new Point2f(1.0f,0.0f));c2++;

          chess.setCoordinate (c2, new Point3f (0,-0.399f,0 ));
          chess.setTextureCoordinate(c2, new Point2f(1.0f,1.0f));c2++;

          chess.setCoordinate (c2, new Point3f (-1.8f,-0.399f,0 ));
          chess.setTextureCoordinate(c2, new Point2f(0.0f,1.0f));c2++;
         
          chess.setCoordinate (c2, new Point3f (0,-0.399f,5 ));
          chess.setTextureCoordinate(c2, new Point2f(0.0f,0.0f));c2++;

          chess.setCoordinate (c2, new Point3f (1.8f,-0.399f,5 ));
          chess.setTextureCoordinate(c2, new Point2f(1.0f,0.0f));c2++;

          chess.setCoordinate (c2, new Point3f (1.8f,-0.399f,0 ));
          chess.setTextureCoordinate(c2, new Point2f(1.0f,1.0f));c2++;

          chess.setCoordinate (c2, new Point3f (0,-0.399f,0 ));
          chess.setTextureCoordinate(c2, new Point2f(0.0f,1.0f));c2++;
          
                   
          /////////////////////////////////////////////////////////////
         //Grass Texture
          int flag2=0;
        ap2.setTextureAttributes(texAttr);
       int c1=0;
       float xa=-3.6f;float xb=3.6f;
       float za=100;float zb=0;i=0;
       while(zb>=-110)
       {
           za=100-5*i;
           zb=za-5;
        flag2=grass1(xa,xb,-0.41f,-0.41f,za,zb,c1);
        c1=flag2;
             i++;
       }
       i=0;
        while(xb<312)
       {
           xa=1.8f+10*i;
           xb=xa+10.0f;
           flag2=grass1(xa,xb,-0.41f,-0.41f,-103,zb,c1);
           c1=flag2;
        
         i++;
       }
       i=0;
       while(za<204.68)
       {
           za=-103+5*i;
           zb=za+5;
           flag2=grass1(xb,314,-0.41f,-0.41f,za,zb,c1);
           c1=flag2;
         i++;
       }
       i=0;
       while(xb>-50)
       {
           xa=321-5*i; xb=xa-5;
           flag2=grass1(xa,xb,-0.41f,-0.41f,za-2,zb+1,c1);
           c1=flag2;
       
         i++;
       }
       i=0;
        while(zb<429)
       {
           za=213+5*i;zb=za+5;
           flag2=grass1(-45,-54,-0.41f,-0.41f,za,zb,c1);
           c1=flag2;
           i++;
       }
       i=0;
           while(xa<-3.6)
           {
               xa=-45+5*i;xb=xa+5;
               flag2=grass1(xa,xb,-0.41f,-0.41f,zb-2,za-6,c1);
               c1=flag2;
             i++;
           }

       /////////////////////////////////////////////////////////////
          bridge.setCoordinate (c3, new Point3f (x,-0.4f,210.69f ));
          bridge.setTextureCoordinate(c3, new Point2f(0.0f,0.0f));c3++;

          bridge.setCoordinate (c3, new Point3f (x2,-0.4f,210.69f ));
          bridge.setTextureCoordinate(c3, new Point2f(0.0f,0.0f));c3++;

          bridge.setCoordinate (c3, new Point3f (x2,-0.4f+k,210.69f ));
          bridge.setTextureCoordinate(c3, new Point2f(1.0f,1.0f));c3++;

          bridge.setCoordinate (c3, new Point3f (x,-0.4f+k,210.69f));
          bridge.setTextureCoordinate(c3, new Point2f(0.0f,1.0f));c3++;

          bridge.setCoordinate (c3, new Point3f (x2,-0.4f,207.09f ));
          bridge.setTextureCoordinate(c3, new Point2f(0.0f,0.0f));c3++;

          bridge.setCoordinate (c3, new Point3f (x,-0.4f,207.09f ));
          bridge.setTextureCoordinate(c3, new Point2f(0.0f,0.0f));c3++;

          bridge.setCoordinate (c3, new Point3f (x,-0.4f+k,207.09f ));
          bridge.setTextureCoordinate(c3, new Point2f(1.0f,1.0f));c3++;

          bridge.setCoordinate (c3, new Point3f (x2,-0.4f+k,207.09f));
          bridge.setTextureCoordinate(c3, new Point2f(0.0f,1.0f));c3++;
          
          bridge.setCoordinate (c3, new Point3f (x2,-0.4f+k,207.09f ));
          bridge.setTextureCoordinate(c3, new Point2f(0.0f,0.0f));c3++;

          bridge.setCoordinate (c3, new Point3f (x,-0.4f+k,207.09f ));
          bridge.setTextureCoordinate(c3, new Point2f(0.0f,0.0f));c3++;

          bridge.setCoordinate (c3, new Point3f (x,-0.4f+k,210.69f ));
          bridge.setTextureCoordinate(c3, new Point2f(1.0f,1.0f));c3++;

          bridge.setCoordinate (c3, new Point3f (x2,-0.4f+k,210.69f));
          bridge.setTextureCoordinate(c3, new Point2f(0.0f,1.0f));c3++;

          ////////////////////////////////////////////////////////////
          //Collision boundary
         int flag1=0;
          for( i=0;i<=10.5;i+=1.5)

        {
          flag1=sign(-2.0f+0.5f*i,-1.5f+0.5f*i,-0.4f,-0.2f,-114.0f,-114.0f,c4 );
          c4=flag1;

          flag1=sign(321.0f,321.0f,-0.4f,-0.2f,-111+0.5f*i,-110.5f+0.5f*i,c4 );
          c4=flag1;

          flag1=sign(321-0.5f*i,320.5f-0.5f*i,-0.4f,-0.2f,212,212,c4 );
          c4=flag1;

          }
             int r1=0;
            int r2=0;
            for( i=0;i<203;i++){
            r1=box1(3.6f,4.0f,-0.4f,-0.3f,100.0f-i,99.0f-i,c3);
            c3=r1;}
            for( i=0;i<215;i++){
            r2=box1(-4.0f,-3.6f,-0.4f,-0.3f,100.0f-i,99.0f-i,c3);
            c3=r2;}

            for( i=0;i<326;i++){
            r1=box1(-4.0f+i,-3.0f+i,-0.4f,-0.3f,-115.0f,-115.4f,c3);
            c3=r1;}
             for( i=0;i<310;i++){
            r2=box1(3.6f+i,4.6f+i,-0.4f,-0.3f,-103.0f,-103.4f,c3);
            c3=r2;}

             for( i=0;i<328;i++){
            r1=box1(321.95f,321.55f,-0.4f,-0.3f,-115.0f+i,-114.0f+i,c3);
            c3=r1;}
             for( i=0;i<308;i++){
            r2=box1(314f,313.6f,-0.4f,-0.3f,-103.4f+i,-102.4f+i,c3);
            c3=r2;}

            for( i=0;i<368;i++){
            r1=box1(314-i,313-i,-0.4f,-0.3f,204.6f,205.0f,c3);
            c3=r1;}
            for( i=0;i<367;i++){
            r2=box1(321.95f-i,320.95f-i,-0.4f,-0.3f,213.0f,213.4f,c3);
            c3=r2;}

            r1=box1(-1.7f,1.6f,-0.4f,-0.2f,212.0f,213.0f,c3);
            c3=r1;
            r2=box1(-1.7f,1.6f,-0.4f,-0.2f,206.9f,205.0f,c3);
            c3=r2;

            for( i=0;i<208;i+=1.4){
            r1=box1(-44.6f,-45f,-0.4f,-0.3f,213.4f+i,214.8f+i,c3);
            c3=r1;}
            for( i=0;i<226;i++){
            r2=box1(-54.0f,-54.4f,-0.4f,-0.3f,205.0f+i,206.0f+i,c3);
            c3=r2;}

            for( i=0;i<56;i++){
            r1=box1(-54.0f+i,-53.0f+i,-0.4f,-0.3f,431f,430.6f,c3);
            c3=r1;}
            for( i=0;i<43;i++){
            r2=box1(-45.0f+i,-44.0f+i,-0.4f,-0.3f,422.0f,421.6f,c3);
            c3=r2;}

            r1=box1(1.7f,2.1f,-0.4f,-0.3f,431f,422.0f,c3);
            c3=r1;


            ////////////////////////////////////////////////////////////
            //Bridge
            int c5=0;
           for(i=0,j=0;i<=150;i+=15,j+=0.15f)
          {
            r1=box2(-2.2f,-1.8f,-0.1f+j,0.2f+j,422-i,407-i,c5);
            c5=r1;
             r1=box2(-2.2f,-1.8f,-0.45f+j,-0.1f+j,409-i,407-i,c5);
           c5=r1;
           }

             for(i=0,j=0;i<=150;i+=15,j+=0.15f)
          {
            r2=box2(1.7f,2.2f,-0.1f+j,0.2f+j,422-i,407-i,c5);
            c5=r2;
            r2=box2(1.7f,2.2f,-0.45f+j,-0.1f+j,409-i,407-i,c5);
            c5=r2;
           }

            //********************************
            {
            r1=box2(-2.2f,-1.8f,-0.45f,-0.1f,422.0f,421.0f,c5);
            c5=r1;
           }
           {
            r2=box2(1.7f,2.2f,-0.45f,-0.1f,422.0f,421.0f,c5);
            c5=r2;
           }

           //***************************************
            for(i=0;i<114;i+=2)
          {
            r1=box2(-2.2f,-1.8f,-0.4f+j+0.15f,-0.12f+j+0.15f,257-i,255-i,c5);
            c5=r1;
           }
           for(i=0;i<114;i+=2)
          {
            r2=box2(1.7f,2.2f,-0.4f+j+0.15f,-0.12f+j+0.15f,257-i,255-i,c5);
            c5=r2;
             }

           ///////////////////////////////////////////////////
           for(i=0;i<129;i+=4)
          {
            r1=box2(-2.2f,-1.8f,-0.4f+k,-0.4f+j+0.15f,271-i,269-i,c5);
            c5=r1;
           }
            for(i=0;i<129;i+=4)
          {
            r2=box2(1.7f,2.2f,-0.4f+k,-0.4f+j+0.15f,271-i,269-i,c5);
            c5=r2;
             
           }

           for(i=0;i<140;i+=2)
          {
            r1=box2(-2.2f,-1.8f,-0.4f+k,-0.4f+k,269-i,265-i,c5);
            c5=r1;
           }
           for(i=0;i<140;i+=2)
          {
            r2=box2(1.7f,2.2f,-0.4f+k,-0.4f+k,269-i,265-i,c5);
            c5=r2;
           }


           //////////////////////////////////////////////////////
         for(i=0,j=0;i<42;i+=6,j+=0.22f)
          {
            r1=box2(-2.2f,-1.8f,-0.4f+k+0.15f-j,-0.1f+k+0.15f-j,142-i,136-i,c5);
           c5=r1;
          }
                                
             for(i=0,j=0;i<42;i+=6,j+=0.22f)
          {
            r2=box2(1.7f,2.2f,-0.4f+k+0.15f-j,-0.1f+k+0.15f-j,142-i,136-i,c5);
            c5=r2;
          }

           //////////////////////////////////////////////////////////

            {
            r1=box2(-4.0f,-1.8f,-0.4f,-0.16f,100.5f,100.0f,c5);
            c5=r1;
           }
          {
            r2=box2(1.8f,4.0f,-0.4f,-0.16f,100.5f,100.0f,c5);
            c5=r2;
           }

           //***********************************************************
        //roadFrame

           int c11=0;
           for( i=0;i<=315;i+=8)
          {
           r1=box3(322.95f,321.95f,-0.4f,4.0f,-100.0f+i,-99.0f+i,c11);
            c11=r1;
           r2=box3(313.6f,312.6f,-0.4f,4.0f,-100.0f+i,-99.0f+i,c11);
            c11=r2;
           r2=box3(312.6f,322.95f,5.0f,4.0f,-100.0f+i,-99.0f+i,c11);
            c11=r2;
          }
         for(i=0,k=0;i<=5;i++,k+=0.2)
         {
          r1=box3(322.95f-i,312.6f+i,-0.4f+k,-0.2f+k,213.4f+i,223.4f-i,c11);
          c11=r1;
         }

         ////////////////////////////////////////////////////////////
        //Parafeet

         int c7=0;
         int c10=0;
         int flag=0;
           for(i=0,j=0;i<12;i+=2,j+=0.30f)
           {
            for(k=0;k<=325;k++)
            {
            r1=box1(-4.0f+k,-3.0f+k,-0.3f+j,-0.15f+j,-115.4f-i,-117.4f-i,c3);
            c3=r1;
            
            flag=base2(-4.0f+k,-3.0f+k,-0.15f+j,0.0f+j,-115.4f-i,-115.4f-i,c10);
            c10=flag;
             }
          }

         ////////////////////////////////////////////////////////////
        //Buildings
          int c6=0;
         
         for( i=0;i<=216;i+=8)
         {
         flag=builds(-4.0f,-4.0f,-0.4f,4.0f,100-i,96-i,c6);
         c6=flag;
         }
          for( i=0;i<=215;i+=8)
         {
         flag=builds(-8.0f,-8.0f,-0.4f,4.0f,96-i,92-i,c6);
         c6=flag;
         }
          for( i=0;i<=215;i+=8)
          {
         flag=builds(-8.0f,-4.0f,-0.4f,4.0f,92-i,92-i,c6);
         c6=flag;
         }
          for( i=0;i<=215;i+=8)
          {
         flag=builds(-4.0f,-8.0f,-0.4f,4.0f,96-i,96-i,c6);
         c6=flag;
         }

         //****************************************************

         for( i=0;i<=200;i+=8)
         {
         flag=builds(4.0f,4.0f,-0.4f,4.0f,-103+i,-99+i,c6);
         c6=flag;
         }
          for( i=0;i<=196;i+=8)
          {
         flag=builds(8.0f,8.0f,-0.45f,4.0f,-99+i,-95+i,c6);
         c6=flag;
          }
          for( i=0;i<=196;i+=8)
          {
         flag=builds(8.0f,4.0f,-0.4f,4.0f,-95+i,-95+i,c6);
         c6=flag;
         }
          for( i=0;i<=196;i+=8)
          {
         flag=builds(4.0f,8.0f,-0.4f,4.0f,-99+i,-99+i,c6);
         c6=flag;
         }

          //********************************************************
         for(i=0;i<=304;i+=8)
         {
         flag=builds(8.0f+i,4.0f+i,-0.4f,4.0f,-103.0f,-103.0f,c6);
         c6=flag;
         }
          for(i=0;i<=300;i+=8)
          {
         flag=builds(12.0f+i,8.0f+i,-0.4f,4.0f,-99.0f,-99.0f,c6);
         c6=flag;
          }
          for(i=0;i<=300;i+=8)
          {
          flag=builds(12.0f+i,12.0f+i,-0.4f,4.0f,-103.0f,-99.0f,c6);
          c6=flag;
          }
        for(i=0;i<=304;i+=8)
        {
         flag=builds(8.0f+i,8.0f+i,-0.4f,4.0f,-99.0f,-103.0f,c6);
         c6=flag;
         }

        //************************************************************
         for(i=0;i<=24;i+=4)
         {
         flag=builds(-16.0f-i,-12.0f-i,-0.4f,4.0f,100.0f,100.0f,c6);
         c6=flag;
         flag=builds(12.0f+i,16.0f+i,-0.4f,4.0f,101.0f,101.0f,c6);
         c6=flag;
         }

          //////////////////////////////////////////////////////////
          //trees
          int c13=0;
          for(i=0;i<265;i+=8)
          {
              flag=bush1(312.6f-i,304.0f-i,1.0f,5.0f,215.2f,215.2f,c13);
              c13=flag;
              flag=bush1(304.0f-i,312.6f-i,1.0f,5.0f,203.0f,203.0f,c13);
              c13=flag;
          }
          for(i=0;i<230;i+=8)
          {
              flag=bush1(312.6f,312.6f,1.0f,5.0f,223.2f+i,215.2f+i,c13);
              c13=flag;
              flag=bush1(40.0f,40.0f,1.0f,5.0f,215.2f+i,223.2f+i,c13);
              c13=flag;
          }
              flag=bush1(40.0f,40.0f,1.0f,5.0f,101.0f,203.0f,c13);
              c13=flag;


         //////////////////////////////////////////////////////////////////
        //Advertise images
         flag=shop(-12.0f,-4.0f,-0.4f,4.0f,100.0f,100.0f,c7);
         c7=flag;
         flag=shop(4.0f,12.0f,-0.4f,4.0f,101.0f,101.0f,c7);
         c7=flag;
         for(i=0;i<=296;i+=8)
         {
         flag=shop(322.95f,322.95f,-0.4f,5.0f,197.0f-i,204.0f-i,c7);
         c7=flag;
         flag=shop(312.6f,312.6f,-0.4f,5.0f,204.0f-i,197.0f-i,c7);
         c7=flag;
         }


         ////////////////////////////////////////////////////////////
        //Water
         int c8=0;
         flag=base1(-100.0f,40f,-0.412f,-0.412f,480.0f,100.0f,c8);
         c8=flag;

         ////////////////////////////////////////////////////////
         //Hillock
         int c9=0;
         flag=hill1(-2.2f,-2.2f,-4.0f,-4.0f,-0.4f,12.0f,421.6f,213.4f,215.2f,419.8f,c9);
         c9=flag;
         flag=hill1(-44.6f,-44.6f,-42.8f,-42.8f,-0.4f,12.0f,213.4f,421.6f,419.8f,215.2f,c9);
         c9=flag;
         flag=hill1(-2.2f,-44.6f,-42.8f,-4.0f,-0.4f,12.0f,213.4f,213.4f,215.2f,215.2f,c9);
         c9=flag;
         flag=hill1(-44.6f,-2.2f,-4.0f,-42.8f,-0.4f,12.0f,421.6f,421.6f,419.8f,419.84f,c9);
         c9=flag;

         ////////////////////////////////////////////////////////////////
         //Pyramid
         flag=hill1(321.95f,321.95f,330.95f,330.95f,-0.4f,4.0f,-115.5f,-100.0f,-107.5f,-107.5f,c9);
        c9=flag;
        flag=hill1(321.95f,340.95f,330.95f,330.95f,-0.4f,4.0f,-100.0f,-100.0f,-107.5f,-107.5f,c9);
        c9=flag;

        ///////////////////////////////////////////////////////////////////
        //Trees Base
        int c12=0;
        flag=hill2(312.6f,40.0f,40.0f,312.6f,-0.4f,1.0f,213.4f,213.4f,215.2f,215.2f,c12);
        c12=flag;
        flag=hill2(40.0f,312.6f,312.6f,40.0f,-0.4f,1.0f,204.6f,204.6f,203.0f,203.0f,c12);
        c12=flag;
        flag=hill2(40.0f,40.0f,40.0f,40.0f,-0.4f,1.0f,213.4f,448.5f,447.0f,215.2f,c12);
        c12=flag;
        flag=hill2(40.0f,40.0f,40.0f,40.0f,-0.4f,1.0f,101.0f,204.6f,203.0f,101.0f,c12);
        c12=flag;
        flag=hill2(312.6f,312.6f,312.6f,312.6f,-0.4f,1.0f,448.5f,213.4f,215.2f,447.0f,c12);
        c12=flag;
          road=new Shape3D(roadMap,ap1);
          roadSide=new Shape3D(grass,ap2);
          roadStart=new Shape3D(chess,ap3);
          roadBridge=new Shape3D(bridge,ap4);
          roadBoundary=new Shape3D(boundary,ap5);
          roadtree=new Shape3D(tree,ap6);
          roadillu=new Shape3D(illu,ap7);
          roadcoke=new Shape3D(coke,ap8);
          roadbase=new Shape3D(base,ap9);
          roadhill=new Shape3D(hill,ap10);
          roadaud=new Shape3D(aud,ap11);
          roadpole=new Shape3D(pole,ap12);
          roadslope=new Shape3D(hill1,ap13);
          roadbush=new Shape3D(bush,ap14);
       }
      
}
