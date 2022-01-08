/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package csdlproject.form.sanpham;

import csdlproject.database_connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author VIP
 */
public class timkiemSP {
    public SanPham timkiem_sp(String MaHH) throws Exception{
            String search = "select * from hanghoa as hh, loaihang as lh where hh.malh = lh.malh and hh.mahh = ?";
            try (
                    Connection connect = database_connect.connection();
                    PreparedStatement data_connect = connect.prepareStatement(search);
            )
                
               
            {
                data_connect.setString(1, MaHH);
                ResultSet rs = data_connect.executeQuery();
                if(rs.next()) {
                    SanPham sp = new SanPham();
                    sp.setMaHH(rs.getString("mahh"));
                    sp.setMaNCC(rs.getString("mancc"));
                    sp.setMaLH(rs.getString("malh"));
                    sp.setMaTTBH(rs.getString("mattbh"));
                    sp.setTenHang(rs.getString("tenhang"));
                    sp.setTenLH(rs.getString("tenlh"));
                    sp.setChip(rs.getString("chip"));
                    sp.setMain(rs.getString("main"));
                    sp.setSSD(rs.getString("ssd"));
                    sp.setHDD(rs.getString("hdd"));
                    sp.setRAM(rs.getString("ram"));
                    sp.setVGA(rs.getString("vga"));
                    sp.setSoLuong(Integer.parseInt(rs.getString("slton")));
                    sp.setGiaBan(Integer.parseInt(rs.getString("giaban")));
                    sp.setGiaNhap(Integer.parseInt(rs.getString("gianhap")));
                    
                    return sp;
                }
                
                
                return null;
            
            }
         
    } 
}
