/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package csdlproject.form.nhacungcap;

import csdlproject.database_connect;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author VIP
 */
public class UpdateNCC {
    public Boolean Update_ncc(NhaCungCap ncc) throws Exception{
            String search = "update nhacungcap set diachi = ?, dienthoai = ? where mancc = ?";
            try (
                    Connection connect = database_connect.connection();
                    PreparedStatement data_connect = connect.prepareStatement(search);
            )
                
               
            {
                data_connect.setString(1, ncc.getDiaChi());
                data_connect.setString(2, ncc.getDienThoai());
                data_connect.setString(3, ncc.getMaNCC());
                
                return data_connect.executeUpdate() > 0;
            }
         
    }
}
