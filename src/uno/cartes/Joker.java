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
        if (couleur == null){
            return true;
        }else {
            return c.getCouleur() == couleur;
        }
    }
    @Override
    public boolean peutEtrePoseeSur(Chiffre c) {
        return estDeCouleurCompatibleAvec(c);
    }
    @Override
    public boolean peutEtrePoseeSur(Plus2 c) {
        return estDeCouleurCompatibleAvec(c);
    }
    @Override
    public boolean peutEtrePoseeSur(Plus4 c) {
        return estDeCouleurCompatibleAvec(c);
    }
    @Override
    public boolean peutEtrePoseeSur(Joker c) {
        return estDeCouleurCompatibleAvec(c);
    }
    @Override
    public boolean peutEtrePoseeSur(PasseTonTour c) {
        return estDeCouleurCompatibleAvec(c);
    }
    @Override
    public boolean peutEtrePoseeSur(ChangementDeSens c) {
        return estDeCouleurCompatibleAvec(c);
    }
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();


        String couleurTexte = getCouleurString();

        result.append(couleurTexte)
                .append("Joker");


        if (couleur != null){
            result.append(" ")
                    .append(couleur);
        }

        result.append("\u001B[0m");

        return result.toString();
    }


    @Override
    public void appliquerEffet() {
        if (u.getJoueurQuiJoue() == u.getNbJoueurs() - 1){
            // on demande au joueur la couleur qu'il veut
            this.couleur = Couleur.BLEU;

        }else {
            this.couleur = Couleur.VERT;
        }
    }
}
