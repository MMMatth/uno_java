package uno.cartes.tests;

import static org.junit.jupiter.api.Assertions.*;
import uno.cartes.*;
import uno.jeu.Uno;

class ChangementDeSensTest {

    private Uno uno;
    private Carte carte;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        uno = new Uno();
        carte = new ChangementDeSens(uno, Couleur.ROUGE);
    }

    @org.junit.jupiter.api.Test
    void getValeur() {
        assertEquals(20, carte.getValeur(), "getValeur() ne renvoie pas la bonne valeur");
    }

    @org.junit.jupiter.api.Test
    void peutEtreRecouvertePar() {
        assertTrue(carte.peutEtreRecouvertePar(new Chiffre(uno, Couleur.ROUGE, 0)), "peutEtreRecouvertePar() ne renvoie pas vrai pour une carte compatible");
        assertFalse(carte.peutEtreRecouvertePar(new Chiffre(uno, Couleur.BLEU, 0)), "peutEtreRecouvertePar() ne renvoie pas faux pour une carte incompatible");
    }

    @org.junit.jupiter.api.Test
    void getCouleur() {
        assertEquals(Couleur.ROUGE, carte.getCouleur(), "getCouleur() ne renvoie pas la bonne valeur");
    }

    @org.junit.jupiter.api.Test
    void setCouleur() {
        carte.setCouleur(Couleur.BLEU);
        assertEquals(Couleur.BLEU, carte.getCouleur(), "setCouleur() ne modifie pas la couleur");
    }

    @org.junit.jupiter.api.Test
    void estSansCouleur() {
        assertFalse(carte.estSansCouleur(), "estSansCouleur() ne renvoie pas faux");
    }

    @org.junit.jupiter.api.Test
    void estDeCouleurCompatibleAvec() {
        assertTrue(carte.estDeCouleurCompatibleAvec(new Chiffre(uno, Couleur.ROUGE, 0)), "estDeCouleurCompatibleAvec() ne renvoie pas vrai pour une carte compatible");
        assertFalse(carte.estDeCouleurCompatibleAvec(new Chiffre(uno, Couleur.BLEU, 0)), "estDeCouleurCompatibleAvec() ne renvoie pas faux pour une carte incompatible");
    }

    @org.junit.jupiter.api.Test
    void peutEtrePoseeSur() {
        assertTrue(carte.peutEtrePoseeSur(new Chiffre(uno, Couleur.ROUGE, 0)), "peutEtrePoseeSur(Chiffre) ne renvoie pas vrai pour une carte compatible");
        assertFalse(carte.peutEtrePoseeSur(new Chiffre(uno, Couleur.BLEU, 0)), "peutEtrePoseeSur(Chiffre) ne renvoie pas faux pour une carte incompatible");

        assertTrue(carte.peutEtrePoseeSur(new Plus2(uno, Couleur.ROUGE)), "peutEtrePoseeSur(Plus2) ne renvoie pas vrai pour une carte compatible");
        assertFalse(carte.peutEtrePoseeSur(new Plus2(uno, Couleur.BLEU)), "peutEtrePoseeSur(Plus2) ne renvoie pas faux pour une carte incompatible");

        assertTrue(carte.peutEtrePoseeSur(new Plus4(uno)), "peutEtrePoseeSur(Plus4) ne renvoie pas vrai pour une carte compatible");

        assertTrue(carte.peutEtrePoseeSur(new Joker(uno)), "peutEtrePoseeSur(Joker) ne renvoie pas vrai pour une carte compatible");

        assertTrue(carte.peutEtrePoseeSur(new PasseTonTour(uno, Couleur.ROUGE)), "peutEtrePoseeSur(PasseTonTour) ne renvoie pas vrai pour une carte compatible");
        assertFalse(carte.peutEtrePoseeSur(new PasseTonTour(uno, Couleur.BLEU)), "peutEtrePoseeSur(PasseTonTour) ne renvoie pas faux pour une carte incompatible");

        assertTrue(carte.peutEtrePoseeSur(new ChangementDeSens(uno, Couleur.ROUGE)), "peutEtrePoseeSur(ChangementDeSens) ne renvoie pas vrai pour une carte compatible");
        assertTrue(carte.peutEtrePoseeSur(new ChangementDeSens(uno, Couleur.BLEU)), "peutEtrePoseeSur(ChangementDeSens) ne renvoie pas faux pour une carte incompatible");
    }
}

