
/*
 * ChooseOptions.java
 * Created on Mar 10, 2010, 2:50:31 PM
 */

package game3dcomponents;

public class ChooseOptions extends javax.swing.JFrame {

    public boolean capabilities[]; // 0=MIRROR, 1=MAP ,2=METER, 3=SOUND
    private boolean choosen[];

    public ChooseOptions() {
        capabilities=new boolean[4];
        choosen=new boolean[4];
        for(int i=0;i<4;i++)
        {
            capabilities[i]=false;
            choosen[i]=false;
        }
        capabilities[3]=true;
        choosen[3]=true;
        initComponents();
    }

    public void clickOk()
    {
        this.setVisible(true);
        this.setAlwaysOnTop(true);
        this.setResizable(false); 
        return;
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        mirrorCheckBox = new javax.swing.JCheckBox();
        mapCheckBox = new javax.swing.JCheckBox();
        meterCheckBox = new javax.swing.JCheckBox();
        soundCheckBox = new javax.swing.JCheckBox();
        okButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mirrorCheckBox.setText("Show Mirror");
        mirrorCheckBox.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                mirrorCheckBoxStateChanged(evt);
            }
        });
        mirrorCheckBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                mirrorCheckBoxItemStateChanged(evt);
            }
        });
        mirrorCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mirrorCheckBoxActionPerformed(evt);
            }
        });

        mapCheckBox.setText("Show Map");
        mapCheckBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                mapCheckBoxItemStateChanged(evt);
            }
        });
        mapCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mapCheckBoxActionPerformed(evt);
            }
        });

        meterCheckBox.setText("Show Speed Meter");
        meterCheckBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                meterCheckBoxItemStateChanged(evt);
            }
        });
        meterCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meterCheckBoxActionPerformed(evt);
            }
        });

        soundCheckBox.setSelected(true);
        soundCheckBox.setText("Sound on");
        soundCheckBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                soundCheckBoxItemStateChanged(evt);
            }
        });
        soundCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                soundCheckBoxActionPerformed(evt);
            }
        });

        okButton.setText("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mapCheckBox)
                            .addComponent(mirrorCheckBox)
                            .addComponent(meterCheckBox)
                            .addComponent(soundCheckBox)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(okButton)))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(mirrorCheckBox)
                .addGap(18, 18, 18)
                .addComponent(mapCheckBox)
                .addGap(18, 18, 18)
                .addComponent(meterCheckBox)
                .addGap(18, 18, 18)
                .addComponent(soundCheckBox)
                .addGap(18, 18, 18)
                .addComponent(okButton)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mirrorCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mirrorCheckBoxActionPerformed

    }//GEN-LAST:event_mirrorCheckBoxActionPerformed

    private void mapCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mapCheckBoxActionPerformed

    }//GEN-LAST:event_mapCheckBoxActionPerformed

    private void meterCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meterCheckBoxActionPerformed
    
    }//GEN-LAST:event_meterCheckBoxActionPerformed

    private void soundCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_soundCheckBoxActionPerformed
   
    }//GEN-LAST:event_soundCheckBoxActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        for(int i=0; i<4; i++)
            capabilities[i]=choosen[i];
        System.out.println("ok "+capabilities[1]);
        this.setVisible(false);
    }//GEN-LAST:event_okButtonActionPerformed

    private void mirrorCheckBoxStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_mirrorCheckBoxStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_mirrorCheckBoxStateChanged

    private void mirrorCheckBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_mirrorCheckBoxItemStateChanged
        choosen[0]=mirrorCheckBox.isSelected()?true:false;
    }//GEN-LAST:event_mirrorCheckBoxItemStateChanged

    private void mapCheckBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_mapCheckBoxItemStateChanged
        choosen[1]=mapCheckBox.isSelected()?true:false;
        System.out.println("map "+choosen[1]);
    }//GEN-LAST:event_mapCheckBoxItemStateChanged

    private void meterCheckBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_meterCheckBoxItemStateChanged
        choosen[2]=meterCheckBox.isSelected()?true:false;
    }//GEN-LAST:event_meterCheckBoxItemStateChanged

    private void soundCheckBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_soundCheckBoxItemStateChanged
        choosen[3]=soundCheckBox.isSelected()?true:false;
    }//GEN-LAST:event_soundCheckBoxItemStateChanged

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JCheckBox mapCheckBox;
    private javax.swing.JCheckBox meterCheckBox;
    private javax.swing.JCheckBox mirrorCheckBox;
    private javax.swing.JButton okButton;
    private javax.swing.JCheckBox soundCheckBox;
    // End of variables declaration//GEN-END:variables

}
