 // created on: Sunday, December 13,2009
 //RoadFighter.java

package theroadfighter;

import javax.swing.*;
import java.awt.CardLayout;
import com.sun.j3d.utils.applet.MainFrame;
import java.awt.event.*;
import javax.swing.Timer;
import java.applet.AudioClip;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics;
import javax.swing.ImageIcon;


public class RoadFighter extends JApplet
{
    JPanel basePanel;
    private JPanel cardsHolder;
    private JPanel startPanel;
    private JPanel serverWindow;
    private JPanel clientWindow;
    private StartingInfo startInfo[];
    public static MainFrame mainFrame;
    public static Timer mainTimer;
    static RoadFighter roadFighter;            

    public void init()
    {
        basePanel =new JPanel();
        cardsHolder=new JPanel();
        cardsHolder.setLayout(new CardLayout());
        //public variable used as global variable
        startInfo=new StartingInfo[1];
        startInfo[0]=new StartingInfo();
        
        //prepare a WELCOME JPanel
        WelcomeWindow fWindow=new WelcomeWindow(cardsHolder,startInfo,mainFrame);
        startPanel=fWindow.startWindowPanel;
        cardsHolder.add(startPanel,"WELCOME_WINDOW");
        ServerWindow sWindow=new ServerWindow(cardsHolder,startInfo);
        serverWindow=sWindow.serverWindowPanel;
        cardsHolder.add(serverWindow,"SERVER_WINDOW");
        ClientWindow cwindow=new ClientWindow(cardsHolder,startInfo);
        clientWindow=cwindow.clientwindowPanel;
        cardsHolder.add(clientWindow,"CLIENT_WINDOW");
        ChooseCar cCar=new ChooseCar(cardsHolder,startInfo,mainFrame);
        cardsHolder.add(cCar.choosecarwindowPanel,"CHOOSE_CAR");

        basePanel.add(cardsHolder);
        add(basePanel);
    }

    public void startProgram()
    {
       // splashSound.play();
       /* mainTimer=new Timer(50,
                new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
               // roadFighter=new RoadFighter();
                mainFrame = new MainFrame(roadFighter,1024,768);
                mainFrame.setAlwaysOnTop(true);
                mainFrame.setResizable(false);
                mainFrame.setTitle("The Road Fighter - a car race");
                splashSound.stop();
                mainTimer.stop();
            }
        });*/
        new SplashWindow(startInfo);
      //  mainTimer.start();
    }

    public static void main(String[] args)
    {
       roadFighter=new RoadFighter();
     //  roadFighter.startProgram();
       mainFrame = new MainFrame(roadFighter,1000,720);
      // mainFrame.setAlwaysOnTop(true);
       mainFrame.setResizable(false);
       mainFrame.setTitle("The Road Fighter - a car race");
     //  roadFighter.startProgram();
      // roadFighter=null;
    }

}


class SplashWindow extends JFrame
{
    private Timer animationTimer,t1;     
    private final static String IMAGE_NAME = "deitel"; 
    protected ImageIcon images[];
    private final int TOTAL_IMAGES = 18;
    private int currentImage = 0;
    private int ANIMATION_DELAY =1000;
    private int width;
    private int height;


   SplashWindow(StartingInfo t[])
    {
        images = new ImageIcon[ TOTAL_IMAGES ];
         for ( int count = 0; count < images.length; count++ )
         {
             System.out.println(count);
         images[ count ] = new ImageIcon( getClass().getResource(
            "images1/" + IMAGE_NAME + count + ".JPG" ) );
         
         }
        LogoAnimatorJPanel logo=new LogoAnimatorJPanel(this,t);
        logo.startAnimation();
        this.add(logo );
        this.setVisible(true);
        width =1024;
                //images[ 0 ].getIconWidth();
        height =768;
                //images[ 0 ].getIconHeight();
        this.setSize(width, height);
    }


    class LogoAnimatorJPanel extends JPanel
    {
        JFrame fram;
        StartingInfo tim[];
        public LogoAnimatorJPanel(JFrame frame,StartingInfo t[])
        {
            fram=frame;
            tim=t;
            animationTimer = new Timer( ANIMATION_DELAY, new TimerHandler() );
            t1=new Timer( 200, new TimerHandler() );
        }
        public void paintComponent( Graphics g )
        {
            super.paintComponent( g );
            if(currentImage==0)
            {
                t1.stop();
                animationTimer.start();
            }
            else if(currentImage==13)
            {
                animationTimer.stop();
                t1.restart();
            }
            
            if(currentImage==18)
                stopAnimation();
            else
            {
            images[ currentImage ].paintIcon( this, g, 0, 0 );
            if ( animationTimer.isRunning()||t1.isRunning() )
                 currentImage = ( currentImage + 1 ); //% TOTAL_IMAGES;
            }

        }

        public void startAnimation()
        {
            if ( animationTimer == null )
            {
                currentImage = 0;
                tim[0].splash.loop();
                animationTimer.start();                
            }
            else
            {
                if ( ! animationTimer.isRunning() )
                    animationTimer.restart();
            } 
        }

        public void stopAnimation()
        {
            animationTimer.stop();            
            tim[0].splash.stop();
            tim[0].background.loop();
            fram.dispose();
           // fram.setVisible(false);
        }

        private class TimerHandler implements ActionListener
        {
            public void actionPerformed( ActionEvent actionEvent )
            {
                repaint();
            }
        }
    }

}
