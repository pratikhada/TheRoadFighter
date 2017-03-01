
package theroadfighter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.SwingWorker;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

import java.net.Socket;
import java.net.InetSocketAddress;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

class SearchingHelping{
    public boolean cancelSearch;
    public SearchingHelping()
    {cancelSearch=false;}
}

public class ClientWindow  {
   public JPanel clientwindowPanel;
   public JPanel cholder;
   private JButton cancel;
   private JProgressBar searchServerProgress ;
   private String serverFound[];
   private DefaultListModel model[] ;
   private JList serversFound;
   private StartingInfo sInfo[];
   private boolean isJoined;
   private SearchingHelping searchHelp[];

  public  ClientWindow(JPanel cardHolder,StartingInfo stInfo[])
  {
        sInfo=stInfo;
        cholder=cardHolder;
        searchHelp=new SearchingHelping[1];
        searchHelp[0]=new SearchingHelping();

        clientwindowPanel = new JPanel();       //,,,,,,,,,,,,,,,,,,,,,
        clientwindowPanel.setBackground(new Color(0, 51, 102));

        JLabel searchserver=new  JLabel(" Searching Servers . . .");  //,,,,,,,,,,,,,,,,,,,
        searchserver.setFont(new Font("Arial Black", 1, 15)); 
        searchserver.setForeground(new Color(255, 255, 255));

        JLabel serverfound=new JLabel("  Servers Found");                   //,,,,,,,,,,,,,,,,,,,,
        serverfound.setFont(new Font("Arial", 1, 14)); 
        serverfound.setForeground(new Color(255, 255, 255));
        searchServerProgress = new JProgressBar(); //,,,,,,,,,,,,
        serverFound=new String[5];
        model = new DefaultListModel[1];
        model[0]=new DefaultListModel();
        serversFound = new JList(model[0]);           //,,,,,,,,,,,,,,,,,,,,
        isJoined=false;
        serversFound.addListSelectionListener(
            new javax.swing.event.ListSelectionListener()
            {
                public void valueChanged(javax.swing.event.ListSelectionEvent event)
                {
                  if(isJoined==false)
                  {
                    searchHelp[0].cancelSearch=true;
                    sInfo[0].whoAmI="CLIENT";
                    ClientThread client=new ClientThread(sInfo,
                            serverFound[serversFound.getSelectedIndex()]);
                    ExecutorService threadExecutor=Executors.newCachedThreadPool();
                    threadExecutor.execute(client);                    
                    isJoined=true;
                    threadExecutor.shutdown();
                    CardLayout cl = (CardLayout)(cholder.getLayout());
                    cl.show(cholder, "CHOOSE_CAR");
                  //  sInfo[0].chooseOptions.clickOk();
                  }
                }
        });
        JScrollPane serversFoundScroll = new JScrollPane(); //,,,,,,,,,,,,,
        serversFoundScroll.setViewportView(serversFound);
        cancel=new JButton("CANCEL");       //************************
        cancel.addActionListener(
             new ActionListener()
             {
                public void actionPerformed(ActionEvent evt)
                {
                    CardLayout cl = (CardLayout)(cholder.getLayout());
                    searchHelp[0].cancelSearch=true;
                    cl.show(cholder, "WELCOME_WINDOW");
                }
        });
        JButton stop=new JButton("STOP");    //******************************
        stop.addActionListener(
             new ActionListener()
             {
                public void actionPerformed(ActionEvent evt)
                {
                    searchHelp[0].cancelSearch=true;
                }
        });
         JLabel selectserver=new JLabel(" Select the server you want to join"); //,,,,
       selectserver.setFont(new Font("Arial", 0, 14));
       selectserver.setForeground(new Color(255, 255, 255));

       //search the servers
       sInfo[0].timerC=new Timer(10,
           new ActionListener() {
           public void actionPerformed(ActionEvent evt)
           {
                searchServerProgress.setMinimum(0);
                searchServerProgress.setMaximum(sInfo[0].ip2_4-sInfo[0].ip1_4);
                searchServerProgress.setValue(0);
                searchServerProgress.setStringPainted(true);
                SearchServers sServer=new SearchServers(sInfo,serverFound,model,searchHelp);
                sServer.addPropertyChangeListener(new PropertyChangeListener()
                {
                    public void propertyChange( PropertyChangeEvent e )
                    {
                        if ( e.getPropertyName().equals( "progress" ) )
                        {
                            int newValue = ( Integer ) e.getNewValue();
                            searchServerProgress.setValue( newValue );
                        }
                    }
                });
                searchHelp[0].cancelSearch=false;
                sServer.execute();
                sInfo[0].timerC.stop();
           }
        });

        GroupLayout clientwindowPanelLayout = new GroupLayout(clientwindowPanel);
        clientwindowPanel.setLayout(clientwindowPanelLayout);
        clientwindowPanelLayout.setHorizontalGroup(
            clientwindowPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(clientwindowPanelLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(clientwindowPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(serverfound, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchserver))
                .addContainerGap(489, Short.MAX_VALUE))
            .addGroup(GroupLayout.Alignment.TRAILING, clientwindowPanelLayout.createSequentialGroup()
                .addContainerGap(179, Short.MAX_VALUE)
                .addGroup(clientwindowPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addGroup(clientwindowPanelLayout.createSequentialGroup()
                        .addComponent(stop, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(cancel))
                    .addComponent(selectserver, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchServerProgress, GroupLayout.PREFERRED_SIZE, 419, GroupLayout.PREFERRED_SIZE)
                    .addComponent(serversFoundScroll, GroupLayout.PREFERRED_SIZE, 422, GroupLayout.PREFERRED_SIZE))
                .addGap(171, 171, 171))
        );
        clientwindowPanelLayout.setVerticalGroup(
            clientwindowPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(clientwindowPanelLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(searchserver, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(searchServerProgress, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(serverfound, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(serversFoundScroll, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(selectserver, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(clientwindowPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(stop)
                    .addComponent(cancel))
                .addContainerGap(120, Short.MAX_VALUE))
        );

      
    }
}

  

class SearchServers  extends SwingWorker< Integer, Integer >
{
    private String iPfirst,temp_ip;
    private int ipFrom, ipTo;
    private int port;
    private String messageReceived;
    private String serverFound[];
    private DefaultListModel model[] ;
    private SearchingHelping searchHelp[];

    public SearchServers( StartingInfo sInfo[],String [] found, 
            DefaultListModel mod[],SearchingHelping sh[])
    {
        iPfirst="";
        iPfirst+=sInfo[0].ip1_1;
        iPfirst+=".";
        iPfirst+=sInfo[0].ip1_2;
        iPfirst+=".";
        iPfirst+=sInfo[0].ip1_3;
        iPfirst+=".";
        ipFrom=sInfo[0].ip1_4;
        ipTo=sInfo[0].ip2_4;
        port= sInfo[0].port;
        serverFound=found;
        model=mod;
        searchHelp=sh;
    }

    public Integer doInBackground()
    {
        int noFound=0;
        for(int ip=ipFrom; ip<=ipTo; ip++)
        {
            setProgress(ip-ipFrom);
            Socket temp_client;
            ObjectInputStream in;
            ObjectOutputStream out;
            temp_ip=iPfirst+ip;           

            try
            {
                temp_client=new Socket();
                temp_client.bind(null);
                //search server with timeout of 200ms
                temp_client.connect(new InetSocketAddress(temp_ip,port),200);
                 System.out.println(temp_ip);   //;;;;;;;;;
                out = new ObjectOutputStream( temp_client.getOutputStream() );
                out.flush();
                in = new ObjectInputStream( temp_client.getInputStream() );
                try
                {
                    messageReceived = ( String ) in.readObject();
                }
                catch ( ClassNotFoundException cNFE)
                {
                    closeConnection(out,in,temp_client);
                }
               if(messageReceived.equals("connected to The Road Fighter Server"))
               {
                   // try {
                       // java.net.InetAddress address = java.net.InetAddress.getLocalHost();
                        model[0].add(noFound, temp_ip);
                        serverFound[noFound++]=temp_ip;
                 //  }catch(Exception e){}
                   sendData(out,"sorry: not connecting now");
                   closeConnection(out,in,temp_client);
                   System.out.println("found"+temp_ip);
               }
               else
                    closeConnection(out,in,temp_client);
            }
            catch ( EOFException eofE ){ }
            catch ( IOException ioE ){}
            if(searchHelp[0].cancelSearch==true)
                break;
        }
        return 0;
    }

    private void sendData( ObjectOutputStream output,String message )
   {
      try
      {
         output.writeObject( message );
         output.flush(); // flush data to output
      }
      catch ( IOException ioException ){ }
   } 

    private void closeConnection(ObjectOutputStream output,
            ObjectInputStream input, Socket client)
    {
        try
            {
                output.close();
                input.close();
                client.close();
            }
            catch ( IOException ioException ){}
    }

}



   
