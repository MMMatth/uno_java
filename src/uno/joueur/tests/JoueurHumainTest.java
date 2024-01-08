package uno.joueur.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uno.cartes.Chiffre;
import uno.cartes.Couleur;
import uno.jeu.DialogueLigneDeCommande;
import uno.jeu.Uno;
import uno.joueur.CoupIncorrect;
import uno.cartes.*;
import uno.joueur.JoueurHumain;

class JoueurHumainTest {
    private Uno uno;
    private JoueurHumain jh;
    @BeforeEach
    void setUp() {
        uno = new Uno();
        uno.initPioche();
        uno.initTalon();
        uno.initSenseHoraire(true);
        uno.initJoueurs(2, "Bot");
        uno.chosirJoueurQuiDistribue();
        uno.choisirJoueurQuiJoue();
        uno.addToTalon(new Chiffre(uno, Couleur.BLEU, 0));
    }

    @Test
    void testCarteChoisie() throws CoupIncorrect {
        Carte c;
        JoueurHumain jh = new JoueurHumain(uno, "JoueurHumain", 0);
        c = jh.carteChoisie("c.1.r");
        assert c instanceof Chiffre : "carteChoisie() ne renvoie pas une carte Chiffre";
        c = jh.carteChoisie("p4.r");
        assert c instanceof Plus4 : "carteChoisie() ne renvoie pas une carte Plus4";
        c = jh.carteChoisie("p2.r");
        assert c instanceof Plus2 : "carteChoisie() ne renvoie pas une carte Plus2";
        c = jh.carteChoisie("ptt.b");
        assert c instanceof PasseTonTour : "carteChoisie() ne renvoie pas une carte PasseTonTour";
        c = jh.carteChoisie("cds.j");
        assert c instanceof ChangementDeSens : "carteChoisie() ne renvoie pas une carte ChangerDeSens";
        c = jh.carteChoisie("j.r");
        assert c instanceof Joker : "carteChoisie() ne renvoie pas une carte Joker";
    }

    @Test
    void testJouer() throws CoupIncorrect {

    }
}