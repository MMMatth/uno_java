package uno.joueur;

import uno.cartes.PaquetDeCartes;
import uno.jeu.Uno;
import uno.cartes.*;

/**
 *   Classe abstraite représentant un joueur
 * @author Matthieu GAUDEL
 */
public abstract class Joueur {
    protected String nom;  /** Nom du joueur */
    protected int id;  /** Id du joueur */
    protected PaquetDeCartes main;  /** Main du joueur */
    protected Uno uno;  /** Référence vers le jeu de Uno */

    /**
     *   Constructeur de la classe Joueur
     * @param uno Référence vers le jeu de Uno
     * @param nom Nom du joueur
     * @param id Id du joueur
     */
    public Joueur(Uno uno, String nom, int id) {
        this.nom = nom;
        this.id = id;
        this.uno = uno;
        this.main = new PaquetDeCartes();
    }

    /**
     *   Fonction qui permet au joueur de jouer son coup
     * @param coup coup joué
     * @throws CoupIncorrect si le coup est incorrect
     */
    public abstract void jouer(String coup) throws CoupIncorrect;

    /* getters */
    public String getNom() {
        return nom;
    }

    public int getId() {
        return id;
    }

    /**
     *   fonction qui permet de piocher une carte
     */
    public void piocher() {
        this.main.ajouter(this.uno.getPioche().piocher());
    }

    /**
     *   fonction qui permet de savoir combien de cartes a le joueur
     */
    public int getNombreDeCartes() {
        return this.main.getNombreDeCartes();
    }

    /**
     *   fonction qui permet de savoir le score du joueur
     * @return le score du joueur
     */
    public int getScore(){
        return this.main.getValeur();
    }

    /**
     *   getter de la main du joueur
     * @return la main du joueur
     */
    public PaquetDeCartes getMain() {
        return main;
    }

    /**
     *   fonction qui permet d'ajouter une carte a la main du joueur
     * @param c carte a ajouter
     */
    public void addCarte(Carte c){
        this.main.ajouter(c);
    }
}
