package reversi;

public class Board {
    private static final int ROWS = 8;
    private static final int COLS = 8;
    private static final String ROW_HEADER = "   0 1 2 3 4 5 6 7\n";
    private static final String ROW_SEPARATOR = "  -----------------\n";

    private final Square[][] board;

    private Color turn;

    public Board() {
        board = new Square[ROWS][COLS];
        for(int row=0; row<ROWS; row++) {
            for(int col=0; col<COLS; col++) {
                board[row][col] = new Square();
            }
        }
    }

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

    public void move(int row, int col) throws BadMoveException {
        board[row][col].occupy(new Piece(turn));
        pass();
    }

    public void pass() {
        turn = turn == Color.BLACK ? Color.WHITE : Color.BLACK;
    }

    public Color getCurrentPlayer() {
        return turn;
    }

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
}
