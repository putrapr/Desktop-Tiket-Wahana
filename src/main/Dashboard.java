/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import com.toedter.calendar.JDateChooser;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
//import net.sf.jasperreports.engine.JRException;
//import net.sf.jasperreports.engine.JasperCompileManager;
//import net.sf.jasperreports.engine.JasperReport;
//import net.sf.jasperreports.engine.design.JasperDesign;
//import net.sf.jasperreports.engine.util.JRLoader;
//import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

import org.jfree.io.IOUtils;

/**
 *
 * @author user
 */
public class Dashboard extends javax.swing.JFrame {

//    public String usernamelogin;
    /**
     * Creates new form Dashboard
     */
    public Dashboard() {
        initComponents();
        setLocationRelativeTo(null);
        setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
        Locale locale = new Locale ("id","ID");
        Locale.setDefault(locale);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        bgMenu1 = new utility.BgMenu();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuUsers = new javax.swing.JMenuItem();
        menuKategori = new javax.swing.JMenuItem();
        menuPesanan = new javax.swing.JMenu();
        menuPenjualan = new javax.swing.JMenu();
        menuReportUsers = new javax.swing.JMenu();
        lap_users = new javax.swing.JMenuItem();
        lap_kategori = new javax.swing.JMenuItem();
        lap_pesanan = new javax.swing.JMenuItem();
        lap_penjualan = new javax.swing.JMenuItem();
        menuLogout = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistem Informasi Penjualan Tiket Wahana Ver.1.0");

        jPanel2.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout bgMenu1Layout = new javax.swing.GroupLayout(bgMenu1);
        bgMenu1.setLayout(bgMenu1Layout);
        bgMenu1Layout.setHorizontalGroup(
            bgMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        bgMenu1Layout.setVerticalGroup(
            bgMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 477, Short.MAX_VALUE)
        );

        jPanel2.add(bgMenu1, java.awt.BorderLayout.CENTER);

        jMenu1.setText("File");

        menuUsers.setText("Users");
        menuUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuUsersActionPerformed(evt);
            }
        });
        jMenu1.add(menuUsers);

        menuKategori.setText("Kategori Tiket");
        menuKategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuKategoriActionPerformed(evt);
            }
        });
        jMenu1.add(menuKategori);

        jMenuBar1.add(jMenu1);

        menuPesanan.setText("Pesanan");
        menuPesanan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuPesananMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuPesanan);

        menuPenjualan.setText("Penjualan");
        menuPenjualan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuPenjualanMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuPenjualan);

        menuReportUsers.setText("Laporan");

        lap_users.setText("Laporan Users");
        lap_users.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lap_usersActionPerformed(evt);
            }
        });
        menuReportUsers.add(lap_users);

        lap_kategori.setText("Laporan Kategori Tiket");
        lap_kategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lap_kategoriActionPerformed(evt);
            }
        });
        menuReportUsers.add(lap_kategori);

        lap_pesanan.setText("Laporan Pesanan");
        lap_pesanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lap_pesananActionPerformed(evt);
            }
        });
        menuReportUsers.add(lap_pesanan);

        lap_penjualan.setText("Laporan Penjualan");
        lap_penjualan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lap_penjualanActionPerformed(evt);
            }
        });
        menuReportUsers.add(lap_penjualan);

        jMenuBar1.add(menuReportUsers);

        menuLogout.setText("Logout");
        menuLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuLogoutMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuLogout);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuLogoutMouseClicked
        Login db = new Login();
        db.setVisible(true);
        dispose();
    }//GEN-LAST:event_menuLogoutMouseClicked

    private void menuPenjualanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuPenjualanMouseClicked
        Penjualan db = new Penjualan();
        db.setVisible(true);
    }//GEN-LAST:event_menuPenjualanMouseClicked

    private void menuPesananMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuPesananMouseClicked
        Pesanan db = new Pesanan();
        db.setVisible(true);
    }//GEN-LAST:event_menuPesananMouseClicked

    private void menuKategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuKategoriActionPerformed
        // TODO add your handling code here:
        Kategori db = new Kategori();
        db.setVisible(true);
    }//GEN-LAST:event_menuKategoriActionPerformed

    private void menuUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuUsersActionPerformed
        // TODO add your handling code here:
        Users db = new Users();
        db.setVisible(true);
    }//GEN-LAST:event_menuUsersActionPerformed

    public static Connection getConnection() {
        Connection connection = null;
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost/db_leuwi"; //ganti dengan database mu
        String user = "root";
        String password = "";
        if (connection == null) {
            try {
                Class.forName(driver);
                connection = DriverManager.getConnection(url, user, password);
            } catch (ClassNotFoundException | SQLException error) {
               System.exit(0);
            }
        }
        return connection;
    }
    
    private String ambilPathGambar(){
        return System.getProperty("user.dir")+"\\src\\img\\icons8_sharechat_48px.png";
    }
    
    private void lap_usersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lap_usersActionPerformed
        try {
            String namaFile = "src/reports/users.jasper";
            Map<String, Object> parameter = new HashMap<>();            
            parameter.put("LOGO", ambilPathGambar());
            File report_file = new File(namaFile);
            
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(report_file.getPath());
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,parameter,getConnection());
            JasperViewer.viewReport(jasperPrint, false); 
            JasperViewer.setDefaultLookAndFeelDecorated(true);
        } catch (JRException e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }//GEN-LAST:event_lap_usersActionPerformed

    private void lap_kategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lap_kategoriActionPerformed
        try {
            String namaFile = "src/reports/kategori.jasper";
            Map<String, Object> parameter = new HashMap<>();            
            parameter.put("LOGO", ambilPathGambar());
            File report_file = new File(namaFile);
            
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(report_file.getPath());
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,parameter,getConnection());
            JasperViewer.viewReport(jasperPrint, false); 
            JasperViewer.setDefaultLookAndFeelDecorated(true);
        } catch (JRException e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }//GEN-LAST:event_lap_kategoriActionPerformed

    private void lap_pesananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lap_pesananActionPerformed
        JDateChooser dc_dari_tgl = new JDateChooser();
        JDateChooser dc_sampai_tgl = new JDateChooser();
        Object[] fields = {
            "Cetak dari tanggal ?", dc_dari_tgl,
            "Cetak sampai tanggal ?", dc_sampai_tgl
        };
        int ok = JOptionPane.showConfirmDialog(null, fields, "Cetak laporan pesanan",
                 JOptionPane.OK_CANCEL_OPTION);
        
        if (ok==0){
            Date dari_tgl = (Date) dc_dari_tgl.getDate();
            Date sampai_tgl = (Date) dc_sampai_tgl.getDate(); 
            if (dari_tgl==null) pesanPopUp("Tanggal pesanan 'Dari' belum diisi !");
            else if (sampai_tgl==null) pesanPopUp("Tanggal pesanan 'Sampai' belum diisi ! ");
            else {
                SimpleDateFormat Format_English = new SimpleDateFormat("yyyy-MM-dd");            
                String dari_english = Format_English.format(dari_tgl);        
                String sampai_english = Format_English.format(sampai_tgl);

                SimpleDateFormat Format_Indo = new SimpleDateFormat("dd-MM-yyyy");
                String dari_indo = Format_Indo.format(dari_tgl);        
                String sampai_indo = Format_Indo.format(sampai_tgl);
                
                try {
                    String namaFile = "src/reports/pesanan.jasper";                
                    Map<String, Object> parameter = new HashMap<>();
                    parameter.put("LOGO", ambilPathGambar());
                    parameter.put("PARA_DARI_INDO", dari_indo);
                    parameter.put("PARA_SAMPAI_INDO", sampai_indo);
                    parameter.put("PARA_DARI_ENGLISH", dari_english);
                    parameter.put("PARA_SAMPAI_ENGLISH", sampai_english);
                    File report_file = new File (namaFile);

                    JasperReport jasperReport = (JasperReport) JRLoader.loadObject(report_file.getPath());
                    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,parameter,getConnection());
                    JasperViewer.viewReport(jasperPrint, false); 
                    JasperViewer.setDefaultLookAndFeelDecorated(true);
                } catch (JRException e){
                    JOptionPane.showMessageDialog(null,e.getMessage());
                }
            }
        }
    }//GEN-LAST:event_lap_pesananActionPerformed

    private void pesanPopUp(String pesan){
        JOptionPane.showMessageDialog(null, pesan);
    }
    
    private void lap_penjualanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lap_penjualanActionPerformed
        JDateChooser dc_dari_tgl = new JDateChooser();
        JDateChooser dc_sampai_tgl = new JDateChooser();
        Object[] fields = {
            "Cetak dari tanggal ?", dc_dari_tgl,
            "Cetak sampai tanggal ?", dc_sampai_tgl
        };
        int ok = JOptionPane.showConfirmDialog(null, fields, "Cetak laporan penjualan",
                 JOptionPane.OK_CANCEL_OPTION);
        
        if (ok==0){
            Date dari_tgl = (Date) dc_dari_tgl.getDate();
            Date sampai_tgl = (Date) dc_sampai_tgl.getDate(); 
            if (dari_tgl==null) pesanPopUp("Tanggal penjualan 'Dari' belum diisi !");
            else if (sampai_tgl==null) pesanPopUp("Tanggal penjualan 'Sampai' belum diisi ! ");
            else {
                SimpleDateFormat Format_English = new SimpleDateFormat("yyyy-MM-dd");            
                String dari_english = Format_English.format(dari_tgl);        
                String sampai_english = Format_English.format(sampai_tgl);

                SimpleDateFormat Format_Indo = new SimpleDateFormat("dd-MM-yyyy");
                String dari_indo = Format_Indo.format(dari_tgl);        
                String sampai_indo = Format_Indo.format(sampai_tgl);
                
                try {
                    String namaFile = "src/reports/penjualan.jasper";                
                    Map<String, Object> parameter = new HashMap<>();
                    parameter.put("LOGO", ambilPathGambar());
                    parameter.put("PARA_DARI_INDO", dari_indo);
                    parameter.put("PARA_SAMPAI_INDO", sampai_indo);
                    parameter.put("PARA_DARI_ENGLISH", dari_english);
                    parameter.put("PARA_SAMPAI_ENGLISH", sampai_english);
                    File report_file = new File (namaFile);

                    JasperReport jasperReport = (JasperReport) JRLoader.loadObject(report_file.getPath());
                    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,parameter,getConnection());
                    JasperViewer.viewReport(jasperPrint, false); 
                    JasperViewer.setDefaultLookAndFeelDecorated(true);
                } catch (JRException e){
                    JOptionPane.showMessageDialog(null,e.getMessage());
                }
            }
        }
    }//GEN-LAST:event_lap_penjualanActionPerformed

      
    
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
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private utility.BgMenu bgMenu1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JMenuItem lap_kategori;
    private javax.swing.JMenuItem lap_penjualan;
    private javax.swing.JMenuItem lap_pesanan;
    private javax.swing.JMenuItem lap_users;
    private javax.swing.JMenuItem menuKategori;
    private javax.swing.JMenu menuLogout;
    private javax.swing.JMenu menuPenjualan;
    private javax.swing.JMenu menuPesanan;
    private javax.swing.JMenu menuReportUsers;
    private javax.swing.JMenuItem menuUsers;
    // End of variables declaration//GEN-END:variables
}