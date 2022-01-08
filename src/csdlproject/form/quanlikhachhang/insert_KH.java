/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package csdlproject.form.quanlikhachhang;

import csdlproject.database_connect;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author VIP
 */
public class insert_KH {
    public boolean insertKhachHang(KhachHang kh) throws Exception{
            String insert = "insert into khachhang (makh, tenkh, diachi, dienthoai) values(?, ?, ?, ?)";
            try (
                    Connection connect = database_connect.connection();
                    PreparedStatement data_connect = connect.prepareStatement(insert);
            )
                
               
            {
                data_connect.setString(1, kh.getMaKH());
                data_connect.setString(2, kh.getTenKH());
                data_connect.setString(3, kh.getDiaChi());
                data_connect.setString(4, kh.getDienThoai());
                
                return data_connect.executeUpdate() > 0;
            }
         
    }
}
