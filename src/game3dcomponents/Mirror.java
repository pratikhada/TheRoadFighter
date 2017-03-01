
package game3dcomponents;

import javax.media.j3d.*;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.image.BufferedImage;
import com.sun.j3d.utils.image.TextureLoader;
import javax.vecmath.*;
import java.awt.Container;

public class Mirror extends  Shape3D
{
    public Mirror()
    {
        
    }
    public Mirror(Canvas3D canvas)
    {
            BufferedImage bufferedImage = new BufferedImage(64,64,BufferedImage.TYPE_4BYTE_ABGR);
            Graphics graphics = bufferedImage.getGraphics();

            graphics.setColor(Color.RED);
            graphics.drawString("Starting", 5, 10);
            graphics.setColor(Color.BLACK);

            TextureLoader tl = new TextureLoader(bufferedImage);
            Appearance appearance =new Appearance();
            appearance.setTextureAttributes(new TextureAttributes(
            TextureAttributes.REPLACE, new Transform3D(),
            new Color4f(), TextureAttributes.NICEST));
            Texture text=tl.getTexture();
            appearance.setTexture(text);
            appearance.setCapability(Appearance.ALLOW_TEXTURE_READ);
            appearance.setCapability(Appearance.ALLOW_TEXTURE_WRITE);

            QuadArray  vert=new QuadArray(4,QuadArray.COORDINATES|QuadArray.TEXTURE_COORDINATE_2);

            vert.setCoordinate(0,new Point3f(-0.1f,0.35f,-1.5f));
            vert.setCoordinate(1,new Point3f(0.1f,0.35f,-1.5f));
            vert.setCoordinate(2,new Point3f(0.1f,0.4f,-1.5f));
            vert.setCoordinate(3,new Point3f(-0.1f,0.4f,-1.5f));

            vert.setTextureCoordinate(0, new Point2f(0.20f,0.10f));
            vert.setTextureCoordinate(1, new Point2f(0.80f,0.10f));
            vert.setTextureCoordinate(2, new Point2f(0.80f,0.45f));
            vert.setTextureCoordinate(3, new Point2f(0.20f,0.45f));
            setCapability(Shape3D.ALLOW_APPEARANCE_WRITE);
            setCapability(Shape3D.ALLOW_APPEARANCE_READ);
            setGeometry(vert);
            setAppearance(appearance);
   }

    public void changeGraphics(Canvas3D canvas)
    {
        BufferedImage bufferedImage=canvas.getOffScreenBuffer().getImage();
        TextureLoader tl=new TextureLoader(bufferedImage);
        try{
            Texture text=tl.getTexture();
            getAppearance().setTexture(text);
        }catch(OutOfMemoryError em){}
    }
    public Shape3D mirrorCover()
    {
            QuadArray  vert=new QuadArray(4,QuadArray.COORDINATES|QuadArray.TEXTURE_COORDINATE_2);

            vert.setCoordinate(0,new Point3f(-0.11f,0.34f,-1.5005f));
            vert.setCoordinate(1,new Point3f(0.11f,0.34f,-1.5005f));
            vert.setCoordinate(2,new Point3f(0.11f,0.41f,-1.5005f));
            vert.setCoordinate(3,new Point3f(-0.11f,0.41f,-1.5005f));

            vert.setTextureCoordinate(0, new Point2f(0.0f,0.0f));
            vert.setTextureCoordinate(1, new Point2f(1.0f,0.0f));
            vert.setTextureCoordinate(2, new Point2f(1.0f,1.0f));
            vert.setTextureCoordinate(3, new Point2f(0.0f,1.0f));

            TextureLoader tl = new TextureLoader(getClass().getResource("mirrorCover.png"),
                new Container());
            Appearance appearance =new Appearance();
            appearance.setTextureAttributes(new TextureAttributes(
            TextureAttributes.REPLACE, new Transform3D(),
               new Color4f(), TextureAttributes.NICEST));
            Texture text=tl.getTexture();
            appearance.setTexture(text);
            return new Shape3D(vert,appearance);
    }


