package uno.joueur;

import uno.cartes.PaquetDeCartes;
import uno.jeu.Uno;

public interface Strategie {

    void jouer(PaquetDeCartes main, Uno uno) throws Exception;
}
