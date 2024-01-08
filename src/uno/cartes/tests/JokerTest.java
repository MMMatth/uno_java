package uno.cartes.tests;

import uno.cartes.*;
import uno.jeu.Uno;
import static org.junit.jupiter.api.Assertions.*;

class JokerTest {

    private Uno uno;
    private Carte joker;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        uno = new Uno();
        joker = new Joker(uno);
    }

    @org.junit.jupiter.api.Test
    void testGetValeur() {
        PaquetDeCartes paquet = new PaquetDeCartes();
        paquet.ajouter(joker);
        assert paquet.getValeur() == 50 : "getValeur() ne renvoie pas la bonne valeur";
    }

    @org.junit.jupiter.api.Test
    void testPeutEtreRecouvertePar() {
        Carte carte = new Chiffre(uno, Couleur.ROUGE, 0);
        assert joker.peutEtreRecouvertePar(carte) : "peutEtreRecouvertePar() ne renvoie pas vrai pour une carte compatible";
        assert joker.peutEtreRecouvertePar(new Plus4(uno)) : "peutEtreRecouvertePar() ne renvoie pas vrai pour une carte compatible";
    }

    @org.junit.jupiter.api.Test
    void testGetCouleur() {
        assert joker.getCouleur() == null : "getCouleur() ne renvoie pas la bonne valeur";
    }

    @org.junit.jupiter.api.Test
    void testSetCouleur() {
        joker.setCouleur(Couleur.BLEU);
        assert joker.getCouleur() == Couleur.BLEU : "setCouleur() ne modifie pas la couleur";
    }

    @org.junit.jupiter.api.Test
    void testEstSansCouleur() {
        assert joker.estSansCouleur() : "estSansCouleur() ne renvoie pas la bonne valeur";
    }

    @org.junit.jupiter.api.Test
    void testEstDeCouleurCompatibleAvec() {
        assert joker.estDeCouleurCompatibleAvec(new Chiffre(uno, Couleur.ROUGE, 0)) : "estDeCouleurCompatibleAvec() ne renvoie pas vrai pour une carte compatible";
        assert joker.estDeCouleurCompatibleAvec(new Chiffre(uno, Couleur.BLEU, 0)) : "estDeCouleurCompatibleAvec() ne renvoie pas vrai pour une carte compatible";
    }

    @org.junit.jupiter.api.Test
    void testPeutEtrePoseeSur() {
        assertTrue(joker.peutEtrePoseeSur(new Chiffre(uno, Couleur.ROUGE, 0)), "peutEtrePoseeSur(Chiffre) ne renvoie pas vrai pour une carte compatible");
        assertTrue(joker.peutEtrePoseeSur(new Chiffre(uno, Couleur.BLEU, 0)), "peutEtrePoseeSur(Chiffre) ne renvoie pas vrai pour une carte compatible");

        assertTrue(joker.peutEtrePoseeSur(new Plus2(uno, Couleur.ROUGE)), "peutEtrePoseeSur(Plus2) ne renvoie pas vrai pour une carte compatible");
        assertTrue(joker.peutEtrePoseeSur(new Plus2(uno, Couleur.BLEU)), "peutEtrePoseeSur(Plus2) ne renvoie pas vrai pour une carte compatible");

        assertTrue(joker.peutEtrePoseeSur(new Plus4(uno)), "peutEtrePoseeSur(Plus4) ne renvoie pas vrai pour une carte compatible");

        assertTrue(joker.peutEtrePoseeSur(new Joker(uno)), "peutEtrePoseeSur(Joker) ne renvoie pas vrai pour une carte compatible");

        assertTrue(joker.peutEtrePoseeSur(new PasseTonTour(uno, Couleur.ROUGE)), "peutEtrePoseeSur(PasseTonTour) ne renvoie pas vrai pour une carte compatible");
        assertTrue(joker.peutEtrePoseeSur(new PasseTonTour(uno, Couleur.BLEU)), "peutEtrePoseeSur(PasseTonTour) ne renvoie pas vrai pour une carte compatible");

        assertTrue(joker.peutEtrePoseeSur(new ChangementDeSens(uno, Couleur.ROUGE)), "peutEtrePoseeSur(ChangementDeSens) ne renvoie pas vrai pour une carte compatible");
        assertTrue(joker.peutEtrePoseeSur(new ChangementDeSens(uno, Couleur.BLEU)), "peutEtrePoseeSur(ChangementDeSens) ne renvoie pas vrai pour une carte compatible");
    }
}
