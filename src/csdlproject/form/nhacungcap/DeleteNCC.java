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
public class DeleteNCC {
    public Boolean delete_ncc(String mancc) throws Exception{
            String search = "delete from nhacungcap where mancc = ?";
            try (
                    Connection connect = database_connect.connection();
                    PreparedStatement data_connect = connect.prepareStatement(search);
            )
                
               
            {
                data_connect.setString(1, mancc);
                
                return data_connect.executeUpdate() > 0;
            }
         
    }
}
