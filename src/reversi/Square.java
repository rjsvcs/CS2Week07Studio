package reversi;

/**
 * A class that represents a square on a board in a game of Reversi.
 */
public class Square {

    /**
     * The piece that may or may not occupy the square.
     */
    private Piece piece;

    /**
     * Creates a new, empty square.
     */
    public Square() {
        piece = null;
    }

    /**
     * Creates a square with a piece corresponding to the specified symbol.
     *
     * @param symbol Either 'B' for black, 'W' for white, or ' ' for empty.
     */
    public Square(char symbol) {
        Color color = Color.getColor(symbol);
        if(color != null) {
            piece = new Piece(color);
        }
    }

    /**
     * Returns true if the square has a piece played on it, and false
     * otherwise.
     *
     * @return True if a piece has been played on the square. Otherwise false.
     */
    public boolean isOccupied() {
        return piece != null;
    }

    /**
     * Attempts to play a piece on the square.
     *
     * @param piece The piece being played on the square.
     *
     * @throws BadMoveException If a piece has already been played on the
     * square.
     */
    public void occupy(Piece piece) throws BadMoveException {
        if(isOccupied()) {
            throw new BadMoveException("Square is already occupied");
        } else {
            this.piece = piece;
        }
    }

    /**
     * Resets the square to the empty state (no piece played).
     */
    public void reset() {
        piece = null;
    }

    /**
     * Flips the piece played on this square to the opposite side.
     *
     * @throws BadMoveException If the square is empty.
     */
    public void flip() throws BadMoveException {
        if(!isOccupied()) {
            throw new BadMoveException("Square is empty.");
        } else {
            piece.flip();
        }
    }

    /**
     * Returns a string representation of the square; either " " if the square
     * is empty, or the short symbol for the piece if it is not.
     *
     * @return A string representation of the square.
     */
    @Override
    public String toString() {
        return isOccupied() ? piece.toString() : " ";
    }
}
