package org.example;
import java.util.*;
public class KolekcijaPoruka {
    private ArrayList<String> poruke=new ArrayList<String>();
    public
    ArrayList<String> getPoruke(){return poruke;}
    KolekcijaPoruka(ArrayList<Predstavi> informacije)
    {
        for(int i=0; i<informacije.size(); i++)
        {
            String poruka=informacije.get(i).predstavi();
            poruke.add(i,poruka);
        }
    }
}
