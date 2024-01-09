package uno.jeu;

import uno.cartes.Carte;
import uno.joueur.CoupIncorrect;

import java.util.Objects;
import java.util.Scanner;

/**
 * @brief Classe qui permet de gérer le dialogue avec le joueur humain
 * @author Matthieu GAUDEL
 */
public class DialogueLigneDeCommande {
    private Uno uno; /** < L'instance de Uno */

    /* Couleurs pour le terminal */

    private final String reset = "\u001B[0m"; /** < Couleur par défaut */
    private final String souligne = "\u001B[4m"; /** < Couleur soulignée */
    private final String gras = "\u001B[1m"; /** < Couleur en gras */
    private final String rouge = "\u001B[31m"; /** < Couleur rouge */
    private final String vert = "\u001B[32m"; /** < Couleur verte */
    private final String jaune = "\u001B[33m"; /** < Couleur jaune */
    private final String bleu = "\u001B[34m"; /** < Couleur bleue */

    /**
     * @brief Constructeur de la classe DialogueLigneDeCommande
     * @param u instance de Uno
     */
    public DialogueLigneDeCommande(Uno u) {
        int nbJoueurs;
        this.uno = u;
        System.out.println(gras + souligne + "Bienvenue dans le jeu Uno" + reset);
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Veuillez choisir le nombre de joueurs");
            while (!sc.hasNextInt()) { // tant que l'utilisateur n'a pas entré un entier
                System.out.println("Veuillez entrer un nombre entier.");
                sc.next();
            }
            nbJoueurs = sc.nextInt();
        } while (nbJoueurs < 2 || nbJoueurs > 10);
        System.out.println("Veuillez choisir un nom");
        String nomJoueurHumain = sc.next();
        do {
            System.out.println("Veuillez choisir la difficulté 0 pour facile, 1 pour difficile");
            while (!sc.hasNextInt()) { // tant que l'utilisateur n'a pas entré un entier
                System.out.println("Veuillez entrer un nombre entier.");
                sc.next();
            }
            uno.setDifficulte(sc.nextInt());
        }while (uno.getDifficulte() != 0 && uno.getDifficulte()  != 1);
        uno.setDialogue(this);
        uno.initialiser(nbJoueurs, nomJoueurHumain);
    }

    /**
     * @brief Fonction qui permet de choisir une couleur
     * @param coup coup joué par le joueur
     * @return le coup joué par le joueur avec la couleur choisie
     */
    public String choisirCouleur(String coup){
        Scanner sc = new Scanner(System.in);
        String couleur;
        do {
            System.out.println("Veuillez choisir une couleur : " + rouge + "r" + reset + ", " + vert + "v" + reset +
                    ", " + jaune + "j" + reset + ", " + bleu + "b" + reset);
            couleur = sc.next();
        }while (!Objects.equals(couleur, "r") && !Objects.equals(couleur, "v") &&
                !Objects.equals(couleur, "j") && !Objects.equals(couleur, "b"));
        coup = coup + "." + couleur;
        return coup;
    }

    /**
     * @brief Fonction qui permet de réagir au coup joué
     * @details cette fonction se sépare en trois aprtie le cas ou le jeux est fini, le cas ou c'est au tour du
     * joueur humain de jouer et le cas ou c'est au tour d'un bot de jouer
     */
    public void reagir(){
        if (uno.estFini()){
            afficherScores();
        } else {
            uno.refreshPioche();
            System.out.println(gras + souligne + "C'est au tour de " +
                    uno.getJoueur(uno.getJoueurQuiJoue()).getNom() + " de jouer " +
                    "il a " + uno.getJoueur(uno.getJoueurQuiJoue()).getNombreDeCartes() + " cartes" +
                    reset);

            if (uno.joueurHumainQuiJoue()){
                try {
                    jouerCarteHumain();
                } catch (CoupIncorrect e) {
                    throw new RuntimeException(e);
                }
            } else {
                try {
                    jouerCarteBot();
                } catch (CoupIncorrect e) {
                    throw new RuntimeException(e);
                }
            }

            uno.changeDeJoueur();
            reagir();
        }
    }

    /**
     * @brief Fonction qui permet d'afficher les scores
     */
    private void afficherScores() {
        System.out.println(gras + souligne + "Le jeu est fini voici les scores" + reset);
        for (int i = 0; i < uno.getNbJoueurs(); i++) {
            System.out.println("Le joueur " + uno.getJoueur(i).getNom() + " a un score de " + uno.getJoueur(i).getScore());
        }
    }

    /**
     * @brief Fonction qui permet au joueur humain de jouer son coup
     * @throws CoupIncorrect si le coup est incorrect (mauvaise couleur, mauvais chiffre, ...)
     */
    private void jouerCarteHumain() throws CoupIncorrect {
        System.out.println("Voici votre main : \n" + uno.getJoueur(uno.getJoueurQuiJoue()).getMain().toString());
        System.out.println(gras +"La carte sur le talon est : " + uno.getTalon().getSommet() + reset);
        Scanner sc = new Scanner(System.in);
        String coup = sc.next();
        if (coup.equals("p4") || coup.equals("j")) {
            coup = choisirCouleur(coup);
        }
        uno.getJoueur(uno.getJoueurQuiJoue()).jouer(coup);
    }

    /**
     * @brief Fonction qui permet au bot de jouer son coup
     * @throws CoupIncorrect si le coup est incorrect (mauvaise couleur, mauvais chiffre, ...)
     */
    private void jouerCarteBot() throws CoupIncorrect {
        Carte sommetTalon = uno.getTalon().getSommet();
        uno.getJoueur(uno.getJoueurQuiJoue()).jouer("");
        if (sommetTalon != uno.getTalon().getSommet()) {
            System.out.println("Le joueur " + uno.getJoueur(uno.getJoueurQuiJoue()).getNom() + " a joué la carte " + uno.getTalon().getSommet());
        } else {
            System.out.println("Le joueur " + uno.getJoueur(uno.getJoueurQuiJoue()).getNom() + " a pioché");
        }
    }

}
