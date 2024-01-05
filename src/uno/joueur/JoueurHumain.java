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
        switch (parts[0]) {
            case "c":
                couleur = choisirCouleur(parts[2]);
                System.out.println(couleur);
                if (couleur == null || Integer.parseInt(parts[1]) < 0 || Integer.parseInt(parts[1]) > 9) {
                    throw (new CoupIncorrect("Couleur incorrecte1"));
                }
                return new Chiffre(this.uno, couleur, Integer.parseInt(parts[1]));
            case "p4":
                return new Plus4(this.uno);
            case "p2":
                couleur = choisirCouleur(parts[1]);
                if (couleur == null) {
                    throw (new CoupIncorrect("Couleur incorrecte2"));
                }
                return new Plus2(this.uno, couleur);
            case "ptt":
                couleur = choisirCouleur(parts[1]);
                if (couleur == null) {
                    throw (new CoupIncorrect("Couleur incorrecte3"));
                }
                return new PasseTonTour(this.uno, couleur);
            case "cds":
                couleur = choisirCouleur(parts[1]);
                if (couleur == null) {
                    throw (new CoupIncorrect("Couleur incorrecte4"));
                }
                return new ChangementDeSens(this.uno, couleur);
            case "j":
                return new Joker(this.uno);
            default:
                throw (new CoupIncorrect("Carte incorrecte5"));
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
                            this.uno.addToTalon(carteVoulue);
                            this.main.enlever(carteVoulue);
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
        if (!rejouer) {
            this.uno.choisirJoueurQuiJoue();
        }else {
            this.uno.joueurRejoue();
        }
    }
}
