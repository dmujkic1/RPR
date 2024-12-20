package org.example;
import java.util.*;

public class Imenik{
    private
    HashMap <String,TelefonskiBroj>  mapa_imenik=new HashMap<>();
    public
    static String kojigrad(Grad g)
    {
        int broj1=g.ordinal();
        switch(broj1) {
            case 0:
                return "070";
            case 1:
                return "071";
            case 2:
                return "072";
            case 3:
                return "073";
            case 4:
                return "074";
            case 5:
                return "075";
            case 6:
                return "076";
            case 7:
                return "077";
            case 8:
                return "078";
            case 9:
                return "079";
            case 10:
                return "080";
            case 11:
                return "088";
            case 12:
                return "089";
        }
        return "";
    }
    void dodaj(String ime, TelefonskiBroj broj)
    {
        if(mapa_imenik.containsKey(ime)) return;
        mapa_imenik.put(ime,broj);
    }
    String dajBroj(String ime)
    {
        if(!mapa_imenik.containsKey(ime)) return "";
        return mapa_imenik.get(ime).ispisi();
    }
    String dajIme(TelefonskiBroj broj)
    {
        String ime="";
        Set<String> kljucevi=mapa_imenik.keySet();
        for(String kljuc: kljucevi)
        {
            if(mapa_imenik.get(kljuc)==broj)
                ime=kljuc;
        }
        return ime;
    }
    String naSlovo(char s) throws MojIzuzetak
    {
        String imena="";
        Set<String> kljucevi=mapa_imenik.keySet();
        for(String kljuc: kljucevi)
        {
            if(kljuc.startsWith(String.valueOf(s)))
            {
                imena=imena+kljuc+" - "+mapa_imenik.get(kljuc).ispisi()+"\n";
            }
        }
        if(imena.equals("")) throw new MojIzuzetak("Nema niko cije ime pocinje na to slovo");
        return imena;
    }
    Set<String> izGrada(Grad g)
    {
        //u skupu ime prezime svih osoba koje zive u gradu g
        Set<String> kljucevi=mapa_imenik.keySet();
        Set<String> skup=new TreeSet<>(); //treeset da bi bilo sortirano abecedno
        String gg=kojigrad(g);
        for(String kljuc: kljucevi)
        {
            if(mapa_imenik.get(kljuc) instanceof FiksniBroj) //instanceof provjera jel ta klasa
            {
                String br=mapa_imenik.get(kljuc).ispisi();
                br=br.substring(0,3);
                if(br.equals(gg))
                {
                    skup.add(kljuc);
                }
            }
        }
        return skup;
    }
    Set<TelefonskiBroj> izGradaBrojevi(Grad g)
    {
        //brojevi za osobe iz grada g
        String gg=kojigrad(g);
        Set<String> kljucevi=mapa_imenik.keySet();
        Set<TelefonskiBroj> brojevi=new HashSet<>();
        for(String kljuc: kljucevi)
        {
            if(mapa_imenik.get(kljuc) instanceof FiksniBroj)
            {
                String br=mapa_imenik.get(kljuc).ispisi();
                br=br.substring(0,3);
                if(br.equals(gg))
                {
                    brojevi.add(mapa_imenik.get(kljuc));
                }
            }
        }
        return brojevi;
    }
}