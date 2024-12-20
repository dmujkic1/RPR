package ba.unsa.etf.rpr;
//import java.util.Scanner;


public class Sat {
    private int sati;
    private int minute;
    private int sekunde;

    public Sat(int h, int m, int s) {this.Postavi(h,m,s);} //konstruktor
    public void Postavi(int h, int m, int s)
    {
        this.sati=h;
        this.minute=m;
        this.sekunde=s;
    }
    public void Sljedeci()
    {
        sekunde++;
        if (sekunde==60) {sekunde=0; minute++;}
        if (minute==60) {minute=0; sati++;}
        if (sati==24) {sati=0;}
    }
    public void Prethodni()
    {
        sekunde--;
        if (sekunde==-1) { sekunde=59; minute--; }
        if (minute==-1) { minute=59; sati--; }
        if (sati==-1) sati=23;
    }
    public void PomjeriZa(int brojSekundi)
    {
        if (brojSekundi>0)
            for (int i=0; i<brojSekundi; i++) Sljedeci();
        else for (int i=0; i<-brojSekundi; i++) Prethodni();
    }
    public int DajSate() {return sati;}
    public int DajMinute() {return this.minute;}
    public int DajSekunde() {return sekunde;}

    public String toString()
    {
        //return new StringBuilder().append(this.sati).append(":").append(this.minute).append...
        return this.sati+":"+this.minute+":"+this.sekunde;
    }


    public static void main(String[] args) {
        // write your code here
        Sat c = new Sat(15,30,45);
        System.out.println(c);
        c.Sljedeci();
        System.out.println(c);
        c.PomjeriZa(-48);
        System.out.println(c);
        c.Postavi(0,0,0);
        System.out.println(c);
    }
}
