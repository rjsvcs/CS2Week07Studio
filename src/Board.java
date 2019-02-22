public class Board {
    private static final int ROWS = 8;
    private static final int COLS = 8;
    private static final String ROW_SEPARATOR = "-----------------\n";

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
        } catch(InvalidMoveException ime) {
            // squash
        }
    }

    public void play(int row, int col) throws InvalidMoveException {
        if(row < 0 || row >= ROWS || col < 0 || col >= COLS) {
            throw new InvalidMoveException("Invalid Location: " +
                    row + "," + col);
        } else {
            board[row][col].occupy(new Piece(turn));
            turn = turn == Color.BLACK ? Color.WHITE : Color.BLACK;
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(ROW_SEPARATOR);
        for(Square[] row : board) {
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
