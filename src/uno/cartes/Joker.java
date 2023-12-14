package uno.cartes;
import uno.jeu.Uno;

public class Joker extends Carte {
    public  Joker(Uno u) {
        super(u);
        this.couleur = null;
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
        this.couleur = c;
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
        return "Joker";
    }

    @Override
    public void appliquerEffet() {
        // rien
    }
}
