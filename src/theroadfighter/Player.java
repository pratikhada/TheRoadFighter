

package theroadfighter;
import javax.vecmath.Point3f;
import javax.vecmath.Vector3f;


public class Player implements java.io.Serializable
{
    public int index,lap;
    transient public String name,ip;
    public Point3f position;
    public Point3f prev_position;
    public Vector3f direction;
    public float velocity;
    public boolean isParticipated,isReady,isStart,isAddedToList,isDropped,gameOver;
    transient public String carModel;


    public Player()
    {
        position=new Point3f();
        direction=new Vector3f();
        isParticipated=false;
        isReady=false;
        isAddedToList=false;
        isDropped=false;
        lap=0;
        gameOver=false;
        
    }
    public void printData()
    {
        System.out.print("index="+index);
        System.out.println("position="+position+" direction="+direction);
    }
}
