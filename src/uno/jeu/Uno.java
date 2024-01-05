package uno.jeu;

import uno.joueur.*;
import uno.cartes.*;

import java.util.ArrayList;

public class Uno {
    private int joueurQuiDistribue; // variable qui varie entre 0 et nbJoueurs - 1
    private int joueurQuiJoue; // variable qui varie entre 0 et nbJoueurs - 1
    private boolean sensHoraire; // true si le sens est horaire, false sinon
    private int difficulte;
    private PaquetDeCartes pioche;
    private PaquetDeCartes talon;
    private ArrayList<Joueur> joueurs;
    private DialogueLigneDeCommande dialogue;
    public Uno() {
    }
    public void initJoueurs(int nbJoueurs) {
        joueurs = new ArrayList<Joueur>();
        for (int i = 0; i < nbJoueurs - 1; i++) {
            joueurs.add(new Bot(this, "Bot " + i, i, 0) );
        }
        joueurs.add(new JoueurHumain(this, "Joueur", nbJoueurs));
    }

    public void setDialogue(DialogueLigneDeCommande dialogue) {
        this.dialogue = dialogue;
    }

    public void choisirJoueurQuiJoue() {
        joueurQuiJoue = (joueurQuiJoue + 1) % (joueurs.size());
        dialogue.reagir();
    }

    public void joueurRejoue() {
        dialogue.reagir();
    }
    public void chosirJoueurQuiDistribue() {
        int ran = (int) (Math.random() % (joueurs.size() - 1)) ;
        System.out.println(ran);
        joueurQuiDistribue = ran;
    }
    public void initPioche() {
        FabriqueCartes fabriqueCartes = FabriqueCartes.getInstance();
        pioche = fabriqueCartes.getPaquetMelangerEntier();
    }
    public void initTalon() {
        FabriqueCartes fabriqueCartes = FabriqueCartes.getInstance();
        talon = fabriqueCartes.getPaquetVide();
    }

    public void dirstribuerCarte(){
        for (int i = 0; i < 7; i++) {
            for (Joueur joueur : joueurs) {
                joueur.piocher();
            }
        }
        addToTalon(pioche.piocher());
    }
    public void initSenseHoraire(boolean sensHoraire){
        this.sensHoraire = sensHoraire;
    }
    public void initialiser(int nbrBots) {
        initJoueurs(nbrBots);
        chosirJoueurQuiDistribue();
        System.out.println("joueur qui distribue : " + joueurQuiDistribue);
        this.joueurQuiJoue = joueurQuiDistribue + 1 % (joueurs.size() - 1);
        initSenseHoraire(true);
        initPioche();
        initTalon();
        dirstribuerCarte();
        this.dialogue.reagir();
    }
    /* carte actions */
    /** fonction qui permet de changer le sens du jeu */
    public void changerSens(){
        sensHoraire = !sensHoraire;
    }

    /** fonction qui permet de sauter le tour du joueur suivant */
    public void changeDeJoueur(){
        joueurQuiJoue = (joueurQuiJoue + 1) % joueurs.size();
    }

    /** fonction qui permet de donner des cartes au joueur suivant */
    public void donnerCarteAuJoueurSuivant(int nbCartes){
        System.out.println("Le joueur " + joueurs.get((joueurQuiJoue + 1) % joueurs.size()).getNom() + " pioche " + nbCartes + " cartes");
        for (int i = 0; i < nbCartes; i++) {
            joueurs.get((joueurQuiJoue + 1) % joueurs.size()).piocher();
        }
    }

    /* getters */
    public int getNbJoueurs() {return joueurs.size();}
    public int getJoueurQuiDistribue() {return joueurQuiDistribue;}
    public int getJoueurQuiJoue() {return joueurQuiJoue;}
    public boolean getSensHoraire() {return sensHoraire;}
    public PaquetDeCartes getPioche() {return pioche;}
    public PaquetDeCartes getTalon() {return talon;}

    // fonction qui recupere les scores des joueurs
    public ArrayList<Integer> getScores(){
        ArrayList<Integer> scores = new ArrayList<Integer>();
        for (Joueur joueur : joueurs) {
            scores.add(joueur.getScore());
        }
        return scores;
    }

    public Joueur getJoueur(int i) {
        return joueurs.get(i);
    }

    /* setters */
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
