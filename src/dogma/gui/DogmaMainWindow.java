package dogma.gui;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.SwingWorker;
import org.apache.commons.validator.routines.UrlValidator;

public class DogmaMainWindow extends javax.swing.JFrame {

    public DogmaMainWindow() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jLabel2 = new javax.swing.JLabel();
        currenlyCrawlingUrl = new javax.swing.JLabel();
        startUrl = new javax.swing.JTextField();
        startButton = new javax.swing.JButton();
        outputField = new javax.swing.JScrollPane();
        outputTextArea = new javax.swing.JTextArea();
        jTextMaxDepth = new javax.swing.JTextField();
        depthLabel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButtonClearDB = new javax.swing.JButton();
        jTextMinImgSizeKB = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jRadioGrabImg = new javax.swing.JRadioButton();
        jRadioPrio2New = new javax.swing.JRadioButton();
        jTextMaxDequeSize = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextSaveFolder = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jRadioWrite2DB = new javax.swing.JRadioButton();
        jRadioStayInDomain = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dogma Web Crawler");
        setBackground(new java.awt.Color(153, 153, 255));
        setForeground(new java.awt.Color(0, 0, 0));
        setName("MainWindow"); // NOI18N
        setSize(new java.awt.Dimension(800, 500));

        jLabel2.setText("Crawling:");

        currenlyCrawlingUrl.setText("anchorUrl");

