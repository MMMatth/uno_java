package uno.joueur;

import uno.cartes.Carte;
import uno.cartes.PaquetDeCartes;
import uno.jeu.Uno;

public class StrategieDifficile implements Strategie {
    @Override
    public void jouer(PaquetDeCartes main, Uno uno) throws Exception{
        Carte sommetTalon = uno.getTalon().getSommet();
        if (sommetTalon != null) {
            while (main.hasNext()) { // on parcourt la main du bot
                System.out.println("Le bot a joué ");
                Carte carte = main.getSommet();
                if (sommetTalon.peutEtreRecouvertePar(carte)) {
                    uno.addToTalon(carte);
                    main.enlever(carte);
                } else {
                    main.next();
                }
            }
        }else{
            System.out.println("Le bot a pioché une carte");
            main.ajouter(uno.getPioche().piocher());
        }
        uno.choisirJoueurQuiJoue();
    }
}
