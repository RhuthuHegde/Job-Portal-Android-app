package com.example.firebaseauth;

import android.widget.Button;
import android.widget.CheckBox;

public class employer {
    public String name,cname,skills,employer;
    public Integer phone;
    public CheckBox python,web,graphic,software,game;
    public Button enter;

    public employer(String name, String cname, String skills, String employer, Integer phone, CheckBox python, CheckBox web, CheckBox graphic, CheckBox software, CheckBox game, Button enter) {
        this.name = name;
        this.cname = cname;
        this.skills = skills;
        this.employer = employer;
        this.phone = phone;
        this.python = python;
        this.web = web;
        this.graphic = graphic;
        this.software = software;
        this.game = game;
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

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getEmployer() {
        return employer;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public CheckBox getPython() {
        return python;
    }

    public void setPython(CheckBox python) {
        this.python = python;
    }

    public CheckBox getWeb() {
        return web;
    }

    public void setWeb(CheckBox web) {
        this.web = web;
    }

    public CheckBox getGraphic() {
        return graphic;
    }

    public void setGraphic(CheckBox graphic) {
        this.graphic = graphic;
    }

    public CheckBox getSoftware() {
        return software;
    }

    public void setSoftware(CheckBox software) {
        this.software = software;
    }

    public CheckBox getGame() {
        return game;
    }

    public void setGame(CheckBox game) {
        this.game = game;
    }

    public Button getEnter() {
        return enter;
    }

    public void setEnter(Button enter) {
        this.enter = enter;
    }
    public employer(){

    }
}
