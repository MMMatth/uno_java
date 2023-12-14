package uno.jeu;

import uno.joueur.*;
import uno.cartes.*;

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
    public void initJoueurs(int nbJoueurs) {
        joueurs = new ArrayList<Joueur>();
        for (int i = 0; i < nbJoueurs - 1; i++) {
            joueurs.add(new Bot(this, "Bot " + i, i, 0) );
        }
        joueurs.add(new JoueurHumain(this, "Joueur", nbJoueurs));
    }

    public void choisirJoueurQuiJoue() {
        joueurQuiJoue = joueurQuiDistribue + 1 % joueurs.size();
    }
    public void chosirJoueurQuiDistribue() {
        int ran = (int) (Math.random() * joueurs.size());
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
        choisirJoueurQuiJoue();
        chosirJoueurQuiDistribue();
        initSenseHoraire(true);
        initPioche();
        initTalon();
        dirstribuerCarte();
    }






    /* carte actions */
    public void changerSens(){
        sensHoraire = !sensHoraire;
    }
    public void passerTour(){
        joueurQuiJoue = (joueurQuiJoue + 1) % joueurs.size();
    }

    public void donnerCarteAuJoueurSuivant(int nbCartes){
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
    /* setters */
    public void setJoueurQuiDistribue(int joueurQuiDistribue) {this.joueurQuiDistribue = joueurQuiDistribue;}
    public void setJoueurQuiJoue(int joueurQuiJoue) {this.joueurQuiJoue = joueurQuiJoue;}
    public void setSensHoraire(boolean sensHoraire) {this.sensHoraire = sensHoraire;}
    public void setPioche(PaquetDeCartes pioche) {this.pioche = pioche;}
    public void setTalon(PaquetDeCartes talon) {this.talon = talon;}
    public void addToTalon(Carte carte) {talon.ajouter(carte);}
}
