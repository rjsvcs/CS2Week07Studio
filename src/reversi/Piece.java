package reversi;

/**
 * A class that represents a flippable piece in a game of Reversi.
 */
public class Piece {
    /**
     * The current {@link Color} of the piece.
     */
    private Color color;

    /**
     * Creates a new {@link Piece} with the specified {@link Color}.
     *
     * @param color The face-up {@link Color} for the new Reversi piece.
     */
    public Piece(Color color) {
        this.color = color;
    }

    /**
     * Flips the {@link Piece} over to the opposing {@link Color}.
     */
    public void flip() {
        color = color.toggle();
    }

    /**
     * Returns a {@link String} with the currently face-up {@link Color
     * Color's} short symbol (e.g. "B" for {@link Color#BLACK}).
     *
     * @return The short symbol for the currently face-up color.
     */
    @Override
    public String toString() {
        return color.getSymbol();
    }
}
