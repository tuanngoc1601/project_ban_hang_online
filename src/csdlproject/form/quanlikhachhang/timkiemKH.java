/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package csdlproject.form.quanlikhachhang;

import csdlproject.database_connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author VIP
 */
public class timkiemKH {
    public KhachHang timkiem_kh(String MaKH) throws Exception{
            String search = "select * from khachhang where makh = ?";
            try (
                    Connection connect = database_connect.connection();
                    PreparedStatement data_connect = connect.prepareStatement(search);
            )
                
               
            {
                data_connect.setString(1, MaKH);
                ResultSet rs = data_connect.executeQuery();
                if(rs.next()) {
                    KhachHang kh = new KhachHang();
                    kh.setMaKH(rs.getString("makh"));
                    kh.setTenKH(rs.getString("tenkh"));
                    kh.setDiaChi(rs.getString("DiaChi"));
                    kh.setDienThoai(rs.getString("DienThoai"));
                    
                    return kh;
                }
                
                
                return null;
            
            }
         
    } 
}
