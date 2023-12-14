package uno.cartes.tests;

import static org.junit.jupiter.api.Assertions.*;
import uno.cartes.*;
import uno.jeu.Uno;
import java.util.Iterator;

class PaquetDeCartesTest {

    private PaquetDeCartes paquet;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        paquet = new PaquetDeCartes();
    }

    @org.junit.jupiter.api.Test
    void testGetNombreDeCartes() {
        assert paquet.getNombreDeCartes() == 0 : "getNombreDeCartes() ne renvoie pas le bon nombre de cartes";
    }

    @org.junit.jupiter.api.Test
    void testAjouter() {
        paquet.ajouter(new Chiffre(new Uno(), Couleur.ROUGE, 0));
        assert paquet.getNombreDeCartes() == 1 : "ajouter() n'ajoute pas une carte au paquet";
    }

    @org.junit.jupiter.api.Test
    void testEstVide() {
        assert paquet.estVide() : "estVide() ne renvoie pas vrai pour un paquet vide";
        paquet.ajouter(new Chiffre(new Uno(), Couleur.ROUGE, 0));
        assert !paquet.estVide() : "estVide() ne renvoie pas faux pour un paquet non vide";
    }

    @org.junit.jupiter.api.Test
    void testGetValeur() {
        paquet.ajouter(new Chiffre(new Uno(), Couleur.ROUGE, 0));
        assert paquet.getValeur() == 0 : "getValeur() ne renvoie pas la bonne valeur de la carte";
    }

    @org.junit.jupiter.api.Test
    void testIterator() {
        paquet.ajouter(new Chiffre(new Uno(), Couleur.ROUGE, 0));
        paquet.ajouter(new Chiffre(new Uno(), Couleur.BLEU, 1));
        paquet.ajouter(new Chiffre(new Uno(), Couleur.VERT, 2));
        paquet.ajouter(new Chiffre(new Uno(), Couleur.JAUNE, 3));

        while (paquet.hasNext()) {
            System.out.println(paquet.next());
        }
    }

    @org.junit.jupiter.api.Test
    void testEcrire() {
        paquet.ajouter(new Chiffre(new Uno(), Couleur.ROUGE, 0));
        paquet.ajouter(new Chiffre(new Uno(), Couleur.BLEU, 1));
        paquet.ajouter(new Chiffre(new Uno(), Couleur.VERT, 2));
        paquet.ajouter(new Chiffre(new Uno(), Couleur.JAUNE, 3));

        paquet.ajouter(new PasseTonTour(new Uno(), Couleur.ROUGE));
        paquet.ajouter(new PasseTonTour(new Uno(), Couleur.BLEU));
        paquet.ajouter(new PasseTonTour(new Uno(), Couleur.VERT));
        paquet.ajouter(new PasseTonTour(new Uno(), Couleur.JAUNE));

        paquet.ajouter(new ChangementDeSens(new Uno(), Couleur.ROUGE));
        paquet.ajouter(new ChangementDeSens(new Uno(), Couleur.BLEU));
        paquet.ajouter(new ChangementDeSens(new Uno(), Couleur.VERT));
        paquet.ajouter(new ChangementDeSens(new Uno(), Couleur.JAUNE));

        paquet.ajouter(new Plus2(new Uno(), Couleur.ROUGE));
        paquet.ajouter(new Plus2(new Uno(), Couleur.BLEU));
        paquet.ajouter(new Plus2(new Uno(), Couleur.VERT));
        paquet.ajouter(new Plus2(new Uno(), Couleur.JAUNE));

        paquet.ajouter(new Joker(new Uno()));
        paquet.ajouter(new Joker(new Uno()));
        paquet.ajouter(new Joker(new Uno()));
        paquet.ajouter(new Joker(new Uno()));

        paquet.ajouter(new Plus4(new Uno()));
        paquet.ajouter(new Plus4(new Uno()));
        paquet.ajouter(new Plus4(new Uno()));
        paquet.ajouter(new Plus4(new Uno()));

        try {
            paquet.ecrire("test.txt");
        } catch (ErreurFichier e) {
            System.out.println(e.getMessage());
        }
    }

    @org.junit.jupiter.api.Test
    void testLire() {
        try {
            paquet.lire("test.txt");
            System.out.println(paquet.toString());
        } catch (ErreurFichier e) {
            System.out.println(e.getMessage());
        }
    }
}
