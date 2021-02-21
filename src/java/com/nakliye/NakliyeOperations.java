/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nakliye;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author AhmetERDOĞAN
 */
public class NakliyeOperations implements DatabaseInfos{
    
    
   public static String getSubeBilgileri(String subeKodu, String info) {
       String subeInfo = "";

        String sql = "SELECT " + info + " FROM " + TABLE_SUBELER + " WHERE SUBE_KODU = ?";
        
            try(PreparedStatement statement = Database.getConnection().prepareStatement(sql);) {
                statement.setString(1, subeKodu);

                ResultSet rs = statement.executeQuery();

                if (rs.next()) {
                    subeInfo = rs.getString(info);
                }

             

            } catch (SQLException e) {
                System.out.println(e);
            }
            
            return subeInfo;
        }

        
   }

