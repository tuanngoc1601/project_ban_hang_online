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
//import java.util.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author VIP
 */
public class TongTienMuaHang {
    public int TongTien(String x, String y) throws Exception {
        String tinhtong = "select sum(tonggiatri) as TGiatri from hoadonmua where ngaylap between ? and ?";
        try (
            Connection connect = database_connect.connection();
            PreparedStatement data_connect = connect.prepareStatement(tinhtong);
        )
        
        {
            Date datex = (Date) new SimpleDateFormat("mm/dd/yyyy").parse(x);
            Date datey = (Date) new SimpleDateFormat("mm/dd/yyyy").parse(x);
            data_connect.setDate(1, datex);
            data_connect.setDate(2, datey);
            ResultSet rs = data_connect.executeQuery();
            int tong = rs.getInt("TGiaTri");
            
            return tong;
        }
        
    }
}
