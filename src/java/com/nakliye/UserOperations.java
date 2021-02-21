package com.nakliye;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author AhmetERDOĞAN
 */
public class UserOperations implements DatabaseInfos {
    
    public static int getId() {
        int maxId = -1;
        String sql = "SELECT Max(ID) FROM " + TABLE_KULLANICI + "";
        
        try(PreparedStatement state = Database.getConnection().prepareStatement(sql)) {     
           ResultSet set = state.executeQuery();

            if (set.next()) {
                maxId = set.getInt(1);
            }

        } catch (SQLException e) {
            e.getMessage();
        }
        
        System.out.println("getID ÇALIŞTI VE " + maxId + "+ 1 döndü");
        return ++maxId;
    }
    
    //Kullanıcı oluşturma UserBeanden çağrılıyor
    public static void createUser(int id, String name, String surname, String username, String mail, String password, String telNo) {
        
        String sql = "INSERT INTO " + TABLE_KULLANICI + " (ID, ISIM, SOYISIM, KULLANICI_ADI, EMAIL, SIFRE, TELEFON) VALUES (?,?,?,?,?,?,?)";
       
        try(PreparedStatement statement = Database.getConnection().prepareStatement(sql)){
          System.out.println("kullanıcı oluşturuluyor ");
          System.out.println(id + "----" + name + "-----" + surname +"-----" + "username" + "---------" + mail + "-----" + password + "----" + telNo);
            statement.setInt(1, id);
            statement.setString(2, name);
            statement.setString(3, surname);
            statement.setString(4, username);
            statement.setString(5, mail);
            statement.setString(6, password);
            statement.setString(7, telNo);
            statement.executeUpdate();
           
        }
        catch(Exception e) {
            System.out.println("kullanıcı oluşturulumadı ");
            e.getMessage();
        }
    }
    
    //Aktif kullanıcıyı güncelleme
    public static void refreshUser(UserBean user) {
        
        String sql = "SELECT * FROM " + TABLE_KULLANICI + " WHERE KULLANICI_ADI = ?";
        
        try(PreparedStatement ps = Database.getConnection().prepareStatement(sql)) {
           
            ps.setString(1, user.username);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                UserBean.id = rs.getInt("ID");
                // user.username = rs.getString("username"); Zaten alındı
                // user.password = rs.getString("password"); Zaten alındı
                user.email = rs.getString("EMAIL");
                user.name = rs.getString("ISIM");
                user.surName = rs.getString("SOYISIM");
                user.telno = rs.getString("TELEFON");
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    
    
    public static boolean checkPasswordAndUserName(String username, String password) {
        if (password != null && password.length() > 0) {
            String sql = "SELECT * FROM " + TABLE_KULLANICI + " WHERE SIFRE = ? AND KULLANICI_ADI = ?";
            try(PreparedStatement statement = Database.getConnection().prepareStatement(sql)) {
                statement.setString(1, password);
                statement.setString(2, username);
                ResultSet rs = statement.executeQuery();

                if (rs.next()) {
                    return true;
                }

            } catch (SQLException e) {
                e.getMessage();
            }
        }
        return false;
    }

    public static void getUserRez(int kullaniciId, UserBean user) {
        
        String sql = "SELECT TARIH FROM " + TABLE_REZERVASYONLAR + " WHERE KULLANICI_ID = ?";
        
        try(PreparedStatement statement = Database.getConnection().prepareStatement(sql)) {
          
            statement.setInt(1, kullaniciId);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                user.rezDate = rs.getString("TARIH") + " tarihli bir rezervasyonunuz bulunmakta";
                
            }
            
            else {
                user.rezDate = "Rezervasyonunuz Bulunmamakta";
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    
    public static boolean kullaniciAdiKontrol(String username) {
       
            String sql = "SELECT * FROM " + TABLE_KULLANICI + " WHERE KULLANICI_ADI = ?";
            try(PreparedStatement statement = Database.getConnection().prepareStatement(sql)) {
                statement.setString(1, username);
                ResultSet rs = statement.executeQuery();
                 
                if (rs.next()) {
                    System.out.print("kullanıcı adı kontrolü try çalıştı ife girdi ve true döndü");
                    return true;
                }
                System.out.print("kullanıcı adı kontrolü try çalıştı ve ife girmedi");
            } catch (SQLException e) {
                System.out.print("kullanıcı adı kontrolü catch çalıştı ve hata oluştu");
                e.getMessage();
            }
        System.out.print("kullanıcı adı kontrolü try çalıştı ve false döndü");
        return false;
    }
    
    
    //çıkış yaptıktan sonra kullanıcı resetleme
    public static void resetData(UserBean user) {
        user.reset();
    }
    
}
