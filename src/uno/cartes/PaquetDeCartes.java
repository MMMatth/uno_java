package uno.cartes;
import uno.jeu.Uno;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.io.PrintWriter;
import java.io.File;
import java.util.Scanner;

public class PaquetDeCartes {

    private ArrayList<Carte> paquet;

    public PaquetDeCartes() {
        paquet = new ArrayList<Carte>();
    }

    public int getNombreDeCartes() {
        return paquet.size();
    }

    public void ajouter(Carte... cartes) {
        for (Carte carte : cartes) {
            paquet.add(carte);
        }
    }

    public boolean estVide() {
        return getNombreDeCartes() == 0;
    }

    public int getValeur() {
        return paquet.get(0).getValeur();
    }

    public String toString() {
        String str = "";
        for (Carte carte : paquet) {
            str += carte.toString() + "\n";
        }
        return str;
    }


    public void ajouter(PaquetDeCartes pdc) {
        for (Carte carte : pdc.paquet) {
            paquet.add(carte);
        }
    }

    public void enlever(Carte carte) {
        paquet.remove(carte);
    }

    public void melanger() {
        Collections.shuffle(paquet);

    }

    public void retourner() {
        Collections.reverse(paquet);

    }

    public Carte getSommet() {
        return paquet.get(paquet.size() - 1);
    }

    public Carte piocher() {
        Carte carte = getSommet();
        paquet.remove(carte);
        return carte;
    }

    public void ecrire(String nomDeFichier) throws ErreurFichier{
        try {
            PrintWriter writer = new PrintWriter(nomDeFichier);
            for (Carte carte : paquet) {
                writer.println(carte.toString());
            }
            writer.close();
        } catch (FileNotFoundException error) {
            throw new ErreurFichier("Erreur lors de l'écriture du fichier : " + error.getMessage());
        }
    }



    public void lire(String nomDeFichier) throws  ErreurFichier{
        try {
            Scanner scanner = new Scanner(new File(nomDeFichier));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // on sépare la ligne en fonction des espaces
                Couleur couleur = null;
                String[] parts = line.split(" ");
                switch (parts[0]) {
                    case "Chiffre":
                        int valeur = Integer.parseInt(parts[1]);
                        couleur = Couleur.valueOf(parts[2].toUpperCase());
                        if (valeur < 0 || valeur > 9)
                            throw new ErreurFichier("Erreur lors de la lecture du fichier : valeur de carte incorrecte");
                        ajouter(new Chiffre(new Uno(), couleur, valeur));
                        break;
                    case "Plus2":
                        couleur = Couleur.valueOf(parts[1].toUpperCase());
                        ajouter(new Plus2(new Uno(), couleur));
                        break;
                    case "Plus4":
                        ajouter(new Plus4(new Uno()));
                        break;
                    case "Joker":
                        ajouter(new Joker(new Uno()));
                        break;
                    case "PasseTonTour":
                        couleur = Couleur.valueOf(parts[1].toUpperCase());
                        ajouter(new PasseTonTour(new Uno(), couleur));
                        break;
                    case "ChangementDeSens":
                        couleur = Couleur.valueOf(parts[1].toUpperCase());
                        ajouter(new ChangementDeSens(new Uno(), couleur));
                        break;
                }
            }
            scanner.close();
        } catch (FileNotFoundException error) {
            throw new ErreurFichier("Erreur lors de la lecture du fichier : " + error.getMessage());
        }
    }
}