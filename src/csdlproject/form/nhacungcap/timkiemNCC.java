/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package csdlproject.form.nhacungcap;

import csdlproject.database_connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author VIP
 */
public class timkiemNCC {
    public NhaCungCap timkiem_ncc(String MaNCC) throws Exception{
            String search = "select * from nhacungcap where mancc = ?";
            try (
                    Connection connect = database_connect.connection();
                    PreparedStatement data_connect = connect.prepareStatement(search);
            )
                
               
            {
                data_connect.setString(1, MaNCC);
                ResultSet rs = data_connect.executeQuery();
                if(rs.next()) {
                    NhaCungCap ncc = new NhaCungCap();
                    ncc.setMaNCC(rs.getString("mancc"));
                    ncc.setTenNCC(rs.getString("TenNCC"));
                    ncc.setDiaChi(rs.getString("DiaChi"));
                    ncc.setDienThoai(rs.getString("DienThoai"));
                    
                    return ncc;
                }
                
                
                return null;
            
            }
         
    } 
}
