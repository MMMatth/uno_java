package uno.joueur;

import uno.cartes.PaquetDeCartes;
import uno.jeu.Uno;

public class Joueur {
    private String nom;
    private int id;
    private PaquetDeCartes main;
    private Uno uno;

    public Joueur(Uno uno, String nom, int id) {
        this.nom = nom;
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public int getId() {
        return id;
    }
}
