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
public class UpdateTTBH {
    public Boolean Update_ttbh(TrungTamBaoHanh ttbh) throws Exception{
            String search = "update ttbh set tenttbh = ?, diachi = ?, dienthoai = ? where mattbh = ?";
            try (
                    Connection connect = database_connect.connection();
                    PreparedStatement data_connect = connect.prepareStatement(search);
            )
                
               
            {
                data_connect.setString(1, ttbh.getTenTTBH());
                data_connect.setString(2, ttbh.getDiaChi());
                data_connect.setString(3, ttbh.getDienThoai());
                data_connect.setString(4, ttbh.getMaTTBH());
                
                return data_connect.executeUpdate() > 0;
            }
         
    }
}
