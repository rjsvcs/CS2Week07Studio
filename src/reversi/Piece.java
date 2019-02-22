package reversi;

public class Piece {
    private Color color;

    public Piece(Color color) {
        this.color = color;
    }

    public void flip() {
        color = color == Color.WHITE ? Color.BLACK : Color.WHITE;
    }

    @Override
    public String toString() {
        return Character.toString(color.toString().charAt(0));
    }
}
