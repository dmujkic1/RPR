package ba.unsa.etf.rpr;

public class Racun
{
    protected
    long brojRacuna;
    Osoba korisnikRacuna;
    boolean odobrenjePrekoracenja;
    double stanjeRacuna;
    private
    void provjeriOdobrenjePrekoracenja(double a)
    {
        if (a > stanjeRacuna && !odobrenjePrekoracenja) {
            throw new IllegalArgumentException("Nemate dozvoljen prekoračen račun.");
        }
    }
    public
    Racun(long broj, Osoba o) {
        brojRacuna = broj;
        korisnikRacuna = o;
    }
    boolean izvrsiUplatu(double uplata) {
        if(uplata<0) throw new IllegalArgumentException("Iznos uplate mora bit veci od nula");
        stanjeRacuna=stanjeRacuna+uplata;
        return true;
    }
    boolean izvrsiIsplatu(double isplata)
    {
        provjeriOdobrenjePrekoracenja(isplata);
        if(isplata<0) throw new IllegalArgumentException("Iznos isplate mora bit veci od nula");
        stanjeRacuna=stanjeRacuna-isplata;
        return true;
    }
    void odobriPrekoracenje()
    {
        odobrenjePrekoracenja=true;
    }
    @Override
    public String toString()
    {
        return "Broj racuna: "+brojRacuna+"\nKorisnik racuna: "+korisnikRacuna.toString()+
                "Ima li odobrenje: "+odobrenjePrekoracenja+"\nTrenutno stanje na racunu: "+stanjeRacuna;
    }
}