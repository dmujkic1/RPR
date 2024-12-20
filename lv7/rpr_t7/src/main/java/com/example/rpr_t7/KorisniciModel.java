package com.example.rpr_t7;

//ova klasa ce koristiti beans klasu korisnik
//treba imat observable array list i atribut te trenutno odabranog korisnika tipa simpleobjectproperty
//za oba atributa trebaju get i set metode
//dodat metodu napuni koja ce popunit listu navedenim podacima

import javafx.beans.Observable;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class KorisniciModel {
    private ObservableList<Korisnik> korisnici=FXCollections.observableArrayList();
    private SimpleObjectProperty<Korisnik> trenutnikorisnik=new SimpleObjectProperty<>();
    public ObjectProperty<Korisnik> trenutniKorisnikProperty()
    {
        //referenca na trenutnog se vraca
        return trenutnikorisnik;
    }
    public Korisnik getTrenutniKorisnik()
    {
        return trenutnikorisnik.get();
    }
    public void setTrenutnikorisnik(Korisnik k)
    {
        trenutnikorisnik.set(k);
    }
    public ObservableList<Korisnik> getKorisnici()
    {
        return korisnici;
    }
    public void setKorisnici(ObservableList<Korisnik> korisnici)
    {
        this.korisnici=korisnici;
    }
    public void napuni()
    {
        korisnici.add(new Korisnik("Daris","Mujkic","dmujkic1@etf.unsa.ba","dmujkic1","ETFdm19413"));
        korisnici.add(new Korisnik("Faris","Mujkic","faris.mujkic@live.com","farisdaris","fare17321"));
        korisnici.add(new Korisnik("Omer","Mujkic","omer_mujkic@hotmail.com","omerhosa","boomcatiga"));
        trenutnikorisnik.set(null);
    }
    void dodajkorisnika(Korisnik k)
    {
        korisnici.add(k);
    }
}