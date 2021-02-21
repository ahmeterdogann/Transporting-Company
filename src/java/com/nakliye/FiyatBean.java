/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nakliye;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author AhmetERDOĞAN
 */
@ManagedBean
@SessionScoped
public class FiyatBean {
    
    String mesafe = "";
    String odaSayisi = "";
    String daireKati = "";
    String yukAsansoruVarMı = "";
    double fiyat = 0.;

    public String getMesafe() {
        return mesafe;
    }

    public void setMesafe(String mesafe) {
        this.mesafe = mesafe;
    }

    public String getOdaSayisi() {
        return odaSayisi;
    }

    public void setOdaSayisi(String odaSayisi) {
        this.odaSayisi = odaSayisi;
    }

    public String getDaireKati() {
        return daireKati;
    }

    public void setDaireKati(String daireKati) {
        this.daireKati = daireKati;
    }

    public String getYukAsansoruVarMı() {
        return yukAsansoruVarMı;
    }

    public void setYukAsansoruVarMı(String yukAsansoruVarMı) {
        this.yukAsansoruVarMı = yukAsansoruVarMı;
    }
    
    public double getFiyat() {
        return fiyat;
    }

    public void setFiyat(double fiyat) {
        this.fiyat = fiyat;
    }
    
    public double hesapla() {
        int odaSayi = Integer.parseInt(odaSayisi);
        int daireKat = Integer.parseInt(daireKati);
        fiyat = odaSayi * 300.5;
        fiyat += daireKat * 40.5;
        
        if (mesafe.equals("sehirdisi"))
           fiyat += 1000.9;
        
        if (yukAsansoruVarMı.equals("yok"))
            fiyat += 200.4;
            
        return getFiyat();
    }
    
    public void insert() {
        double fiyatUser = hesapla();
        FiyatOperations.createFiyat(UserBean.id, fiyat);
    }
    
    public void temizle() {
        mesafe = "";
        odaSayisi = "";
        daireKati = "";
        yukAsansoruVarMı = "";
        fiyat = 0.;
    }
    
    
}
