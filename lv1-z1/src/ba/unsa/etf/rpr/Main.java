package ba.unsa.etf.rpr;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner unos = new Scanner(System.in);
        int a,b;
        System.out.print("Unesite dva broja: ");
        a=unos.nextInt();
        b=unos.nextInt();
        System.out.println("Prvi broj je: "+a);
        System.out.println("Drugi broj je: "+b);
    }
}
