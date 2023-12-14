package uno.cartes;
import uno.jeu.Uno;


public class Plus4 extends Carte {
    public Plus4(Uno u) {
        super(u);
    }
    @Override
    public int getValeur() {
        return 50;
    }
    @Override
    public boolean peutEtreRecouvertePar(Carte c) {
        return c.peutEtrePoseeSur(this);
    }
    @Override
    public Couleur getCouleur() {
        return couleur;
    }
    @Override
    public void setCouleur(Couleur c) {
        couleur = c;
    }
    @Override
    public boolean estSansCouleur() {
        return true;
    }
    @Override
    public boolean estDeCouleurCompatibleAvec(Carte c) {
        return true;
    }
    @Override
    public boolean peutEtrePoseeSur(Chiffre c) {
        return true;
    }
    @Override
    public boolean peutEtrePoseeSur(Plus2 c) {
        return true;
    }
    @Override
    public boolean peutEtrePoseeSur(Plus4 c) {
        return true;
    }
    @Override
    public boolean peutEtrePoseeSur(Joker c) {
        return true;
    }
    @Override
    public boolean peutEtrePoseeSur(PasseTonTour c) {
        return true;
    }
    @Override
    public boolean peutEtrePoseeSur(ChangementDeSens c) {
        return true;
    }
    @Override
    public String toString() {
        return "Plus4";
    }

    @Override
    public void appliquerEffet() {
        u.donnerCarteAuJoueurSuivant(4);
    }
}
