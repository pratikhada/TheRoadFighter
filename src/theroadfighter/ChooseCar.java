
package theroadfighter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import com.sun.j3d.utils.applet.MainFrame;
import game3dcomponents.*;

public class ChooseCar
   {
     public JPanel choosecarwindowPanel;
        private String names[]={"Chevrolet","Acura","Buick","Audi","BMW","Bentley","mercedes"};
        private Icon icons[]={
            new ImageIcon(getClass().getResource("images/"+names[0]+".jpg")),
        new ImageIcon(getClass().getResource("images/"+names[1]+".jpg")),
        new ImageIcon(getClass().getResource("images/"+names[2]+".jpg")),
        new ImageIcon(getClass().getResource("images/"+names[3]+".jpg")),
        new ImageIcon(getClass().getResource("images/"+names[4]+".jpg")),
        new ImageIcon(getClass().getResource("images/"+names[5]+".jpg")),
        new ImageIcon(getClass().getResource("images/"+names[6]+".jpg"))
        };
        private JLabel carmodelpreview;
        private  JComboBox carModelJCombo;
        public JButton cancel, start;
        private GameStartWindow gameWindow;
        private boolean started;
        private StartingInfo sInfo[];

      public ChooseCar(final JPanel cholder,StartingInfo stInfo[],final MainFrame frame)
       {
        sInfo=stInfo;
        started=false;
        choosecarwindowPanel = new JPanel();    //,,,,,,,,,,,,,,,,,,,,
        choosecarwindowPanel.setBackground(new Color(0, 51, 102));
        choosecarwindowPanel.setForeground(new Color(204, 204, 204));
         JLabel  difficulty = new JLabel(" Select Game Level");  //*******************
         difficulty.setFont(new Font("Arial Black", 0, 14));
         difficulty.setForeground(new Color(0, 102, 102));
        JRadioButton easy= new JRadioButton("Easy",false);//************************
          easy.addItemListener(
                new ItemListener()
                 {
                    public void itemStateChanged(ItemEvent evt)
                    {
                        if(sInfo[0].whoAmI.equals("SERVER"))
                            sInfo[0].difficulty="EASY";
                    }
                }
        );
            easy.setBackground(new Color(0, 51, 102));
            easy.setForeground(new Color(204, 204, 204));
            JRadioButton medium = new JRadioButton("Medium",true);//******************
            sInfo[0].difficulty="MEDIUM";
                 medium.addItemListener(
                    new ItemListener()
                    {
                        public void itemStateChanged(ItemEvent evt)
                        {
                            if(sInfo[0].whoAmI.equals("SERVER"))
                            sInfo[0].difficulty="MEDIUM";
                         }
                    }
             );
            medium.setBackground(new Color(0, 51, 102));
            medium.setForeground(new Color(204, 204, 204));
            JRadioButton hard = new JRadioButton("Hard",false);//*************************
                     hard.addItemListener(
                             new ItemListener()
                            {
                                public void itemStateChanged(ItemEvent evt)
                                 {
                                     if(sInfo[0].whoAmI.equals("SERVER"))
                                        sInfo[0].difficulty="DIFFICULT";
                                 }
                             }
                             );
             hard.setBackground(new Color(0, 51, 102));
             hard.setForeground(new Color(204, 204, 204));



        //*********************************************radiobutton group*********
            ButtonGroup  radiogroup=new ButtonGroup();
            radiogroup.add(hard);
            radiogroup.add(medium);
            radiogroup.add(easy);
            JLabel carmodel = new JLabel("Car Model");//**********************
            carmodel.setFont(new Font("Arial Black", 0, 14));
            carmodel.setForeground(new Color(0, 102, 102));
            carmodelpreview = new JLabel("Car Model Preview");//************************
            carmodelpreview.setFont(new Font("Arial", 0, 14));
            carmodelpreview.setForeground(new Color(0, 102, 102));
            carmodelpreview.setIcon(icons[0]);
            carmodelpreview.setHorizontalTextPosition(SwingConstants.CENTER);
            carmodelpreview.setVerticalTextPosition(SwingConstants.BOTTOM);
            carmodelpreview.setSize(icons[0].getIconWidth(),
                icons[0].getIconHeight());
//**************  FOR   CAR CHOOSING DIASPLAY********************
            carModelJCombo = new JComboBox(names);    //car image in combobox
            carModelJCombo.setMaximumRowCount(6);
            carModelJCombo.setSize(200, 300);
            sInfo[0].carModel=names[0];
            carModelJCombo.addItemListener( new ItemListener()
                     {
                         public void itemStateChanged(ItemEvent ev)
                         {
                             if(ev.getStateChange()==ItemEvent.SELECTED)
                             {
                                     carmodelpreview.setIcon(icons[carModelJCombo.getSelectedIndex()]);
                                     sInfo[0].carModel= names[carModelJCombo.getSelectedIndex()];
                              }
                         }
                    }
            );
                     cancel=new JButton("CANCEL");
                     cancel.setForeground(new Color(255,0,0));
                     cancel.setFont(new Font("Arial", 0, 14));
                     cancel.addActionListener(
                        new ActionListener(){
                            public void actionPerformed(ActionEvent evt)
                         {
                            CardLayout cl = (CardLayout)(cholder.getLayout());
                             sInfo[0].isServerExists=false;
                             cl.show(cholder, "WELCOME_WINDOW");
                         }
                        }
                     );


                cancel.setHorizontalTextPosition(SwingConstants.RIGHT);
                choosecarwindowPanel.add(cancel);
                start=new JButton("START");
                start.setForeground(new Color(255,0,0));
                start.setFont(new Font("Arial", 0, 14));
                start.addActionListener(
                    new ActionListener()
                {
                         public void actionPerformed(ActionEvent evt)
                            {
                                if(started==false)
                                    {
                                          started=true;
                                             if(sInfo[0].whoAmI.equals("SERVER"))
                                                 {
                                                     sInfo[0].player[0].carModel=sInfo[0].carModel;
                                                         sInfo[0].player[0].isReady=true;
                                                     }
                                     sInfo[0].isCarChoosen=true;
                                     while(sInfo[0].player==null);
                                     gameWindow=new GameStartWindow(sInfo);
                                     while(sInfo[0].player[sInfo[0].id]==null);
                                     gameWindow.startGame();
                         //  frame.setVisible(false);
                                         frame.dispose();
                                         sInfo[0].background.stop();
                                    }
                        }
                   }
                 );

                   choosecarwindowPanel.add(start);
       

         JLayeredPane carPreviewLayer = new JLayeredPane();  //,,,,,,,,,,,,,,,,
        carPreviewLayer.setBounds(-50, -10, 170, 110);
        
        GroupLayout choosecarwindowPanelLayout = new GroupLayout(choosecarwindowPanel);
        choosecarwindowPanel.setLayout(choosecarwindowPanelLayout);

        choosecarwindowPanelLayout.setHorizontalGroup(
            choosecarwindowPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(choosecarwindowPanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(choosecarwindowPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(difficulty)
                    .addGroup(choosecarwindowPanelLayout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addGroup(choosecarwindowPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(hard)
                            .addComponent(medium)
                            .addComponent(easy, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)))
                    .addGroup(choosecarwindowPanelLayout.createSequentialGroup()
                        .addGroup(choosecarwindowPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(carModelJCombo, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)
                            .addComponent(carmodel, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(GroupLayout.Alignment.TRAILING, choosecarwindowPanelLayout.createSequentialGroup()
                .addComponent(carmodelpreview, GroupLayout.PREFERRED_SIZE, icons[0].getIconWidth(), GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
             .addGroup(GroupLayout.Alignment.TRAILING, choosecarwindowPanelLayout.createSequentialGroup()
                .addComponent(start)
                 .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cancel)
                .addGap(374, 374, 374))
        )));

        choosecarwindowPanelLayout.setVerticalGroup(
            choosecarwindowPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(choosecarwindowPanelLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(difficulty)
                .addGap(6, 6, 6)
                .addComponent(easy)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(medium)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(hard)
                .addGap(58, 58, 58)
                .addComponent(carmodel)
                .addGap(18, 18, 18)
                .addComponent(carModelJCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(338, 338, 338)
                .addContainerGap(0, Short.MAX_VALUE))
            .addGroup(GroupLayout.Alignment.TRAILING, choosecarwindowPanelLayout.createSequentialGroup()
                .addComponent(carmodelpreview, GroupLayout.PREFERRED_SIZE, icons[0].getIconHeight()+20, GroupLayout.PREFERRED_SIZE)
              .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
             .addGroup(choosecarwindowPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(start)
                .addComponent(cancel)
                .addGap(124, 124, 124))
        ));

    }
}
   

