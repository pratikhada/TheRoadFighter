
package theroadfighter;

import javax.swing.*;
import java.awt.*;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingWorker;

import java.io.IOException;
import java.net.ServerSocket;
import javax.swing.JOptionPane;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;


public class ServerWindow  extends javax.swing.JApplet
{

    public JPanel serverWindowPanel;
    private JPanel cardHolder;
    private JButton cancelButton;
    private JButton playButton;
    private JProgressBar connProgressBar;
    private StartingInfo sInfo[];
    private DefaultListModel model[] ;
    private String ConPlayer[];
    private boolean isClicked[];
    Timer tim;

    public ServerWindow(JPanel cHolder,StartingInfo stInfo[])
    {
        isClicked=new boolean[1];
        isClicked[0]=false;
        sInfo=stInfo;
        cardHolder =cHolder;
        serverWindowPanel = new JPanel();           //,,,,,,,,,,,,,,,,,,,,,,,,,,
        serverWindowPanel.setBackground(new Color(0, 51, 102));
        JLabel estConnLabel = new JLabel(" Establishing Connection..."); //,,,,,,
        estConnLabel.setFont(new Font("Arial Black", 1, 14));
        estConnLabel.setForeground(new Color(255, 255, 255));

        connProgressBar = new JProgressBar();  //,,,,,,,,,,,,,,,
        sInfo[0].timerS = new Timer(10,
            new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                sInfo[0].isServerExists=true;
                connProgressBar.setMinimum(0);
                connProgressBar.setMaximum(sInfo[0].maxNoOfPlayer);
                connProgressBar.setValue(0);
                Establishing est=new Establishing(sInfo);
                est.addPropertyChangeListener(new PropertyChangeListener()
                {
                    public void propertyChange( PropertyChangeEvent e )
                    {
                        if ( e.getPropertyName().equals( "progress" ) )
                        {
                            int newValue = ( Integer ) e.getNewValue();
                            connProgressBar.setValue( newValue );
                        }
                    }
                });
                est.execute();
                sInfo[0].timerS.stop();
                if(est.getStatus()==0)
                {
                    sInfo[0].isServerExists=false;
                    try{
                        sInfo[0].server[0].close();
                    }catch(IOException ex){}
                    JOptionPane.showMessageDialog(null,"Sorry couldn't establish",
                            "Establishing Error",JOptionPane.ERROR_MESSAGE);
                     CardLayout cl = (CardLayout)(cardHolder.getLayout());
                    cl.show(cardHolder, "WELCOME_WINDOW");
                }
                else tim.start();
            }
        });

        connProgressBar.setStringPainted(true);
        JLabel connPlayerLabel = new JLabel("Connected Players"); //,,,,,,,,,
        connPlayerLabel.setFont(new Font("Tahoma", 1, 12));
        connPlayerLabel.setForeground(new Color(255, 255, 255));
        model=new DefaultListModel[1]; //,,,,,,,,,,,,,,,,,,,,,,,
        model[0]=new DefaultListModel();
        JList connPlayerList = new JList(model[0]);             //,,,,,,,,,,,,,,,,

        JScrollPane connPlayerScrollPane = new JScrollPane();   //,,,,,,,,,,,,,,,,,,
        connPlayerScrollPane.setViewportView(connPlayerList);

        tim=new Timer(100,
            new ActionListener() {
                public void actionPerformed(ActionEvent evt)
                {
                    ConPlayer=new String[6];
                    Connected connected=new Connected(sInfo,ConPlayer,model,isClicked);
                    connected.execute();
                    /*  while(true)
                    {
                        if(sInfo[0].player!=null)
                        {
                            for(int i=1; i<sInfo[0].maxNoOfPlayer; i++)
                            {
                                if(sInfo[0].player[i]!=null)
                                {
                                    if(sInfo[0].player[i].name!=null)
                                      if(sInfo[0].player[i].isAddedToList==false &&
                                        sInfo[0].player[i].name.length()>2)
                                     {
                                        sInfo[0].player[i].isAddedToList=true;
                                        model.add(noFound++, sInfo[0].player[i].ip
                                                +"  "+sInfo[0].player[i].name);
                                     }
                                }
                            }
                        }
                    }*/
                    tim.stop();
                }
        });

        playButton = new JButton("  PLAY  ");         //,,,,,,,,,,,,,,,,,,,,,
        playButton.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent evt)
                    {
                        sInfo[0].whoAmI="SERVER";
                        CardLayout cl = (CardLayout)(cardHolder.getLayout());
                        cl.show(cardHolder, "CHOOSE_CAR");
                       // sInfo[0].chooseOptions.clickOk();
                        isClicked[0]=true;
                    }
        });

        cancelButton = new JButton("CANCEL");               //,,,,,,,,,,,,,,,,,,
        cancelButton.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent evt)
                    {
                        CardLayout cl = (CardLayout)(cardHolder.getLayout());
                        sInfo[0].isServerExists=false;
                        try{
                            sInfo[0].server[0].close();
                        }catch(IOException ex){}
                        catch(java.lang.NullPointerException ex){}
                        cl.show(cardHolder, "WELCOME_WINDOW");
                        isClicked[0]=true;
                    }
        });

        GroupLayout serverWindowPanelLayout = new GroupLayout(serverWindowPanel);
        serverWindowPanel.setLayout(serverWindowPanelLayout);
        serverWindowPanelLayout.setHorizontalGroup(
            serverWindowPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, serverWindowPanelLayout.createSequentialGroup()
                .addContainerGap(195, Short.MAX_VALUE)
                .addComponent(connProgressBar, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)
                .addGap(321, 321, 321))
            .addGroup(serverWindowPanelLayout.createSequentialGroup()
                .addGap(164, 164, 164)
                .addComponent(estConnLabel)
                .addContainerGap(325, Short.MAX_VALUE))
            .addGroup(GroupLayout.Alignment.TRAILING, serverWindowPanelLayout.createSequentialGroup()
                .addContainerGap(164, Short.MAX_VALUE)
                .addGroup(serverWindowPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(playButton)
                    .addGroup(serverWindowPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(connPlayerLabel, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
                        .addComponent(connPlayerScrollPane, GroupLayout.PREFERRED_SIZE, 320, GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cancelButton)
                .addGap(155, 155, 155))
        );
        serverWindowPanelLayout.setVerticalGroup(
            serverWindowPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(serverWindowPanelLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(estConnLabel, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(connProgressBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(connPlayerLabel)
                .addGap(18, 18, 18)
                .addComponent(connPlayerScrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addGroup(serverWindowPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(playButton)
                    .addComponent(cancelButton))
                .addGap(129, 129, 129))
        );


    }

}

class Establishing  extends SwingWorker< Integer, Integer >
{
    private static ExecutorService threadExecutor;
    ServerThreads [] players;
    private int status;
    StartingInfo [] startInfo;

    public Establishing(StartingInfo sInfo[])
    {
        startInfo=sInfo;
        status=1;
    }

    public Integer doInBackground()
    {
        try{
        Thread.currentThread().sleep(100);
        startInfo[0].server[0]=new ServerSocket(startInfo[0].port, 100);
        threadExecutor=Executors.newCachedThreadPool();
        players=new ServerThreads[startInfo[0].maxNoOfPlayer-1];

        startInfo[0].player=new theroadfighter.Player[startInfo[0].maxNoOfPlayer];
        for(int i=0; i< startInfo[0].maxNoOfPlayer; i++)
        {
            //create and initialize other players
            startInfo[0].player[i]=new theroadfighter.Player();
            startInfo[0].player[i].index=i;
            startInfo[0].player[i].direction=new javax.vecmath.Vector3f(0.0f,0.0f,-1.0f);
            startInfo[0].player[i].position=new
                    javax.vecmath.Point3f(i%2*1.8f-0.9f,-0.28f,(float)(i*2+1));
            startInfo[0].player[i].prev_position=new
                    javax.vecmath.Point3f(i%2*1.8f-0.9f,-0.28f,(float)(i*2+2));
            startInfo[0].player[i].velocity=0.0f;
        }
        //create and initialize server player
        startInfo[0].id=0;
        startInfo[0].player[0].name=startInfo[0].playerName;
        startInfo[0].player[0].ip=startInfo[0].server[0].getInetAddress().getHostAddress();
        startInfo[0].player[0].isParticipated=true;
        setProgress(1);
        int playerCount=0;
        while(playerCount < players.length )
        {
            players[playerCount]=new ServerThreads(startInfo[0].server,playerCount,startInfo);
            threadExecutor.execute(players[playerCount]);
            playerCount++;
            Thread.currentThread().sleep(100);
            setProgress(playerCount+1);
        }
        threadExecutor.shutdown();
        }
        catch(IOException ex)
        {
            status=0;
        }
       catch( java.lang.InterruptedException e){ }
       startInfo[0].mePlayer=startInfo[0].player[0];
       return status;
    }

    public int getStatus()
    {
        return status;
    }
}



class Connected extends SwingWorker< Integer, Integer >
{
    private DefaultListModel model[];
    private String connectedClients[];
    int noFound=0;
    StartingInfo sInfo[];
    boolean clicked[];

    public Connected(StartingInfo stInfo[],String [] found,
            DefaultListModel mod[],boolean click[])
    {
        connectedClients=found;
        model=mod;
        sInfo=stInfo;
        clicked=click;
    }

    public Integer doInBackground()
    {
        while(clicked[0]==false)
        {
            if(sInfo[0].player!=null)
            {
                for(int i=1; i<sInfo[0].maxNoOfPlayer; i++)
                {
                    if(sInfo[0].player[i]!=null)
                    {
                      if(sInfo[0].player[i].ip!=null)
                        if(sInfo[0].player[i].isAddedToList==false)
                        {
                            sInfo[0].player[i].isAddedToList=true;
                            model[0].add(noFound++, sInfo[0].player[i].ip);
                        }
                    }
                }
            }
          }
        return 0;
    }
}

