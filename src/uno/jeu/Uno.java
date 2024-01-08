package uno.jeu;

import uno.joueur.*;
import uno.cartes.*;

import java.util.ArrayList;
import java.util.Random;

/**
 * Class Uno
 * @brief Classe qui permet de gerer le jeu
 * @author Matthieu GAUDEL
 */
public class Uno {
    private int joueurQuiDistribue; /** < variable qui varie entre 0 et nbJoueurs - 1 */

    private int joueurQuiJoue; /** < variable qui varie entre 0 et nbJoueurs - 1 */
    private boolean sensHoraire; /** < true si le sens est horaire, false sinon */
    private int difficulte; /** < difficulte du jeu */
    private PaquetDeCartes pioche; /** < pioche du jeu */
    private PaquetDeCartes talon; /** < talon du jeu */
    private ArrayList<Joueur> joueurs; /** < liste des joueurs */
    private DialogueLigneDeCommande dialogue; /** < dialogue du jeu */

    /**
     * @brief Constructeur de la classe Uno
     */
    public Uno() {}

    /**
     * @brief Fonction qui permet d'initialiser les joueurs
     * @param nbJoueurs nombre de joueurs
     * @param nomJoueur nom du joueur humain
     * @throws IllegalArgumentException si le nombre de joueurs est inferieur a 2 ou superieur a 10
     */
    public void initJoueurs(int nbJoueurs, String nomJoueur) throws IllegalArgumentException{
        joueurs = new ArrayList<Joueur>();
        if (nbJoueurs < 2) {
            throw new IllegalArgumentException("Il faut au moins 2 joueurs");
        }
        if (nbJoueurs > 10) {
            throw new IllegalArgumentException("Il faut au plus 10 joueurs");
        }
        for (int i = 0; i < nbJoueurs - 1; i++) {
            joueurs.add(new Bot(this, "Bot " + i, i, this.difficulte) );
        }
        joueurs.add(new JoueurHumain(this, nomJoueur, nbJoueurs));
    }

    /**
     * @brief Fonction qui permet d'initialiser le dialogue
     * @param dialogue
     */
    public void setDialogue(DialogueLigneDeCommande dialogue) {
        this.dialogue = dialogue;
    }

    /**
     * @brief Fonction qui permet de choisir le joueur qui joue en premier
     */
    public void choisirJoueurQuiJoue() {
        this.joueurQuiJoue = (joueurQuiDistribue + 1) % (joueurs.size() - 1); // le joueur qui joue est le joueur apres le joueur qui distribue
    }

    /**
     * @brief Fonction qui permet de refaire jouer un joueur
     * @details Fonction qui permet de refaire jouer un joueur par exemple dans le cas ou le joueur se trompe de carte
     */
    public void joueurRejoue() {
        dialogue.reagir();
    }

    /**
     * @brief Fonction qui permet de choisir le joueur qui distribue
     * @details cette fonction utilise un random pour choisir le joueur qui distribue aleatoirement parmis les joueurs
     */
    public void chosirJoueurQuiDistribue() {
        Random rand = new Random();
        this.joueurQuiDistribue = rand.nextInt(joueurs.size() - 1); // on choisit un joueur au hasard
    }



    /**
     * @brief Fonction qui permet d'initialiser la pioche
     */
    public void initPioche() {
        FabriqueCartes fabriqueCartes = FabriqueCartes.getInstance();
        pioche = fabriqueCartes.getPaquetMelangerEntier();
    }

    /**
     * @brief Fonction qui permet d'initialiser le talon
     */
    public void initTalon() {
        FabriqueCartes fabriqueCartes = FabriqueCartes.getInstance();
        talon = fabriqueCartes.getPaquetVide();
    }

    /**
     * @brief Fonction qui permet de rafraichir la pioche
     * @details Cette fonction permet de rafraichir la pioche dans le cas ou elle est vide
     */
    public void refreshPioche(){
        if (this.pioche.estVide()){
            Carte derniereCarte = talon.getSommet();
            this.talon.enlever(talon.getNombreDeCartes() - 1);
            this.pioche = new PaquetDeCartes(talon);
            this.talon = new PaquetDeCartes();
            this.talon.ajouter(derniereCarte);
        }
    }

