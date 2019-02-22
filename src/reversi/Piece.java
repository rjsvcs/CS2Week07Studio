package reversi;

public class Piece {
    private Color color;

    public Piece(Color color) {
        this.color = color;
    }

    public void flip() {
        color = color.toggle();
    }

    @Override
    public String toString() {
        return color.getSymbol();
    }
}
