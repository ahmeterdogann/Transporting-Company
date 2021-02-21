/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nakliye;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

/**
 *
 * @author AhmetERDOĞAN
 */
public class KamyonOperations implements DatabaseInfos{
   
         public static ArrayList<KamyonBean> getKamyonlar(String subeKodu) {
            String sql = "SELECT * FROM " + TABLE_KAMYONLAR + " WHERE SUBE_KODU = ?";
            try(PreparedStatement statement = Database.getConnection().prepareStatement(sql);) {
           
                statement.setString(1, subeKodu);
                ResultSet rs=statement.executeQuery();
                ArrayList<KamyonBean> liste=new ArrayList<>();
                while(rs.next())
                {
                    KamyonBean k =new KamyonBean();
                    k.setMarka(rs.getString("MARKA"));
                    k.setModel(rs.getString("MODEL"));
                    k.setPlaka(rs.getString("PLAKA"));
                    k.setSubeKodu(rs.getString("SUBE_KODU"));
                    liste.add(k);//Her bir dönen sonucu listeye ekliyoruz.
                }
                System.out.println(liste.get(1).subeKodu + "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
            return liste;//Listeyi return ediyoruz.
            } 
            catch (Exception e) {
                System.out.println("HATA OLUŞTU " + subeKodu);
                e.getMessage();
                return null;
            }
            
        }   
}
