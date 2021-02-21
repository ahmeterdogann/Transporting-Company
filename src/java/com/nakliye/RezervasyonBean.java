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
public class RezervasyonBean {

   
    String tarih;
    String newDate;
    String updateErr;
    boolean updateErrFlag;
    String iptalErr;

    public String getIptalErr() {
        return iptalErr;
    }

    public void setIptalErr(String iptalErr) {
        this.iptalErr = iptalErr;
    }
    
    public String getUpdateErr() {
        return updateErr;
    }

    public void setUpdateErr(String updateErr) {
        this.updateErr = updateErr;
    }
    
    public String getNewDate() {
        return newDate;
    }

    public void setNewDate(String newDate) {
        this.newDate = newDate;
    }
    
   
    public RezervasyonBean() {
    }



    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }
    
    public String create() {
        System.out.println(tarih);
        RezervasyonOperations.createRez(UserBean.id, tarih);
        tarih = null;
        return "useranasayfa?faces-redirect=true";
    }
    
    public String  updateRezDate()
    {
        if (updateErrFlag) {
            updateErr = "Rezervasyonunuz Bulunmamakta Lütfen İlk Önce Rezervasyon Oluşturunuz!";
            return "profilim?faces-redirect=true";
        }
        else {
            RezervasyonOperations.updateRezDate(UserBean.id, newDate);
            updateErr = "Rezervasyon Tarihiniz Güncellenmiştir!";
            return "profilim?faces-redirect=true";
        }
    }
    
    public void rezervasyonVarMi()
    {

        updateErrFlag = !RezervasyonOperations.rezervasyonVarMi(UserBean.id);
    }
    
    public String rezervasyonIptal()
    {
        if (updateErrFlag) {
            iptalErr = "Rezervasyonunuz Bulunmamakta Lütfen İlk Önce Rezervasyon Oluşturunuz!";
            return "profilim?faces-redirect=true";
        }
        else {
            RezervasyonOperations.iptalRez(UserBean.id);
            iptalErr = "Rezervasyonunuz İptal Edilmiştir";
            return "profilim?faces-redirect=true";
        }
    }
}
