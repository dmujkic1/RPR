package ba.unsa.etf.rpr;
import java.util.Scanner;

/*Napravite program
koji na ekranu ispisuje sve brojeve između 1 i n koji su djeljivi sa sumom svojih cifara,
pri čemu se n unosi sa tastature. U programu se obavezno treba nalaziti funkcija
sumaCifara. Po završetku zadatak treba postaviti na GitHub koristeći isključivo
funkcionalnosti IntelliJ IDEA okruženja!
Nakon toga, potrebno je da uradite konverziju tog projekta u Maven projekat i da
pokrenete iz Command Prompt-a.
*/
public class Main {

    private static int sumaCifara(int broj)
    {
        int sumacif=0;
        int cifra;
        while (broj!=0)
        {
            cifra=broj%10;
            sumacif+=cifra;
            broj/=10;
        }
        return sumacif;
    }

    public static void main(String[] args) {
	// write your code here
        System.out.print("Unesite n: ");
        Scanner unos = new Scanner(System.in);
        int n=unos.nextInt();
        for (int i=1; i<n; i++)
        {
            if (i%sumaCifara(i)==0) System.out.println(i);
        }

    }
}
