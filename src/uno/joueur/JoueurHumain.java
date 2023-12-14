package uno.joueur;

import uno.jeu.Uno;
import uno.cartes.*;
import uno.cartes.PaquetDeCartes;

public class JoueurHumain extends Joueur{
    public JoueurHumain(Uno uno, String nom, int id) {
        super(uno, nom, id);
    }

    public Couleur choisirCouleur(String couleur){
        return switch (couleur) {
            case "r" -> Couleur.ROUGE;
            case "b" -> Couleur.BLEU;
            case "c" -> Couleur.VERT;
            case "j" -> Couleur.JAUNE;
            default -> null;
        };
    }

    /** Renvoie la carte choisie par le joueur pour jouer son coup.
     * @param coup le coup joué par le joueur sur la forme c.1.r p4 p2.r
     * @return la carte choisie par le joueur pour jouer son coup
     */
    public Carte carteChoisie(String coup) throws CoupIncorrect {
        String[] parts = coup.split("\\.");
        Couleur couleur;
        switch (parts[0]) {
            case "c":
                couleur = choisirCouleur(parts[2]);
                if (couleur == null || Integer.parseInt(parts[1]) < 0 || Integer.parseInt(parts[1]) > 9) {
                    throw (new CoupIncorrect("Couleur incorrecte"));
                }
                return new Chiffre(this.uno, couleur, Integer.parseInt(parts[1]));
            case "p4":
                return new Plus4(this.uno);
            case "p2":
                couleur = choisirCouleur(parts[1]);
                if (couleur == null) {
                    throw (new CoupIncorrect("Couleur incorrecte"));
                }
                return new Plus2(this.uno, couleur);
            case "ptt":
                couleur = choisirCouleur(parts[1]);
                if (couleur == null) {
                    throw (new CoupIncorrect("Couleur incorrecte"));
                }
                return new PasseTonTour(this.uno, couleur);
            case "cds":
                couleur = choisirCouleur(parts[1]);
                if (couleur == null) {
                    throw (new CoupIncorrect("Couleur incorrecte"));
                }
                return new ChangementDeSens(this.uno, couleur);
            case "j":
                return new Joker(this.uno);
            default:
                throw (new CoupIncorrect("Carte incorrecte"));
        }
    }
    public void jouer(String coup) {
        if (coup.equals("p")) {
            this.piocher();
        } else {
            try {
                Carte carteVoulue = carteChoisie(coup);
                if (this.main.contient(carteVoulue)){
                    this.uno.addToTalon(carteVoulue);
                    this.main.enlever(carteVoulue);
                }
                else {
                    throw (new CoupIncorrect("Carte non présente dans la main"));
                }
            } catch (CoupIncorrect e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
