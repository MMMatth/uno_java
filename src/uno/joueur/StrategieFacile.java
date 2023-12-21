package uno.joueur;
import uno.cartes.PaquetDeCartes;
import uno.jeu.Uno;
import uno.cartes.Carte;
import uno.joueur.Strategie;
public class StrategieFacile implements Strategie {
    @Override
    public void jouer(PaquetDeCartes main, Uno uno) throws Exception{
        Carte sommetTalon = uno.getTalon().getSommet();
        if (sommetTalon != null) {
            while (main.hasNext()) { // on parcourt la main du bot
                Carte carte = main.getSommet();
                if (sommetTalon.peutEtreRecouvertePar(carte)) {
                    System.out.println("Le bot a joué ");
                    uno.addToTalon(carte);
                    main.enlever(carte);
                } else {
                    main.next();
                }
            }
            System.out.println("Le bot a pioché une carte");
            main.ajouter(uno.getPioche().piocher());
        }
        uno.choisirJoueurQuiJoue();
    }
}
