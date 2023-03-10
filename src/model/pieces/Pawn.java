package model.pieces;

import model.ChessBoard;
import model.Position;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Pawn extends ChessPiece {
    public Pawn(ChessBoard chessboard, Color color) {
        super(chessboard, color);
    }

    @Override
    public Collection<Position> getLegalMoves() {
        Position position = chessboard.getPosition(this);
        List<Position> theoreticalMoves = new ArrayList<>();

        // Pawns can always move forward one square
        Position moveForwardOneSquare = new Position(position.getRank() + (color == Color.WHITE ? 1 : -1), position.getFile());

        boolean pieceAtOneSquare = chessboard.isOccupied(moveForwardOneSquare);

        if (!pieceAtOneSquare) {
            theoreticalMoves.add(moveForwardOneSquare);

            // Pawns can move forward two squares if they are on their starting rank
            Position moveForwardTwoSquares = new Position(position.getRank() + (color == Color.WHITE ? 2 : -2), position.getFile());

            boolean pieceAtTwoSquares = chessboard.isOccupied(moveForwardTwoSquares);
            if (!moved && !pieceAtTwoSquares) {
                theoreticalMoves.add(moveForwardTwoSquares);
            }
        }

        // Pawns can also move diagonally if there is an enemy piece there
        Position diagonalLeft = new Position(position.getRank() + (color == Color.WHITE ? 1 : -1), position.getFile() - 1);
        Position diagonalRight = new Position(position.getRank() + (color == Color.WHITE ? 1 : -1), position.getFile() + 1);

        // Check if diagonal left is on the board and if there is an enemy piece there
        Color opponentColor = color == Color.WHITE ? Color.BLACK : Color.WHITE;
        if (!Position.isOffBoard(diagonalLeft) && chessboard.isOccupiedByColor(diagonalLeft, opponentColor)) {
            theoreticalMoves.add(diagonalLeft);
        }
        // Do the same for diagonal right
        if (!Position.isOffBoard(diagonalRight) && chessboard.isOccupiedByColor(diagonalRight, opponentColor)) {
            theoreticalMoves.add(diagonalRight);
        }

        return theoreticalMoves;
    }

    @Override
    public String toString() {
        return "p";
    }
}
