/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package csdlproject.form.thongke;

/**
 *
 * @author VIP
 */
public class MatHang {
    String MaHH, TenHang;
    int loinhuan;

    public MatHang() {
        
    }

    public String getMaHH() {
        return MaHH;
    }

    public void setMaHH(String MaHH) {
        this.MaHH = MaHH;
    }

    public String getTenHang() {
        return TenHang;
    }

    public void setTenHang(String TenHang) {
        this.TenHang = TenHang;
    }

    public int getLoinhuan() {
        return loinhuan;
    }

    public void setLoinhuan(int loinhuan) {
        this.loinhuan = loinhuan;
    }

    public MatHang(String MaHH, String TenHang, int loinhuan) {
        this.MaHH = MaHH;
        this.TenHang = TenHang;
        this.loinhuan = loinhuan;
    }
    
}
