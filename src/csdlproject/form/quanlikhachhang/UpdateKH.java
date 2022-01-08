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
public class UpdateKH {
    public Boolean Update_kh(KhachHang kh) throws Exception{
            String search = "update khachhang set diachi = ?, dienthoai = ? where makh = ?";
            try (
                    Connection connect = database_connect.connection();
                    PreparedStatement data_connect = connect.prepareStatement(search);
            )
                
               
            {
                data_connect.setString(1, kh.getDiaChi());
                data_connect.setString(2, kh.getDienThoai());
                data_connect.setString(3, kh.getMaKH());
                
                return data_connect.executeUpdate() > 0;
            }
         
    }
}
