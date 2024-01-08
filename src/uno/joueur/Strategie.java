package uno.joueur;

import uno.cartes.PaquetDeCartes;
import uno.jeu.Uno;

/**
 * @brief Interface définissant une stratégie de jeu
 */
public interface Strategie {
    /**
     * @brief Fonction qui permet au bot de jouer son coup
     */
    void jouer(PaquetDeCartes main, Uno uno) throws Exception;
}
