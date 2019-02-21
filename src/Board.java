public class Board {
    private static final int ROWS = 8;
    private static final int COLS = 8;
    private static final String ROW_SEPARATOR = "------------------------\n";

    private final Square[][] board;

    public Board() {
        board = new Square[ROWS][COLS];
        for(int row=0; row<ROWS; row++) {
            for(int col=0; col<COLS; col++) {
                board[row][col] = new Square();
            }
        }
    }
}
