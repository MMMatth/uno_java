package uno.cartes;
import uno.jeu.Uno;


public class PasseTonTour extends Carte{
    public PasseTonTour(Uno u, Couleur c){
        super(u, c);
    }
    @Override
    public int getValeur(){
        return 20;
    }
    @Override
    public boolean peutEtreRecouvertePar(Carte c){
        return c.peutEtrePoseeSur(this);
    }
    @Override
    public Couleur getCouleur(){
        return couleur;
    }
    @Override
    public void setCouleur(Couleur c){
        couleur = c;
    }
    @Override
    public boolean estSansCouleur(){
        return false;
    }
    @Override
    public boolean estDeCouleurCompatibleAvec(Carte c){
        return c.getCouleur() == couleur;
    }
    @Override
    public boolean peutEtrePoseeSur(Chiffre c){
        return c.estDeCouleurCompatibleAvec(this);
    }
    @Override
    public boolean peutEtrePoseeSur(Plus2 c){
        return c.estDeCouleurCompatibleAvec(this);
    }
    @Override
    public boolean peutEtrePoseeSur(Plus4 c){
        return c.estDeCouleurCompatibleAvec(this);
    }
    @Override
    public boolean peutEtrePoseeSur(Joker c){
        return c.estDeCouleurCompatibleAvec(this);
    }
    @Override
    public boolean peutEtrePoseeSur(PasseTonTour c){
        return c.estDeCouleurCompatibleAvec(this);
    }
    @Override
    public boolean peutEtrePoseeSur(ChangementDeSens c){
        return c.estDeCouleurCompatibleAvec(this);
    }

    @Override
    public void appliquerEffet() {
        u.changeDeJoueur();
    }
    public String toString(){
        return "PasseTonTour " +
                couleur;
    }
}
