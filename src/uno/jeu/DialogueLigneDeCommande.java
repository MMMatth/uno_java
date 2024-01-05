package uno.jeu;

import java.util.Scanner;

public class DialogueLigneDeCommande {
    private Uno uno;

    private String reset = "\u001B[0m";
    private String souligné = "\u001B[4m";

    private String gras = "\u001B[1m";
    private String rouge = "\u001B[31m";
    private String vert = "\u001B[32m";
    private String jaune = "\u001B[33m";
    private String bleu = "\u001B[34m";
    public DialogueLigneDeCommande(Uno u) {
        this.uno = u;
        System.out.println(gras + souligné + "Bienvenue dans le jeu Uno" + reset);
        System.out.println("Veuillez choisir le nombre de joueurs");
        Scanner sc = new Scanner(System.in);
        int nbJoueurs = sc.nextInt();
        System.out.println("Veuillez choisir un nom");
        String nom = sc.next();
        uno.setDialogue(this);
        uno.initialiser(nbJoueurs);
    }

    public void reagir(){
     if (uno.estFini()){
            System.out.println(gras + souligné + "Le jeu est fini voici les scores" + reset);
            for (int i = 0; i < uno.getNbJoueurs(); i++) {
                System.out.println("Le joueur " + uno.getJoueur(i).getNom() + " a un score de " + uno.getJoueur(i).getScore());
            }
     }else if(uno.getJoueurQuiJoue() == uno.getNbJoueurs() - 1){
        System.out.println(gras + souligné +  "C'est à votre tour de jouer" + reset); // TO DO : preciser ulterieuement le nom du joueur
        System.out.println("Voici votre main : \n" + uno.getJoueur(uno.getJoueurQuiJoue()).getMain().toString());
        System.out.println(gras +"La carte sur le talon est : " + uno.getTalon().getSommet() + reset);
        Scanner sc = new Scanner(System.in);
        String coup = sc.next();
        uno.getJoueur(uno.getJoueurQuiJoue()).jouer(coup);
     }else if(uno.getJoueurQuiJoue() != uno.getNbJoueurs() - 1){
        System.out.println(gras + souligné + "C'est au tour de " + uno.getJoueur(uno.getJoueurQuiJoue()).getNom() + " de jouer" + reset);
        System.out.println(gras + "La carte sur le talon est : " + uno.getTalon().getSommet() + reset);
        uno.getJoueur(uno.getJoueurQuiJoue()).jouer("");
     }
    }
}
