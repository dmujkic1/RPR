package com.example.rpr_t7;

import javafx.beans.property.SimpleStringProperty;

//ovo je javabeans klasa koja nema nista osim atributa, seterra i gettera

public class Korisnik {
    private SimpleStringProperty ime,prezime,email,korisnicko_ime,lozinka;
    public Korisnik()
    {
        this("","","","",""); //poziva donji konstruktor
    }
    public Korisnik( String ime, String prezime, String email, String k, String lozinka)
    {
        this.ime=new SimpleStringProperty(ime);
        this.prezime=new SimpleStringProperty(prezime);
        this.email=new SimpleStringProperty(email);
        this.korisnicko_ime=new SimpleStringProperty(k);
        this.lozinka=new SimpleStringProperty(lozinka);
    }
    public SimpleStringProperty imeProperty() {
        return ime;
    }
    public  String getIme() {
        return ime.get();
    }
    public void setIme( String ime)
    {
        this.ime.set(ime);
    }
    //ovo su geteri za propertije, ne postoje seteri jer kad se jednom spoje za kontrolu neku samo im se vrijed mogu mijenjat
    public SimpleStringProperty prezimeProperty() {
        return prezime; //ovo vraca referencu na property
    }
    public  String getPrezime() {
        return prezime.get();
    }
    public void setPrezime( String prezime)
    {
        this.prezime.set(prezime);
    }
    public  SimpleStringProperty emailProperty() {
        return email;
    }
    public String getEmail() {
        return email.get();
    }
    public void setEmail( String email)
    {
        this.email.set(email);
    }
    public SimpleStringProperty korisnicko_imeProperty() {
        return korisnicko_ime;
    }
    public  String getKorisnicko_ime() {
        return korisnicko_ime.get();
    }
    public void setKorisnicko_ime( String k)
    {
        this.korisnicko_ime.set(k);
    }
    public SimpleStringProperty lozinkaProperty() {
        return lozinka;
    }
    public String getLozinka() {
        return lozinka.get();
    }
    public void setLozinka(String lozinka)
    {
        this.lozinka.set(lozinka);
    }
    @Override
    public String toString()
    {
        return "Korisnik: "+ime.get();
    }
}