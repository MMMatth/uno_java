package uno.joueur.tests;

import uno.cartes.Chiffre;
import uno.cartes.Couleur;
import uno.joueur.*;
import uno.jeu.Uno;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BotTest {
    private Uno uno;
    private Bot bot;
    @BeforeEach
    void setUp() {
        uno = new Uno();
        uno.initPioche();
        uno.initTalon();
        uno.addToTalon(new Chiffre(uno, Couleur.BLEU, 0));
        bot = new Bot(uno, "Bot", 1, 1);
    }

    @Test
    void jouer() {
        this.bot.piocher(); // on ajoute une carte à la main du bot
        this.bot.jouer(""); // on fait jouer le bot
    }
}