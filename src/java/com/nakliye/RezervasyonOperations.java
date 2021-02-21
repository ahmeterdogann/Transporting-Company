package com.nakliye;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author AhmetERDOĞAN
 */
public class RezervasyonOperations implements DatabaseInfos{
    public static void createRez(int kullaniciId, String tarih) {
        
        String sql = "INSERT INTO " + TABLE_REZERVASYONLAR + " (KULLANICI_ID, TARIH) VALUES (?,?)";
 
        try(PreparedStatement statement = Database.getConnection().prepareStatement(sql)){
         
            statement.setInt(1, kullaniciId);
            statement.setString(2, tarih);
            statement.executeUpdate();
           
        }
        catch(Exception e) {
            e.getMessage();
        }
    }
    
    public static boolean rezervasyonVarMi(int kullanici_id) {
       
            String sql = "SELECT * FROM " + TABLE_REZERVASYONLAR + " WHERE KULLANICI_ID = ?";
            try(PreparedStatement statement = Database.getConnection().prepareStatement(sql)) {
                statement.setInt(1, kullanici_id);
                ResultSet rs = statement.executeQuery();

                if (rs.next()) {
                    return true;
                }

            } catch (SQLException e) {
                e.getMessage();
            }
        
        return false;
    }
    
    public static void updateRezDate(int kullanici_id, String newDate)
    {
        String sql = "UPDATE " + TABLE_REZERVASYONLAR + " SET TARIH = ? WHERE KULLANICI_ID = ?";
 
        try(PreparedStatement statement = Database.getConnection().prepareStatement(sql)){
            statement.setString(1, newDate);
            statement.setInt(2, kullanici_id);
            statement.executeUpdate();

           
        }
        catch(Exception e) {

            e.getMessage();
        }
        
    }
    
    
    public static void iptalRez(int kullanici_id)
    {
        String sql = "DELETE FROM " + TABLE_REZERVASYONLAR + " WHERE KULLANICI_ID = ?";
 
        try(PreparedStatement statement = Database.getConnection().prepareStatement(sql)){
            statement.setInt(1, kullanici_id);
            statement.executeUpdate();
            System.out.println("REZ TABLOSU İÇİN TRY ÇALIŞTI");
           
        }
        catch(Exception e) {
            System.out.println("REZ TABLOSU İÇİN CATCH ÇALIŞTI");
            e.getMessage();
        }
        
        
        String sql2 = "DELETE FROM " + TABLE_ADRES + " WHERE KULLANICI_ID = ?";
 
        try(PreparedStatement statement = Database.getConnection().prepareStatement(sql2)){
            statement.setInt(1, kullanici_id);
            statement.executeUpdate();
            System.out.println("ADRES TABLOSU İÇİN TRY ÇALIŞTI");
           
        }
        catch(Exception e) {
            System.out.println("ADRES TABLOSU İÇİN CATCH ÇALIŞTI");
            e.getMessage();
        }
        
        String sql3 = "DELETE FROM " + TABLE_FIYATLAR + " WHERE KULLANICI_ID = ?";
 
        try(PreparedStatement statement = Database.getConnection().prepareStatement(sql3)){
            statement.setInt(1, kullanici_id);
            statement.executeUpdate();
            System.out.println("FIYAT TABLOSU İÇİN TRY ÇALIŞTI");
           
        }
        catch(Exception e) {
            System.out.println("FIYAT TABLOSU İÇİN CATCH ÇALIŞTI");
            e.getMessage();
        }
    }
    
    
}
