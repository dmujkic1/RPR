package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Banka
{
    private
    long brojRacuna;
    protected
    List<Korisnik> korisnici=new ArrayList<>();
    List<Uposlenik> uposlenici=new ArrayList<>();
    public
    Banka(){}
    Korisnik kreirajNovogKorisnika(String ime, String prezime)
    {
        Korisnik korisnik=new Korisnik(ime,prezime);
        korisnici.add(korisnik);
        kreirajRacunZaKorisnika(korisnik);
        return korisnik;
    }
    Uposlenik kreirajNovogUposlenika(String ime, String prezime)
    {
        Uposlenik uposlenik=new Uposlenik(ime,prezime);
        uposlenici.add(uposlenik);
        return uposlenik;
    }
    Racun kreirajRacunZaKorisnika(Korisnik korisnik)
    {
        Random random=new Random();
        long broj=1000000000L + random.nextLong();
        if(broj<0) broj*=-1;
        Racun racun=new Racun(broj,korisnik);
        korisnik.dodajRacun(racun);
        return racun;
    }
    Korisnik getKorisnikaizBanke(int indeks)
    {
        if(indeks<0 || indeks>korisnici.size())
            throw new IllegalArgumentException("Indeks van opsega");
        return korisnici.get(indeks);
    }
    Uposlenik getUposlenikaizBanke(int indeks)
    {
        if(indeks<0 || indeks>korisnici.size())
            throw new IllegalArgumentException("Indeks van opsega");
        return uposlenici.get(indeks);
    }
}