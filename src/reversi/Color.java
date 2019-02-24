package reversi;

/**
 * Determines the color of the pieces and players in a game of Reversi.
 */
public enum Color {
    WHITE("W"),
    BLACK("B");

    /**
     * The short symbol for the color.
     */
    private final String symbol;

    /**
     * Creates a new {@link Color} with the specified short symbol.
     *
     * @param symbol The short symbol for the new color.
     */
    Color(String symbol) {
        this.symbol = symbol;
    }

    /**
     * Returns the {@link Color} associated with the given symbol.
     *
     * @param symbol The symbol.
     *
     * @return The color for the given symbol, or null if the symbol is not
     * recognized.
     */
    public static Color getColor(char symbol) {
        Color color;
        switch(symbol) {
            case 'B':
                color = Color.BLACK;
                break;
            case 'W':
                color = Color.WHITE;
                break;
            default:
                color = null;
        }
        return color;
    }

    /**
     * Returns the symbol for this color.
     *
     * @return The symbol for this color.
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * Returns the opposing color. Useful when changing turns or flipping
     * pieces.
     *
     * @return The opposing color.
     */
    public Color toggle() {
        return this == BLACK ? WHITE : BLACK;
    }
}
