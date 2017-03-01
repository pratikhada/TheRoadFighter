
package game3dcomponents;

import javax.media.j3d.BranchGroup;
import javax.media.j3d.Background;
import javax.media.j3d.Appearance;
import javax.media.j3d.Texture;
import com.sun.j3d.utils.geometry.Sphere;
import com.sun.j3d.utils.geometry.Primitive;
import com.sun.j3d.utils.image.TextureLoader;


public class BackGround extends javax.swing.JApplet
{
    public Background createBackGround()
    {
        BranchGroup backGroup =new BranchGroup();
        Appearance App1 = new Appearance();
        Appearance App2=new Appearance();
         try {
            Texture tex1 = new TextureLoader(getClass().getResource("blue-sky-texture.jpg"),
                    this).getTexture();
            App1.setTexture(tex1);
            }
        catch (Exception e)
        {
        }
        Sphere sky = new Sphere( 1.0f, Primitive.GENERATE_TEXTURE_COORDS
                | Primitive.GENERATE_NORMALS_INWARD, App1);
        backGroup.addChild(sky);
        Background backGround=new Background();
        backGround.setGeometry(backGroup);
        return backGround;
    }
    
}
