package reversi;

public class NotImplemtedException extends RuntimeException {
    public NotImplemtedException(String feature) {
        super("Feature not yet implemented: " + feature);
    }
}
