package reversi;

import java.util.Scanner;

/**
 * A simple command line interface for playing a game of Reversi.
 */
public class Reversi {
    /**
     * Creates a board and plays a game of Reversi.
     * @param args Not used.
     */
    public static void main(String[] args) {
        Board board = new Board();
        board.begin();
        try(Scanner scanner = new Scanner(System.in)) {
            boolean sentinel = true;
            while(sentinel) {
                System.out.println(board);
                System.out.println("It is the " + board.getCurrentPlayer() +
                        " player's turn.");
                System.out.print(">> ");
                String[] command = scanner.nextLine().split(" ");
                switch(command[0]) {
                    case "quit":
                        sentinel = !quit(scanner);
                        break;
                    case "move":
                        move(command, board);
                        break;
                    case "pass":
                        pass(board);
                        break;
                    case "help":
                        help();
                        break;
                    case "save":
                        save(command);
                        break;
                    case "load":
                        load(command);
                        break;
                    default:
                        invalid(command);
                        break;
                }
            }
            System.out.println("Good bye!");
        }
    }

    /**
     * Prints a help message with the available commands.
     */
    private static void help() {
        System.out.println("Available commands: ");
        System.out.println("  help - displays this message");
        System.out.println("  load <filename> - loads a saved game");
        System.out.println("  move R C - makes a move for the current player");
        System.out.println("  pass - forfeits this turn");
        System.out.println("  quit - quits the game");
        System.out.println("  save <filename> - saves the current game");
        System.out.println();
    }

    /**
     * Prompts the user to ask if they are sure, and if so, quits the game.
     * @param scanner The scanner used to read the user response.
     * @return True if the game should quit, false if it should not.
     */
    private static boolean quit(Scanner scanner) {
        System.out.print("Are you sure? (y/n): ");
        String response = scanner.nextLine();
        return response.equalsIgnoreCase("y");
    }

    /**
     * Attempts to make a move.
     *
     * @param command The split command entered by the user.
     * @param board The board on which the move will be made.
     */
    private static void move(String[] command, Board board) {
        if(command.length != 3) {
            System.err.println("Invalid move!");
        } else {
            int row = Integer.parseInt(command[1]);
            int col = Integer.parseInt(command[2]);
            board.move(row, col);
        }
    }

    /**
     * Called when the player voluntarily passes their turn.
     * @param board The board on which the current game is being played.
     */
    private static void pass(Board board) {
        board.pass();
    }

    /**
     * Displays an invalid command message.
     *
     * @param command The invalid command.
     */
    private static void invalid(String[] command) {
        System.out.println("Invalid command: " + command[0]);
    }

    /**
     * Saves the current game progress to a specified file.
     *
     * @param command The command array; should be length of 2 and contain
     *                the filename in index 1.
     */
    private static void save(String[] command) {
        throw new NotImplemtedException("save");
    }

    /**
     * Loads an in-progress game from a specified file.
     *
     * @param command The command array; should be length of 2 and contain
     *                the filename in index 1.
     */
    private static void load(String[] command) {
        throw new NotImplemtedException("load");
    }
}
