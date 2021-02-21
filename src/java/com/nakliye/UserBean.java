
package com.nakliye;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author AhmetERDOĞAN
 */

@ManagedBean
@SessionScoped
public class UserBean implements DatabaseInfos {

    static int id;
    String name;
    String surName;
    String username;
    String email;
    String password;
    String telno;
    String logErr;
    String rezDate;
    static boolean logged;
    String regErr;
    boolean regErrFlag;

    
    public String getRegErr() {
        return regErr;
    }

   
    
    public void setRegErr(String regErr) {    
        this.regErr = regErr;
    }

    public UserBean() {
    }

    public String getRezDate() {
        return rezDate;
    }

    public void setRezDate(String rezDate) {
        this.rezDate = rezDate;
    }

    public String getLogErr() {
        return logErr;
    }

    public void setLogErr(String logErr) {
        this.logErr = logErr;
    }

    public static boolean isLogged() {
        return logged;
    }

    public static void setLogged(boolean logged) {
        UserBean.logged = logged;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelno() {
        return telno;
    }

    public void setTelno(String telno) {
        this.telno = telno;
    }
    
    public int getId() {
        return id;
    }
    
    
    
    public String loginAndRefreshInfos() {
        if (UserBean.logged) {
            return "useranasayfa?faces-redirect=true"; // Sayfaya bağlanma
        }

        reset();
        logErr = "Kullanıcı Adı veya Şifre yanlış";
        return "login?faces-redirect=true";
    }
    
    //LOGİN YAPAN KULLANICININ KULLANICI ADI VE ŞİFRE KONTROLÜ
    public void checkUser() {
        boolean error = false;

        if (!UserOperations.checkPasswordAndUserName(username, password)) {
            error = true;
        }

        if (!error) {
            UserOperations.refreshUser(this);
            logged = true;
           
        }

   
    }
    
    public String logOut() {
        if (logged) {
            logged = false;
            UserOperations.resetData(this);
        }

        return "index?faces-redirect=true";
    }
    
    //rezervasyon tarihi
    public String dateRez() {
       UserOperations.getUserRez(id, this);
       return rezDate;
    }
    
    public void reset() {
        id = 0;
        email = null;
        username = null;
        password = null;
        name = null;
        surName = null;
        telno = null;
        logErr = null;
        regErr=null;
    }

  
    public String register()
    {
     
      if (regErrFlag) {
          regErr = "Kullanici Adı Müsait Değil Lütfen Başka Bir Kullanıcı Adıyla Tekrar Deneyiniz!";
          return "register?faces-redirect=true";
      }
      else {
          System.out.println("register metoduna else kısmına girildi");
      UserOperations.createUser(UserOperations.getId(), name, surName, username, email, password, telno);
      reset();
      return "index?faces-redirect=true";
      }
    }
    
    public void kullaniciAdiKontrol()
    {

        regErrFlag = UserOperations.kullaniciAdiKontrol(username);
    }
}

