package org.example;

public class MedunarodniBroj extends TelefonskiBroj{
    private
    String drzava;
    String broj;
    public
    MedunarodniBroj(String drzava,String broj)
    {
        this.drzava=drzava;
        this.broj=broj;
    }
    @Override
    public String ispisi()
    {
        return drzava+"/"+broj;
    }
    @Override
    public int hashCode()
    {
        int suma=0;
        for(int i=0; i<drzava.length(); i++)
        {
            suma=suma+drzava.charAt(i);
        }
        for(int i=0; i<broj.length(); i++)
        {
            suma=suma+broj.charAt(i);
        }
        return suma;
    }
}