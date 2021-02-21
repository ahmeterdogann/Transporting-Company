/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nakliye;

import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author AhmetERDOĞAN
 */
@ManagedBean
@SessionScoped

public class AdresBean {
    String sehirK, ilceK, mahalleK, caddeSokakK, binaNoK, daireNoK;
    String sehirH, ilceH, mahalleH, caddeSokakH, binaNoH, daireNoH;

    public AdresBean() {
    }

    public String getSehirK() {
        return sehirK;
    }

    public void setSehirK(String sehirK) {
        this.sehirK = sehirK;
    }

    public String getIlceK() {
        return ilceK;
    }

    public void setIlceK(String ilceK) {
        this.ilceK = ilceK;
    }

    public String getMahalleK() {
        return mahalleK;
    }

    public void setMahalleK(String mahalleK) {
        this.mahalleK = mahalleK;
    }

    public String getCaddeSokakK() {
        return caddeSokakK;
    }

    public void setCaddeSokakK(String caddeSokakK) {
        this.caddeSokakK = caddeSokakK;
    }

    public String getBinaNoK() {
        return binaNoK;
    }

    public void setBinaNoK(String binaNoK) {
        this.binaNoK = binaNoK;
    }

    public String getDaireNoK() {
        return daireNoK;
    }

    public void setDaireNoK(String daireNoK) {
        this.daireNoK = daireNoK;
    }

    public String getSehirH() {
        return sehirH;
    }

    public void setSehirH(String sehirH) {
        this.sehirH = sehirH;
    }

    public String getIlceH() {
        return ilceH;
    }

    public void setIlceH(String ilceH) {
        this.ilceH = ilceH;
    }

    public String getMahalleH() {
        return mahalleH;
    }

    public void setMahalleH(String mahalleH) {
        this.mahalleH = mahalleH;
    }

    public String getCaddeSokakH() {
        return caddeSokakH;
    }

    public void setCaddeSokakH(String caddeSokakH) {
        this.caddeSokakH = caddeSokakH;
    }

    public String getBinaNoH() {
        return binaNoH;
    }

    public void setBinaNoH(String binaNoH) {
        this.binaNoH = binaNoH;
    }

    public String getDaireNoH() {
        return daireNoH;
    }

    public void setDaireNoH(String daireNoH) {
        this.daireNoH = daireNoH;
    }
    
    public void insert() {
        insertK();
        insertH();
        reset();
    }
    public void insertK() {
        System.out.println("TEST" + sehirK);
        AdresOperations.createAdres(UserBean.id, sehirK, ilceK, mahalleK, caddeSokakK, binaNoK, daireNoK);
    }
    
    public void insertH() {
        System.out.println("TEST " + sehirH);
        AdresOperations.createAdres(UserBean.id, sehirH, ilceH, mahalleH, caddeSokakH, binaNoH, daireNoH);
    }
    
    public void reset() {
        sehirK = null; 
        ilceK = null; 
        mahalleK = null; 
        caddeSokakK = null; 
        binaNoK = null; 
        daireNoK = null;
        sehirH = null; 
        ilceH = null;
        mahalleH = null;
        caddeSokakH = null; 
        binaNoH = null; 
        daireNoH = null;
    }
}
