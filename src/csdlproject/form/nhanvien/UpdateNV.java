/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package csdlproject.form.nhanvien;

import csdlproject.database_connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author VIP
 */
public class UpdateNV {
    public Boolean update_nv(NhanVien nv) throws Exception{
            String search = "update nhanvienbh set diachi = ?, dienthoai = ?, gioitinh = ? where manv = ?";
            try (
                    Connection connect = database_connect.connection();
                    PreparedStatement data_connect = connect.prepareStatement(search);
            )
                
               
            {
                data_connect.setString(1, nv.getDiaChi());
                data_connect.setString(2, nv.getDienThoai());
                data_connect.setString(3, nv.getGioiTinh());
                data_connect.setString(4, nv.getMaNV());
                
                return data_connect.executeUpdate() > 0;
            }
         
    }  
}
