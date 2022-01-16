/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package csdlproject.form.thongke;

/**
 *
 * @author VIP
 */
public class NhaCungCap {
    String MaNCC, TenNCC;
    int loinhuan;

    public NhaCungCap() {
        
    }

    public String getMaNCC() {
        return MaNCC;
    }

    public void setMaNCC(String MaNCC) {
        this.MaNCC = MaNCC;
    }

    public String getTenNCC() {
        return TenNCC;
    }

    public void setTenNCC(String TenNCC) {
        this.TenNCC = TenNCC;
    }

    public int getLoinhuan() {
        return loinhuan;
    }

    public void setLoinhuan(int loinhuan) {
        this.loinhuan = loinhuan;
    }

    public NhaCungCap(String MaNCC, String TenNCC, int loinhuan) {
        this.MaNCC = MaNCC;
        this.TenNCC = TenNCC;
        this.loinhuan = loinhuan;
    }
}
