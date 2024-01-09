package uno.joueur;

import uno.jeu.Uno;

/**
 *   Classe représentant un joueur bot
 * @author Matthieu GAUDEL
 */
public class Bot extends Joueur{
    private final Strategie strategie; // Stratégie du bot

    /**
     *   Constructeur de la classe Bot
     * @param uno Référence vers le jeu de Uno
     * @param nom Nom du bot
     * @param id Id du bot
     * @param difficulte Difficulté du bot (0 = facile, 1 = difficile)
     */
    public Bot(Uno uno, String nom, int id, int difficulte) {
        super(uno, nom, id);
        if (difficulte == 0){
            this.strategie = new StrategieFacile();
        }else{
            this.strategie = new StrategieDifficile();
        }
    }

    /**
     *   Fonction qui permet au bot de jouer son coup
     * @param coup coup joué (pas utilisé)
     */
    public void jouer(String coup) {
        try{
            this.strategie.jouer(main, uno);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
