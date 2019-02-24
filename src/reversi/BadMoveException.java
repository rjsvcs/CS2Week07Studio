package reversi;

/**
 * An exception indicating that a player attempted to make a bad move.
 */
public class BadMoveException extends Exception {
    /**
     * Creates a new {@link BadMoveException} with the specified informative
     * message.
     *
     * @param message The informative message.
     */
    public BadMoveException(String message) {
        super(message);
    }
}
