import uno.jeu.DialogueLigneDeCommande;
import uno.jeu.Uno;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Uno uno = new Uno();
        DialogueLigneDeCommande dlc = new DialogueLigneDeCommande(uno);
        uno.setDialogue(dlc);


    }
}