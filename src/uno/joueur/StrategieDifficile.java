package uno.joueur;

import uno.cartes.Carte;
import uno.cartes.PaquetDeCartes;
import uno.jeu.Uno;

import java.util.Iterator;

public class StrategieDifficile implements Strategie {
    @Override
    public void jouer(PaquetDeCartes main, Uno uno) throws Exception {
        System.out.println(main);
        Iterator<Carte> it = main.iterator(); // Utilisez iterator() pour obtenir un itérateur sur la liste
        Carte sommetTalon = uno.getTalon().getSommet(); // Utilisez getSommet() pour obtenir le sommet de la pile
        int score = 0;
        Carte carteAjouer = null;
        if (sommetTalon != null) { // Utilisez != pour vérifier si le sommet est null
            while (it.hasNext()) { // tant qu'il y a des cartes dans la main
                Carte carte = it.next(); // Utilisez next() pour obtenir l'élément suivant de la liste
                carte.setUno(uno);
                if (sommetTalon.peutEtreRecouvertePar(carte) && carte.getValeur() > score) {
                    carteAjouer = carte;
                    score = carte.getValeur();
                }
            }
            if (carteAjouer != null) {
                carteAjouer.appliquerEffet(); // on applique l'effet de la carte
                uno.addToTalon(carteAjouer); // on ajoute la carte au talon
                main.enlever(carteAjouer); // on enleve la carte de la main
            }else {
                if (uno.getPioche().getNombreDeCartes() == 0) { // on verifie si la pioche est vide
                    throw new Exception("La pioche est vide");
                }
                main.ajouter(uno.getPioche().piocher()); // on pioche une carte
            }
        } else {
            throw new Exception("Le talon est vide");
        }
    }
}
