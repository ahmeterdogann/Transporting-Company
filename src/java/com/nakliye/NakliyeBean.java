package com.nakliye;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author AhmetERDOĞAN
 */
@ManagedBean
@SessionScoped
public class NakliyeBean implements Serializable{

    
    public NakliyeBean() {
    }
    
    
    public String getSubeBilgileri(String subeKodu, String info) {
        return NakliyeOperations.getSubeBilgileri(subeKodu, info);
    }
}
