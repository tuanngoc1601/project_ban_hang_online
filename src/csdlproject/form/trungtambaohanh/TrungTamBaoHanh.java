/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package csdlproject.form.trungtambaohanh;

/**
 *
 * @author VIP
 */
public class TrungTamBaoHanh {
    private String MaTTBH, DiaChi, DienThoai;

    public TrungTamBaoHanh() {
        
    }

    public String getMaTTBH() {
        return MaTTBH;
    }

    public void setMaTTBH(String MaTTBH) {
        this.MaTTBH = MaTTBH;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getDienThoai() {
        return DienThoai;
    }

    public void setDienThoai(String DienThoai) {
        this.DienThoai = DienThoai;
    }

    public TrungTamBaoHanh(String MaTTBH, String DiaChi, String DienThoai) {
        this.MaTTBH = MaTTBH;
        this.DiaChi = DiaChi;
        this.DienThoai = DienThoai;
    }
}
