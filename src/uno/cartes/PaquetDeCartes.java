package uno.cartes;
import uno.jeu.Uno;


import java.util.ArrayList;
import java.util.Collections;

public class PaquetDeCartes {
    
    private ArrayList<Carte> paquet;

    public PaquetDeCartes(){
        paquet = new ArrayList<Carte>();
    }

    public int getNombreDeCartes(){
        return paquet.size();
    }

    public void ajouter(Carte ... cartes){
        for (Carte carte : cartes){
            paquet.add(carte);
        }
    }

    public boolean estVide(){
        return getNombreDeCartes() == 0;
    }
    
    public int getValeur(){
        return paquet.get(0).getValeur();
    }

    public String toString(){
        String str = "";
        for (Carte carte : paquet){
            str += carte.toString() + "\n";
        }
        return str;
    }


    public void ajouter(PaquetDeCartes pdc){
        for (Carte carte : pdc.paquet){
            paquet.add(carte);
        }
    }

    public void enlever(Carte carte){
        paquet.remove(carte);
    }

    public void melanger(){
        Collections.shuffle(paquet);

    }
    
    public void retourner(){
        Collections.reverse(paquet);

    }

    public Carte getSommet(){
        return paquet.get(paquet.size() - 1);
    }

    public Carte piocher(){
        Carte carte = getSommet();
        paquet.remove(carte);
        return carte;
    }
}
