package uno.joueur;

/**
 * @brief Exception levée lorsqu'un joueur joue un coup incorrect
 * @author Matthieu GAUDEL
 */
public class CoupIncorrect extends Exception {
    public CoupIncorrect(String message) {
        super(message);
    }
}
