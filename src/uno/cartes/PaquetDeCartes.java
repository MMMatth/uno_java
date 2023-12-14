package uno.cartes;
import uno.jeu.Uno;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.io.PrintWriter;
import java.io.File;
import java.util.Iterator;
import java.util.Scanner;

public class PaquetDeCartes implements Iterator<Carte>{
    private final ArrayList<Carte> paquet;
    private int index;

    public PaquetDeCartes() {
        paquet = new ArrayList<Carte>();
        index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < paquet.size();
    }

    @Override
    public Carte next() {
        if (!hasNext()) {
            throw new java.util.NoSuchElementException();
        }
        return paquet.get(index++);
    }

    public int getNombreDeCartes() {
        return paquet.size();
    }

    public void ajouter(Carte... cartes) {
        Collections.addAll(paquet, cartes);
    }

    public boolean contient(Carte carte) {
        // on compare donnée par donnée par rapport a la classe
        switch (carte.getClass().getSimpleName()) {
            case "Chiffre":
                for (Carte c : paquet) {
                    if (c.getClass().getSimpleName().equals("Chiffre")) {
                        if (c.getValeur() == carte.getValeur() && c.getCouleur() == carte.getCouleur()) {
                            return true;
                        }
                    }
                }
                break;
            case "Plus2":
                for (Carte c : paquet) {
                    if (c.getClass().getSimpleName().equals("Plus2")) {
                        if (c.getCouleur() == carte.getCouleur()) {
                            return true;
                        }
                    }
                }
                break;
            case "Plus4":
                for (Carte c : paquet) {
                    if (c.getClass().getSimpleName().equals("Plus4")) {
                        return true;
                    }
                }
                break;
            case "Joker":
                for (Carte c : paquet) {
                    if (c.getClass().getSimpleName().equals("Joker")) {
                        return true;
                    }
                }
                break;
            case "PasseTonTour":
                for (Carte c : paquet) {
                    if (c.getClass().getSimpleName().equals("PasseTonTour")) {
                        if (c.getCouleur() == carte.getCouleur()) {
                            return true;
                        }
                    }
                }
                break;
            case "ChangementDeSens":
                for (Carte c : paquet) {
                    if (c.getClass().getSimpleName().equals("ChangementDeSens")) {
                        if (c.getCouleur() == carte.getCouleur()) {
                            return true;
                        }
                    }
                }
                break;
        }
        return false;
    }
    public boolean estVide() {
        return getNombreDeCartes() == 0;
    }

    public int getValeur() {
        int valeur = 0;
        for (Carte carte : paquet) {
            valeur += carte.getValeur();
        }
        return valeur;
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Carte carte : paquet) {
            str.append(carte.toString()).append("\n");
        }
        return str.toString();
    }


    public void ajouter(PaquetDeCartes pdc) {
        paquet.addAll(pdc.paquet);
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

    public void ecrire(String nomDeFichier) throws ErreurFichier {
        try {
            PrintWriter writer = new PrintWriter(nomDeFichier);

            // Utiliser la fonction getCode pour obtenir le code correspondant aux cartes
            String code = getCode();

            // Écrire le code dans le fichier
            writer.println(code);

            writer.close();
        } catch (FileNotFoundException error) {
            throw new ErreurFichier("Erreur lors de l'écriture du fichier : " + error.getMessage());
        }
    }

    public String getCode() {
        StringBuilder codeBuilder = new StringBuilder();

        for (Carte carte : paquet) {
            String color = "";
            if (carte.getCouleur() != null) {
                switch (carte.getCouleur()) {
                    case ROUGE:
                        color = "r";
                        break;
                    case BLEU:
                        color = "b";
                        break;
                    case VERT:
                        color = "c";
                        break;
                    case JAUNE:
                        color = "j";
                        break;
                    default:
                        break;
                }
            }

            switch (carte.getClass().getSimpleName()) {
                case "Chiffre":
                    codeBuilder.append("c.").append(carte.getValeur()).append(".").append(color).append("\n");
                    break;
                case "Plus2":
                    codeBuilder.append("p2.").append(color).append("\n");
                    break;
                case "Plus4":
                    codeBuilder.append("p4.").append("\n");
                    break;
                case "Joker":
                    codeBuilder.append("j.").append("\n");
                    break;
                case "PasseTonTour":
                    codeBuilder.append("ptt.").append(color).append("\n");
                    break;
                case "ChangementDeSens":
                    codeBuilder.append("cds.").append(color).append("\n");
                    break;
            }
        }
        return codeBuilder.toString();
    }



    public Couleur choisirCouleur(String couleur){
        return switch (couleur) {
            case "r" -> Couleur.ROUGE;
            case "b" -> Couleur.BLEU;
            case "c" -> Couleur.VERT;
            case "j" -> Couleur.JAUNE;
            default -> null;
        };
    }
    public void lire(String nomDeFichier) throws  ErreurFichier{
        try {
            Scanner scanner = new Scanner(new File(nomDeFichier));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // on sépare la ligne en fonction des espaces
                Couleur couleur = null;
                String[] parts = line.split("\\.");
                switch (parts[0]) {
                    case "c":
                        int valeur = Integer.parseInt(parts[1]);
                        couleur = choisirCouleur(parts[2]);
                        if (valeur < 0 || valeur > 9)
                            throw new ErreurFichier("Erreur lors de la lecture du fichier : valeur de carte incorrecte");
                        ajouter(new Chiffre(new Uno(), couleur, valeur));
                        break;
                    case "p2":
                        couleur = choisirCouleur(parts[1]);
                        ajouter(new Plus2(new Uno(), couleur));
                        break;
                    case "p4":
                        ajouter(new Plus4(new Uno()));
                        break;
                    case "j":
                        ajouter(new Joker(new Uno()));
                        break;
                    case "ptt":
                        couleur = choisirCouleur(parts[1]);
                        ajouter(new PasseTonTour(new Uno(), couleur));
                        break;
                    case "cds":
                        couleur = choisirCouleur(parts[1]);
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