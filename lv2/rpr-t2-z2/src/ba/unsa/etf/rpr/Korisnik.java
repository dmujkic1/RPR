package ba.unsa.etf.rpr;

class Korisnik extends Osoba
{
    protected
    Racun racun;
    public
    Korisnik(String ime, String prezime)
    {
        super(ime,prezime);
    }
    public void dodajRacun(Racun racun)
    {
        this.racun=racun;
    }
    Racun getRacun(){return racun;}
}