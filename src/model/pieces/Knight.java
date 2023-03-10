package model.pieces;

import model.ChessBoard;
import model.Position;

import java.util.Collection;
import java.util.List;

public class Knight extends ChessPiece {
    public Knight(ChessBoard chessboard, Color color) {
        super(chessboard, color);
    }

    @Override
    public Collection<Position> getLegalMoves() {
        // Get current position of the knight based on the chessboard
        Position currentPosition = chessboard.getPosition(this);

        // Using current position, get all theoretical moves for the knight
        List<Position> theoreticalMoves = new java.util.ArrayList<>(List.of(
                new Position(currentPosition.getRank() + 2, currentPosition.getFile() + 1),
                new Position(currentPosition.getRank() + 2, currentPosition.getFile() - 1),
                new Position(currentPosition.getRank() - 2, currentPosition.getFile() + 1),
                new Position(currentPosition.getRank() - 2, currentPosition.getFile() - 1),
                new Position(currentPosition.getRank() + 1, currentPosition.getFile() + 2),
                new Position(currentPosition.getRank() + 1, currentPosition.getFile() - 2),
                new Position(currentPosition.getRank() - 1, currentPosition.getFile() + 2),
                new Position(currentPosition.getRank() - 1, currentPosition.getFile() - 2)
        ));

        // Filter out theoretical moves that are not legal
        // (i.e. are off the board or are occupied by a piece of the same color)
        theoreticalMoves.removeIf(position -> !checkIfValidMove(position));

        return theoreticalMoves;
    }


    @Override
    public String toString() {
        return "H";
    }
}
