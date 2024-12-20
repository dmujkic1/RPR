package org.example;
import java.util.*;
public class Predmet implements Predstavi{
    private String naziv,opis;
    ArrayList<Ocjena> ocjene=new ArrayList<Ocjena>();
    public
    Predmet(){naziv=null; opis=null;}
    Predmet(String naziv, String opis)
    {
        this.naziv=naziv;
        this.opis=opis;
    }
    String getNaziv(){return naziv;}
    String getOpis(){return opis;}
    void setNaziv(){this.naziv=naziv;}
    void setOpis(){this.opis=opis;}
    @Override
    public String toString()
    {
        return "Naziv: "+naziv+" Opis: "+opis;
    }
    @Override
    public String predstavi()
    {
        return this.toString();
    }
    void ocijeniPredmet(LicneInformacije osoba,int x) throws NevalidnaOcjena
    {
        Ocjena o=osoba.ocijeni(x);
        ocjene.add(ocjene.size(),o);
    }
    void utisci()
    {
        System.out.println("Ocjene za "+this.naziv);
        for(int i=0; i<ocjene.size(); i++)
            System.out.println(ocjene.get(i).toString());
    }
}
