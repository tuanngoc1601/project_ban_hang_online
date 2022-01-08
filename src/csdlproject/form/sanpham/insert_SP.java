/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package csdlproject.form.sanpham;

import csdlproject.database_connect;
import csdlproject.form.sanpham.SanPham;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author VIP
 */
public class insert_SP {
    public boolean insertSanPham(SanPham sp) throws Exception{
            String insertHangHoa = "insert into hanghoa (mahh, tenhang, malh, chip, main, hdd, ram, vga, ssd, slton, gianhap, GiaBan) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            String insertLoaiHang = "insert into loaihang (malh, tenlh, mancc, mattbh) values (?, ?, ?, ?)";
            try (
                    Connection connect = database_connect.connection();
                    PreparedStatement data_connect_HangHoa = connect.prepareStatement(insertHangHoa);
                    PreparedStatement data_connect_LoaiHang = connect.prepareStatement(insertLoaiHang);
            )
                
               
            {
                data_connect_HangHoa.setString(1, sp.getMaHH());
                data_connect_HangHoa.setString(2, sp.getTenHang());
                data_connect_HangHoa.setString(3, sp.getMaLH());
                data_connect_HangHoa.setString(4, sp.getChip());
                data_connect_HangHoa.setString(5, sp.getMain());
                data_connect_HangHoa.setString(6, sp.getHDD());
                data_connect_HangHoa.setString(7, sp.getRAM());
                data_connect_HangHoa.setString(8, sp.getVGA());
                data_connect_HangHoa.setString(9, sp.getSSD());
                data_connect_HangHoa.setInt(10, sp.getSoLuong());
                data_connect_HangHoa.setInt(11, sp.getGiaNhap());
                data_connect_HangHoa.setInt(12, sp.getGiaBan());
                
                data_connect_LoaiHang.setString(1, sp.getMaLH());
                data_connect_LoaiHang.setString(2, sp.getTenLH());
                data_connect_LoaiHang.setString(3, sp.getMaNCC());
                data_connect_LoaiHang.setString(4, sp.getMaTTBH());
                
                return data_connect_HangHoa.executeUpdate() > 0 && data_connect_LoaiHang.executeUpdate() > 0;
            }
         
    }
}
