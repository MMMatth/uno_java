package uno.jeu;

import uno.cartes.Carte;

import java.util.Scanner;

public class DialogueLigneDeCommande {
    private Uno uno; /** < L'instance de Uno */

    /* Couleurs pour le terminal */

    private final String reset = "\u001B[0m"; /** < Couleur par défaut */
    private String souligne = "\u001B[4m"; /** < Couleur soulignée */
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
        System.out.println(gras + souligne + "Bienvenue dans le jeu Uno" + reset);
        System.out.println("Veuillez choisir le nombre de joueurs");
        Scanner sc = new Scanner(System.in);
        int nbJoueurs = sc.nextInt();
        System.out.println("Veuillez choisir un nom");
        String nom = sc.next();
        uno.setDialogue(this);
        uno.initialiser(nbJoueurs, nom);
    }

    /**
     * @brief Fonction qui permet de choisir une couleur
     * @param coup coup joué par le joueur
     * @return le coup joué par le joueur avec la couleur choisie
     */
    public String choisirCouleur(String coup){
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez choisir une couleur : " + rouge + "r" + reset + ", " + vert + "v" + reset + ", " + jaune + "j" + reset + ", " + bleu + "b" + reset);
        String couleur = sc.next();
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
            System.out.println(gras + souligne + "Le jeu est fini voici les scores" + reset);
            for (int i = 0; i < uno.getNbJoueurs(); i++) {
                System.out.println("Le joueur " + uno.getJoueur(i).getNom() + " a un score de " + uno.getJoueur(i).getScore());
            }
        }else {
            uno.refreshPioche();
            System.out.println(gras + souligne + "C'est au tour de " +
                    uno.getJoueur(uno.getJoueurQuiJoue()).getNom() + " de jouer" +
                    "il a " + uno.getJoueur(uno.getJoueurQuiJoue()).getNombreDeCartes() + " cartes" +
                    reset);
            if(uno.joueurHumainQuiJoue()){
                System.out.println("Voici votre main : \n" + uno.getJoueur(uno.getJoueurQuiJoue()).getMain().toString());
                System.out.println(gras +"La carte sur le talon est : " + uno.getTalon().getSommet() + reset);
                Scanner sc = new Scanner(System.in);
                String coup = sc.next();
                if (coup.equals("p4") || coup.equals("j")){ // si le joueur joue un plus 4 ou un joker
                    coup = choisirCouleur(coup); // on lui demande de choisir une couleur
                }
                uno.getJoueur(uno.getJoueurQuiJoue()).jouer(coup);
                uno.choisirJoueurQuiJoue(); // on passe au joueur suivant
            }else if( !uno.joueurHumainQuiJoue()){ // si c'est un bot qui joue
                Carte sommetTalon = uno.getTalon().getSommet();
                uno.getJoueur(uno.getJoueurQuiJoue()).jouer("");
                if (sommetTalon != uno.getTalon().getSommet()){
                    System.out.println("Le joueur " + uno.getJoueur(uno.getJoueurQuiJoue()).getNom() + " a joué la carte " + uno.getTalon().getSommet());
                }else{
                    System.out.println("Le joueur " + uno.getJoueur(uno.getJoueurQuiJoue()).getNom() + " a pioché");
                }
                uno.choisirJoueurQuiJoue(); // on passe au joueur suivant
            }
        }
    }
}
