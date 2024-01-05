package uno.cartes;
import uno.jeu.Uno;


public class Chiffre extends Carte{
    private  int valeur;

    public Chiffre(Uno u, Couleur c, int v){
        super(u, c);
        valeur = v;
    }
    @Override
    public int getValeur(){
        return valeur;
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
        // rien
    }
    public String toString() {
        StringBuilder result = new StringBuilder();

        String couleurTexte = getCouleurString();

        result.append(couleurTexte)
                .append("Chiffre ")
                .append(valeur)
                .append(" ")
                .append(couleur)
                .append("\u001B[0m");

        return result.toString();
    }


}
