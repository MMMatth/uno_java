package uno.jeu.tests;

import uno.jeu.Uno;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class UnoTest {
    private Uno uno;
    @BeforeEach
    void setUp() {
        this.uno = new Uno();
    }
    @Test
    void initJoueurs() {
        uno.setDifficulte(1);
        uno.initJoueurs(4, "Nom du Joueur");
        assertEquals(4, uno.getNbJoueurs(), "initJoueurs() ne renvoie pas la bonne valeur");
        assertEquals(1, uno.getDifficulte(), "initJoueurs() ne renvoie pas la bonne valeur");
    }

    @Test
    void choisirJoueurQuiJoue() {
        uno.initJoueurs(4, "Nom du Joueur");
        uno.chosirJoueurQuiDistribue();
        uno.choisirJoueurQuiJoue();
        assertEquals(uno.getJoueurQuiJoue(),(uno.getJoueurQuiDistribue() + 1) % (uno.getNbJoueurs() - 1), "choisirJoueurQuiJoue() ne renvoie pas la bonne valeur");
    }

    @Test
    void chosirJoueurQuiDistribue() {
        uno.initJoueurs(4, "Nom du Joueur");
        uno.chosirJoueurQuiDistribue();
        System.out.println(uno.getJoueurQuiDistribue());
        assertTrue(uno.getJoueurQuiDistribue() >= 0 && uno.getJoueurQuiDistribue() < 4, "chosirJoueurQuiDistribue() ne renvoie pas la bonne valeur");
    }

    @Test
    void initPioche() {
        uno.initPioche();
        assertEquals(108, uno.getPioche().getNombreDeCartes(), "initPioche() ne renvoie pas la bonne valeur");
    }

    @Test
    void initTalon() {
        uno.initTalon();
        assertEquals(0, uno.getTalon().getNombreDeCartes(), "initTalon() ne renvoie pas la bonne valeur");
    }

    @Test
    void initSenseHoraire() {
        uno.initSenseHoraire(true);
        assertTrue(uno.getSensHoraire(), "initSenseHoraire() ne renvoie pas la bonne valeur");
    }

    @Test
    void testRefreshPioche(){
        uno.initPioche();
        uno.initTalon();
        int nbCartes = uno.getPioche().getNombreDeCartes();
        for (int i = 0; i < nbCartes; i++) {
            uno.getTalon().ajouter(uno.getPioche().piocher());
        }
        uno.refreshPioche();
        assertEquals(nbCartes - 1, uno.getPioche().getNombreDeCartes(), "refreshPioche() ne renvoie pas la bonne valeur");
    }

    @Test
    void testDistribution(){
        uno.initJoueurs(4, "Nom du Joueur");
        uno.initPioche();
        uno.initTalon();
        uno.dirstribuerCarte();
        assertEquals(7, uno.getJoueur(0).getMain().getNombreDeCartes(), "dirstribuerCarte() ne renvoie pas la bonne valeur");
        assertEquals(7, uno.getJoueur(1).getMain().getNombreDeCartes(), "dirstribuerCarte() ne renvoie pas la bonne valeur");
        assertEquals(7, uno.getJoueur(2).getMain().getNombreDeCartes(), "dirstribuerCarte() ne renvoie pas la bonne valeur");
        assertEquals(7, uno.getJoueur(3).getMain().getNombreDeCartes(), "dirstribuerCarte() ne renvoie pas la bonne valeur");
    }

    @Test
    void testChangerSens(){
        uno.initSenseHoraire(true);
        uno.changerSens();
        assertFalse(uno.getSensHoraire(), "changerSens() ne renvoie pas la bonne valeur");
    }

    @Test
    void testChangeDeJoueur(){
        uno.initJoueurs(4, "Nom du Joueur");
        uno.initSenseHoraire(true);
        uno.choisirJoueurQuiJoue();
        int joueurQuiJoue = uno.getJoueurQuiJoue();
        uno.changeDeJoueur();
        assertEquals((joueurQuiJoue + 1) % (uno.getNbJoueurs() - 1), uno.getJoueurQuiJoue(), "changeDeJoueur() ne renvoie pas la bonne valeur");
    }

    @Test
    void testDonnerCarteAuJoueurSuivant(){
        uno.initJoueurs(4, "Nom du Joueur");
        uno.initPioche();
        uno.initTalon();
        uno.dirstribuerCarte();
        uno.chosirJoueurQuiDistribue();
        uno.choisirJoueurQuiJoue();
        int nbCartes = uno.getPioche().getNombreDeCartes();
        uno.donnerCarteAuJoueurSuivant(1);
        assertEquals(nbCartes - 1, uno.getPioche().getNombreDeCartes(), "donnerCarteAuJoueurSuivant() ne renvoie pas la bonne valeur");
    }

    @Test
    void testGetScores(){
        uno.initJoueurs(4, "Nom du Joueur");
        ArrayList<Integer> scores = uno.getScores();
        assertEquals(0, scores.get(0), "getScores() ne renvoie pas la bonne valeur");
        assertEquals(0, scores.get(1), "getScores() ne renvoie pas la bonne valeur");
        assertEquals(0, scores.get(2), "getScores() ne renvoie pas la bonne valeur");
        assertEquals(0, scores.get(3), "getScores() ne renvoie pas la bonne valeur");
    }

    @Test
    void testEstFini(){
        uno.initJoueurs(4, "Nom du Joueur");
        uno.initPioche();
        uno.initTalon();
        uno.chosirJoueurQuiDistribue();
        uno.dirstribuerCarte();
        uno.choisirJoueurQuiJoue();
        assertFalse(uno.estFini(), "estFini() ne renvoie pas la bonne valeur");
        uno.getJoueur(0).getMain().vider();
        assertTrue(uno.estFini(), "estFini() ne renvoie pas la bonne valeur");
    }

}