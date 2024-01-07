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
            case "v" -> Couleur.VERT;
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
        Carte carte;
        switch (parts[0]) {
            case "c":
                couleur = choisirCouleur(parts[2]);
                if (couleur == null || Integer.parseInt(parts[1]) < 0 || Integer.parseInt(parts[1]) > 9) {
                    throw (new CoupIncorrect("Couleur incorrecte pour le chiffre"));
                }
                return new Chiffre(this.uno, couleur, Integer.parseInt(parts[1]));
            case "p4":
                couleur = choisirCouleur(parts[1]);
                if (couleur == null) {
                    throw (new CoupIncorrect("Couleur incorrecte pour le plus 4"));
                }
                carte = new Plus4(this.uno);
                carte.setCouleur(couleur);
                return carte;
            case "p2":
                couleur = choisirCouleur(parts[1] );
                if (couleur == null) {
                    throw (new CoupIncorrect("Couleur incorrecte pour le plus 2"));
                }
                return new Plus2(this.uno, couleur);
            case "ptt":
                couleur = choisirCouleur(parts[1]);
                if (couleur == null) {
                    throw (new CoupIncorrect("Couleur incorrecte pour le passe ton tour"));
                }
                return new PasseTonTour(this.uno, couleur);
            case "cds":
                couleur = choisirCouleur(parts[1]);
                if (couleur == null) {
                    throw (new CoupIncorrect("Couleur incorrecte pour le changement de sens"));
                }
                return new ChangementDeSens(this.uno, couleur);
            case "j":
                couleur = choisirCouleur(parts[1]);
                if (couleur == null) {
                    throw (new CoupIncorrect("Couleur incorrecte pour le joker"));
                }
                carte = new Joker(this.uno);
                carte.setCouleur(couleur);
                return carte;
            default:
                throw (new CoupIncorrect("Carte incorrecte pour le coup joué"));
        }
    }
    public void jouer(String coup) {
        boolean rejouer = false;
        if (coup.equals("p")) {
            this.piocher();
        } else {
            try {
                try {
                    Carte carteVoulue = carteChoisie(coup);
                    Carte sommetTalon = this.uno.getTalon().getSommet();
                    if (this.main.contient(carteVoulue) ) {
                        if (sommetTalon.peutEtreRecouvertePar(carteVoulue)) {
                            carteVoulue.appliquerEffet();
                            this.uno.addToTalon(carteVoulue);
                            main.enlever(carteVoulue);
                        }else {
                            throw (new CoupIncorrect("Carte non jouable sur le talon"));
                        }
                    }
                    else {
                        throw (new CoupIncorrect("Carte non présente dans la main"));
                    }
                }
                catch (CoupIncorrect e){
                    throw (new CoupIncorrect("Carte incorrecte"));
                }
            } catch (CoupIncorrect e) {
                rejouer = true;
                System.out.println(e.getMessage());
            }
        }
        if (rejouer) {
            this.uno.joueurRejoue();
        }
    }
}