     public Shape3D roadMapPlot()
    {
        QuadArray  vert=new QuadArray(4,QuadArray.COORDINATES
                |QuadArray.TEXTURE_COORDINATE_2 |QuadArray.COLOR_3);

        vert.setCoordinate(0,new Point3f(0.39f,0.127f,-1.5005f));
        vert.setCoordinate(1,new Point3f(0.583f,0.127f,-1.5005f));
        vert.setCoordinate(2,new Point3f(0.583f,0.40f,-1.5005f));
        vert.setCoordinate(3,new Point3f(0.39f,0.40f,-1.5005f));

        vert.setTextureCoordinate(0, new Point2f(0.0f,0.0f));
        vert.setTextureCoordinate(1, new Point2f(1.0f,0.0f));
        vert.setTextureCoordinate(2, new Point2f(1.0f,1.0f));
        vert.setTextureCoordinate(3, new Point2f(0.0f,1.0f));

        TextureLoader loader = new TextureLoader(getClass()
                .getResource("images/roadMap.jpg"),new Container());
        ImageComponent2D image = loader.getImage();
        Texture2D texture = new Texture2D(Texture.BASE_LEVEL, Texture.RGBA,
                                      image.getWidth(), image.getHeight());
        texture.setImage(0, image);
        texture.setEnable(true);

        texture.setMagFilter(Texture.BASE_LEVEL_LINEAR);
        texture.setMinFilter(Texture.BASE_LEVEL_LINEAR);

        Appearance appearance =new Appearance();
        appearance.setTexture(texture);
      //  PolygonAttributes polyAttrib = new PolygonAttributes();
      //  polyAttrib.setCullFace(PolygonAttributes.CULL_NONE);
      //  polyAttrib.setBackFaceNormalFlip(true);
      //  appearance.setPolygonAttributes(polyAttrib);

        TransparencyAttributes t_attr = new
                TransparencyAttributes(TransparencyAttributes.BLENDED,0.5f,

                TransparencyAttributes.BLEND_SRC_ALPHA,

                TransparencyAttributes.BLEND_ONE);

      //  appearance.setTransparencyAttributes( t_attr );

      //  appearance.setTransparencyAttributes(new
       //         TransparencyAttributes(TransparencyAttributes.NICEST,0.1f));


       /*  appearance.setTextureAttributes(new TextureAttributes(
            TextureAttributes.REPLACE, new Transform3D(),
            new Color4f(), TextureAttributes.NICEST));


            */


        return new Shape3D(vert,appearance);
    }

      public Shape3D speedCover()
    {
         QuadArray  vert=new QuadArray(4,QuadArray.COORDINATES|QuadArray.TEXTURE_COORDINATE_2);

        vert.setCoordinate(0,new Point3f(-0.11f,-0.41f,-1.5005f));
        vert.setCoordinate(1,new Point3f(0.11f,-0.41f,-1.5005f));
        vert.setCoordinate(2,new Point3f(0.11f,-0.34f,-1.5005f));
        vert.setCoordinate(3,new Point3f(-0.11f,-0.34f,-1.5005f));

        vert.setTextureCoordinate(0, new Point2f(0.0f,0.0f));
        vert.setTextureCoordinate(1, new Point2f(1.0f,0.0f));
        vert.setTextureCoordinate(2, new Point2f(1.0f,1.0f));
        vert.setTextureCoordinate(3, new Point2f(0.0f,1.0f));

        TextureLoader tl = new TextureLoader(getClass().getResource("images/speed.png"),
                new Container());
         Appearance appearance =new Appearance();
         appearance.setTextureAttributes(new TextureAttributes(
            TextureAttributes.REPLACE, new Transform3D(),
            new Color4f(), TextureAttributes.NICEST));
        Texture text=tl.getTexture();
        appearance.setTexture(text);
        return new Shape3D(vert,appearance);
    }

	
	
}
