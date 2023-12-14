package uno.joueur;

import uno.cartes.Carte;
import uno.jeu.Uno;

public class Bot extends Joueur{
    public Bot(Uno uno, String nom, int id, int difficulte) {
        super(uno, nom, id);
    }

    public void jouer(String coup) {
        Carte sommetTalon = this.uno.getTalon().getSommet();
        if (sommetTalon != null) {
            while (this.main.hasNext()) { // on parcourt la main du bot
                Carte carte = this.main.getSommet();
                if (sommetTalon.peutEtreRecouvertePar(carte)) {
                    System.out.println("Le bot " + this.nom + " a joué " + this.main.next().toString());
                    this.uno.addToTalon(carte);
                    this.main.enlever(carte);
                } else {
                    this.main.next();
                }
            }
        }else{
            System.out.println("Le bot " + this.nom + " a pioché une carte");
            this.main.ajouter(this.uno.getPioche().piocher());
        }
    }
}
