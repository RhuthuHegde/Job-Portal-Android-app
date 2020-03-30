package com.example.firebaseauth;

import android.widget.Button;
import android.widget.CheckBox;

public class employer {
    public String name,cname,city,country;
    public Integer phone;
    public Button enter;

    public employer(String name,String cname, Integer phone, Button enter) {
        this.name = name;
        this.cname = cname;
        this.phone = phone;
        this.enter = enter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }


    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    public String getCountry() {
        return country;
    }

    public void setCountry(String name) {
        this.country = country;
    }
    public employer(String trim, String cname, String s, String trim1){

    }
}
