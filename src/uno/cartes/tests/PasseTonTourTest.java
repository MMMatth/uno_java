package uno.cartes.tests;

import uno.cartes.*;
import uno.jeu.Uno;

import static org.junit.jupiter.api.Assertions.*;

class PasseTonTourTest {

    private Uno uno;
    private PaquetDeCartes paquet;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        uno = new Uno();
        paquet = new PaquetDeCartes();
    }

    @org.junit.jupiter.api.Test
    void testGetValeur() {
        paquet.ajouter(new PasseTonTour(uno, Couleur.ROUGE));
        assertEquals(20, paquet.getValeur(), "getValeur() ne renvoie pas la bonne valeur");
    }

    @org.junit.jupiter.api.Test
    void testPeutEtreRecouvertePar() {
        Carte c = new PasseTonTour(uno, Couleur.ROUGE);
        assertTrue(c.peutEtreRecouvertePar(new Chiffre(uno, Couleur.ROUGE, 0)));
        assertFalse(c.peutEtreRecouvertePar(new Chiffre(uno, Couleur.BLEU, 0)));
        assertTrue(c.peutEtreRecouvertePar(new Plus4(uno)));
    }

    @org.junit.jupiter.api.Test
    void testGetCouleur() {
        Carte c = new PasseTonTour(uno, Couleur.ROUGE);
        assertEquals(Couleur.ROUGE, c.getCouleur(), "getCouleur() ne renvoie pas la bonne valeur");
    }

    @org.junit.jupiter.api.Test
    void testSetCouleur() {
        Carte c = new PasseTonTour(uno, Couleur.ROUGE);
        c.setCouleur(Couleur.BLEU);
        assertEquals(Couleur.BLEU, c.getCouleur(), "setCouleur() ne modifie pas la couleur");
    }

    @org.junit.jupiter.api.Test
    void testEstSansCouleur() {
        Carte c = new PasseTonTour(uno, Couleur.ROUGE);
        assertFalse(c.estSansCouleur(), "estSansCouleur() ne renvoie pas la bonne valeur");
    }

    @org.junit.jupiter.api.Test
    void testEstDeCouleurCompatibleAvec() {
        Carte c = new PasseTonTour(uno, Couleur.ROUGE);
        assertTrue(c.estDeCouleurCompatibleAvec(new Chiffre(uno, Couleur.ROUGE, 0)));
        assertFalse(c.estDeCouleurCompatibleAvec(new Chiffre(uno, Couleur.BLEU, 0)));
    }

    @org.junit.jupiter.api.Test
    void testPeutEtrePoseeSur() {
        Carte c = new PasseTonTour(uno, Couleur.ROUGE);
        assertTrue(c.peutEtrePoseeSur(new Chiffre(uno, Couleur.ROUGE, 0)));
        assertFalse(c.peutEtrePoseeSur(new Chiffre(uno, Couleur.BLEU, 0)));
        assertTrue(c.peutEtrePoseeSur(new Plus2(uno, Couleur.ROUGE)));
        assertFalse(c.peutEtrePoseeSur(new Plus2(uno, Couleur.BLEU)));
        assertTrue(c.peutEtrePoseeSur(new Plus4(uno)));
        assertTrue(c.peutEtrePoseeSur(new Joker(uno)));
        assertTrue(c.peutEtrePoseeSur(new PasseTonTour(uno, Couleur.ROUGE)));
        assertFalse(c.peutEtrePoseeSur(new PasseTonTour(uno, Couleur.BLEU)));
        assertTrue(c.peutEtrePoseeSur(new ChangementDeSens(uno, Couleur.ROUGE)));
        assertFalse(c.peutEtrePoseeSur(new ChangementDeSens(uno, Couleur.BLEU)));
    }

    @org.junit.jupiter.api.Test
    void testToString() {
        assertEquals("PasseTonTour rouge", new PasseTonTour(uno, Couleur.ROUGE).toString(), "toString() ne renvoie pas la bonne valeur");
    }
}
