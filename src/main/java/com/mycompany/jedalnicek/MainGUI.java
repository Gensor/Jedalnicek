/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jedalnicek;

import java.awt.Color;
import java.awt.Font;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author John
 */
public class MainGUI extends javax.swing.JFrame {
    private DBconnect dbconect ;
    /**
     * Creates new form MainGUI
     */
    public MainGUI() throws SQLException  {
        initComponents();
        dbconect = new DBconnect();
        zobrazRecepty(dbconect);
        
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jPanel_Main = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_Main_tyzdenZoznam = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Main_tyzdenNutrienty = new javax.swing.JTable();
        jButton_Main_pridajRecept = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Jedalnicek");
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel_Main.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane2.setViewportBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jTable_Main_tyzdenZoznam.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTable_Main_tyzdenZoznam.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"00:00", null, null, null, null, null, null, null},
                {"01:00", null, null, null, null, null, null, null},
                {"02:00", null, null, null, null, null, null, null},
                {"03:00", null, null, null, null, null, null, null},
                {"04:00", null, null, null, null, null, null, null},
                {"05:00", null, null, null, null, null, null, null},
                {"06:00", null, null, null, null, null, null, null},
                {"07:00", null, null, null, null, null, null, null},
                {"08:00", null, null, null, null, null, null, null},
                {"09:00", null, null, null, null, null, null, null},
                {"10:00", null, null, null, null, null, null, null},
                {"11:00", null, null, null, null, null, null, null},
                {"12:00", null, null, null, null, null, null, null},
                {"13:00", null, null, null, null, null, null, null},
                {"14:00", null, null, null, null, null, null, null},
                {"15:00", null, null, null, null, null, null, null},
                {"16:00", null, null, null, null, null, null, null},
                {"17:00", null, null, null, null, null, null, null},
                {"18:00", null, null, null, null, null, null, null},
                {"19:00", null, null, null, null, null, null, null},
                {"20:00", null, null, null, null, null, null, null},
                {"21:00", null, null, null, null, null, null, null},
                {"22:00", null, null, null, null, null, null, null},
                {"23:00", null, null, null, null, null, null, null}
            },
            new String [] {
                "cas", "Pondelok", "Utorok", "Streda", "Stvrtok", "Piatok", "Sobota", "Nedela"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_Main_tyzdenZoznam.setColumnSelectionAllowed(true);
        jTable_Main_tyzdenZoznam.setGridColor(new java.awt.Color(204, 204, 204));
        jTable_Main_tyzdenZoznam.setRowHeight(32);
        jTable_Main_tyzdenZoznam.setSelectionBackground(new java.awt.Color(51, 153, 255));
        jTable_Main_tyzdenZoznam.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable_Main_tyzdenZoznam.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable_Main_tyzdenZoznam.setShowGrid(true);
        jTable_Main_tyzdenZoznam.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTable_Main_tyzdenZoznam);
        jTable_Main_tyzdenZoznam.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (jTable_Main_tyzdenZoznam.getColumnModel().getColumnCount() > 0) {
            jTable_Main_tyzdenZoznam.getColumnModel().getColumn(0).setResizable(false);
        }

        jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jTable_Main_tyzdenNutrienty.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Bielkoviny", null, null, null, null, null, null, null},
                {"Sacharidy", null, null, null, null, null, null, null},
                {"Tuky", null, null, null, null, null, null, null},
                {"kcal", null, null, null, null, null, null, null}
            },
            new String [] {
                "Makronutrienty", "Pondelok", "Utorok", "Streda", "Stvrtok", "Piatok", "Sobota", "Nedela"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_Main_tyzdenNutrienty.setColumnSelectionAllowed(true);
        jTable_Main_tyzdenNutrienty.setGridColor(new java.awt.Color(204, 204, 204));
        jTable_Main_tyzdenNutrienty.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jTable_Main_tyzdenNutrienty.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jTable_Main_tyzdenNutrienty.setShowGrid(true);
        jTable_Main_tyzdenNutrienty.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable_Main_tyzdenNutrienty);
        jTable_Main_tyzdenNutrienty.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jButton_Main_pridajRecept.setText("+");
        jButton_Main_pridajRecept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Main_pridajReceptActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(138, 157, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel_MainLayout = new javax.swing.GroupLayout(jPanel_Main);
        jPanel_Main.setLayout(jPanel_MainLayout);
        jPanel_MainLayout.setHorizontalGroup(
            jPanel_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_MainLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 980, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(35, 35, 35)
                .addComponent(jButton_Main_pridajRecept, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel_MainLayout.setVerticalGroup(
            jPanel_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_MainLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Main_pridajRecept, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_Main, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_Main, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_Main_pridajReceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Main_pridajReceptActionPerformed
      
        
        int riadok = jTable_Main_tyzdenZoznam.getSelectedRow();
        int stlpec = jTable_Main_tyzdenZoznam.getSelectedColumn();
        System.out.println(riadok+" "+stlpec);
        
        
        
        
        
        
        
        
    }//GEN-LAST:event_jButton_Main_pridajReceptActionPerformed

    /**
     * @param args the command line arguments
     */
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MainGUI().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Main_pridajRecept;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel_Main;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable_Main_tyzdenNutrienty;
    private javax.swing.JTable jTable_Main_tyzdenZoznam;
    // End of variables declaration//GEN-END:variables

    private void zobrazRecepty(DBconnect dbconect) throws SQLException {
       
        for (int hodina = 0; hodina < 24; hodina++) {
            for (int den = 1; den < 8; den++) {
                ReceptDenHodina rdh = dbconect.getReceptDenHodina(den,hodina);
                if(rdh!=null){
                    String nazovReceptu = rdh.getNazov();
                    jTable_Main_tyzdenZoznam.setValueAt(nazovReceptu, hodina, den);
                    
                }
            }
        }
        
    }
}
