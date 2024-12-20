package org.example;
public class Ocjena {
    private
    LicneInformacije osoba;
    int ocjena;
    public
    void setOcjena (int ocjena) throws NevalidnaOcjena
    {
        if(ocjena<=0 || ocjena>10 ) throw new NevalidnaOcjena("Nevalidna vam ocjena");
        this.ocjena=ocjena;
    }
    Ocjena(LicneInformacije osoba, int ocjena) throws NevalidnaOcjena
    {
        this.osoba=osoba;
        if(ocjena<=0 || ocjena>10) throw new NevalidnaOcjena("Nevalidna ocjena");
        this.ocjena=ocjena;
    }
    LicneInformacije getOsoba(){return osoba;}
    @Override
    public String toString()
    {
        return "Osoba: "+osoba.getIme()+" "+osoba.getPrezime()+" je dala ocjenu: "+ocjena;
    }
}
