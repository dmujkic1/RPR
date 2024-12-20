package org.example;
import java.util.*;
abstract public class LicneInformacije implements Predstavi, MozeOcijeniti{
    protected String ime, prezime;

    public
    LicneInformacije(){
        ime=null;
        prezime=null;
    }
    LicneInformacije(String a,String b){
        ime=a;
        prezime=b;
    }
    abstract String getIme();
    abstract String getPrezime();
    abstract void setIme(String a);
    abstract void setPrezime(String b);
    @Override
    public abstract String toString();
    @Override
    public abstract String predstavi();
    @Override
    public Ocjena ocijeni(int x) throws NevalidnaOcjena{
        if(x<=0 || x>10) throw new NevalidnaOcjena("Nevalidna ocjena");
        Ocjena o=new Ocjena(this,x);
        return o;
    }
}
