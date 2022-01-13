/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package csdlproject.form.trungtambaohanh;

import csdlproject.database_connect;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author VIP
 */
public class insert_TTBH {
    public boolean insertTrungTamBaoHanh(TrungTamBaoHanh ttbh) throws Exception{
            String insert = "insert into ttbh (mattbh, tenttbh, diachi, dienthoai) values(?, ?, ?, ?)";
            try (
                    Connection connect = database_connect.connection();
                    PreparedStatement data_connect = connect.prepareStatement(insert);
            )
                
               
            {
                data_connect.setString(1, ttbh.getMaTTBH());
                data_connect.setString(2, ttbh.getTenTTBH());
                data_connect.setString(3, ttbh.getDiaChi());
                data_connect.setString(4, ttbh.getDienThoai());
                
                return data_connect.executeUpdate() > 0;
            }
         
    }
}
