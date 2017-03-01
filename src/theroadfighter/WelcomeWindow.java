
//WelcomeWindow.java

package theroadfighter;
import javax.swing.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import com.sun.j3d.utils.applet.MainFrame;


public class WelcomeWindow
{
    private JTextField clientNameTextField;
    private JTextField serverNameTextField;
    public JPanel startWindowPanel;
    public JTabbedPane firstPanel;
    public JPanel cardHolder;
    private JButton estServerButton;
    private JButton searchServerButton;
    private JRadioButton noPlayer1, noPlayer2, noPlayer3, noPlayer4,noPlayer5;
    private  ButtonGroup selectNoOfPlayer;
    private JTextField  ip1TextField,ip2TextField,ip3TextField,ip4TextField,ip5TextField;
    private StartingInfo startInfo[];
    public static MainFrame mainFrame;

    public WelcomeWindow(JPanel cards,StartingInfo sInfo[],MainFrame frame)
    {
        startInfo=sInfo;
        cardHolder=cards;
        startWindowPanel = new JPanel();
        mainFrame=frame;

        //prepare the tabbedPane
        JTabbedPane firstPanel = new JTabbedPane();
        firstPanel.setBackground(new java.awt.Color(0, 0, 0));

        //----------------------------------------------------------------
       //prepare home Tab
        JPanel homeTab = new JPanel();
        JLabel institute =new JLabel("Institute Of Engineering"); //,,,,,,,,,,,,
        institute.setFont(new Font("Tahoma", 1, 18));
        institute.setForeground(new Color(51, 0, 51));
        JLabel campus=new JLabel("Pulchowk Campus");              //,,,,,,,,,,,
        campus.setFont(new java.awt.Font("Tahoma", 1, 14));
        campus.setForeground(new java.awt.Color(255, 51, 51));
        JLabel batch=new JLabel("063BCT Batch");                  //,,,,,,,,,,,
        batch.setFont(new Font("Tahoma", 1, 14));
        batch.setForeground(new Color(255, 51, 51));
        JLabel bikash=new JLabel("1.Bikash Bishwokarma (505)");   //,,,,,,,,,
        bikash.setFont(new java.awt.Font("Tahoma", 1, 14));
        bikash.setForeground(new java.awt.Color(255, 0, 51));
        JLabel pratik=new JLabel("2.Pratik Shankar Hada (522)");  //,,,,,,,
        pratik.setFont(new java.awt.Font("Tahoma", 1, 14));
        pratik.setForeground(new java.awt.Color(255, 51, 51));
        JLabel shyam =new JLabel("3.Shyam Sundar Shah (525)");   //,,,,,,,,
        shyam.setFont(new java.awt.Font("Tahoma", 1, 14));
        shyam.setForeground(new java.awt.Color(255, 0, 0));
        JLabel projectMembers=new JLabel("A  Minor Project By:"); //,,,,,,,
        projectMembers.setFont(new java.awt.Font("Tahoma", 1, 12));
        projectMembers.setForeground(new java.awt.Color(255, 0, 51));

        homeTab.setBackground(new java.awt.Color(51, 0, 51));
        GroupLayout homeTabLayout = new GroupLayout(homeTab);
        homeTab.setLayout(homeTabLayout);
        homeTabLayout.setHorizontalGroup(
            homeTabLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, homeTabLayout.createSequentialGroup()
                .addGroup(homeTabLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, homeTabLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(institute)
                        .addGap(76, 76, 76))
                    .addGroup(homeTabLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(homeTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(batch, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campus, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(114, 114, 114)))
                .addGroup(homeTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(shyam)
                    .addComponent(bikash, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pratik, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(105, 105, 105))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, homeTabLayout.createSequentialGroup()
                .addGap(335, 335, 335)
                .addComponent(projectMembers, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                .addGap(96, 96, 96))
        );
        homeTabLayout.setVerticalGroup(
            homeTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeTabLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(projectMembers)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(homeTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(homeTabLayout.createSequentialGroup()
                        .addComponent(bikash, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pratik)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(shyam))
                    .addGroup(homeTabLayout.createSequentialGroup()
                        .addComponent(institute)
                        .addGap(15, 15, 15)
                        .addComponent(campus)))
                .addGap(12, 12, 12)
                .addComponent(batch)
                .addGap(363, 363, 363))
        );
        firstPanel.addTab("", new ImageIcon(getClass().
                getResource("icons/home.jpeg")), homeTab);

        //----------------------------------------------------------------------
        //prepare servertab
        JPanel serverTab=new JPanel();
        serverTab.setBackground(new Color(0, 0, 0));
        serverTab.setPreferredSize(new Dimension(250, 50));
        JLabel nameofplayer=new JLabel("Name");//************
        nameofplayer.setFont(new Font("Tahoma", 1, 14));
        nameofplayer.setForeground(new Color(255, 51, 51));
        serverNameTextField=new JTextField();              //,,,,,,,,,,,,,,,
        serverNameTextField.setFont(new Font("Tahoma", 1, 14));
        serverNameTextField.setForeground(new java.awt.Color(255, 51, 0));

        JLabel noofPlayer=new JLabel("No of player:");      //,,,,,,,,,,,,,,,
        noofPlayer.setFont(new Font("Tahoma", 1, 14));
        noofPlayer.setForeground(new Color(255, 51, 51));
        noPlayer1=new  JRadioButton("1");//**************
        noPlayer1.setFont(new Font("Tahoma", 1, 14));
        noPlayer1.setForeground(new Color(255, 102, 102));
        noPlayer1.addItemListener(
                new ItemListener()
              {
                    public void itemStateChanged(ItemEvent evt)
                    {
                        startInfo[0].maxNoOfPlayer=1;
                    }
                }
        );
        noPlayer2 = new JRadioButton("2");     //,,,,,,,,,,,,,,,
        noPlayer2.setFont(new Font("Tahoma", 1, 14));
        noPlayer2.setForeground(new Color(255, 51, 51));
        noPlayer2.addItemListener(
                new ItemListener()
               {
                    public void itemStateChanged(ItemEvent evt)
                    {
                        startInfo[0].maxNoOfPlayer=2;
                    }
                }
        );
        noPlayer3 = new JRadioButton("3",true);       //,,,,,,,,,,,,,,,
        startInfo[0].maxNoOfPlayer=3;
        noPlayer3.setFont(new java.awt.Font("Tahoma", 1, 14));
        noPlayer3.setForeground(new java.awt.Color(255, 51, 51));
        noPlayer3.addItemListener(
                new ItemListener()
               {
                    public void itemStateChanged(ItemEvent evt)
                    {
                        startInfo[0].maxNoOfPlayer=3;
                    }
                }
        );
        noPlayer4=new JRadioButton("4");//*****************
        noPlayer4.setFont(new Font("Tahoma", 1, 14));
        noPlayer4.setForeground(new Color(255, 51, 51));
        noPlayer4.addItemListener(
                new ItemListener()
               {
                    public void itemStateChanged(ItemEvent evt)
                    {
                        startInfo[0].maxNoOfPlayer=4;
                    }
                }
        );
        noPlayer5=new JRadioButton("5");//**************
        noPlayer5.setFont(new java.awt.Font("Tahoma", 1, 14));
        noPlayer5.setForeground(new java.awt.Color(255, 51, 51));
        noPlayer5.addItemListener(
                new ItemListener()
                {
                    public void itemStateChanged(ItemEvent evt)
                    {
                        startInfo[0].maxNoOfPlayer=5;
                    }
                }
        );
        selectNoOfPlayer=new ButtonGroup();         //,,,,,,,,,,,,,,,,,,,
        selectNoOfPlayer.add(noPlayer1);
        selectNoOfPlayer.add(noPlayer2);
        selectNoOfPlayer.add(noPlayer3);
        selectNoOfPlayer.add(noPlayer4);
        selectNoOfPlayer.add(noPlayer5);

        estServerButton=new JButton("Establish Server"); //***************
        estServerButton.setFont(new Font("Tahoma", 1, 18));
        estServerButton.setForeground(new Color(0, 102, 0));
        estServerButton.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent evt)
                    {

                        CardLayout cl = (CardLayout)(cardHolder.getLayout());
                        if(startInfo[0].setPlayerName(serverNameTextField.getText()))
                        {
                            startInfo[0].timerS.start();
                            cl.show(cardHolder,"SERVER_WINDOW");
                        }
                    }
                }
        );


        javax.swing.GroupLayout serverTabLayout = new javax.swing.GroupLayout(serverTab);
        serverTab.setLayout(serverTabLayout);
        serverTabLayout.setHorizontalGroup(
            serverTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(serverTabLayout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(serverTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(noofPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameofplayer, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(serverTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(serverTabLayout.createSequentialGroup()
                        .addComponent(noPlayer1)
                        .addGap(18, 18, 18)
                        .addComponent(noPlayer2)
                        .addGap(18, 18, 18)
                        .addComponent(noPlayer3)
                        .addGap(18, 18, 18)
                        .addComponent(noPlayer4)
                        .addGap(18, 18, 18)
                        .addComponent(noPlayer5))
                    .addComponent(serverNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(498, 498, 498))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, serverTabLayout.createSequentialGroup()
                .addContainerGap(122, Short.MAX_VALUE)
                .addComponent(estServerButton)
                .addGap(612, 612, 612))
        );
        serverTabLayout.setVerticalGroup(
            serverTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, serverTabLayout.createSequentialGroup()
                .addContainerGap(69, Short.MAX_VALUE)
                .addGroup(serverTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameofplayer, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(serverNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(serverTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(noofPlayer)
                    .addComponent(noPlayer1)
                    .addComponent(noPlayer2)
                    .addComponent(noPlayer3)
                    .addComponent(noPlayer4)
                    .addComponent(noPlayer5))
                .addGap(42, 42, 42)
                .addComponent(estServerButton)
                .addContainerGap())
        );

         firstPanel.addTab("", new ImageIcon(
                 getClass().getResource("icons/server.png")),  serverTab); //NOI18N

         //---------------------------------------------------------------------
         //prepare the client tab
            JPanel clientTab=new JPanel();//*******************
            clientTab.setBackground(new Color(51, 0, 51));
            JLabel enameclient=new JLabel("Enter Name");//**********************
            enameclient.setFont(new java.awt.Font("Tahoma", 1, 14));
            enameclient.setForeground(new Color(255, 0, 51));
            clientNameTextField=new JTextField();
            clientNameTextField.setFont(new java.awt.Font("Tahoma", 1, 14));
            clientNameTextField.setForeground(new java.awt.Color(255, 51, 102));
            JLabel serversearch=new JLabel("SEARCH SERVER FROM IP");//*********
            serversearch.setFont(new Font("Tahoma", 1, 14));
            serversearch.setForeground(new Color(255, 51, 51));

            ip1TextField =new JTextField("10");            //**************
            ip1TextField.setFont(new java.awt.Font("Tahoma", 1, 14));
            ip1TextField.setForeground(new java.awt.Color(255, 51, 102));

            ip2TextField =new JTextField("200");  //********************
            ip2TextField.setFont(new Font("Tahoma", 1, 14));
            ip2TextField.setForeground(new Color(255, 51, 102));
            ip3TextField =new  JTextField("0");           //*******************
            ip3TextField.setFont(new Font("Tahoma 14", 1, 14));
            ip3TextField.setForeground(new Color(255, 51, 102));

            ip4TextField =new JTextField("1");             //*******************
            ip4TextField.setFont(new Font("Tahoma", 1, 14));
            ip4TextField.setForeground(new Color(255, 51, 102));
            ip4TextField.setText("1");
            JLabel To =new JLabel("To");//****************************************
            To.setFont(new Font("Tahoma", 1, 14));
            To.setForeground(new Color(255, 102, 102));

            ip5TextField=new  JTextField("255");//*********************
            ip5TextField.setFont(new Font("Tahoma", 1, 14));
            ip5TextField.setForeground(new Color(255, 51, 102));

            searchServerButton=new  JButton("SEARCH");//***********************
            searchServerButton.setFont(new  Font("Tahoma", 1, 14));
            searchServerButton.setForeground(new Color(255, 51, 51));
            searchServerButton.setText("SEARCH");
             searchServerButton.addActionListener(
                new ActionListener()
                 {
                    public void actionPerformed(ActionEvent event)
                    {
                        if( startInfo[0].setPlayerName(clientNameTextField.getText()) )
                           if(  startInfo[0].setSearchingIps(Integer.parseInt(ip1TextField.getText()),
                                Integer.parseInt(ip2TextField.getText()),
                                Integer.parseInt(ip3TextField.getText()),
                                Integer.parseInt(ip4TextField.getText()),
                                Integer.parseInt(ip5TextField.getText()))
                            )
                           {
                               startInfo[0].timerC.start();
                               CardLayout cl = (CardLayout)(cardHolder.getLayout());
                               cl.show(cardHolder, "CLIENT_WINDOW");
                           }
                    }
                }
        );

     JLabel jLabel4=new JLabel();

        javax.swing.GroupLayout clientTabLayout = new javax.swing.GroupLayout(clientTab);
        clientTab.setLayout(clientTabLayout);
        clientTabLayout.setHorizontalGroup(
            clientTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, clientTabLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(searchServerButton)
                .addGap(800, 800, 800))
            .addGroup(clientTabLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(clientTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(clientTabLayout.createSequentialGroup()
                        .addComponent(serversearch)
                        .addGap(18, 18, 18)
                        .addComponent(ip1TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ip2TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ip3TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ip4TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(To)
                        .addGap(10, 10, 10)
                        .addComponent(ip5TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(clientTabLayout.createSequentialGroup()
                        .addComponent(enameclient)
                        .addGap(18, 18, 18)
                        .addComponent(clientNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(413, 413, 413))
        );
        clientTabLayout.setVerticalGroup(
            clientTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clientTabLayout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(clientTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(enameclient)
                    .addComponent(clientNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(clientTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(serversearch)
                    .addComponent(ip1TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ip2TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ip3TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ip4TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(To)
                    .addComponent(ip5TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(searchServerButton)
                .addGap(23, 23, 23))
        );

       firstPanel.addTab("", new ImageIcon(getClass().
                getResource("icons/client.png")), clientTab); // NOI18N

      //****************************************
       //prepare help tab
                JPanel helpTab=new JPanel();//**************
                helpTab.setBackground(new java.awt.Color(51, 0, 51));
                JLabel aboutgame=new  JLabel("About Game");//**********************
                aboutgame.setForeground(new Color(255, 51, 51));
                JLabel jLabel6=new JLabel();//*******************
                jLabel6.setFont(new  Font("Tahoma", 0, 12));
                jLabel6.setForeground(new Color(255, 0, 0));
                jLabel6.setText("The Road Fighter is a multiplayer networking game  developed  by");
                JLabel jLabel7=new JLabel();//***********************
                jLabel7.setFont(new Font("Tahoma", 0, 12));
                jLabel7.setForeground(new java.awt.Color(255, 0, 0));
                jLabel7.setText("a  project team of III year II part minor project of IOE, Pulchowk");
                JLabel jLabel17=new JLabel();
                jLabel17.setFont(new Font("Tahoma", 0, 12));
                jLabel17.setForeground(new Color(255, 0, 0));
                jLabel17.setText("campus 063BCT batch....");
                JLabel jLabel18=new JLabel();//*****************************
                jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12));
                jLabel18.setForeground(new java.awt.Color(255, 0, 0));
                JButton helpButton=new JButton();//********************************
                helpButton.setFont(new java.awt.Font("Tahoma", 1, 12));
                helpButton.setForeground(new java.awt.Color(255, 0, 0));
                helpButton.setText("for more help...");
             helpButton.addActionListener(new java.awt.event.ActionListener()
            {
               public void actionPerformed(java.awt.event.ActionEvent evt)
               {
               }
              }
             );

        javax.swing.GroupLayout helpTabLayout = new javax.swing.GroupLayout(helpTab);
        helpTab.setLayout(helpTabLayout);
        helpTabLayout.setHorizontalGroup(
            helpTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(helpTabLayout.createSequentialGroup()
                .addGroup(helpTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, helpTabLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, helpTabLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(helpTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(aboutgame, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(helpTabLayout.createSequentialGroup()
                        .addGap(293, 293, 293)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(227, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, helpTabLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(helpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(756, 756, 756))
        );
        helpTabLayout.setVerticalGroup(
            helpTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(helpTabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(helpTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(aboutgame)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17)
                .addGap(18, 18, 18)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(helpButton)
                .addGap(28, 28, 28))
        );

       firstPanel.addTab("", new ImageIcon(getClass().getResource("icons/help.jpeg")),helpTab); // NOI18N

       JButton exitButton=new JButton("EXIT");
       exitButton.addActionListener(
               new ActionListener()
       {
           public void actionPerformed(ActionEvent evt)
           {
               try{
                   Thread.currentThread().sleep(500);
                  }
               catch(InterruptedException x){}
               mainFrame.dispose();
               System.exit(0);
           }
       });
    //   JPanel exPanel=new JPanel();

        GroupLayout startWindowPanelLayout = new GroupLayout(startWindowPanel);
        startWindowPanel.setLayout(startWindowPanelLayout);
        startWindowPanelLayout.setHorizontalGroup(
            startWindowPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 726, Short.MAX_VALUE)
            .addGroup(startWindowPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(startWindowPanelLayout.createSequentialGroup()
                    .addGap(41, 41, 41)
                    .addComponent(firstPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(41, Short.MAX_VALUE)))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,startWindowPanelLayout.createSequentialGroup()
                    .addContainerGap(225, Short.MAX_VALUE)
                    .addComponent(exitButton)
                    .addGap(110, 110, 110))
        );
        startWindowPanelLayout.setVerticalGroup(
            startWindowPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 341, Short.MAX_VALUE)
            .addGroup(startWindowPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(startWindowPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(firstPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                   // .addContainerGap()
                    .addGap(15, 15, 15)
                    .addComponent(exitButton)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))

        );

    }
}
