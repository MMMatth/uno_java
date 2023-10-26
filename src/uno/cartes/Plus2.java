package uno.cartes;

public class Plus2 extends Carte{
    @Override
    public int getValeur() {
        return 0;
    }

    public Plus2(Uno u, Couleur c){
        super(u, c);
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
        return "Plus2 " +
                couleur;
    }
}
