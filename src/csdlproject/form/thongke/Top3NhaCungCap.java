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
public class Top3NhaCungCap {
    public NhaCungCap TKTop3NCC() throws Exception {
        String ncc = "select hoadonmua.mancc, nhacungcap.tenncc, sum((hanghoa.giaban - hanghoa.gianhap) * chitiethdmua.slmua) as loinhuan from chitiethdmua inner join hanghoa on chitiethdmua.mahh = hanghoa.mahh inner join hoadonmua on chitiethdmua.mahd = hoadonmua.mahd inner join nhacungcap on hoadonmua.mancc = nhacungcap.mancc group by hoadonmua.mancc, nhacungcap.tenncc order by loinhuan DESC limit 3";
        try (
            Connection connect = database_connect.connection();
            PreparedStatement data_connect = connect.prepareStatement(ncc);    
        )
            
        {   
            ResultSet rs = data_connect.executeQuery();
            if(rs.next()) {
                NhaCungCap nhacc = new NhaCungCap();
                nhacc.setMaNCC(rs.getString("mancc"));
                nhacc.setTenNCC(rs.getString("tenncc"));
                nhacc.setLoinhuan(rs.getInt("loinhuan"));
                
                return nhacc;
            }
            return null;
        }
    }
}
