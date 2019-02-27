package reversi;

import java.util.*;

/**
 * A class to represent a Reversi board. Includes all of the logic for making
 * and validating moves as well as which player is currently taking a turn.
 */
public class Board {
    /**
     * The number of rows on the board.
     */
    private static final int ROWS = 8;

    /**
     * The number of columns on the board.
     */
    private static final int COLS = 8;

    /**
     * Used when printing the board; labels the columns.
     */
    private static final String ROW_HEADER = "   0 1 2 3 4 5 6 7\n";

    /**
     * Used when printing the board; separates rows.
     */
    private static final String ROW_SEPARATOR = "  -----------------\n";

    /**
     * The two-dimensional array of {@link Square squares} that comprise the
     * board.
     */
    private Square[][] board;

    /**
     * The {@link Color} of the current player.
     */
    private Color turn;

    /**
     * Creates a new, empty Reversi board.
     */
    public Board() {
        board = new Square[ROWS][COLS];
        for(int row=0; row<ROWS; row++) {
            for(int col=0; col<COLS; col++) {
                board[row][col] = new Square();
            }
        }
    }

    /**
     * Starts a new game by resetting all of the {@link Square squares} on the
     * board and playing 4 pieces in the center of the board (two of each
     * color).
     */
    public void begin() {
        for(Square[] row : board) {
            for(Square square : row) {
                square.reset();
            }
        }

        turn = Color.BLACK;

        try {
            // black and white pieces played in center
            board[3][3].occupy(new Piece(Color.BLACK));
            board[3][4].occupy(new Piece(Color.WHITE));
            board[4][3].occupy(new Piece(Color.WHITE));
            board[4][4].occupy(new Piece(Color.BLACK));
        } catch(BadMoveException ime) {
            // squash
        }
    }

    /**
     * Attempts to play a piece of the current player's {@link Color} on the
     * square at the specified row and column on the board.
     *
     * @param row The row on which the player would like to play a piece.
     * @param col The column on which the player would like to play a piece.
     */
    public void move(int row, int col) {


    }

    /**
     * Passes the turn to the next player.
     */
    public void pass() {
        turn = turn == Color.BLACK ? Color.WHITE : Color.BLACK;
    }

    /**
     * Returns the {@link Color} of the current player.
     *
     * @return The {@link Color} of the current player.
     */
    public Color getCurrentPlayer() {
        return turn;
    }

    /**
     * Returns the {@link Square squares} that comprise this board.
     *
     * @return The {@link Square squares} that comprise this board.
     */
    public Square[][] getSquares() {
        return board;
    }

    /**
     * Replaces the current board with the one specified.
     *
     * @param squares The new {@link Square squares} to use for this board.
     */
    public void setSquares(Square[][] squares) {
        this.board = squares;
    }

    /**
     * Returns a {@link String} representation of the board suitable for
     * printing.
     *
     * @return A {@link String} representation of the board.
     */
    @Override
    public String toString() {
        // using a string builder is more efficient than concatenation
        // (it also makes the IntelliJ warnings go away)
        StringBuilder builder = new StringBuilder(ROW_HEADER);
        builder.append(ROW_SEPARATOR);
        int column = 0;
        for(Square[] row : board) {
            builder.append(column++);
            builder.append(" ");
            for(Square square : row) {
                builder.append("|");
                builder.append(square);
            }
            builder.append("|\n");
            builder.append(ROW_SEPARATOR);
        }

        return builder.toString();
    }

    /**
     * Returns all of the squares that should potentially be flipped after the
     * current player plays a piece at the specified location.
     *
     * @param row The row of the play.
     * @param col The column of the play.
     *
     * @return The collection of all squares that should be flipped after the
     * play.
     */
    private Collection<Square> searchAll(int row, int col) {
        Collection<Square> squares = new HashSet<>();
        squares.addAll(searchDir(row, col, Direction.TOP));
        squares.addAll(searchDir(row, col, Direction.TOP_RIGHT));
        squares.addAll(searchDir(row, col, Direction.RIGHT));
        squares.addAll(searchDir(row, col, Direction.BOTTOM_RIGHT));
        squares.addAll(searchDir(row, col, Direction.BOTTOM));
        squares.addAll(searchDir(row, col, Direction.BOTTOM_LEFT));
        squares.addAll(searchDir(row, col, Direction.LEFT));
        squares.addAll(searchDir(row, col, Direction.TOP_LEFT));
        return squares;
    }

    /**
     * Searches in the given direction.
     *
     * @param row The row at which the search starts.
     * @param col The column at which the search starts.
     * @param d The direction of the search.
     * @return The list of opposing pieces.
     */
    private List<Square> searchDir(int row, int col, Direction d ) {
        List<Square> squares = new ArrayList<>();
        for(int r=row+d.getRowMod(), c=col+d.getColMod();
            r>=0 && r<ROWS && c>=0 && c<COLS;
            r=r+d.getRowMod(), c=c+d.getColMod()) {

            Square square = board[r][c];
            Color color = square.getOccupyingColor();
            if (color == null) {
                squares.clear();
                return squares;
            } else if (color == getCurrentPlayer()) {
                // found an enclosing square!
                return squares;
            } else {
                // add this to the list of potential squares
                squares.add(square);
            }
        }
        // did not find an enclosing square
        squares.clear();
        return squares;
    }
}
