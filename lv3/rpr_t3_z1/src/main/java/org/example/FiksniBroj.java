package org.example;

public class FiksniBroj extends TelefonskiBroj{
    private
    String broj;
    Grad grad;
    public
    FiksniBroj(Grad grad, String broj)
    {
        this.broj=broj;
        this.grad=grad;
    }
    @Override
    public String ispisi() {
        int broj1=grad.ordinal();
        switch(broj1)
        {
            case 0:
                return "070/"+broj;
            case 1:
                return "071/"+broj;
            case 2:
                return "072/"+broj;
            case 3:
                return "073/"+broj;
            case 4:
                return "074/"+broj;
            case 5:
                return "075/"+broj;
            case 6:
                return "076/"+broj;
            case 7:
                return "077/"+broj;
            case 8:
                return "078/"+broj;
            case 9:
                return "079/"+broj;
            case 10:
                return "080/"+broj;
            case 11:
                return "088/"+broj;
            case 12:
                return "089/"+broj;
        }
        return " ";
    }
    @Override
    public int hashCode(){
        int suma=0;
        int b=grad.ordinal();
        for(int i=0; i<broj.length(); i++)
        {
            suma=suma+broj.charAt(i);
        }
        suma=suma+b;
        return b;
    }
}