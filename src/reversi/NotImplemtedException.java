package reversi;

/**
 * An unchecked exception thrown when a user attempts to use a feature of the
 * game that has not yet been implemented.
 */
public class NotImplemtedException extends RuntimeException {
    /**
     * Creates a new {@link NotImplemtedException} for the specified feature
     * name.
     *
     * @param feature The name of the feature that has not yet been
     *                implemented.
     */
    public NotImplemtedException(String feature) {
        super("Feature not yet implemented: " + feature);
    }
}
