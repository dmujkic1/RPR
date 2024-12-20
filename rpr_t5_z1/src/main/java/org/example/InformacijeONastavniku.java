package org.example;
import java.util.*;

public class InformacijeONastavniku extends LicneInformacije {
    private String titula;
    ArrayList<Ocjena> ocjene=new ArrayList<Ocjena>();
    public
    InformacijeONastavniku(){super(); titula=null;}
    InformacijeONastavniku(String ime, String prezime, String titula)
    {
        super(ime,prezime);
        this.titula=titula;
    }
    @Override
    public void setIme(String ime){this.ime=ime;}
    @Override
    public void setPrezime(String prezime){this.prezime=prezime;}
    @Override
    public String getIme(){return ime;}
    @Override
    public String getPrezime(){return prezime;}
    String getTitula(){return titula;}
    void setTitula(String titula){this.titula=titula;}
    @Override
    public String toString()
    {
        return "Ime: " + getIme()+"\n Prezime: " + getPrezime()+"\n"+"Titula: "+getTitula()+"\n";
    }
    @Override
    public String predstavi()
    {
        return this.toString();
    }
    void ocijeniNastavnika(InformacijeOStudentu osoba, int x) throws NevalidnaOcjena
    {
        Ocjena o=osoba.ocijeni(x);
        ocjene.add(ocjene.size(),o);
    }
    void utisci()
    {
        System.out.println("Ocjene za "+this.getIme()+" "+ this.getPrezime());
        for(int i=0; i<ocjene.size(); i++)
            System.out.println(ocjene.get(i).toString());
    }
}
