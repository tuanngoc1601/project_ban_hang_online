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
public class timkiemNV {
    public NhanVien timkiem_nv(String MaNV) throws Exception{
            String search = "select * from nhanvienbh where manv = ?";
            try (
                    Connection connect = database_connect.connection();
                    PreparedStatement data_connect = connect.prepareStatement(search);
            )
                
               
            {
                data_connect.setString(1, MaNV);
                ResultSet rs = data_connect.executeQuery();
                if(rs.next()) {
                    NhanVien nv = new NhanVien();
                    nv.setMaNV(rs.getString("manv"));
                    nv.setTenNV(rs.getString("TenNV"));
                    nv.setGioiTinh(rs.getString("GioiTinh"));
                    nv.setDiaChi(rs.getString("DiaChi"));
                    nv.setDienThoai(rs.getString("DienThoai"));
                    
                    return nv;
                }
                
                
                return null;
            
            }
         
    } 
}
