package reversi;

public class Square {

    private Piece piece;

    public Square() {
        piece = null;
    }

    public Square(char symbol) {
        Color color = Color.getColor(symbol);
        if(color != null) {
            piece = new Piece(color);
        }
    }

    public boolean isOccupied() {
        return piece != null;
    }

    public void occupy(Piece piece) throws BadMoveException {
        if(isOccupied()) {
            throw new BadMoveException("Square is already occupied");
        } else {
            this.piece = piece;
        }
    }

    public void reset() {
        piece = null;
    }

    public void flip() throws BadMoveException {
        if(!isOccupied()) {
            throw new BadMoveException("Square is empty.");
        } else {
            piece.flip();
        }
    }

    @Override
    public String toString() {
        return isOccupied() ? piece.toString() : " ";
    }
}
