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
public class AdresOperations implements DatabaseInfos {
    
    public static void createAdres(int kullaniciId, String sehir, String ilce, String mahalle, String caddeSokak, String binaNo, String daireNo) {
        
        System.out.println("TEST :" + mahalle );
        String sql = "INSERT INTO " + TABLE_ADRES + " (KULLANICI_ID, SEHIR, ILCE, MAHALLE, CADDE_SOKAK, BINA_NO, DAIRE_NO) VALUES (?,?,?,?,?,?,?)";
 
        try(PreparedStatement statement = Database.getConnection().prepareStatement(sql)){
         
            statement.setInt(1, kullaniciId);
            statement.setString(2, sehir);
            statement.setString(3, ilce);
            statement.setString(4, mahalle);
            statement.setString(5, caddeSokak);
            statement.setString(6, binaNo);
            statement.setString(7, daireNo);
            statement.executeUpdate();
            System.out.println("TEST :" + mahalle +"için işlem tamamlandı");
           
        }
        catch(Exception e) {
            System.out.println("TEST :" + mahalle +"için işlem tamamlanamadı");
            e.getMessage();
        }
    }
}
