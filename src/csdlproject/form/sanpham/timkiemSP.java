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
    public SanPham timkiem_TenLoaiHang(String tenlh) throws Exception{
            String search = "select hanghoa.* from hanghoa inner join loaihang on hanghoa.malh = loaihang.malh where loaihang.tenlh = ?";
            try (
                    Connection connect = database_connect.connection();
                    PreparedStatement data_connect = connect.prepareStatement(search);
            )
                
               
            {
                data_connect.setString(1, tenlh);
                ResultSet rs = data_connect.executeQuery();
                if(rs.next()) {
                    SanPham sp = new SanPham();
                    sp.setMaHH(rs.getString("mahh"));
                    sp.setMaLH(rs.getString("malh"));
                    sp.setTenHang(rs.getString("tenhang"));
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
    
    public SanPham timkiem_Chip(String chip) throws Exception{
            String search = "select * from hanghoa where (chip LIKE '%' + ? +'%')";
            try (
                    Connection connect = database_connect.connection();
                    PreparedStatement data_connect = connect.prepareStatement(search);
            )
                
               
            {
                data_connect.setString(1, chip);
                ResultSet rs = data_connect.executeQuery();
                if(rs.next()) {
                    SanPham sp = new SanPham();
                    sp.setMaHH(rs.getString("mahh"));
                    sp.setMaLH(rs.getString("malh"));
                    sp.setTenHang(rs.getString("tenhang"));
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
    
    public SanPham timkiem_VGA(String vga) throws Exception{
            String search = "select * from hanghoa where (vga = ?)";
            try (
                    Connection connect = database_connect.connection();
                    PreparedStatement data_connect = connect.prepareStatement(search);
            )
                
               
            {
                data_connect.setString(1, vga);
                ResultSet rs = data_connect.executeQuery();
                if(rs.next()) {
                    SanPham sp = new SanPham();
                    sp.setMaHH(rs.getString("mahh"));
                    sp.setMaLH(rs.getString("malh"));
                    sp.setTenHang(rs.getString("tenhang"));
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
    
    public SanPham timkiem_RAM(String ram) throws Exception{
            String search = "select * from hanghoa where (ram = ?)";
            try (
                    Connection connect = database_connect.connection();
                    PreparedStatement data_connect = connect.prepareStatement(search);
            )
                
               
            {
                data_connect.setString(1, ram);
                ResultSet rs = data_connect.executeQuery();
                if(rs.next()) {
                    SanPham sp = new SanPham();
                    sp.setMaHH(rs.getString("mahh"));
                    sp.setMaLH(rs.getString("malh"));
                    sp.setTenHang(rs.getString("tenhang"));
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
    
    public SanPham timkiem_TenHangHoa(String tenhh) throws Exception{
            String search = "select * from hanghoa where (tenhang = ?)";
            try (
                    Connection connect = database_connect.connection();
                    PreparedStatement data_connect = connect.prepareStatement(search);
            )
                
               
            {
                data_connect.setString(1, tenhh);
                ResultSet rs = data_connect.executeQuery();
                if(rs.next()) {
                    SanPham sp = new SanPham();
                    sp.setMaHH(rs.getString("mahh"));
                    sp.setMaLH(rs.getString("malh"));
                    sp.setTenHang(rs.getString("tenhang"));
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
    
    public SanPham timkiem_ThoiGianTonKho(String tgtk) throws Exception{
            String search = "select * from hanghoa as hh inner join chitiethdmua as cthdm on hh.mahh = cthdm.mhh inner join hoadonmua as hdm on cthdm.mahd = hdm.mahd where (hh.slton > 1) and (hdm.ngaylap < {fn NOW()} - 30*?)";
            try (
                    Connection connect = database_connect.connection();
                    PreparedStatement data_connect = connect.prepareStatement(search);
            )
                
               
            {
                data_connect.setInt(1, Integer.parseInt(tgtk));
                ResultSet rs = data_connect.executeQuery();
                if(rs.next()) {
                    SanPham sp = new SanPham();
                    sp.setMaHH(rs.getString("mahh"));
                    sp.setMaLH(rs.getString("malh"));
                    sp.setTenHang(rs.getString("tenhang"));
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
    
    public SanPham timkiem_SoLuongTon(String slton) throws Exception{
            String search = "select * from hanghoa where slton <= ?";
            try (
                    Connection connect = database_connect.connection();
                    PreparedStatement data_connect = connect.prepareStatement(search);
            )
                
               
            {
                data_connect.setInt(1, Integer.parseInt(slton));
                ResultSet rs = data_connect.executeQuery();
                if(rs.next()) {
                    SanPham sp = new SanPham();
                    sp.setMaHH(rs.getString("mahh"));
                    sp.setMaLH(rs.getString("malh"));
                    sp.setTenHang(rs.getString("tenhang"));
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
