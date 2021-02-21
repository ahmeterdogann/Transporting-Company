/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nakliye;


import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.*;

/**
 *
 * @author AhmetERDOĞAN
 */
@ManagedBean
@SessionScoped
public class KamyonBean implements Serializable{
    String subeKodu;
    String marka;
    String model;
    String plaka;
   
    public KamyonBean() {
    }

    public String getSubeKodu() {
        return subeKodu;
    }

    public void setSubeKodu(String subeKodu) {
        this.subeKodu = subeKodu;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPlaka() {
        return plaka;
    }

    public void setPlaka(String plaka) {
        this.plaka = plaka;
    }
    
    public String setSubeIst() {
        this.subeKodu = "34341";
        return "kamyonlar?faces-redirect=true";
    }
    
    public String setSubeAnk() {
        this.subeKodu = "06061";
        return "kamyonlar?faces-redirect=true";
    }
    
    public String setSubeIzm() {
        this.subeKodu = "35351";
        return "kamyonlar?faces-redirect=true";
    }
    
    public ArrayList<KamyonBean> getKamyonlar(String subeKodu) {
        ArrayList<KamyonBean> aList = KamyonOperations.getKamyonlar(subeKodu);
        
        return aList;
    }
}
