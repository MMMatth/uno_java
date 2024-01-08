package uno.joueur;

import uno.cartes.Carte;
import uno.cartes.PaquetDeCartes;
import uno.jeu.Uno;

import java.util.Iterator;

/**
 * @brief Classe qui définit la stratégie difficile ( le bot joue la carte qui a le plus gros score
 * pour avoir le moins de points possible )
 */
public class StrategieDifficile implements Strategie {

    /**
     * @brief Fonction qui permet au bot de jouer son coup
     * @details le bot joue la carte qui a le plus gros score pour avoir le moins de points possible
     * @param main la main du bot
     * @param uno le jeu de uno
     * @throws Exception si le talon est vide ou si la pioche est vide
     */
    @Override
    public void jouer(PaquetDeCartes main, Uno uno) throws Exception {
        Iterator<Carte> it = main.iterator(); // Utilisez iterator() pour obtenir un itérateur sur la liste
        Carte sommetTalon = uno.getTalon().getSommet(); // Utilisez getSommet() pour obtenir le sommet de la pile
        int score = 0;
        Carte carteAjouer = null;
        if (sommetTalon != null) { // Utilisez != pour vérifier si le sommet est null
            while (it.hasNext()) { // tant qu'il y a des cartes dans la main
                Carte carte = it.next(); // Utilisez next() pour obtenir l'élément suivant de la liste
                carte.setUno(uno);
                if (sommetTalon.peutEtreRecouvertePar(carte) && carte.getValeur() > score) {
                    carteAjouer = carte;
                    score = carte.getValeur();
                }
            }
            if (carteAjouer != null) {
                carteAjouer.appliquerEffet(); // on applique l'effet de la carte
                uno.addToTalon(carteAjouer); // on ajoute la carte au talon
                main.enlever(carteAjouer); // on enleve la carte de la main
            }else {
                if (uno.getPioche().getNombreDeCartes() == 0) { // on verifie si la pioche est vide
                    throw new Exception("La pioche est vide");
                }
                main.ajouter(uno.getPioche().piocher()); // on pioche une carte
            }
        } else {
            throw new Exception("Le talon est vide");
        }
    }
}
