/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package csdlproject.form.thongke;

import csdlproject.database_connect;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author VIP
 */
public class doanhthumain extends javax.swing.JFrame {

    /**
     * Creates new form doanhthumain
     */
    public doanhthumain() {
        initComponents();
        initTableKhachHang();
    }
    
    private JFrame parentJFrame;
    DefaultTableModel tblModel;
    
    public doanhthumain(JFrame parentJFrame) {
        this.setTitle("Doanh Thu");
        this.parentJFrame = parentJFrame;
        initComponents();
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                close(); //To change body of generated methods, choose Tools | Templates.
            }
            
        });
    }
    
    private void initTableKhachHang() {
        tblModel = new DefaultTableModel();
        tblModel.setColumnIdentifiers(new String[]{"Mã Khách Hàng", "Tên Khách Hàng", "Doanh Thu", "Lợi Nhuận"});
        jTable1.setModel(tblModel);
    }
    
    private void initTableTop5MHLoiNHuanNhat() {
        tblModel = new DefaultTableModel();
        tblModel.setColumnIdentifiers(new String[]{"Mã Hàng Hóa", "Tên Hàng Hóa", "Lợi Nhuận"});
        jTable1.setModel(tblModel);
    }
    
    private void initTableTop5MHKemLoiNHuanNhat() {
        tblModel = new DefaultTableModel();
        tblModel.setColumnIdentifiers(new String[]{"Mã Hàng Hóa", "Tên Hàng Hóa", "Lợi Nhuận"});
        jTable1.setModel(tblModel);
    }
    
    private void initTableTop3NhaCungCap() {
        tblModel = new DefaultTableModel();
        tblModel.setColumnIdentifiers(new String[]{"Mã Nhà Cung Cấp", "Tên Nhà Cung Cấp", "Lợi Nhuận"});
        jTable1.setModel(tblModel);
    }

    public void close() {
        if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn thoát?", "Warning!!", JOptionPane.YES_NO_OPTION)) {
            dispose();
        }
    }
    
    public void UpdateDatabaseTKKhachHang() {
        try {
            initTableKhachHang();
            String khachhang = "select khachhang.makh, khachhang.tenkh, sum(chitiethdban.giaban * chitiethdban.slban) as doanhthu, sum((chitiethdban.giaban - hanghoa.gianhap) * chitiethdban.slban) as loinhuan from khachhang inner join hoadonban on khachhang.makh = hoadonban.makh inner join chitiethdban on hoadonban.mahd = chitiethdban.mahd inner join hanghoa on chitiethdban.mahh = hanghoa.mahh group by khachhang.makh, khachhang.tenkh";
            Connection connect = database_connect.connection();
            PreparedStatement data_connect = connect.prepareStatement(khachhang);
            
            ResultSet rs = data_connect.executeQuery();
            tblModel.setRowCount(0);
            while(rs.next()) {
                Object[] row = new Object[]{rs.getString("khachhang.makh"), rs.getString("khachhang.tenkh"), rs.getInt("doanhthu"), rs.getInt("loinhuan")};
                tblModel.addRow(row);
            }
            tblModel.fireTableDataChanged();
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    public void UpdateDatabaseTop5MHLoiNhuanNhat() {
        try {
            initTableTop5MHLoiNHuanNhat();
            String top5 = "select top(5) chitiethdban.mahd, hanghoa.tenhang, sum((chitiethdban.giaban - hanghoa.gianhap) * chitiethdban.slban) as loinhuan from chitiethdban inner join hanghoa on chitiethdban.mahh = hanghoa.mahh inner join hoadonban on chitiethdban.mahd = hoadonban.mahd group by chitiethdban.mahh, hanghoa.tenhang order by loinhuan DESC";
            Connection connect = database_connect.connection();
            PreparedStatement data_connect = connect.prepareStatement(top5);
            
            ResultSet rs = data_connect.executeQuery();
            tblModel.setRowCount(0);
            while(rs.next()) {
                Object[] row = new Object[]{rs.getString("mahh"), rs.getString("tenhang"), rs.getInt("loinhuan")};
                tblModel.addRow(row);
            }
            tblModel.fireTableDataChanged();
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    public void UpdateDatabaseTop5MHKemLoiNhuanNhat() {
        try {
            initTableTop5MHKemLoiNHuanNhat();
            String top5 = "select top(5) chitiethdban.mahh, hanghoa.tenhang, sum((chitiethdban.giaban - hanghoa.gianhap) * chitiethdban.slban) as loinhuan from chitiethdban inner join hanghoa on chitiethdban.mahh = hanghoa.mahh inner join hoadonban on chitiethdban.mahd = hoadonban.mahd group by chitiethdban.mahh, hanghoa.tenhang order by loinhuan";
            Connection connect = database_connect.connection();
            PreparedStatement data_connect = connect.prepareStatement(top5);
            
            ResultSet rs = data_connect.executeQuery();
            tblModel.setRowCount(0);
            while(rs.next()) {
                Object[] row = new Object[]{rs.getString("mahh"), rs.getString("tenhang"), rs.getInt("loinhuan")};
                tblModel.addRow(row);
            }
            tblModel.fireTableDataChanged();
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    public void UpdateDatabaseTop3NhaCungCap() {
        try {
            initTableTop3NhaCungCap();
            String top3 = "select top(3) hoadonmua.mancc, nhacungcap.tenncc, sum((hanghoa.giaban - hanghoa.gianhap) * chitiethdmua.slmua) as loinhuan from chitiethdmua inner join hanghoa on chitiethdmua.mahh = hanghoa.mahh inner join hoadonmua on chitiethdmua.mahd = hoadonmua.mahd inner join nhacungcap on hoadonmua.mancc = nhacungcap.mancc group by hoadonmua.mancc, nhacungcap.tenncc order by loinhuan DESC";
            Connection connect = database_connect.connection();
            PreparedStatement data_connect = connect.prepareStatement(top3);
            
            ResultSet rs = data_connect.executeQuery();
            tblModel.setRowCount(0);
            while(rs.next()) {
                Object[] row = new Object[]{rs.getString("mancc"), rs.getString("tenncc"), rs.getInt("loinhuan")};
                tblModel.addRow(row);
            }
            tblModel.fireTableDataChanged();
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 255, 255));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel1.setText("THỐNG KÊ DOANH THU");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(308, 308, 308)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(29, 29, 29))
        );

        jPanel2.setForeground(new java.awt.Color(204, 204, 204));

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel2.setText("Từ Ngày");

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel3.setText("Đến Ngày");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jButton1.setText("Tổng Tiền Mua Hàng");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jButton2.setText("Khách Hàng");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jButton3.setText("Top 5 Mặt Hàng Lợi Nhuận Nhiều Nhất");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jButton4.setText("Top 5 Mặt Hàng Lợi Nhuận Thấp Nhất");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jButton5.setText("Top 3 Nhà Cung Cấp");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(304, 304, 304)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(123, 123, 123)
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton5))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton4)))))
                .addContainerGap(152, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jLabel3))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel2))
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(28, 116, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(jDateChooser1.getDate().toString().equals("") || jDateChooser2.getDate().toString().equals("")) {
            JOptionPane.showMessageDialog(this, "Ban Chua Nhap Thong Tin Ngay Thang!");
            return ;
        }
        
        try {
            TongTienMuaHang tt = new TongTienMuaHang();
//            int tong = tt.TongTien(jDateChooser1.getDate(), jDateChooser2.getDate());
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try {
            ThongKeKhachHang thongkekh = new ThongKeKhachHang();
            KhachHang kh = new KhachHang();
            kh = thongkekh.thongkeKH();
            if(kh != null) {
                JOptionPane.showMessageDialog(this, "Da Thong Ke Thanh Cong Doanh Thu Va Loi Nhuan Khach Hang!");
                UpdateDatabaseTKKhachHang();
            } else {
                JOptionPane.showMessageDialog(this, "Loi");
            }
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        try {
            Top5MHLoiNHuanNhat top5mh = new Top5MHLoiNHuanNhat();
            MatHang mh = new MatHang();
            mh = top5mh.TKtop5MHLoiNhuanNhat();
            if(mh!= null) {
                JOptionPane.showMessageDialog(this, "Da Thong Ke Thanh Cong Top 5 Mat Hang Loi Nhuan Nhat!");
                UpdateDatabaseTop5MHLoiNhuanNhat();
            }
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        try {
            Top5MatHangKemLoiNhuanNhat top5mh = new Top5MatHangKemLoiNhuanNhat();
            MatHang mh = new MatHang();
            mh = top5mh.TKtop5MHKemLoiNhuanNhat();
            if(mh!= null) {
                JOptionPane.showMessageDialog(this, "Da Thong Ke Thanh Cong Top 5 Mat Hang Kem Loi Nhuan Nhat!");
                UpdateDatabaseTop5MHKemLoiNhuanNhat();
            }
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        try {
            Top3NhaCungCap nhacc = new Top3NhaCungCap();
            NhaCungCap ncc = new NhaCungCap();
            ncc = nhacc.TKTop3NCC();
            if(ncc != null) {
                JOptionPane.showMessageDialog(this, "Da Thong Ke Thanh Cong Doanh Thu Va Loi Nhuan Khach Hang!");
                UpdateDatabaseTop3NhaCungCap();
            }
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(doanhthumain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(doanhthumain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(doanhthumain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(doanhthumain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new doanhthumain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
