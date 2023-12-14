package uno.joueur.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uno.cartes.Chiffre;
import uno.cartes.Couleur;
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
        uno.addToTalon(new Chiffre(uno, Couleur.BLEU, 0));
        jh = new JoueurHumain(uno, "Bot", 1);
    }

    @Test
    void testCarteChoisie() throws CoupIncorrect {
        jh.carteChoisie("c.1.r");
        jh.carteChoisie("p4");
        jh.carteChoisie("p2.r");
        jh.carteChoisie("ptt.b");
        jh.carteChoisie("cds.j");
        jh.carteChoisie("j");
    }

    @Test
    void testJouer() throws CoupIncorrect {
        jh.addCarte(new Chiffre(uno, Couleur.ROUGE, 1));
        jh.jouer("c.1.r");
    }
}