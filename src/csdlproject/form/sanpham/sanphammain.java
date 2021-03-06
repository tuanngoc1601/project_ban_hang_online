/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package csdlproject.form.sanpham;


import csdlproject.database_connect;
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
public class sanphammain extends javax.swing.JPanel {

    /**
     * Creates new form NewJPanel
     */
    
    private JFrame parentJFrame; 
    DefaultTableModel tblModel;

    public sanphammain(JFrame parentFrame) {
        this.parentJFrame = parentFrame;
        initComponents();
        initTable();
        LoadDatabase();
    }
    
    private void initTable() {
        tblModel = new DefaultTableModel();
        tblModel.setColumnIdentifiers(new String[]{"Mã Hàng Hóa", "Tên Hàng Hóa", "Mã Loại Hãng", "Chip", "Main", "HDD", "RAM", "VGA", "SSD", "Số Lượng", "Giá Nhập", "Giá Bán"});
        jTable1.setModel(tblModel);
    }
    
    public void LoadDatabase(){
            
            try {
                    String insert = "select * from hanghoa";
                    Connection connect = database_connect.connection();
                    PreparedStatement data_connect = connect.prepareStatement(insert);
                    
                    ResultSet rs = data_connect.executeQuery();
                    tblModel.setRowCount(0);
                    while(rs.next()) {
                        String[] row = new String[]{rs.getString("mahh"), rs.getString("tenhang"), rs.getString("malh"), rs.getString("chip"), rs.getString("main"), rs.getString("hdd"), rs.getString("ram"), rs.getString("vga"), rs.getString("ssd"), rs.getString("slton"), rs.getString("gianhap"), rs.getString("giaban")};
                        tblModel.addRow(row);
                    }
                    tblModel.fireTableDataChanged();
            
            }
                
            catch(Exception e) {
            
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
    }
    
    public void UpdateDatabaseLoaiHang() {
        try {
            String insert = "select hanghoa.* from hanghoa inner join loaihang on hanghoa.malh = loaihang.malh where loaihang.tenlh = ?";
            Connection connect = database_connect.connection();
            PreparedStatement data_connect = connect.prepareStatement(insert);
            
            data_connect.setString(1, jComboBox1.getSelectedItem().toString());
            ResultSet rs = data_connect.executeQuery();
            tblModel.setRowCount(0);
            while(rs.next()) {
                String[] row = new String[]{rs.getString("mahh"), rs.getString("tenhang"), rs.getString("malh"), rs.getString("chip"), rs.getString("main"), rs.getString("hdd"), rs.getString("ram"), rs.getString("vga"), rs.getString("ssd"), rs.getString("slton"), rs.getString("gianhap"), rs.getString("giaban")};
                tblModel.addRow(row);
            }
            tblModel.fireTableDataChanged();
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    public void UpdateDatabaseRAM() {
        try {
            String insert = "select * from hanghoa where (ram = ?)";
            Connection connect = database_connect.connection();
            PreparedStatement data_connect = connect.prepareStatement(insert);
            
            data_connect.setString(1, jComboBox3.getSelectedItem().toString());
            ResultSet rs = data_connect.executeQuery();
            tblModel.setRowCount(0);
            while(rs.next()) {
                String[] row = new String[]{rs.getString("mahh"), rs.getString("tenhang"), rs.getString("malh"), rs.getString("chip"), rs.getString("main"), rs.getString("hdd"), rs.getString("ram"), rs.getString("vga"), rs.getString("ssd"), rs.getString("slton"), rs.getString("gianhap"), rs.getString("giaban")};
                tblModel.addRow(row);
            }
            tblModel.fireTableDataChanged();
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    public void UpdateDatabaseChip() {
        try {
            String insert = "select * from hanghoa where (chip LIKE '%' + ? +'%')";
            Connection connect = database_connect.connection();
            PreparedStatement data_connect = connect.prepareStatement(insert);
            
            data_connect.setString(1, jComboBox2.getSelectedItem().toString());
            ResultSet rs = data_connect.executeQuery();
            tblModel.setRowCount(0);
            while(rs.next()) {
                String[] row = new String[]{rs.getString("mahh"), rs.getString("tenhang"), rs.getString("malh"), rs.getString("chip"), rs.getString("main"), rs.getString("hdd"), rs.getString("ram"), rs.getString("vga"), rs.getString("ssd"), rs.getString("slton"), rs.getString("gianhap"), rs.getString("giaban")};
                tblModel.addRow(row);
            }
            tblModel.fireTableDataChanged();
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    public void UpdateDatabaseVGA() {
        try {
            String insert = "select * from hanghoa where (vga = ?)";
            Connection connect = database_connect.connection();
            PreparedStatement data_connect = connect.prepareStatement(insert);
            
            data_connect.setString(1, jComboBox4.getSelectedItem().toString());
            ResultSet rs = data_connect.executeQuery();
            tblModel.setRowCount(0);
            while(rs.next()) {
                String[] row = new String[]{rs.getString("mahh"), rs.getString("tenhang"), rs.getString("malh"), rs.getString("chip"), rs.getString("main"), rs.getString("hdd"), rs.getString("ram"), rs.getString("vga"), rs.getString("ssd"), rs.getString("slton"), rs.getString("gianhap"), rs.getString("giaban")};
                tblModel.addRow(row);
            }
            tblModel.fireTableDataChanged();
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    public void UpdateDatabaseTenHangHoa() {
        try {
            String insert = "select * from hanghoa where (tenhang = ?)";
            Connection connect = database_connect.connection();
            PreparedStatement data_connect = connect.prepareStatement(insert);
            
            data_connect.setString(1, jTextField1.getText());
            ResultSet rs = data_connect.executeQuery();
            tblModel.setRowCount(0);
            while(rs.next()) {
                String[] row = new String[]{rs.getString("mahh"), rs.getString("tenhang"), rs.getString("malh"), rs.getString("chip"), rs.getString("main"), rs.getString("hdd"), rs.getString("ram"), rs.getString("vga"), rs.getString("ssd"), rs.getString("slton"), rs.getString("gianhap"), rs.getString("giaban")};
                tblModel.addRow(row);
            }
            tblModel.fireTableDataChanged();
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    public void UpdateDatabaseThoiGianTonKho() {
        try {
            String insert = "select * from hanghoa as hh inner join chitiethdmua as cthdm on hh.mahh = cthdm.mhh inner join hoadonmua as hdm on cthdm.mahd = hdm.mahd where (hh.slton > 1) and (hdm.ngaylap < {fn NOW()} - 30*?)";
            Connection connect = database_connect.connection();
            PreparedStatement data_connect = connect.prepareStatement(insert);
            
            data_connect.setInt(1, Integer.parseInt(jTextField2.getText()));
            ResultSet rs = data_connect.executeQuery();
            tblModel.setRowCount(0);
            while(rs.next()) {
                String[] row = new String[]{rs.getString("mahh"), rs.getString("tenhang"), rs.getString("malh"), rs.getString("chip"), rs.getString("main"), rs.getString("hdd"), rs.getString("ram"), rs.getString("vga"), rs.getString("ssd"), rs.getString("slton"), rs.getString("gianhap"), rs.getString("giaban")};
                tblModel.addRow(row);
            }
            tblModel.fireTableDataChanged();
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    public void UpdateDatabaseSoLuongTon() {
        try {
            String insert = "select * from hanghoa where slton <= ?";
            Connection connect = database_connect.connection();
            PreparedStatement data_connect = connect.prepareStatement(insert);
            
            data_connect.setInt(1, Integer.parseInt(jTextField3.getText()));
            ResultSet rs = data_connect.executeQuery();
            tblModel.setRowCount(0);
            while(rs.next()) {
                String[] row = new String[]{rs.getString("mahh"), rs.getString("tenhang"), rs.getString("malh"), rs.getString("chip"), rs.getString("main"), rs.getString("hdd"), rs.getString("ram"), rs.getString("vga"), rs.getString("ssd"), rs.getString("slton"), rs.getString("gianhap"), rs.getString("giaban")};
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jComboBox4 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();

        jPanel1.setBackground(new java.awt.Color(153, 255, 255));

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel1.setText("THÔNG TIN MÁY TÍNH");

        jTable1.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Hàng Hóa", "Tên Hàng Hóa", "Mã Loại Hãng", "Chip", "Main", "HDD", "RAM", "VGA", "SSD", "Số Lượng", "Gía Nhập", "Giá Bán"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton5.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon_tim_kiem.png"))); // NOI18N
        jButton5.setText("Tìm KIếm");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jComboBox1.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn", "Dahua", "ThinkView", "Acer", "HKC", "HP", "Viewsoni", "AOC", "LG", "Dell", "BenQ", "Asus", "Samsung", "Gigabyte", "Msi" }));

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel3.setText("Tên Hãng");

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel4.setText("Chip");

        jComboBox2.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn", "i3", "core i5", "i7", "i9" }));

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel5.setText("RAM");

        jComboBox3.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn", "2GB", "4GB", "8GB", "16GB", "32GB", "64GB" }));

        jComboBox4.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn", "RTX 2060", "GTX 1080", "RTX 3060", "GTX 1070 Ti", "RTX 2080", "RTX 2070 Super", "GTX 1080 Ti", "RTX 2070", "RTX 2060 Super", "GTX 1080", "GTX 1070 Ti", "GTX 1660 Super", "GTX 1660 Ti", "GTX 1070" }));

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel6.setText("VGA");

        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel7.setText("Tên Sản Phẩm");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel8.setText("Thời gian tồn kho");

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel9.setText("(Tháng)");

        jLabel10.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel10.setText("Số Lượng Tồn");

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4))
                        .addGap(33, 33, 33)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addComponent(jLabel2))
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(48, 48, 48)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(jLabel10)
                        .addGap(28, 28, 28)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                        .addComponent(jButton5)
                        .addGap(66, 66, 66))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(281, 281, 281)
                .addComponent(jLabel9)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel10)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(417, 417, 417)
                .addComponent(jLabel1)
                .addContainerGap(397, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        LoadDatabase();
        if(jComboBox1.getSelectedItem().toString().equals("Chọn") && jComboBox2.getSelectedItem().toString().equals("Chọn") && jComboBox4.getSelectedItem().toString().equals("Chọn") && jComboBox3.getSelectedItem().toString().equals("Chọn") && jTextField1.getText().equals("") && jTextField2.getText().equals("") && jTextField3.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Ban Chua Nhap Thong Tin De Tim Kiem!");
            return ;
        }
        
        try {
            timkiemSP tkSP = new timkiemSP();
            SanPham sp = new SanPham();
            if(!jComboBox1.getSelectedItem().toString().equals("Chọn")) {
                sp = tkSP.timkiem_TenLoaiHang(jComboBox1.getSelectedItem().toString());
                if(sp != null) {
                    JOptionPane.showMessageDialog(this, "Da Tim Thay San Pham!");
                    UpdateDatabaseLoaiHang();
                }
                else {
                    JOptionPane.showMessageDialog(this, "Khong Tim Thay San Pham Nao!");
                }
            }
            
            
            if(!jComboBox2.getSelectedItem().toString().equals("Chọn")) {
                sp = tkSP.timkiem_Chip(jComboBox2.getSelectedItem().toString());
                if( sp != null) {
                    JOptionPane.showMessageDialog(this, "Da Tim Thay San Pham!");
                    UpdateDatabaseChip();
                }
                else {
                    JOptionPane.showMessageDialog(this, "Khong Tim Thay San Pham Nao!");
                }
            }
            
            if(!jComboBox4.getSelectedItem().toString().equals("Chọn")) {
                sp = tkSP.timkiem_VGA(jComboBox4.getSelectedItem().toString());
                if( sp != null) {
                    JOptionPane.showMessageDialog(this, "Da Tim Thay San Pham!");
                    UpdateDatabaseVGA();
                }
                else {
                    JOptionPane.showMessageDialog(this, "Khong Tim Thay San Pham Nao!");
                }
            }
            
            if(!jComboBox3.getSelectedItem().toString().equals("Chọn")) {
                sp = tkSP.timkiem_RAM(jComboBox3.getSelectedItem().toString());
                if( sp != null) {
                    JOptionPane.showMessageDialog(this, "Da Tim Thay San Pham!");
                    UpdateDatabaseRAM();
                }
                else {
                    JOptionPane.showMessageDialog(this, "Khong Tim Thay San Pham Nao!");
                }
            }
            
            if(!jTextField1.getText().equals("")) {
                sp = tkSP.timkiem_TenHangHoa(jTextField1.getText());
                if( sp != null) {
                    JOptionPane.showMessageDialog(this, "Da Tim Thay San Pham!");
                    UpdateDatabaseTenHangHoa();
                }
                else {
                    JOptionPane.showMessageDialog(this, "Khong Tim Thay San Pham Nao!");
                }
            }
            
            if(!jTextField2.getText().equals("")) {
                sp = tkSP.timkiem_ThoiGianTonKho(jTextField2.getText());
                if( sp != null) {
                    JOptionPane.showMessageDialog(this, "Da Tim Thay San Pham!");
                    UpdateDatabaseThoiGianTonKho();
                }
                else {
                    JOptionPane.showMessageDialog(this, "Khong Tim Thay San Pham Nao!");
                }
            }
            
            if(!jTextField3.getText().equals("")) {
                sp = tkSP.timkiem_SoLuongTon(jTextField3.getText());
                if( sp != null) {
                    JOptionPane.showMessageDialog(this, "Da Tim Thay San Pham!");
                    UpdateDatabaseSoLuongTon();
                }
                else {
                    JOptionPane.showMessageDialog(this, "Khong Tim Thay San Pham Nao!");
                }
            }
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
