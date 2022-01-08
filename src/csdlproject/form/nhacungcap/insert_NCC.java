/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package csdlproject.form.nhacungcap;

import csdlproject.database_connect;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author VIP
 */
public class insert_NCC {
    public boolean insertNhaCungCap(NhaCungCap ncc) throws Exception{
            String insert = "insert into nhacungcap (mancc, tenncc, diachi, dienthoai) values(?, ?, ?, ?)";
            try (
                    Connection connect = database_connect.connection();
                    PreparedStatement data_connect = connect.prepareStatement(insert);
            )
                
               
            {
                data_connect.setString(1, ncc.getMaNCC());
                data_connect.setString(2, ncc.getTenNCC());
                data_connect.setString(3, ncc.getDiaChi());
                data_connect.setString(4, ncc.getDienThoai());
                
                return data_connect.executeUpdate() > 0;
            }
         
    }
}
