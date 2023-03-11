package ui;

import model.ChessBoard;
import model.Position;
import model.pieces.ChessPiece;
import model.pieces.ChessPiece.Color;

import java.util.Scanner;

public class ChessGame {

    private static final Scanner scanner = new Scanner(System.in);
    private final ChessBoard chessBoard;

    private Color currentTurn;

    public ChessGame() {
        this.chessBoard = new ChessBoard();
        this.currentTurn = Color.WHITE;
    }

    public boolean playerTakeTurn() {

        if (currentTurn == Color.WHITE) {
            System.out.println(chessBoard);
        } else {
            System.out.println(chessBoard.toStringBlack());
        }

        System.out.println("\nIt is " + currentTurn + "'s turn.");

        try {
            // Ask for what position of the piece they want to move
            System.out.println("Enter the position of the piece you want to move (eg: E2): ");

            // Parse the input into a Position object
            String input = getUserInput();

            // If input is "quit", return false
            if (input.equals("quit")) {
                System.out.println("Thanks for playing!");
                return false;
            }

            Position position = new Position(input);

            // Get the piece at that position
            ChessPiece piece = chessBoard.getPiece(position);

            System.out.println(piece.getLegalMoves());

            // Throw an error if the piece's color doesn't match the current turn
            if (piece.getColor() != currentTurn) {
                throw new Exception("That is not your piece!");
            }

            // Ask for what position they want to move the piece to
            System.out.println("Enter the position you want to move the piece to (eg: E4): ");

            // Parse the input into a Position object
            input = getUserInput();
            Position newPosition = new Position(input);

            // Move the piece to the new position
            piece.move(newPosition);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Try again!");
            return true;
        }

        // Switch color turn
        currentTurn = currentTurn == Color.WHITE ? Color.BLACK : Color.WHITE;

        return true;
    }

    private static String getUserInput() {
        String inputLine = scanner.nextLine();
        return inputLine.trim();
    }
}
