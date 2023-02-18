package main;
import utility.KoneksiDB;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 * @author user
 */
public class Penjualan extends javax.swing.JFrame {
    KoneksiDB DB = new KoneksiDB();
    Statement stat = DB.stat;
    ResultSet rs;
    String query, id_jual, id_pesanan, id_pesLama, nama, pembayaran, str_tgl;
    String[] arrPesanan;
    int jumlah, harga, no=0;
    
    public Penjualan() {
        initComponents();
        setLocationRelativeTo(null);
        tabel();
        setCbPesanan();
    }

    private void tabel(){
        DefaultTableModel tb = new DefaultTableModel();
        tb.addColumn("Id Jual");
        tb.addColumn("Pesanan");
        tb.addColumn("Pembayaran");
        tb.addColumn("Total");
        tb.addColumn("Tgl Pembayaran");
        tb_penjualan.setModel(tb);
        
        query = "SELECT * FROM tb_penjualan JOIN tb_pesanan ON "
              + "(tb_penjualan.id_pesanan=tb_pesanan.id_pesanan)";
        try {
            rs = stat.executeQuery(query);           
            while(rs.next()) {
                str_tgl = rs.getString("tanggal_pembayaran");
                str_tgl = formatTglId(str_tgl);
                tb.addRow(new Object[]{
                    rs.getString("id_penjualan"),
                    rs.getString("id_pesanan")+" - "+rs.getString("nama_pemesan"),
                    rs.getString("jenis_pembayaran"),
                    rs.getString("total"),
                    str_tgl
                });
            }
        } catch(SQLException e){
            System.err.println(e.getMessage());
        }
    }

