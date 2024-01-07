package uno.cartes;
import uno.jeu.Uno;

public abstract class Carte {
    protected Uno u;
    protected Couleur couleur;
    public  Carte(Uno u){
        this.u = u;
    }
    public Carte(Uno u, Couleur c){
        this.u = u;
        this.couleur = c;
    }
    public void setUno(Uno u){
        this.u = u;
    }
    public abstract int getValeur();
    public abstract boolean peutEtreRecouvertePar(Carte c);
    public abstract Couleur getCouleur();
    public abstract void setCouleur(Couleur c);
    public abstract boolean estSansCouleur();
    public abstract boolean estDeCouleurCompatibleAvec(Carte c);
    // double dispatch
    public abstract boolean peutEtrePoseeSur(Chiffre c);
    public abstract boolean peutEtrePoseeSur(Plus2 c);
    public abstract boolean peutEtrePoseeSur(Plus4 c);
    public abstract boolean peutEtrePoseeSur(Joker c);
    public abstract boolean peutEtrePoseeSur(PasseTonTour c);
    public abstract boolean peutEtrePoseeSur(ChangementDeSens c);

    public abstract void appliquerEffet();

    public String getCouleurString(){
        if (couleur == null) {
            return "\u001B[37m";
        }else{
            return switch (couleur) {
                case ROUGE -> "\u001B[31m";
                case BLEU -> "\u001B[34m";
                case VERT -> "\u001B[32m";
                case JAUNE -> "\u001B[33m";
            };
        }
    }
    public abstract String toString();

}