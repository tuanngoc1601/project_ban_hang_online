/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package csdlproject.form.thongke;

import csdlproject.database_connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author VIP
 */
public class Top5MHLoiNHuanNhat {
    public MatHang TKtop5MHLoiNhuanNhat() throws Exception {
        String top5 = "select chitiethdban.mahh, hanghoa.tenhang, sum((chitiethdban.giaban - hanghoa.gianhap) * chitiethdban.slban) as loinhuan from chitiethdban inner join hanghoa on chitiethdban.mahh = hanghoa.mahh inner join hoadonban on chitiethdban.mahd = hoadonban.mahd group by chitiethdban.mahh, hanghoa.tenhang order by loinhuan DESC limit 5";
        try (
            Connection connect = database_connect.connection();
            PreparedStatement data_connect = connect.prepareStatement(top5);    
        )
            
        {   
            ResultSet rs = data_connect.executeQuery();
            if(rs.next()) {
                MatHang mh = new MatHang();
                mh.setMaHH(rs.getString("mahh"));
                mh.setTenHang(rs.getString("tenhang"));
                mh.setLoinhuan(rs.getInt("loinhuan"));
                
                return mh;
            }
            return null;
        }
    }
}
