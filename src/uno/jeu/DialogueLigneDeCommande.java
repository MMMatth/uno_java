package uno.jeu;

import java.util.Scanner;

public class DialogueLigneDeCommande {
    private Uno uno; /** < L'instance de Uno */

    /* Couleurs pour le terminal */

    private String reset = "\u001B[0m"; /** < Couleur par défaut */
    private String souligné = "\u001B[4m"; /** < Couleur soulignée */
    private String gras = "\u001B[1m"; /** < Couleur en gras */
    private String rouge = "\u001B[31m"; /** < Couleur rouge */
    private String vert = "\u001B[32m"; /** < Couleur verte */
    private String jaune = "\u001B[33m"; /** < Couleur jaune */
    private String bleu = "\u001B[34m"; /** < Couleur bleue */

    /**
     * @brief Constructeur de la classe DialogueLigneDeCommande
     * @param u instance de Uno
     */
    public DialogueLigneDeCommande(Uno u) {
        this.uno = u;
        System.out.println(gras + souligné + "Bienvenue dans le jeu Uno" + reset);
        System.out.println("Veuillez choisir le nombre de joueurs");
        Scanner sc = new Scanner(System.in);
        int nbJoueurs = sc.nextInt();
        System.out.println("Veuillez choisir un nom");
        String nom = sc.next();
        uno.setDialogue(this);
        uno.initialiser(nbJoueurs, nom);
    }

    public String choisirCouleur(String coup){
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez choisir une couleur : " + rouge + "r" + reset + ", " + vert + "v" + reset + ", " + jaune + "j" + reset + ", " + bleu + "b" + reset);
        String couleur = sc.next();
        coup = coup + "." + couleur;
        sc.close();
        return coup;
    }

    /**
     * @brief Fonction qui permet de réagir au coup joué
     */
    public void reagir(){
        uno.refreshPioche();
        if (uno.estFini()){
            System.out.println(gras + souligné + "Le jeu est fini voici les scores" + reset);
            for (int i = 0; i < uno.getNbJoueurs(); i++) {
                System.out.println("Le joueur " + uno.getJoueur(i).getNom() + " a un score de " + uno.getJoueur(i).getScore());
            }
        }else if(uno.getJoueurQuiJoue() == uno.getNbJoueurs() - 1){
            System.out.println(gras + souligné + "C'est au tour de " + uno.getJoueur(uno.getJoueurQuiJoue()).getNom() + " de jouer" + reset);
            System.out.println("Voici votre main : \n" + uno.getJoueur(uno.getJoueurQuiJoue()).getMain().toString());
            System.out.println(gras +"La carte sur le talon est : " + uno.getTalon().getSommet() + reset);
            Scanner sc = new Scanner(System.in);
            String coup = sc.next();
            if (coup.equals("p4") || coup.equals("j")){
                coup = choisirCouleur(coup);
            }
            uno.getJoueur(uno.getJoueurQuiJoue()).jouer(coup);
        }else if(uno.getJoueurQuiJoue() != uno.getNbJoueurs() - 1){
            System.out.println(gras + souligné + "C'est au tour de " + uno.getJoueur(uno.getJoueurQuiJoue()).getNom() + " de jouer" + reset);
            System.out.println(gras + "La carte sur le talon est : " + uno.getTalon().getSommet() + reset);
            uno.getJoueur(uno.getJoueurQuiJoue()).jouer("");
        }
    }
}
