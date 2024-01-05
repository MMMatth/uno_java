package uno.joueur;
import uno.cartes.PaquetDeCartes;
import uno.jeu.Uno;
import uno.cartes.Carte;
import uno.joueur.Strategie;
public class StrategieFacile implements Strategie {
    @Override
    public void jouer(PaquetDeCartes main, Uno uno) throws Exception{
        Carte sommetTalon = uno.getTalon().getSommet();
        boolean aJoue = false;
        if (sommetTalon != null) {
            while (main.hasNext()) { // on parcourt la main du bot
                Carte carte = main.getSommet();
                if (sommetTalon.peutEtreRecouvertePar(carte) && !aJoue) {
                    System.out.println("Le bot a joué la carte " + carte + " sur le talon ");
                    uno.addToTalon(carte);
                    main.enlever(carte);
                    aJoue = true;
                } else {
                    main.next();
                }
            }
            if (!aJoue){
                System.out.println("Le bot a pioché une carte");
                main.ajouter(uno.getPioche().piocher());
            }
        }
    }
}
