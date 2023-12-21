package uno.jeu;

import java.util.Scanner;

public class DialogueLigneDeCommande {
    private Uno uno;
    public DialogueLigneDeCommande(Uno u) {
        this.uno = u;
        System.out.println("Bienvenue dans le jeu Uno");
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
            System.out.println("Le jeu est fini voici les scores");
            for (int i = 0; i < uno.getNbJoueurs(); i++) {
                System.out.println("Le joueur " + uno.getJoueur(i).getNom() + " a un score de " + uno.getJoueur(i).getScore());
            }
     }else if(uno.getJoueurQuiJoue() == uno.getNbJoueurs()){
        System.out.println("C'est à votre tour de jouer");
        Scanner sc = new Scanner(System.in);
        String coup = sc.next();
        uno.getJoueur(uno.getJoueurQuiJoue()).jouer(coup);
     }else if(uno.getJoueurQuiJoue() != uno.getNbJoueurs()){
         System.out.println("C'est au tour de " + uno.getJoueur(uno.getJoueurQuiJoue()-1).getNom() + " de jouer");
            uno.getJoueur(uno.getJoueurQuiJoue()).jouer("");
     }
    }
}
