package uno.joueur;

import uno.cartes.Carte;
import uno.cartes.PaquetDeCartes;
import uno.jeu.Uno;
import java.util.Iterator;

/**
 * @brief Classe définissant une stratégie de jeu facile ( dès que le bot peut jouer, il joue )
 */
public class StrategieFacile implements Strategie {
    /**
     * @brief Fonction qui permet au bot de jouer son coup
     * @param main la main du bot
     * @param uno le jeu de uno
     * @throws Exception si le talon est vide ou si la pioche est vide
     */
    @Override
    public void jouer(PaquetDeCartes main, Uno uno) throws Exception {
        Iterator<Carte> it = main.iterator(); // Utilisez iterator() pour obtenir un itérateur sur la liste
        Carte sommetTalon = uno.getTalon().getSommet(); // Utilisez getSommet() pour obtenir le sommet de la pile
        boolean aJoue = false; // Utilisez aJoue pour savoir si le joueur a joué ou non
        if (sommetTalon != null) { // Utilisez != pour vérifier si le sommet est null
            while (it.hasNext()) { // tant qu'il y a des cartes dans la main
                Carte carte = it.next(); // Utilisez next() pour obtenir l'élément suivant de la liste
                carte.setUno(uno);
                if (sommetTalon.peutEtreRecouvertePar(carte) && !aJoue) {
                    carte.appliquerEffet(); // on applique l'effet de la carte
                    uno.addToTalon(carte); // on ajoute la carte au talon
                    it.remove(); // Utilisez remove() pour enlever l'élément de la liste pendant l'itération
                    aJoue = true;
                }
            }

            if (!aJoue) { // Si le joueur n'a pas joué
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
