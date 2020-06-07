package com.itann.swipechef.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity (name = "gebruiker")
public class Gebruiker {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String voornaam;
    private String achternaam;
    private String email;
    private String wachtwoord;
    private String rol;

//    public Gebruiker(int id, String voornaam, String achternaam, String email, String wachtwoord, String rol) {
//        this.id = id;
//        this.voornaam = voornaam;
//        this.achternaam = achternaam;
//        this.email = email;
//        this.wachtwoord = wachtwoord;
//        this.rol = rol;
//    }

    public enum Rol {
        ADMINISTRATOR,
        USER;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWachtwoord() {
        return wachtwoord;
    }

    public void setWachtwoord(String wachtwoord) {
        this.wachtwoord = wachtwoord;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

}
