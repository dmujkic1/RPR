package org.example;
import java.util.*;

class Main {

    public static void main(String[] args) {
        FiksniBroj f=new FiksniBroj(Grad.SARAJEVO,"626-388");
        System.out.println(f.ispisi());
        MobilniBroj m=new MobilniBroj(62,"096-640");
        System.out.println(m.ispisi());
        MedunarodniBroj mb=new MedunarodniBroj("+387","62-096-640");
        System.out.println(mb.ispisi());
        System.out.println(mb.hashCode());
        Imenik imenik=new Imenik();
        try
        {
            System.out.println(imenik.naSlovo('D'));
        }catch(MojIzuzetak e)
        {
            System.out.println("Greska: "+e.getDodatnaPoruka());
        }
        imenik.dodaj("Daris Mujkic",f);
        imenik.dodaj("Faris Mujkic",m);
        Set<String> skup=imenik.izGrada(Grad.SARAJEVO);
        for(String el: skup)
            System.out.println(el);
        Set<TelefonskiBroj> skup2=imenik.izGradaBrojevi(Grad.SARAJEVO);
        for(TelefonskiBroj el: skup2)
            System.out.println(el.ispisi());
    }
}