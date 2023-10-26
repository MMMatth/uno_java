package uno.cartes;

public class Plus4 extends Carte {
    public Plus4(Uno u) {
        super(u);
    }
    public int getValeur() {
        return 0;
    }
    public boolean peutEtreRecouvertePar(Carte c) {
        return c.peutEtrePoseeSur(this);
    }
    public Couleur getCouleur() {
        return null;
    }
    public void setCouleur(Couleur c) {}
    public boolean estSansCouleur() {
        return true;
    }
    public boolean estDeCouleurCompatibleAvec(Carte c) {
        return true;
    }
    public boolean peutEtrePoseeSur(Chiffre c) {
        return true;
    }
    public boolean peutEtrePoseeSur(Plus2 c) {
        return true;
    }
    public boolean peutEtrePoseeSur(Plus4 c) {
        return true;
    }
    public boolean peutEtrePoseeSur(Joker c) {
        return true;
    }
    public boolean peutEtrePoseeSur(PasseTonTour c) {
        return true;
    }
    public boolean peutEtrePoseeSur(ChangementDeSens c) {
        return true;
    }
    public String toString() {
        return "Plus4";
    }
}
