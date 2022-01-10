/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package csdlproject.form.trungtambaohanh;

import csdlproject.database_connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author VIP
 */
public class timkiemTTBH {
    public TrungTamBaoHanh timkiem_ttbh(String Mattbh) throws Exception{
            String search = "select * from ttbh where mattbh = ?";
            try (
                    Connection connect = database_connect.connection();
                    PreparedStatement data_connect = connect.prepareStatement(search);
            )
                
               
            {
                data_connect.setString(1, Mattbh);
                ResultSet rs = data_connect.executeQuery();
                if(rs.next()) {
                    TrungTamBaoHanh ttbh = new TrungTamBaoHanh();
                    ttbh.setMaTTBH(rs.getString("mattbh"));
                    ttbh.setDiaChi(rs.getString("DiaChi"));
                    ttbh.setDienThoai(rs.getString("SoDienThoai"));
                    
                    return ttbh;
                }
                
                
                return null;
            
            }
         
    } 
}
