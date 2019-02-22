package reversi;

public enum Color {
    WHITE("W"),
    BLACK("B");

    private final String symbol;

    Color(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public Color toggle() {
        return this == BLACK ? WHITE : BLACK;
    }
}
