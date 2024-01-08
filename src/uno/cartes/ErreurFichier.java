package uno.cartes;

/**
 * @brief Exception levée lorsqu'il y a une erreur dans le fichier de configuration
 */
public class ErreurFichier extends Exception{
    public ErreurFichier(String message) {
        super(message);
    }
}