    public void setCbPesanan(){
        int panjang = 0, no=0;
        query = "SELECT COUNT(id_pesanan) FROM tb_pesanan WHERE status = 'Belum dibayar'";
        try {
            rs = stat.executeQuery(query);
            if (rs.next()) {
                panjang = rs.getInt("COUNT(id_pesanan)");
                if (panjang == 0) return;
                arrPesanan = new String[panjang];                
                query = "SELECT id_pesanan, nama_pemesan FROM tb_pesanan "
                      + "WHERE status='Belum dibayar'";
                rs = stat.executeQuery(query);
                while (rs.next()) {
                    id_pesanan = rs.getString(1);
                    nama = rs.getString(2);                                        
                    arrPesanan[no] = id_pesanan+" - "+nama;
                    no++;
                }
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        DefaultComboBoxModel model = new DefaultComboBoxModel(arrPesanan);
        cb_pesanan.setModel(model);
        id_pesanan = cb_pesanan.getSelectedItem().toString().split(" - ")[0];    
        lb_total.setText(getStrTotal(id_pesanan));
    }  
    
    private String getStrTotal(String pid_pesanan){
        query = "SELECT jumlah, harga_jual FROM tb_pesanan JOIN tb_kategori ON "
              + "(tb_pesanan.id_kategori = tb_kategori.id_kategori) "                
              + "WHERE id_pesanan = '"+pid_pesanan+"'";
        try {
            rs = stat.executeQuery(query);
            if (rs.next()) {
                jumlah = rs.getInt("jumlah");
                harga = rs.getInt("harga_jual");
                return ""+(jumlah*harga);
            }
        } catch(SQLException e){
            System.err.println(e.getMessage());
        }
        return "";
    }
    
    private String formatTglId(String ptgl){
        String tgl = ptgl.substring(8,10);
        String bulan = ptgl.substring(5,7);
        String tahun = ptgl.substring(0,4);
        return tgl+"-"+bulan+"-"+tahun;
    }
    
    private String formatTglEn(String ptgl){
        // 22-02-2023 to 2023-02-22
        String tgl = ptgl.split("-")[0];
        String bulan = ptgl.split("-")[1];
        String tahun = ptgl.split("-")[2];
        return tahun+"-"+bulan+"-"+tgl;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        dt_tglBayar = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_penjualan = new javax.swing.JTable();
        cb_pesanan = new javax.swing.JComboBox<>();
        cb_pembayaran = new javax.swing.JComboBox<>();
        btn_tambah = new javax.swing.JButton();
        btn_edit = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        lb_total = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Penjualan");
        setMinimumSize(new java.awt.Dimension(589, 490));

        jLabel1.setText("Tgl Bayar");

        jLabel2.setText("Total");

        jLabel3.setText("Pesanan");

        jLabel4.setText("Pembayaran");

        tb_penjualan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id Penjualan", "Id Pesanan", "Jenis Pembayaran", "Total", "Tgl Pembayaran"
            }
        ));
        tb_penjualan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_penjualanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_penjualan);

        cb_pesanan.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_pesananItemStateChanged(evt);
            }
        });

        cb_pembayaran.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cash", "Transfer" }));

        btn_tambah.setText("Tambah");
        btn_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambahActionPerformed(evt);
            }
        });

        btn_edit.setText("Edit");
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });

        btn_hapus.setText("Hapus");
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });

        lb_total.setText("...");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 559, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cb_pesanan, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cb_pembayaran, javax.swing.GroupLayout.Alignment.LEADING, 0, 322, Short.MAX_VALUE)
                            .addComponent(dt_tglBayar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lb_total, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_tambah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_edit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_hapus, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_pesanan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_tambah))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cb_pembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_edit))
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_total, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_hapus)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dt_tglBayar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tb_penjualanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_penjualanMouseClicked
        int row = tb_penjualan.getSelectedRow();
        TableModel model = tb_penjualan.getModel();
        id_jual = model.getValueAt(row, 0).toString();
        String pesanan = model.getValueAt(row, 1).toString();
        id_pesLama = pesanan.split(" - ")[0];
        if (no == 0){
            cb_pesanan.addItem(pesanan);
            cb_pesanan.setSelectedItem(pesanan);
            no++;
        } else {
            cb_pesanan.removeItemAt(cb_pesanan.getItemCount() - 1);
            cb_pesanan.addItem(pesanan);
            cb_pesanan.setSelectedItem(pesanan);
        }        
        pembayaran = model.getValueAt(row, 2).toString();
        lb_total.setText(model.getValueAt(row, 3).toString());
        str_tgl = formatTglEn(model.getValueAt(row, 4).toString());
        try {
            Date tglTiket = new SimpleDateFormat("yyyy-MM-dd").parse(str_tgl);
            dt_tglBayar.setDate(tglTiket);
        } catch(ParseException e){
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_tb_penjualanMouseClicked

    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
        Format formatter = new SimpleDateFormat("YYYY-MM-dd");
        String tglbayar = formatter.format(dt_tglBayar.getDate());
        id_pesanan = cb_pesanan.getSelectedItem().toString().split(" - ")[0]; 
        Dashboard log = new Dashboard();
        System.out.println(log.id_user);
        query = "INSERT INTO tb_penjualan VALUES "
              + "(null,'"+id_pesanan+"','"+cb_pembayaran.getSelectedItem()
              + "','"+lb_total.getText()+"','"+tglbayar+"','"+log.id_user+"')";
        try {
            stat.executeUpdate(query);
            UbahStatusPesanan(id_pesanan,"Lunas");
            tabel();
            setCbPesanan();
            no = 0;
            JOptionPane.showMessageDialog(null, "berhasil simpan");
        } catch(SQLException e) {
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btn_tambahActionPerformed

    private void UbahStatusPesanan(String pid, String pstatus){
        query = "UPDATE tb_pesanan SET status = '"+pstatus+"' WHERE id_pesanan = '"+pid+"'";
        try {
            stat.executeUpdate(query);
        } catch(SQLException e){
            System.err.println(e.getMessage());
        }
    }
    
    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
        Format formatter = new SimpleDateFormat("YYYY-MM-dd");
        String tglbayar = formatter.format(dt_tglBayar.getDate());
        id_pesanan = cb_pesanan.getSelectedItem().toString().split(" - ")[0]; 
        query = "UPDATE tb_penjualan SET id_pesanan='"+id_pesanan
              + "',jenis_pembayaran ='"+cb_pembayaran.getSelectedItem()
              + "',tanggal_pembayaran ='"+tglbayar+"',total='"+lb_total.getText()
              + "' WHERE id_penjualan="+id_jual;
        try {
            stat.executeUpdate(query);
            UbahStatusPesanan(id_pesLama,"Belum dibayar");
            UbahStatusPesanan(id_pesanan,"Lunas");            
            tabel();
            setCbPesanan();
            no = 0;
            JOptionPane.showMessageDialog(null, "berhasil diupdate");
        } catch(SQLException e) {
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btn_editActionPerformed

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        query = "DELETE FROM tb_penjualan WHERE id_penjualan ="+id_jual;
        try {
            stat.executeUpdate(query);
            tabel();
            setCbPesanan();
            no = 0;
            JOptionPane.showMessageDialog(null, "berhasil dihapus");
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void cb_pesananItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_pesananItemStateChanged
        id_pesanan = cb_pesanan.getSelectedItem().toString().split(" - ")[0];    
        lb_total.setText(getStrTotal(id_pesanan));
    }//GEN-LAST:event_cb_pesananItemStateChanged
    
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
            java.util.logging.Logger.getLogger(Penjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Penjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Penjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Penjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Penjualan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_tambah;
    private javax.swing.JComboBox<String> cb_pembayaran;
    private javax.swing.JComboBox<String> cb_pesanan;
    private com.toedter.calendar.JDateChooser dt_tglBayar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_total;
    private javax.swing.JTable tb_penjualan;
    // End of variables declaration//GEN-END:variables
}
