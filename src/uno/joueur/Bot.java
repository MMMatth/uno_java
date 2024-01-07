package uno.joueur;

import uno.jeu.Uno;

public class Bot extends Joueur{
    private final Strategie strategie;
    public Bot(Uno uno, String nom, int id, int difficulte) {
        super(uno, nom, id);
        if (difficulte == 0){
            this.strategie = new StrategieFacile();
        }else{
            this.strategie = new StrategieDifficile();
        }
    }

    public void jouer(String coup) {
        try{
            this.strategie.jouer(main, uno);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
