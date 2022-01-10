/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package csdlproject.form.trungtambaohanh;

import csdlproject.database_connect;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author VIP
 */
public class DeleteTTBH {
    public Boolean delete_ttbh(String mattbh) throws Exception{
            String search = "delete from ttbh where mattbh = ?";
            try (
                    Connection connect = database_connect.connection();
                    PreparedStatement data_connect = connect.prepareStatement(search);
            )
                
               
            {
                data_connect.setString(1, mattbh);
                
                return data_connect.executeUpdate() > 0;
            }
         
    }
}
