package uno.cartes;

import cartes.Carte;
import cartes.Couleur;
import cartes.PaquetDeCartes;

public class FabriqueCartes {
    private static FabriqueCartes instance;

    public static FabriqueCartes getInstance() {
        if (instance == null) {
            instance = new FabriqueCartes();
        }
        return instance;
    }

    public PaquetDeCartes getPaquetVide(){
        return new PaquetDeCartes();
    }

    public PaquetDeCartes getPaquet1Vert(){
        PaquetDeCartes paquet = new PaquetDeCartes();
        paquet.ajouter(new Carte(1, Couleur.VERT));
        return paquet;
    }

    public PaquetDeCartes getPaquet5Vert(){
        PaquetDeCartes paquet = new PaquetDeCartes();
        for (int i = 0; i < 5; i++) {
            paquet.ajouter(new Carte(i + 1, Couleur.VERT));
        }
        return paquet;
    }
}
