/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package csdlproject.form.thongke;

/**
 *
 * @author VIP
 */
public class KhachHang {
    String MaKH, TenKH;
    int doanhthu, loinhuan;

    public KhachHang() {
        
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public String getTenKH() {
        return TenKH;
    }

    public void setTenKH(String TenKH) {
        this.TenKH = TenKH;
    }

    public int getDoanhthu() {
        return doanhthu;
    }

    public void setDoanhthu(int doanhthu) {
        this.doanhthu = doanhthu;
    }

    public int getLoinhuan() {
        return loinhuan;
    }

    public void setLoinhuan(int loinhuan) {
        this.loinhuan = loinhuan;
    }

    public KhachHang(String MaKH, String TenKH, int doanhthu, int loinhuan) {
        this.MaKH = MaKH;
        this.TenKH = TenKH;
        this.doanhthu = doanhthu;
        this.loinhuan = loinhuan;
    }
}
