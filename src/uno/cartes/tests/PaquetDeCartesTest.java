package uno.cartes.tests;

import uno.cartes.*;
import uno.jeu.Uno;

import java.util.Iterator;

class PaquetDeCartesTest {

    public static void main(String[] args) {
        getNombreDeCartes();
        ajouter();
        estVide();
        getValeur();
        ecrire();
        lire();
        testIterator();
    }

    private static void getNombreDeCartes() {
        PaquetDeCartes p = new PaquetDeCartes();
        assert p.getNombreDeCartes() == 0 : "getNombreDeCartes() ne renvoie pas le bon nombre de cartes";
    }

    private static void ajouter() {
        PaquetDeCartes p = new PaquetDeCartes();
        p.ajouter(new Chiffre(new Uno(), Couleur.ROUGE, 0));
        assert p.getNombreDeCartes() == 1 : "ajouter() n'ajoute pas une carte au paquet";
    }

    private static void estVide() {
        PaquetDeCartes p = new PaquetDeCartes();
        assert p.estVide() : "estVide() ne renvoie pas vrai pour un paquet vide";
        p.ajouter(new Chiffre(new Uno(), Couleur.ROUGE, 0));
        assert !p.estVide() : "estVide() ne renvoie pas faux pour un paquet non vide";
    }

    private static void getValeur() {
        PaquetDeCartes p = new PaquetDeCartes();
        p.ajouter(new Chiffre(new Uno(), Couleur.ROUGE, 0));
        assert p.getValeur() == 0 : "getValeur() ne renvoie pas la bonne valeur de la carte";
    }

    private static void testIterator() {
        PaquetDeCartes p = new PaquetDeCartes();
        p.ajouter(new Chiffre(new Uno(), Couleur.ROUGE, 0));
        p.ajouter(new Chiffre(new Uno(), Couleur.BLEU, 1));
        p.ajouter(new Chiffre(new Uno(), Couleur.VERT, 2));
        p.ajouter(new Chiffre(new Uno(), Couleur.JAUNE, 3));
        while (p.hasNext()) {
            System.out.println(p.next());
        }
    }

    private static void ecrire() {
        PaquetDeCartes p = new PaquetDeCartes();
        p.ajouter(new Chiffre(new Uno(), Couleur.ROUGE, 0));
        p.ajouter(new Chiffre(new Uno(), Couleur.BLEU, 1));
        p.ajouter(new Chiffre(new Uno(), Couleur.VERT, 2));
        p.ajouter(new Chiffre(new Uno(), Couleur.JAUNE, 3));

        p.ajouter(new PasseTonTour(new Uno(), Couleur.ROUGE));
        p.ajouter(new PasseTonTour(new Uno(), Couleur.BLEU));
        p.ajouter(new PasseTonTour(new Uno(), Couleur.VERT));
        p.ajouter(new PasseTonTour(new Uno(), Couleur.JAUNE));

        p.ajouter(new ChangementDeSens(new Uno(), Couleur.ROUGE));
        p.ajouter(new ChangementDeSens(new Uno(), Couleur.BLEU));
        p.ajouter(new ChangementDeSens(new Uno(), Couleur.VERT));
        p.ajouter(new ChangementDeSens(new Uno(), Couleur.JAUNE));

        p.ajouter(new Plus2(new Uno(), Couleur.ROUGE));
        p.ajouter(new Plus2(new Uno(), Couleur.BLEU));
        p.ajouter(new Plus2(new Uno(), Couleur.VERT));
        p.ajouter(new Plus2(new Uno(), Couleur.JAUNE));

        p.ajouter(new Joker(new Uno()));
        p.ajouter(new Joker(new Uno()));
        p.ajouter(new Joker(new Uno()));
        p.ajouter(new Joker(new Uno()));

        p.ajouter(new Plus4(new Uno()));
        p.ajouter(new Plus4(new Uno()));
        p.ajouter(new Plus4(new Uno()));
        p.ajouter(new Plus4(new Uno()));
        try {
            p.ecrire("test.txt");
        } catch (ErreurFichier e) {
            System.out.println(e.getMessage());
        }
    }

    private static void lire() {
        PaquetDeCartes p = new PaquetDeCartes();
        try {
            p.lire("test.txt");
        } catch (ErreurFichier e) {
            System.out.println(e.getMessage());
        }
        assert p.getNombreDeCartes() == 24 : "lire() ne lit pas le bon nombre de cartes";
    }
}