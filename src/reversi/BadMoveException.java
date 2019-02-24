package reversi;

public class BadMoveException extends Exception {
    public BadMoveException(String message) {
        super(message);
    }
}
