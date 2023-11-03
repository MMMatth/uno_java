package uno.cartes.tests;

import uno.cartes.*;
import uno.jeu.Uno;

class Plus2Test {
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
        p.ajouter(new Plus2(u, Couleur.ROUGE));
        assert p.getValeur() == 20 : "getValeur() ne renvoie pas la bonne valeur";
    }

    private static void testPeutEtreRecouvertePar() {
        Carte c; Uno u;
        u = new Uno();
        c = new Plus2(u, Couleur.ROUGE);
        assert c.peutEtreRecouvertePar(new Chiffre(u, Couleur.ROUGE, 0));
        assert !c.peutEtreRecouvertePar(new Chiffre(u, Couleur.BLEU, 0));
        assert c.peutEtreRecouvertePar(new Plus4(u));
    }

    private static void testGetCouleur() {
        Carte c; Uno u;
        u = new Uno();
        c = new Plus2(u, Couleur.ROUGE);
        assert c.getCouleur() == Couleur.ROUGE : "getCouleur() ne renvoie pas la bonne valeur";
    }

    private static void testSetCouleur() {
        Carte c; Uno u;
        u = new Uno();
        c = new Plus2(u, Couleur.ROUGE);
        c.setCouleur(Couleur.BLEU);
        assert c.getCouleur() == Couleur.BLEU : "setCouleur() ne modifie pas la couleur";
    }

    private static void testEstSansCouleur() {
        Carte c; Uno u;
        u = new Uno();
        c = new Plus2(u, Couleur.ROUGE);
        assert !c.estSansCouleur() : "estSansCouleur() ne renvoie pas la bonne valeur";
    }

    private static void testEstDeCouleurCompatibleAvec() {
        Carte c; Uno u;
        u = new Uno();
        c = new Plus2(u, Couleur.ROUGE);
        assert c.estDeCouleurCompatibleAvec(new Chiffre(u, Couleur.ROUGE, 0));
        assert !c.estDeCouleurCompatibleAvec(new Chiffre(u, Couleur.BLEU, 0));
    }

    private static void testPeutEtrePoseeSur() {
        Carte c; Uno u;
        u = new Uno();
        c = new Plus2(u, Couleur.ROUGE);
        /* chiffre */
        assert c.peutEtrePoseeSur(new Chiffre(u, Couleur.ROUGE, 0));
        assert !c.peutEtrePoseeSur(new Chiffre(u, Couleur.BLEU, 0));
        /* plus2 */
        assert c.peutEtrePoseeSur(new Plus2(u, Couleur.ROUGE));
        assert !c.peutEtrePoseeSur(new Plus2(u, Couleur.BLEU));
        /* plus4 */
        assert c.peutEtrePoseeSur(new Plus4(u));
        /* joker */
        assert c.peutEtrePoseeSur(new Joker(u));
        /* passeTonTour */
        assert c.peutEtrePoseeSur(new PasseTonTour(u, Couleur.ROUGE));
        assert !c.peutEtrePoseeSur(new PasseTonTour(u, Couleur.BLEU));
        /* changementDeSens */
        assert c.peutEtrePoseeSur(new ChangementDeSens(u, Couleur.ROUGE));
        assert !c.peutEtrePoseeSur(new ChangementDeSens(u, Couleur.BLEU));
    }

    private static void testToString() {
        assert new Plus2(new Uno(), Couleur.ROUGE).toString().equals("Plus2 rouge") : "toString() ne renvoie pas la bonne valeur";
    }
}