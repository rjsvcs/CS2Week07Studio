package reversi.io;

import reversi.Square;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Examples of methods that read/write character data using readers and
 * writers.
 */
public class SquareChars {
    /**
     * Writes the specified {@link List} of {@Square squares} to the file with
     * the specified name.
     * @param squares The {@link List} of {@link Square squares} to write out
     *                to the file.
     * @param filename The name of the file into which the squares should be
     *                 written.
     * @throws IOException If anything goes wrong.
     */
    public void writeSquares(List<Square> squares, String filename)
            throws IOException {
        // uses try-with-resources to automatically close the writer
        try(Writer writer = new FileWriter(filename)) {
            // string buidler is more efficient than concatenation
            StringBuilder all = new StringBuilder();
            for(Square square : squares) {
                all.append(square.toString());
            }
            char[] chars = all.toString().toCharArray();
            writer.write(chars);
            writer.flush();
        }
    }

    /**
     * Returns the {@link List} of {@link Square squares} read from the file
     * with the specified name.
     * @param filename The name of the file from which the {@link Square
     * squares} should be read.
     * @return The {@link List} of {@link Square squares} read from the file.
     * @throws IOException If anything goes wrong.
     */
    public List<Square> readSquares(String filename) throws IOException {
        // try-with-resources to automatically close the reader
        try(Reader reader= new FileReader(filename)) {
            List<Square> squares = new ArrayList<>();

            // it is more efficient to read chunks of data than one at a time,
            // so use a buffer and a loop
            char[] buffer = new char[10240];
            int n;
            while((n = reader.read(buffer)) > 0) { // n <= 0 means we're done
                for(int i=0; i<n; i++) {
                    Square square = new Square(buffer[i]);
                    squares.add(square);
                }
            }

            return squares;
        }
    }
}
