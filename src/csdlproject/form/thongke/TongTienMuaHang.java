/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package csdlproject.form.thongke;

import csdlproject.database_connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;

/**
 *
 * @author VIP
 */
public class TongTienMuaHang {
    public int TongTien(Date x, Date y) throws Exception {
        String tinhtong = "select sum(tonggiatri) as TGiatri from hoadonmua where ngaylap between ? and ?";
        try (
            Connection connect = database_connect.connection();
            PreparedStatement data_connect = connect.prepareStatement(tinhtong);
        )
        
        {
            data_connect.setDate(1, x);
            data_connect.setDate(2, y);
            ResultSet rs = data_connect.executeQuery();
            int tong = 0;
            if(rs.next()) {
                tong = tong + rs.getInt("tonggiatri");
            }
            return tong;
        }
        
    }
}
