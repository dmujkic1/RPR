package org.example;

public class MobilniBroj extends TelefonskiBroj{
    private
    int mobilnaMreza;
    String broj;
    public
    MobilniBroj(int mobilnaMreza, String broj)
    {
        this.mobilnaMreza=mobilnaMreza;
        this.broj=broj;
    }
    @Override
    public String ispisi()
    {
        return "0"+mobilnaMreza+"/"+broj;
    }
    @Override
    public int hashCode()
    {
        int suma=mobilnaMreza;
        for(int i=0; i<broj.length(); i++)
            suma=suma+broj.charAt(i);
        return suma;
    }
}