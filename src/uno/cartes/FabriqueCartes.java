package uno.cartes;
import uno.jeu.Uno;

public class FabriqueCartes {
    private static FabriqueCartes instance;

    public static FabriqueCartes getInstance() {
        if (instance == null) {
            instance = new FabriqueCartes();
        }
        return instance;
    }

    public PaquetDeCartes getPaquetVide() {
        return new PaquetDeCartes();
    }

    public PaquetDeCartes getPaquetEntier() {
        PaquetDeCartes paquet = new PaquetDeCartes();
        Uno u = new Uno();
        paquet.ajouter(new Chiffre(u, Couleur.BLEU, 0));
        paquet.ajouter(new Chiffre(u, Couleur.JAUNE, 0));
        paquet.ajouter(new Chiffre(u, Couleur.ROUGE, 0));
        paquet.ajouter(new Chiffre(u, Couleur.VERT, 0));
        for (int j = 0; j < 2; j ++){
            for (int i = 1; i < 10; i++) {
                paquet.ajouter(new Chiffre(u, Couleur.BLEU, i));
                paquet.ajouter(new Chiffre(u, Couleur.JAUNE, i));
                paquet.ajouter(new Chiffre(u, Couleur.ROUGE, i));
                paquet.ajouter(new Chiffre(u, Couleur.VERT, i));
            }
        }
        for (int i = 0; i < 2; i++) {
            // 2 cartes +2 de chaque couleur
            paquet.ajouter(new Plus2(u, Couleur.BLEU));
            paquet.ajouter(new Plus2(u, Couleur.JAUNE));
            paquet.ajouter(new Plus2(u, Couleur.ROUGE));
            paquet.ajouter(new Plus2(u, Couleur.VERT));
            // 2 cartes passe ton tour de chaque couleur
            paquet.ajouter(new PasseTonTour(u, Couleur.BLEU));
            paquet.ajouter(new PasseTonTour(u, Couleur.JAUNE));
            paquet.ajouter(new PasseTonTour(u, Couleur.ROUGE));
            paquet.ajouter(new PasseTonTour(u, Couleur.VERT));
            // 2 cartes changement de sens de chaque couleur
            paquet.ajouter(new ChangementDeSens(u, Couleur.BLEU));
            paquet.ajouter(new ChangementDeSens(u, Couleur.JAUNE));
            paquet.ajouter(new ChangementDeSens(u, Couleur.ROUGE));
            paquet.ajouter(new ChangementDeSens(u, Couleur.VERT));
        }
        for (int i = 0; i < 4; i++) {
            // 4 cartes joker
            paquet.ajouter(new Joker(u));
            // 4 cartes +4
            paquet.ajouter(new Plus4(u));
        }
        return paquet;
    }

    public PaquetDeCartes getPaquetMelange() {
        PaquetDeCartes paquet = getPaquetEntier();
        paquet.melanger();
        return paquet;
    }

    public PaquetDeCartes getChiffreRouge(){
        PaquetDeCartes paquet = new PaquetDeCartes();
        Uno u = new Uno();
        for (int i = 0; i < 10; i++) {
            paquet.ajouter(new Chiffre(u, Couleur.ROUGE, i));
        }
        return paquet;
    }
}
