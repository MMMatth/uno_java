package uno.cartes;

/**
 * Exception levée lorsqu'il y a une erreur dans le fichier de configuration
 * @author Matthieu GAUDEL
 */
public class ErreurFichier extends Exception{
    public ErreurFichier(String message) {
        super(message);
    }
}
