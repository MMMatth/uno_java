package uno.cartes;

public class Chiffre extends Carte{
    private  int valeur;

    public Chiffre(Uno u, Couleur c, int v){
        super(u, c);
        valeur = v;
    }
    public int getValeur(){
        return valeur;
    }
    public boolean peutEtreRecouvertePar(Carte c){
        return c.peutEtrePoseeSur(this);
    }
    public Couleur getCouleur(){
        return couleur;
    }
    public void setCouleur(Couleur c){
        couleur = c;
    }
    public boolean estSansCouleur(){
        return false;
    }
    public boolean estDeCouleurCompatibleAvec(Carte c){
        return c.getCouleur() == couleur;
    }

    public boolean peutEtrePoseeSur(Chiffre c){
        return c.estDeCouleurCompatibleAvec(this);
    }
    public boolean peutEtrePoseeSur(Plus2 c){
        return c.estDeCouleurCompatibleAvec(this);
    }
    public boolean peutEtrePoseeSur(Plus4 c){
        return c.estDeCouleurCompatibleAvec(this);
    }
    public boolean peutEtrePoseeSur(Joker c){
        return c.estDeCouleurCompatibleAvec(this);
    }
    public boolean peutEtrePoseeSur(PasseTonTour c){
        return c.estDeCouleurCompatibleAvec(this);
    }
    public boolean peutEtrePoseeSur(ChangementDeSens c){
        return c.estDeCouleurCompatibleAvec(this);
    }
    public String toString(){
        return "Chiffre " +
                valeur +
                " " +
                couleur;
    }

}
