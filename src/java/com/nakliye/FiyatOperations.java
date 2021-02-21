/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nakliye;

import java.sql.PreparedStatement;

/**
 *
 * @author AhmetERDOĞAN
 */


public class FiyatOperations implements DatabaseInfos {
    public static void createFiyat(int kullaniciId, double fiyat) {
        
        System.out.println("DENEME :" + fiyat );
        String sql = "INSERT INTO " + TABLE_FIYATLAR + " (KULLANICI_ID, FIYAT) VALUES (?,?)";
 
        try(PreparedStatement statement = Database.getConnection().prepareStatement(sql)){
         
            statement.setInt(1, kullaniciId);
            statement.setDouble(2, fiyat);
            statement.executeUpdate();
           
        }
        catch(Exception e) {
            e.getMessage();
        }
    }
}

