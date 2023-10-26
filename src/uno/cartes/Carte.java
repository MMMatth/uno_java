package uno.cartes;

public class Carte {

    private int valeur ;

    private Couleur couleur ;

    public Carte(Uno u) {

    }

    public Carte(Uno u, Couleur c){}

    public int getValeur() {return valeur;}

    public boolean peutEtreRecouvertePar(Carte c) {return false;}
    public Couleur getCouleur() {
        return couleur;
    }
    public void setCouleur(Couleur c) {
        assert c != null : "La couleur ne doit pas être nulle." ;
        this.couleur = c;
    }

    boolean estSansCouleur() {
        return false;
    }

    boolean estDeCouleurCompatibleAvec(Carte c) {
        return false;
    }

    // methode peut etre posee sur
    boolean peutEtrePoseeSur(Chiffre c){
        return false;
    }
    boolean peutEtrePoseeSur(Plus2 c){
        return false;
    }
    boolean peutEtrePoseeSur(Plus4 c){
        return false;
    }
    boolean peutEtrePoseeSur(Joker c){
        return false;
    }
    boolean peutEtrePoseeSur(PasseTonTour c){
        return false;
    }
    boolean peutEtrePoseeSur(ChangementDeSens c){
        return false;
    }





    public String toString() {
        return "Carte{" +
                "valeur=" + valeur +
                ", couleur=" + couleur +
                '}';
    }

}