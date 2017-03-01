
package theroadfighter;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import game3dcomponents.*;
import java.net.ServerSocket;
import java.applet.AudioClip;
/**
 *
 * @author bikash
 */
public class StartingInfo extends javax.swing.JApplet
{
    public int id;
    public String playerName;
    public int port;
    public int ip1_1,ip1_2,ip1_3,ip1_4,ip2_4;
    public String difficulty,carModel;
    public Timer timerS;
    public Timer timerC;
    public boolean isServerExists,isCarChoosen,isGameStarted;
    public String whoAmI;
    public int maxNoOfPlayer;
    public Player player[];
    public Player mePlayer;
    public boolean collided;
    public AudioClip background,splash;
    public ServerSocket server[];
    public ChooseOptions chooseOptions;

    public StartingInfo()
    {
        playerName=null;
        port=55555;
        isCarChoosen=false;
        isGameStarted=false;
        mePlayer=new Player();
        collided=false;
        player=null;
        server=new ServerSocket[1];
        chooseOptions=new ChooseOptions();
        background=newAudioClip(getClass().getResource("sounds/splash.mid"));
        splash=newAudioClip(getClass().getResource("sounds/splash.mid"));
        background.loop();
    }

    public boolean setSearchingIps(int ip11,
            int ip12, int ip13, int ip14, int ip24)
    {
        boolean ipPractical=true;
        String message="";
        ip1_1=ip11; ip1_2=ip12; ip1_3=ip13; ip1_4=ip14; ip2_4=ip24;
        if(ip1_1>255 || ip1_1<0)
        {
            ipPractical=false;
            message="Error in first field of IP.";
        }
        if(ip1_2>255 || ip1_2<0)
        {
            ipPractical=false;
            message+="\nError in second field of IP.";
        }
        if(ip1_3>255 || ip1_3<0)
        {
            ipPractical=false;
            message+="\nError in third field of IP.";
        }
        if(ip1_4>255 || ip1_4<0)
        {
            ipPractical=false;
            message+="\nError in fourth field of IP.";
        }
        if(ip2_4>255 || ip2_4<0)
        {
            ipPractical=false;
            message+="\nError in fifth field of IP.";
        }
        if(ip2_4<ip1_4)
            ipPractical=false;

        if(ipPractical == false)
            JOptionPane.showMessageDialog(this, message+"\n    (Each field should lie within 0-255).",
                    "IP Field Error..",JOptionPane.ERROR_MESSAGE);
        return ipPractical;
    }

     public boolean setPlayerName(String name)
       {
            playerName=null;
            boolean nameNotNull=true;
            playerName=name;
            if(playerName.length()<2)
            {
            nameNotNull=false;
            JOptionPane.showMessageDialog(this,"A name should contain more than 2 letters!",
                    "Name Fields Error..",JOptionPane.ERROR_MESSAGE);
             }
         return nameNotNull;
       }


    public boolean areAllReady()
     {
        boolean ready=true;
         for(int i=0; i<maxNoOfPlayer; i++)
         {
             if( player[i].isParticipated== true && player[i].isReady== false)
                 ready=false;
         }
          return ready;
     }

     public boolean areAllStarted()
     {
            boolean started=true;
             for(int i=0; i<maxNoOfPlayer; i++)
             {
               if( player[i].isParticipated== true && player[i].isStart== false)
                 started=false;
              }
         return started;
      }

    }
