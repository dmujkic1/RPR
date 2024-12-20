package ba.unsa.etf.rpr;

public class Osoba
{
    private
    String ime;
    String prezime;
    public
    Osoba(String ime, String prezime)
    {
        this.ime=ime;
        this.prezime=prezime;
    }
    @Override
    public String toString()
    {
        return ime+" "+prezime+"\n";
    }
    String getIme(){return ime;}
    String getPrezime(){return prezime;}
    void setIme(String ime){this.ime=ime;}
    void setPrezime(String prezime){this.prezime=prezime;}
}