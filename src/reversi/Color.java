package reversi;

public enum Color {
    WHITE("W"),
    BLACK("B");

    private final String symbol;

    Color(String symbol) {
        this.symbol = symbol;
    }

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

    public String getSymbol() {
        return symbol;
    }

    public Color toggle() {
        return this == BLACK ? WHITE : BLACK;
    }
}
