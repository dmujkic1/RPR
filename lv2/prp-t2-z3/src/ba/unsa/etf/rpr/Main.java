package ba.unsa.etf.rpr;
import java.util.*;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> lista=new LinkedList<>();
        Scanner ulaz=new Scanner(System.in);
        String unos=null;
        System.out.println("Unesite brojeve: ");
        while(true)
        {
            unos=ulaz.nextLine(); if(unos.equals("stop")) System.exit(0);
            boolean ponoviunos=false; boolean negativan=false;
            if (unos.startsWith("-")) {
                unos = unos.substring(1);
                negativan=true;
            }
            for(int i=0; i<unos.length(); i++)
            {
                if(!(unos.charAt(i)>='0' && unos.charAt(i)<='9'))
                {
                    ponoviunos=true;
                    break;
                }
            }
            if(ponoviunos) continue;
            double provjera=Double.parseDouble(unos);
            int p=(int)provjera;
            if(negativan) p=-p;
            lista.add(p);
            int min=lista.get(0);
            int max=lista.get(0);
            double mean=0;
            for(int i=0; i<lista.size(); i++)
            {
                if(lista.get(i)<min)
                    min=lista.get(i);
                if(lista.get(i)>max)
                    max=lista.get(i);
                mean+=lista.get(i);
            }
            mean=mean/lista.size();
            double dev=0;
            for(int i=0; i<lista.size(); i++)
            {
                double a=lista.get(i)-mean;
                dev+=a*a;
            }
            dev=dev/(lista.size()-1);
            dev=Math.sqrt(dev);
            System.out.println("Min el: "+min+" Max el: "+max+" Mean: "+mean+" St. dev: "+dev);
        }
    }
}