package uno.joueur;

import uno.cartes.PaquetDeCartes;
import uno.jeu.Uno;
import uno.cartes.*;

public abstract class Joueur {
    protected String nom;
    protected int id;
    protected PaquetDeCartes main;
    protected Uno uno;

    public Joueur(Uno uno, String nom, int id) {
        this.nom = nom;
        this.id = id;
        this.uno = uno;
        this.main = new PaquetDeCartes();
    }
    public abstract void jouer(String coup);
    public String getNom() {
        return nom;
    }

    public int getId() {
        return id;
    }

    public void piocher() {
        this.main.ajouter(this.uno.getPioche().piocher());
    }

    public int getNombreDeCartes() {
        return this.main.getNombreDeCartes();
    }

    public int getScore(){
        return this.main.getValeur();
    }

    public PaquetDeCartes getMain() {
        return main;
    }

    public void addCarte(Carte c){
        this.main.ajouter(c);
    }
}
