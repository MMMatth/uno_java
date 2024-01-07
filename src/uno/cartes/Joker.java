package uno.cartes;
import uno.jeu.Uno;
import java.util.Random;
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
        return couleur == null;
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
        if (couleur == null){
            Random random = new Random();
            int choix = random.nextInt(4);
            switch (choix){
                case 0:
                    couleur = Couleur.BLEU;
                    break;
                case 1:
                    couleur = Couleur.ROUGE;
                    break;
                case 2:
                    couleur = Couleur.VERT;
                    break;
                case 3:
                    couleur = Couleur.JAUNE;
                    break;
            }
        }
    }
}
