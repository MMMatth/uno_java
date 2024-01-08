package uno.cartes.tests;

import static org.junit.jupiter.api.Assertions.*;

import uno.cartes.*;
import uno.jeu.Uno;

class ChiffreTest {

    private Uno uno;
    private Carte chiffre;

    @org.junit.jupiter.api.BeforeEach

    void setUp() {
        uno = new Uno();
        chiffre = new Chiffre(uno, Couleur.ROUGE, 0);
    }

    @org.junit.jupiter.api.Test
    void testGetValeur() {
        assertEquals(0, chiffre.getValeur(), "getValeur() ne renvoie pas la bonne valeur");
    }

    @org.junit.jupiter.api.Test
    void testPeutEtreRecouvertePar() {
        assertTrue(chiffre.peutEtreRecouvertePar(new Chiffre(uno, Couleur.ROUGE, 1)), "peutEtreRecouvertePar() ne renvoie pas vrai pour une carte compatible");
        assertTrue(chiffre.peutEtreRecouvertePar(new Chiffre(uno, Couleur.BLEU, 0)), "peutEtreRecouvertePar() ne renvoie pas faux pour une carte incompatible");
        assertFalse(chiffre.peutEtreRecouvertePar(new Chiffre(uno, Couleur.BLEU, 9)), "peutEtreRecouvertePar() ne renvoie pas faux pour une carte incompatible");
    }

    @org.junit.jupiter.api.Test
    void testGetCouleur() {
        assertEquals(Couleur.ROUGE, chiffre.getCouleur(), "getCouleur() ne renvoie pas la bonne valeur");
    }

    @org.junit.jupiter.api.Test
    void testSetCouleur() {
        chiffre.setCouleur(Couleur.BLEU);
        assertEquals(Couleur.BLEU, chiffre.getCouleur(), "setCouleur() ne modifie pas la couleur");
    }

    @org.junit.jupiter.api.Test
    void testEstSansCouleur() {
        assertFalse(chiffre.estSansCouleur(), "estSansCouleur() ne renvoie pas faux");
    }

    @org.junit.jupiter.api.Test
    void testEstDeCouleurCompatibleAvec() {
        assertTrue(chiffre.estDeCouleurCompatibleAvec(new Chiffre(uno, Couleur.ROUGE, 1)), "estDeCouleurCompatibleAvec() ne renvoie pas vrai pour une carte compatible");
        assertFalse(chiffre.estDeCouleurCompatibleAvec(new Chiffre(uno, Couleur.BLEU, 0)), "estDeCouleurCompatibleAvec() ne renvoie pas faux pour une carte incompatible");
    }

    @org.junit.jupiter.api.Test
    void testPeutEtrePoseeSur() {
        assertTrue(chiffre.peutEtrePoseeSur(new Chiffre(uno, Couleur.ROUGE, 1)), "peutEtrePoseeSur(Chiffre) ne renvoie pas vrai pour une carte compatible");
        assertTrue(chiffre.peutEtrePoseeSur(new Chiffre(uno, Couleur.BLEU, 0)), "peutEtrePoseeSur(Chiffre) ne renvoie pas faux pour une carte incompatible");

        assertTrue(chiffre.peutEtrePoseeSur(new Plus2(uno, Couleur.ROUGE)), "peutEtrePoseeSur(Plus2) ne renvoie pas vrai pour une carte compatible");
        assertFalse(chiffre.peutEtrePoseeSur(new Plus2(uno, Couleur.BLEU)), "peutEtrePoseeSur(Plus2) ne renvoie pas faux pour une carte incompatible");

        assertTrue(chiffre.peutEtrePoseeSur(new Plus4(uno)), "peutEtrePoseeSur(Plus4) ne renvoie pas vrai pour une carte compatible");

        assertTrue(chiffre.peutEtrePoseeSur(new Joker(uno)), "peutEtrePoseeSur(Joker) ne renvoie pas vrai pour une carte compatible");

        assertTrue(chiffre.peutEtrePoseeSur(new PasseTonTour(uno, Couleur.ROUGE)), "peutEtrePoseeSur(PasseTonTour) ne renvoie pas vrai pour une carte compatible");
        assertFalse(chiffre.peutEtrePoseeSur(new PasseTonTour(uno, Couleur.BLEU)), "peutEtrePoseeSur(PasseTonTour) ne renvoie pas faux pour une carte incompatible");

        assertTrue(chiffre.peutEtrePoseeSur(new ChangementDeSens(uno, Couleur.ROUGE)), "peutEtrePoseeSur(ChangementDeSens) ne renvoie pas vrai pour une carte compatible");
        assertFalse(chiffre.peutEtrePoseeSur(new ChangementDeSens(uno, Couleur.BLEU)), "peutEtrePoseeSur(ChangementDeSens) ne renvoie pas faux pour une carte incompatible");
    }

}