        startUrl.setText("http://www.github.com");
        startUrl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startUrlActionPerformed(evt);
            }
        });

        startButton.setText("Crawl");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        outputTextArea.setBackground(new java.awt.Color(0, 0, 204));
        outputTextArea.setColumns(20);
        outputTextArea.setFont(new java.awt.Font("Hack", 0, 12)); // NOI18N
        outputTextArea.setForeground(new java.awt.Color(255, 255, 255));
        outputTextArea.setRows(5);
        outputTextArea.setWrapStyleWord(true);
        outputTextArea.setCaretColor(new java.awt.Color(255, 255, 255));
        outputTextArea.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        outputTextArea.setFocusable(false);
        outputTextArea.setMaximumSize(new java.awt.Dimension(220, 85));
        outputTextArea.setName(""); // NOI18N
        outputTextArea.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        outputField.setViewportView(outputTextArea);

        jTextMaxDepth.setText("4");
        jTextMaxDepth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextMaxDepthActionPerformed(evt);
            }
        });
        jTextMaxDepth.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextMaxDepthKeyTyped(evt);
            }
        });

        depthLabel.setText("Depth");

        jButton1.setText("Clear");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButtonClearDB.setText("Clear DB");
        jButtonClearDB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClearDBActionPerformed(evt);
            }
        });

        jTextMinImgSizeKB.setText("50");
        jTextMinImgSizeKB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextMinImgSizeKBKeyTyped(evt);
            }
        });

        jLabel1.setText("Min. Img. Size in kB");

        jRadioGrabImg.setSelected(true);
        jRadioGrabImg.setText("Grab Images");

        jRadioPrio2New.setText("Prio2NewDomains");
        jRadioPrio2New.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioPrio2NewItemStateChanged(evt);
            }
        });

        jTextMaxDequeSize.setText("10");
        jTextMaxDequeSize.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextMaxDequeSizeKeyTyped(evt);
            }
        });

        jLabel3.setText("Deque");

        jTextSaveFolder.setText("/home/arjen/Pictures");
        jTextSaveFolder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextSaveFolderMouseClicked(evt);
            }
        });
        jTextSaveFolder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextSaveFolderActionPerformed(evt);
            }
        });

        jLabel4.setText("Save images in:");

        jRadioWrite2DB.setText("Write2DB");

        jRadioStayInDomain.setSelected(true);
        jRadioStayInDomain.setText("Stay Within Domain");
        jRadioStayInDomain.setToolTipText("Don't let the crawler wander of to some other domain");
        jRadioStayInDomain.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jRadioStayInDomainStateChanged(evt);
            }
        });

        jLabel5.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(currenlyCrawlingUrl))
                            .addComponent(startUrl, javax.swing.GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioStayInDomain)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextMaxDepth, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(depthLabel)
                        .addGap(6, 6, 6)
                        .addComponent(jTextMaxDequeSize, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(jLabel3))
                    .addComponent(outputField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonClearDB))
                    .addComponent(jRadioPrio2New)
                    .addComponent(jRadioGrabImg)
                    .addComponent(jRadioWrite2DB)
                    .addComponent(jLabel1)
                    .addComponent(jTextMinImgSizeKB, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jTextSaveFolder, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(currenlyCrawlingUrl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(startUrl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioStayInDomain)
                    .addComponent(jTextMaxDepth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(depthLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextMaxDequeSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jRadioPrio2New))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jRadioGrabImg)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextMinImgSizeKB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextSaveFolder, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(startButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 115, Short.MAX_VALUE)
                        .addComponent(jRadioWrite2DB)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButtonClearDB)))
                    .addComponent(outputField))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startCrawling() throws IOException {
        SwingWorker<Void, Void> worker;
        worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                startButton.setBackground(Color.blue);
                String crawlerUrl = startUrl.getText();
                currenlyCrawlingUrl.setText(crawlerUrl);
                String minImgSizeKB = jTextMinImgSizeKB.getText();
                String[] schemes = {"http", "https"};
                UrlValidator urlValidator = new UrlValidator(schemes);

                if (urlValidator.isValid(crawlerUrl)) {
                   new Crawler().initCrawler(crawlerUrl);
                } else {
                    System.out.println("URL is NOT valid");
                }
                return null;
            }
        };
        PrintStream printStream = new PrintStream(new CustomOutputStream(outputTextArea));
        System.setOut(printStream);
        //System.setErr(printStream);
        worker.execute();
    }

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        try {
            startCrawling();
        } catch (IOException ex) {
            Logger.getLogger(DogmaMainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_startButtonActionPerformed

    private void startUrlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startUrlActionPerformed
        try {
            startCrawling();
        } catch (IOException ex) {
            Logger.getLogger(DogmaMainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_startUrlActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        outputTextArea.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonClearDBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClearDBActionPerformed
        /* try {
            ConnectionDB.dbClearDomain();
        } catch (SQLException ex) {
            Logger.getLogger(DogmaMainWindow.class.getName()).log(Level.SEVERE, null, ex);
        } */
    }//GEN-LAST:event_jButtonClearDBActionPerformed

    private void jTextMaxDepthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextMaxDepthActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextMaxDepthActionPerformed

    private void jTextSaveFolderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextSaveFolderMouseClicked
        jFileChooser1.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnVal = jFileChooser1.showOpenDialog(DogmaMainWindow.this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File f = jFileChooser1.getSelectedFile();
            jTextSaveFolder.setText(f.getAbsolutePath());
        }
    }//GEN-LAST:event_jTextSaveFolderMouseClicked

    private void jTextSaveFolderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextSaveFolderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextSaveFolderActionPerformed

    private void jTextMaxDepthKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextMaxDepthKeyTyped
        char c = evt.getKeyChar();
        String bs = "\b";
        if (!((c >= '0') && (c <= '9')
                || (c == bs.charAt(0)))) {
            getToolkit().beep();
            evt.consume();
        }
        if (jTextMaxDepth.getText().length() == 0){
            jTextMaxDepth.setText("1");
        }
    }//GEN-LAST:event_jTextMaxDepthKeyTyped

    private void jTextMaxDequeSizeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextMaxDequeSizeKeyTyped
       char c = evt.getKeyChar();
        String bs = "\b";
        if (!((c >= '0') && (c <= '9')
                || (c == bs.charAt(0)))) {
            getToolkit().beep();
            evt.consume();
        }
        if (jTextMaxDequeSize.getText().length() == 0){
            jTextMaxDequeSize.setText("1");
        }
    }//GEN-LAST:event_jTextMaxDequeSizeKeyTyped

    private void jTextMinImgSizeKBKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextMinImgSizeKBKeyTyped
        char c = evt.getKeyChar();
        String bs = "\b";
        if (!((c >= '0') && (c <= '9')
                || (c == bs.charAt(0)))) {
            getToolkit().beep();
            evt.consume();
        }
        if (jTextMinImgSizeKB.getText().length() == 0){
            jTextMinImgSizeKB.setText("1");
        }
    }//GEN-LAST:event_jTextMinImgSizeKBKeyTyped

    private void jRadioStayInDomainStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioStayInDomainStateChanged
        if (jRadioStayInDomain.isSelected()) {
            jRadioPrio2New.setSelected(false);
        }
    }//GEN-LAST:event_jRadioStayInDomainStateChanged

    private void jRadioPrio2NewItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioPrio2NewItemStateChanged
        if (jRadioPrio2New.isSelected()) {
        jRadioStayInDomain.setSelected(false);
        }
    }//GEN-LAST:event_jRadioPrio2NewItemStateChanged

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DogmaMainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            DogmaMainWindow dmw = new DogmaMainWindow();
            dmw.setVisible(true);
        });
    }
    
    public static void updateImage(BufferedImage img) {
        int newWidth = 130;
        int newHeight = 130;
        BufferedImage resized = new BufferedImage(newWidth, newHeight, img.getType());
        Graphics2D g = resized.createGraphics();
        
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.drawImage(img, 0, 0, newWidth, newHeight, 0, 0, img.getWidth(), img.getHeight(), null);
        
        jLabel5.setIcon(new ImageIcon(resized));
        g.dispose();
    }

    public void setCurrenlyCrawlingUrl(JLabel currenlyCrawlingUrl) {
        this.currenlyCrawlingUrl = currenlyCrawlingUrl;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel currenlyCrawlingUrl;
    private javax.swing.JLabel depthLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonClearDB;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    public static javax.swing.JLabel jLabel5;
    public static javax.swing.JRadioButton jRadioGrabImg;
    public static javax.swing.JRadioButton jRadioPrio2New;
    public static javax.swing.JRadioButton jRadioStayInDomain;
    public static javax.swing.JRadioButton jRadioWrite2DB;
    public static javax.swing.JTextField jTextMaxDepth;
    public static javax.swing.JTextField jTextMaxDequeSize;
    public static javax.swing.JTextField jTextMinImgSizeKB;
    public static javax.swing.JTextField jTextSaveFolder;
    private static javax.swing.JScrollPane outputField;
    public static javax.swing.JTextArea outputTextArea;
    public static javax.swing.JButton startButton;
    private javax.swing.JTextField startUrl;
    // End of variables declaration//GEN-END:variables
}
