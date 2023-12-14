package uno.jeu.tests;

import uno.jeu.Uno;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnoTest {
    private Uno uno;
    @BeforeEach
    void setUp() {
        this.uno = new Uno();
    }
    @Test
    void initJoueurs() {
        uno.initJoueurs(4);
        assertEquals(4, uno.getNbJoueurs(), "initJoueurs() ne renvoie pas la bonne valeur");
    }

    @Test
    void choisirJoueurQuiJoue() {
        uno.initJoueurs(4);
        uno.chosirJoueurQuiDistribue();
        uno.choisirJoueurQuiJoue();
        assertEquals(uno.getJoueurQuiJoue(),uno.getJoueurQuiDistribue() + 1 % uno.getNbJoueurs(), "choisirJoueurQuiJoue() ne renvoie pas la bonne valeur");
    }

    @Test
    void chosirJoueurQuiDistribue() {
        uno.initJoueurs(4);
        uno.chosirJoueurQuiDistribue();
        assertTrue(uno.getJoueurQuiDistribue() >= 0 && uno.getJoueurQuiDistribue() < uno.getNbJoueurs(), "chosirJoueurQuiDistribue() ne renvoie pas la bonne valeur");
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

}