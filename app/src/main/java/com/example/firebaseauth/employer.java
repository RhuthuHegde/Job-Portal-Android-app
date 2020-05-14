package com.example.firebaseauth;

public class employer
{
    private String editname;
    private String editcname;
    private String editphone;
    private String editcity;
    private String editcountry;
    private String editvac;
    private String editdocumentid;
    employer()
    {

    }

    private employer(String name, String cname, String phone, String city, String country, String vacancy, String documentid)
    {
        this.editname=name;
        this.editcname=cname;
        this.editdocumentid=documentid;
        this.editphone=phone;
        this.editcity=city;
        this.editcountry=country;
        this.editvac=vacancy;
    }

    String getEditname() {
        return editname;
    }

    public void setEditname(String editname) {
        this.editname = editname;
    }

    String getEditcname() {
        return editcname;
    }

    public void setEditcname(String editcname) {
        this.editcname = editcname;
    }

    String getEditphone() {
        return editphone;
    }

    public void setEditphone(String editphone) {
        this.editphone = editphone;
    }

    String getEditcity() {
        return editcity;
    }

    public void setEditcity(String editcity) {
        this.editcity = editcity;
    }

    String getEditcountry() {
        return editcountry;
    }

    public void setEditcountry(String editcountry) {
        this.editcountry = editcountry;
    }

    String getEditvac() {
        return editvac;
    }

    public void setEditvac(String editvac) {
        this.editvac = editvac;
    }

    String getEditdocumentid() {
        return editdocumentid;
    }

    void setEditdocumentid(String editdocumentid) {
        this.editdocumentid = editdocumentid;
    }
}