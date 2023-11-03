package uno.cartes.tests;

import uno.cartes.*;
import uno.jeu.Uno;

class ChiffreTest {
    public static void main(String[] args) {
        testGetValeur();
        testPeutEtreRecouvertePar();
        testGetCouleur();
        testSetCouleur();
        testEstSansCouleur();
        testEstDeCouleurCompatibleAvec();
        testPeutEtrePoseeSur();
        testToString();
    }

    private static void testGetValeur() {
        PaquetDeCartes p; Uno u;
        u = new Uno();
        p = new PaquetDeCartes();
        p.ajouter(new Chiffre(u, Couleur.ROUGE, 0));
        assert p.getValeur() == 0 : "getValeur() ne renvoie pas la bonne valeur";
    }

    private static void testPeutEtreRecouvertePar() {
        Carte c; Uno u;
        u = new Uno();
        c = new Chiffre(u, Couleur.ROUGE, 0);
        assert c.peutEtreRecouvertePar(new Chiffre(u, Couleur.ROUGE, 0));
        assert !c.peutEtreRecouvertePar(new Chiffre(u, Couleur.BLEU, 0));
        assert c.peutEtreRecouvertePar(new Plus4(u));
    }

    private static void testGetCouleur() {
        Carte c; Uno u;
        u = new Uno();
        c = new Chiffre(u, Couleur.ROUGE, 0);
        assert c.getCouleur() == Couleur.ROUGE : "getCouleur() ne renvoie pas la bonne valeur";
    }

    private static void testSetCouleur() {
        Carte c; Uno u;
        u = new Uno();
        c = new Chiffre(u, Couleur.ROUGE, 0);
        c.setCouleur(Couleur.BLEU);
        assert c.getCouleur() == Couleur.BLEU : "setCouleur() ne modifie pas la couleur";
    }

    private static void testEstSansCouleur() {
        Carte c; Uno u;
        u = new Uno();
        c = new Chiffre(u, Couleur.ROUGE, 0);
        assert !c.estSansCouleur() : "estSansCouleur() ne renvoie pas la bonne valeur";
    }

    private static void testEstDeCouleurCompatibleAvec() {
        Carte c; Uno u;
        u = new Uno();
        c = new Chiffre(u, Couleur.ROUGE, 0);
        assert c.estDeCouleurCompatibleAvec(new Chiffre(u, Couleur.ROUGE, 0));
        assert !c.estDeCouleurCompatibleAvec(new Chiffre(u, Couleur.BLEU, 0));
    }

    private static void testPeutEtrePoseeSur(){
        Carte c; Uno u;
        u = new Uno();
        c = new Chiffre(u, Couleur.ROUGE, 0);
        /* Chiffre */
        assert c.peutEtrePoseeSur(new Chiffre(u, Couleur.ROUGE, 0));
        assert !c.peutEtrePoseeSur(new Chiffre(u, Couleur.BLEU, 0));
        /* Plus4 */
        assert c.peutEtrePoseeSur(new Plus4(u));
        /* Plus2 */
        assert c.peutEtrePoseeSur(new Plus2(u, Couleur.ROUGE));
        assert !c.peutEtrePoseeSur(new Plus2(u, Couleur.BLEU));
        /* PasseTonTour */
        assert c.peutEtrePoseeSur(new PasseTonTour(u, Couleur.ROUGE));
        assert !c.peutEtrePoseeSur(new PasseTonTour(u, Couleur.BLEU));
        /* Joker */
        assert c.peutEtrePoseeSur(new Joker(u));
        /* Changement de sens */
        assert c.peutEtrePoseeSur(new ChangementDeSens(u, Couleur.ROUGE));
        assert !c.peutEtrePoseeSur(new ChangementDeSens(u, Couleur.BLEU));
    }
    private static void testToString() {
        Carte c; Uno u;
        u = new Uno();
        c = new Chiffre(u, Couleur.ROUGE, 0);
        assert c.toString().equals("Chiffre 0 rouge") : "toString() ne renvoie pas la bonne valeur";
    }
}