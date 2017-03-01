
package game3dcomponents;
import java.io.FileNotFoundException;
import javax.media.j3d.*;
import com.sun.j3d.loaders.objectfile.ObjectFile;
import com.sun.j3d.loaders.ParsingErrorException;
import com.sun.j3d.loaders.IncorrectFormatException;
import com.sun.j3d.loaders.Scene;
import javax.vecmath.Vector3f;

public class LoadTheCarShape extends BranchGroup
{
    LoadTheCarShape(String carName)
    {
        int flags = ObjectFile.RESIZE;
        ObjectFile f =new ObjectFile(flags,(float)(49.0 * Math.PI / 180.0));//, (float)(49.0 * Math.PI / 180.0));
        Scene s = null;
        try {
            s = f.load(getClass().getResource(carName));
        }
        catch (FileNotFoundException e) {
            System.err.println(e);
            System.exit(1);
        }
        catch (ParsingErrorException e) {
            System.err.println(e);
            System.exit(1);
        }
        catch (IncorrectFormatException e) {
            System.err.println(e);
            System.exit(1);
        }

        TransformGroup tg1=new TransformGroup();
        Transform3D t=new Transform3D();
        t.rotX(Math.toRadians(-90));
        tg1.setTransform(t);
        tg1.addChild(s.getSceneGroup());

        TransformGroup tg=new TransformGroup();
        Transform3D t3d=new Transform3D();
        t3d.rotY(Math.toRadians(180.0));
        t3d.setTranslation(new Vector3f(0.0f,0.22f,0.0f));
        tg.setTransform(t3d);
      //  tg.addChild(s.getSceneGroup());
        tg.addChild(tg1);

        this.addChild(tg);
        
    //    this.addChild(s.getSceneGroup());
        
    }

}
