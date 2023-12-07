import uno.jeu.Uno;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Combien de bots ?");
        int nbrBots = sc.nextInt();
        Uno uno = new Uno();
        uno.initialiser(nbrBots);
    }
}