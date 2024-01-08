package uno.joueur;

/**
 * @brief Exception levée lorsqu'un joueur joue un coup incorrect
 */
public class CoupIncorrect extends Exception {
    public CoupIncorrect(String message) {
        super(message);
    }
}
