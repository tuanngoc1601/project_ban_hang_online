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
public class ThongKeKhachHang {
    public KhachHang thongkeKH() throws Exception {
        String khachhang = "select khachhang.makh, khachhang.tenkh, sum(chitiethdban.giaban * chitiethdban.slban) as doanhthu, sum((chitiethdban.giaban - hanghoa.gianhap) * chitiethdban.slban) as loinhuan from khachhang inner join hoadonban on khachhang.makh = hoadonban.makh inner join chitiethdban on hoadonban.mahd = chitiethdban.mahd inner join hanghoa on chitiethdban.mahh = hanghoa.mahh group by khachhang.makh, khachhang.tenkh";
        try (
            Connection connect = database_connect.connection();
            PreparedStatement data_connect = connect.prepareStatement(khachhang);    
        )
            
        {   
            ResultSet rs = data_connect.executeQuery();
            if(rs.next()) {
                KhachHang kh = new KhachHang();
                kh.setMaKH(rs.getString("makh"));
                kh.setTenKH(rs.getString("tenkh"));
                kh.setDoanhthu(rs.getInt("doanhthu"));
                kh.setLoinhuan(rs.getInt("loinhuan"));
                
                return kh;
            }
            return null;
        }
    }
}
