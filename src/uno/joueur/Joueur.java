package uno.joueur;

import uno.cartes.PaquetDeCartes;
import uno.jeu.Uno;
import uno.cartes.*;

/**
 * @brief Classe abstraite représentant un joueur
 */
public abstract class Joueur {
    protected String nom; /** < Nom du joueur */
    protected int id; /** < Id du joueur */
    protected PaquetDeCartes main; /** < Main du joueur */
    protected Uno uno; /** < Référence vers le jeu de Uno */

    /**
     * @brief Constructeur de la classe Joueur
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
     * @brief Fonction qui permet au joueur de jouer son coup
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
     * @brief fonction qui permet de piocher une carte
     */
    public void piocher() {
        this.main.ajouter(this.uno.getPioche().piocher());
    }

    /**
     * @brief fonction qui permet de savoir combien de cartes a le joueur
     */
    public int getNombreDeCartes() {
        return this.main.getNombreDeCartes();
    }

    /**
     * @brief fonction qui permet de savoir le score du joueur
     * @return le score du joueur
     */
    public int getScore(){
        return this.main.getValeur();
    }

    /**
     * @brief getter de la main du joueur
     * @return la main du joueur
     */
    public PaquetDeCartes getMain() {
        return main;
    }

    /**
     * @brief fonction qui permet d'ajouter une carte a la main du joueur
     * @param c carte a ajouter
     */
    public void addCarte(Carte c){
        this.main.ajouter(c);
    }
}
