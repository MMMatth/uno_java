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
                Carte carte = main.next();
                carte.setUno(uno); // on lui donne le uno pour qu'elle puisse appliquer son effet
                if (sommetTalon.peutEtreRecouvertePar(carte) && !aJoue) {
                    System.out.println("Le bot a joué " + carte);
                    carte.appliquerEffet();
                    uno.addToTalon(carte);
                    main.enlever(carte);
                    aJoue = true;
                }
            }
            if (!aJoue){
                main.ajouter(uno.getPioche().piocher());
            }
        }else{
            throw (new Exception("Le talon est vide"));
        }
    }
}
