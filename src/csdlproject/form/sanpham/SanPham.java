/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package csdlproject.form.sanpham;

/**
 *
 * @author VIP
 */
public class SanPham {
    private String MaLH, MaNCC, MaHH, TenLH, MaTTBH, TenHang, Chip, Main, VGA, SSD, HDD, RAM;
    private int SoLuong, GiaBan, GiaNhap;

    public String getTenLH() {
        return TenLH;
    }

    public void setTenLH(String TenLH) {
        this.TenLH = TenLH;
    }
    

    public SanPham() {
        
    }

    public String getMaLH() {
        return MaLH;
    }

    public void setMaLH(String MaLH) {
        this.MaLH = MaLH;
    }

    public String getMaNCC() {
        return MaNCC;
    }

    public void setMaNCC(String MaNCC) {
        this.MaNCC = MaNCC;
    }

    public String getMaHH() {
        return MaHH;
    }

    public void setMaHH(String MaHH) {
        this.MaHH = MaHH;
    }

    public String getMaTTBH() {
        return MaTTBH;
    }

    public void setMaTTBH(String MaTTBH) {
        this.MaTTBH = MaTTBH;
    }

    public String getTenHang() {
        return TenHang;
    }

    public void setTenHang(String TenHang) {
        this.TenHang = TenHang;
    }

    public String getChip() {
        return Chip;
    }

    public void setChip(String Chip) {
        this.Chip = Chip;
    }

    public String getMain() {
        return Main;
    }

    public void setMain(String Main) {
        this.Main = Main;
    }

    public String getVGA() {
        return VGA;
    }

    public void setVGA(String VGA) {
        this.VGA = VGA;
    }

    public String getSSD() {
        return SSD;
    }

    public void setSSD(String SSD) {
        this.SSD = SSD;
    }

    public String getHDD() {
        return HDD;
    }

    public void setHDD(String HDD) {
        this.HDD = HDD;
    }

    public String getRAM() {
        return RAM;
    }

    public void setRAM(String RAM) {
        this.RAM = RAM;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public int getGiaBan() {
        return GiaBan;
    }

    public void setGiaBan(int GiaBan) {
        this.GiaBan = GiaBan;
    }

    public int getGiaNhap() {
        return GiaNhap;
    }

    public void setGiaNhap(int GiaNhap) {
        this.GiaNhap = GiaNhap;
    }

    public SanPham(String MaLH, String MaNCC, String MaHH, String MaTTBH, String TenHang, String Chip, String Main, String VGA, String SSD, String HDD, String RAM, int SoLuong, int GiaBan, int GiaNhap) {
        this.MaLH = MaLH;
        this.MaNCC = MaNCC;
        this.MaHH = MaHH;
        this.MaTTBH = MaTTBH;
        this.TenHang = TenHang;
        this.Chip = Chip;
        this.Main = Main;
        this.VGA = VGA;
        this.SSD = SSD;
        this.HDD = HDD;
        this.RAM = RAM;
        this.SoLuong = SoLuong;
        this.GiaBan = GiaBan;
        this.GiaNhap = GiaNhap;
    }
    
    
    
    
}
