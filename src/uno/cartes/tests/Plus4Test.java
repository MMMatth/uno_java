package uno.cartes.tests;

import uno.cartes.*;
import uno.jeu.Uno;
import static org.junit.jupiter.api.Assertions.*;

class Plus4Test {

    private Uno uno;
    private PaquetDeCartes paquet;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        uno = new Uno();
        paquet = new PaquetDeCartes();
    }

    @org.junit.jupiter.api.Test
    void testGetValeur() {
        paquet.ajouter(new Plus4(uno));
        assertEquals(50, paquet.getValeur(), "getValeur() ne renvoie pas la bonne valeur");
    }

    @org.junit.jupiter.api.Test
    void testPeutEtreRecouvertePar() {
        Carte c = new Plus4(uno);
        assertTrue(c.peutEtreRecouvertePar(new Chiffre(uno, Couleur.ROUGE, 0)));
        assertTrue(c.peutEtreRecouvertePar(new Chiffre(uno, Couleur.BLEU, 0)));
        assertTrue(c.peutEtreRecouvertePar(new Plus4(uno)));
    }

    @org.junit.jupiter.api.Test
    void testGetCouleur() {
        Carte c = new Plus4(uno);
        assertNull(c.getCouleur(), "getCouleur() ne renvoie pas la bonne valeur");
    }

    @org.junit.jupiter.api.Test
    void testSetCouleur() {
        Carte c = new Plus4(uno);
        c.setCouleur(Couleur.BLEU);
        assert c.getCouleur() == Couleur.BLEU : "setCouleur() ne modifie pas la couleur";
    }

    @org.junit.jupiter.api.Test
    void testEstSansCouleur() {
        Carte c = new Plus4(uno);
        assertTrue(c.estSansCouleur(), "estSansCouleur() ne renvoie pas la bonne valeur");
    }

    @org.junit.jupiter.api.Test
    void testEstDeCouleurCompatibleAvec() {
        Carte c = new Plus4(uno);
        assertTrue(c.estDeCouleurCompatibleAvec(new Chiffre(uno, Couleur.ROUGE, 0)));
        assertTrue(c.estDeCouleurCompatibleAvec(new Chiffre(uno, Couleur.BLEU, 0)));
    }

    @org.junit.jupiter.api.Test
    void testPeutEtrePoseeSur() {
        Carte c = new Plus4(uno);
        /* chiffre */
        assertTrue(c.peutEtrePoseeSur(new Chiffre(uno, Couleur.ROUGE, 0)));
        assertTrue(c.peutEtrePoseeSur(new Chiffre(uno, Couleur.BLEU, 0)));
        /* plus2 */
        assertTrue(c.peutEtrePoseeSur(new Plus2(uno, Couleur.ROUGE)));
        assertTrue(c.peutEtrePoseeSur(new Plus2(uno, Couleur.BLEU)));
        /* plus4 */
        assertTrue(c.peutEtrePoseeSur(new Plus4(uno)));
        /* joker */
        assertTrue(c.peutEtrePoseeSur(new Joker(uno)));
        /* passeTonTour */
        assertTrue(c.peutEtrePoseeSur(new PasseTonTour(uno, Couleur.ROUGE)));
        assertTrue(c.peutEtrePoseeSur(new PasseTonTour(uno, Couleur.BLEU)));
        /* changementDeSens */
        assertTrue(c.peutEtrePoseeSur(new ChangementDeSens(uno, Couleur.ROUGE)));
        assertTrue(c.peutEtrePoseeSur(new ChangementDeSens(uno, Couleur.BLEU)));
    }

}
