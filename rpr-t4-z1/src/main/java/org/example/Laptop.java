package org.example;

public class Laptop {
    private
    String brend,model;
    double cijena;
    int ram,hdd,ssd;
    String procesor,grafickaKartica;
    double velicinaEkrana;
    public
    Laptop(){
        brend=null; model=null; cijena=0.; ram=0; hdd=0; ssd=0;
        procesor=null; grafickaKartica=null; velicinaEkrana=0.;
    };
    Laptop(String brend, String model, double cijena, int ram, int hdd ,int ssd, String procesor,
           String grafickaKartica, double velicinaEkrana ){
        this.brend=brend;
        this.model=model;
        this.cijena=cijena;
        this.ram=ram;
        this.hdd=hdd;
        this.ssd=ssd;
        this.procesor=procesor;
        this.grafickaKartica=grafickaKartica;
        this.velicinaEkrana=velicinaEkrana;
    }
    String getBrend(){return brend;}
    String getModel(){return model;}
    double getCijena(){return cijena;}
    int getRam(){return ram;}
    int getHdd(){return hdd;}
    int getSsd(){return ssd;}
    String getProcesor(){return procesor;}
    String getGrafickaKartica(){return grafickaKartica;}
    double getVelicinaEkrana(){return velicinaEkrana;}
    void setBrend(String brend)
    {
        this.brend=brend;
    }
    void setModel(String model)
    {
        this.model=model;
    }
    void setCijena(double cijena)
    {
        this.cijena=cijena;
    }
    void setRam(int ram)
    {
        this.ram=ram;
    }
    void setHdd(int hdd)
    {
        this.hdd=hdd;
    }
    void setSsd(int ssd)
    {
        this.ssd=ssd;
    }
    void setProcesor(String procesor)
    {
        this.procesor=procesor;
    }
    void setGrafickaKartica(String graficka)
    {
        this.grafickaKartica=graficka;
    }
    void setVelicinaEkrana(double velicina )
    {
        this.velicinaEkrana=velicina;
    }
}