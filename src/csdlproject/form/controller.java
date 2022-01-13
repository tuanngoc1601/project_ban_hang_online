/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package csdlproject.form;


import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import csdlproject.form.sanpham.sanphammain;
import csdlproject.form.nhacungcap.nhacungcapmain;
import csdlproject.form.nhanvien.nhanvienmain;
import csdlproject.form.quanlikhachhang.quanlikhachhangmain;
import csdlproject.form.trungtambaohanh.trungtambaohanhmain;



/**
 *
 * @author VIP
 */
class controller {
    private JFrame jfrMain;
    private JPanel root;
    private String kindSelected;
    
    public controller(JPanel root, JFrame jfrMain) {
        this.jfrMain = jfrMain;
        this.root = root;
    }
    
    public void setView(JPanel jpnItem, JLabel jlbItem, String kind) {
        this.kindSelected = kind;
        jpnItem.setBackground(new Color(0));
        jlbItem.setBackground(new Color(0));
        JPanel view = new  JPanel();
        switch(kind) {
                case "TrangChu":
                    view = new home();
                    break;
                case "SanPham":
                    view = new sanphammain(this.jfrMain);
                    break;
                case "TrungTambaoHanh":
                    view = new trungtambaohanhmain(this.jfrMain);
                    break;
                case "NhaCungCap":
                    view = new nhacungcapmain(this.jfrMain);
                    break;
                case "QuanLiNhanVien":
                    view = new nhanvienmain(this.jfrMain);
                    break; 
                case "QuanLiKhachHang":
                    view = new quanlikhachhangmain(this.jfrMain);
                    break;
                //any more
                default:
                    break;
            }  
        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(view);
        root.validate();
        root.repaint();
    } 

}
