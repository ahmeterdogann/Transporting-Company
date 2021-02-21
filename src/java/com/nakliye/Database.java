package com.nakliye;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    
    //Database Bağlantı
    private static Connection connection = null;
    
    
    //Database Kullanıcı Adı
    private static final String USERNAME = "APP";
    
    
    //Database Şifre
    private static final String PASSWORD = "APP";
    
    
    //Database'e bağlantı oluşturma
    private static void connect() throws SQLException {
        if (connection != null){
            close();
            connection = null;
        }
        
       connection = DriverManager.getConnection("jdbc:derby://localhost:1527/nakliye", USERNAME, PASSWORD);
    }
    
    
    //Bağlantıyı kapatma
    public static void close() throws SQLException {
        if (connection != null)
            connection.close();
        
        connection = null;
    }
    
    
    //Bağlantıyı döndürme (yoksa oluşturma)
    public static Connection getConnection() throws SQLException {
        if (connection == null)
            connect();
        
        return connection;
    }
}
