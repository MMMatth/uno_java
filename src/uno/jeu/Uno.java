package uno.jeu;

import uno.cartes.PaquetDeCartes;
import uno.joueur.Joueur;

import java.util.ArrayList;

public class Uno {
    private int joueurQuiDistribue;
    private int joueurQuiJoue;
    private boolean sensHoraire;
    private int difficulte;
    private PaquetDeCartes pioche;
    private PaquetDeCartes talon;
    private ArrayList<Joueur> joueurs;
    public Uno() {
    }
}
