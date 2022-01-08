/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package csdlproject.form.nhanvien;

import csdlproject.database_connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
/**
 *
 * @author VIP
 */
public class insert_NV {
    public boolean insert_NhanVien(NhanVien nv) throws Exception{
            String insert = "insert into nhanvienbh (MaNV, TenNV, GioiTinh, DiaChi, DienThoai) values(?, ?, ?, ?, ?)";
            try (
                    Connection connect = database_connect.connection();
                    PreparedStatement data_connect = connect.prepareStatement(insert);
            )
                
               
            {
                data_connect.setString(1, nv.getMaNV());
                data_connect.setString(2, nv.getTenNV());
                data_connect.setString(3, nv.getGioiTinh());
                data_connect.setString(4, nv.getDiaChi());
                data_connect.setString(5, nv.getDienThoai());
                
                return data_connect.executeUpdate() > 0;
            }
         
    }
    
}
