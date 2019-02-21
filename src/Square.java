public class Square {

    private Piece piece;

    public boolean isOccupied() {
        return piece != null;
    }

    public void occupy(Piece piece) throws InvalidMoveException {
        if(isOccupied()) {
            throw new InvalidMoveException("Square is already occupied");
        } else {
            this.piece = piece;
        }
    }

    public void flip() throws InvalidMoveException {
        if(!isOccupied()) {
            throw new InvalidMoveException("Square is empty.");
        } else {
            piece.flip();
        }
    }

    @Override
    public String toString() {
        return isOccupied() ? piece.toString() : " ";
    }
}
