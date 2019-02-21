public class Piece {
    private Color color;

    public Piece(Color color) {
        this.color = color;
    }

    public void flip() {
        color = color == Color.W ? Color.B : Color.W;
    }

    @Override
    public String toString() {
        return color.toString();
    }
}