    /**
     * @brief Fonction qui permet de distribuer les cartes
     * @details cette fonction distribue 7 cartes a chaque joueur une par une
     */
    public void dirstribuerCarte(){
        for (int i = 0; i < 7; i++) {
            for (Joueur joueur : joueurs) {
                joueur.piocher();
            }
        }
        addToTalon(pioche.piocher());
    }

    /**
     * @brief Fonction qui permet d'initialiser le sens du jeu
     * @param sensHoraire true si le sens est horaire, false sinon
     */
    public void initSenseHoraire(boolean sensHoraire){
        this.sensHoraire = sensHoraire;
    }

    /**
     * @brief Fonction qui permet d'initialiser le jeu
     * @param nbrBots nombre de bots
     * @param nomJoueur nom du joueur humain
     */
    public void initialiser(int nbrBots, String nomJoueur) {
        initJoueurs(nbrBots, nomJoueur);
        chosirJoueurQuiDistribue();
        choisirJoueurQuiJoue();
        initSenseHoraire(true); // le sens du jeu est horaire
        initPioche();
        initTalon();
        dirstribuerCarte();
        this.dialogue.reagir(); // on démarre le jeu
    }

    /* Effet des cartes */
    /**
     * @brief Fonction qui permet de changer le sens du jeu
     */
    public void changerSens(){
        sensHoraire = !sensHoraire;
    }

    /**
     * @brief Fonction qui permet de changer de joueur
     */
    public void changeDeJoueur(){
        if (sensHoraire){
            joueurQuiJoue = (joueurQuiJoue + 1) % joueurs.size();
        }else {
            if (joueurQuiJoue == 0){
                joueurQuiJoue = joueurs.size() - 1;
            }
            else {
                joueurQuiJoue = (joueurQuiJoue - 1) % joueurs.size();
            }
        }
    }

    /**
     * @brief Fonction qui permet de faire piocher un joueur
     * @param nbCartes nombre de cartes a piocher
     */
    public void donnerCarteAuJoueurSuivant(int nbCartes) {
        if (nbCartes > this.pioche.getNombreDeCartes()){
            nbCartes = this.pioche.getNombreDeCartes(); // on ne peut pas piocher plus de cartes que ce qu'il y a dans la pioche
        }
        for (int i = 0; i < nbCartes; i++) {
            if (sensHoraire){
                joueurs.get((joueurQuiJoue + 1) % joueurs.size()).piocher();
            }else {
                joueurs.get((joueurQuiJoue - 1) % joueurs.size()).piocher();
            }
        }
    }

    public int getNbJoueurs() {return joueurs.size();}
    public int getJoueurQuiDistribue() {return joueurQuiDistribue;}
    public int getJoueurQuiJoue() {return joueurQuiJoue;}
    public boolean getSensHoraire() {return sensHoraire;}
    public PaquetDeCartes getPioche() {return pioche;}
    public PaquetDeCartes getTalon() {return talon;}
    public Joueur getJoueur(int i) {
        return joueurs.get(i);
    }
    public boolean joueurHumainQuiJoue() {
        return getJoueurQuiJoue() == getNbJoueurs() - 1;
    }
    public int getDifficulte() {return difficulte;}
    public void setDifficulte(int difficulte) { this.difficulte = difficulte; }


    /**
     * @brief Fonction qui permet de recuperer les scores des joueurs
     * @return La liste des scores des joueurs
     */
    public ArrayList<Integer> getScores(){
        ArrayList<Integer> scores = new ArrayList<Integer>();
        for (Joueur joueur : joueurs) {
            scores.add(joueur.getScore());
        }
        return scores;
    }

    /**
     * @brief Fonction qui permet de savoir si le jeu est fini
     * @return true si le jeu est fini, false sinon
     */
    public boolean estFini() {
        for (Joueur joueur : joueurs) {
            if (joueur.getNombreDeCartes() == 0) {
                return true;
            }
        }
        return false;
    }

    public void addToTalon(Carte carte) {talon.ajouter(carte);}
}
