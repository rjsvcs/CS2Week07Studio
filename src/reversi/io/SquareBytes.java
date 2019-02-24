package reversi.io;

import reversi.BadMoveException;
import reversi.Color;
import reversi.Piece;
import reversi.Square;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Examples of methods that read/write binary data (bytes) using input and
 * output streams.
 */
public class SquareBytes {
    /**
     * Writes the specified {@link List} of {@link Square squares} to a file
     * with the specified name. Each square is written as a single byte: 0 if
     * the square is unoccupied, 1 if the occupying piece is black, and 2 if
     * the occupying piece is white.
     * @param squares The {@link List} of {@link Square squares} to write out
     *                to a file.
     * @param filename The name of the file to which the squares should be
     *                 written.
     * @throws IOException If anything goes wrong.
     */
    public void writeSquares(List<Square> squares, String filename)
            throws IOException {
        // try-with-resources to automatically close the stream when done
        try(OutputStream out = new FileOutputStream(filename)) {
            byte[] bytes = new byte[squares.size()];
            for(int i=0; i<squares.size(); i++) {
                Square square = squares.get(i);
                String symbol = square.toString();
                if(symbol.equals("B")) {
                    bytes[i] = 1;
                } else if(symbol.equals("W")) {
                    bytes[i] = 2;
                } else {
                    bytes[i] = 0;
                }
            }
            out.write(bytes);
            out.flush();
        }
    }

    /**
     * Uses an {@link InputStream} to read squares as bytes from the file with
     * the specified name.
     * @param filename The name of the file containing the binary data.
     * @return The {@link List} of squares read from the file.
     * @throws IOException If anything goes wrong.
     */
    public List<Square> readSquares(String filename) throws IOException,
                                                            BadMoveException {
        // try-with-resources closes the stream when done
        try(InputStream in = new FileInputStream(filename)) {
            List<Square> squares = new ArrayList<>();
            byte[] buffer = new byte[10240];
            int n;
            while((n = in.read(buffer)) > 0) {
                for(int i=0; i<n; i++) {
                    Square square = new Square();
                    if(buffer[i] == 1) {
                        square.occupy(new Piece(Color.BLACK));
                    } else if(buffer[i] == 2) {
                        square.occupy(new Piece(Color.WHITE));
                    }
                    squares.add(square);
                }
            }
            return squares;
        }
    }
}
