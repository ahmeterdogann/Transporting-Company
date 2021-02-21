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
public class BazıSorgularBean {
    double enYuksekRezFiyat = 0.;
    String enYuksekRezIsim = "";
    String enYuksekRezTarih = "";
    String enYüksekRezBilgiler = "";
  
    public BazıSorgularBean() {
    }

    public String getEnYüksekRezBilgiler() {
        return enYüksekRezBilgiler;
    }

    public void setEnYüksekRezBilgiler(String enYüksekRezBilgiler) {
        this.enYüksekRezBilgiler = enYüksekRezBilgiler;
    }

   
    public double getEnYuksekRezFiyat() {
        return enYuksekRezFiyat;
    }

    public void setEnYuksekRezFiyat(double enYuksekRezFiyat) {
        this.enYuksekRezFiyat = enYuksekRezFiyat;
    }

    public String getEnYuksekRezIsim() {
        return enYuksekRezIsim;
    }

    public void setEnYuksekRezIsim(String enYuksekRezIsim) {
        this.enYuksekRezIsim = enYuksekRezIsim;
    }

    public String getEnYuksekRezTarih() {
        return enYuksekRezTarih;
    }

    public void setEnYuksekRezTarih(String enYuksekRezTarih) {
        this.enYuksekRezTarih = enYuksekRezTarih;
    }
    
    public double enYuksekRezFiyat()
    {
        enYuksekRezFiyat = BaziSorgularOperations.enYuksekRezFiyat();
        
        return enYuksekRezFiyat;
    }
    
    public String enYuksekRezIsim()
    {
        enYuksekRezIsim = BaziSorgularOperations.enYuksekRezIsim();
        
        return enYuksekRezIsim;
    }
    
    public String enYuksekRezTarih()
    {
        enYuksekRezTarih = BaziSorgularOperations.enYuksekRezTarih();
        
        return enYuksekRezTarih;
    }
    
    public String enYuksekRezBilgiler()
    {
        enYüksekRezBilgiler = BaziSorgularOperations.enYuksekRezBilgiler();
        
        return enYüksekRezBilgiler;
    }
}
