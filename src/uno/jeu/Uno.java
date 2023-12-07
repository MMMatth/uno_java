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
    }

    /* getters */
    public int getNbJoueurs() {return joueurs.size();}
    public int getJoueurQuiDistribue() {return joueurQuiDistribue;}
    public int getJoueurQuiJoue() {return joueurQuiJoue;}
    public boolean getSensHoraire() {return sensHoraire;}
    public PaquetDeCartes getPioche() {return pioche;}
    public PaquetDeCartes getTalon() {return talon;}
}
