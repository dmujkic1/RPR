package org.example;

public class Main {
    public static void main(String[] args) {
        Laptop laptop1=new Laptop("EliteBook","HP",319.99,8,0,256,"Intel core I5",null,15.0);
        try
        {
            LaptopDao dao1 = null;
            dao1.dodajLaptopUFile(laptop1);
            dao1.getLaptop("Intel");
        }catch(NeodgovarajuciProcesorException izuzetak)
        {
            System.out.println(izuzetak.getPoruka());
        }
        return;
    }
}