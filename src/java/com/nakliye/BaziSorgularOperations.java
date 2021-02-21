/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nakliye;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author AhmetERDOĞAN
 */
public class BaziSorgularOperations implements DatabaseInfos {
    
   public static double enYuksekRezFiyat() {
        double maxFiyat = 0.;
        
        String sql = "SELECT Max(FIYAT) FROM " + TABLE_FIYATLAR + "";
        
        try(PreparedStatement state = Database.getConnection().prepareStatement(sql)) {     
           ResultSet set = state.executeQuery();

            if (set.next()) {
                maxFiyat = set.getDouble(1);
            }

        } catch (SQLException e) {
            e.getMessage();
        }

        return maxFiyat;
    }
   
   public static String enYuksekRezIsim()
   {
       
       String username = "";
        String sql = "SELECT KULLANICI_ADI FROM " + 
                TABLE_KULLANICI + 
                " WHERE ID = (SELECT KULLANICI_ID FROM " 
                +  TABLE_FIYATLAR 
                + " WHERE FIYAT IN(SELECT MAX(FIYAT) FROM "
                + TABLE_FIYATLAR + "))";
        
        try(PreparedStatement state = Database.getConnection().prepareStatement(sql)) {   
           ResultSet set = state.executeQuery();

            if (set.next()) {
                username = set.getString(1);
            }

        } catch (SQLException e) {
            e.getMessage();
        }
        

        return username;
   }
   
   public static String enYuksekRezTarih()
   {
       
       String date = "";
        String sql = "SELECT TARIH FROM " + 
                TABLE_REZERVASYONLAR + 
                " WHERE KULLANICI_ID = (SELECT KULLANICI_ID FROM " 
                +  TABLE_FIYATLAR 
                + " WHERE FIYAT IN(SELECT MAX(FIYAT) FROM "
                + TABLE_FIYATLAR + "))";
        
        try(PreparedStatement state = Database.getConnection().prepareStatement(sql)) {   
           ResultSet set = state.executeQuery();

            if (set.next()) {
                date = set.getString(1);
            }

        } catch (SQLException e) {
            e.getMessage();
        }
        

        return date;
   }
   
   public static String enYuksekRezBilgiler()
   {
       
        ArrayList<String> adresKH = new ArrayList<>();
        
        String sql = "SELECT SEHIR FROM " + 
                TABLE_ADRES + 
                " WHERE KULLANICI_ID = (SELECT KULLANICI_ID FROM " 
                +  TABLE_FIYATLAR 
                + " WHERE FIYAT IN(SELECT MAX(FIYAT) FROM "
                + TABLE_FIYATLAR + "))";
        
        try(PreparedStatement state = Database.getConnection().prepareStatement(sql)) {   
           ResultSet set = state.executeQuery();
           
            while(set.next()) {
                adresKH.add(set.getString(1));
            }

        } catch (SQLException e) {
            e.getMessage();
        }
        
        String adresBilgisi = "";
        
        if (adresKH.isEmpty())
            return "";
        else {
           adresBilgisi += adresKH.get(0);
           adresBilgisi += "->";
           adresBilgisi += adresKH.get(1);
           
           return adresBilgisi;
        }
        
   }
   
}
