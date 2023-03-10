package model.pieces;

import model.ChessBoard;
import model.Position;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Rook extends ChessPiece {
    public Rook(ChessBoard chessboard, Color color) {
        super(chessboard, color);
    }

    @Override
    public Collection<Position> getLegalMoves() {
        Position currentPosition = chessboard.getPosition(this);

        // Rooks can only move in a straight line
        List<Position> theoreticalMoves = new ArrayList<>();

        for (int i = 1; i < 8; i++) {
            Position currentMove = new Position(currentPosition.getRank() + i, currentPosition.getFile());
            if (checkAndAddPosition(currentPosition, theoreticalMoves, i, currentMove)) break;
        }

        for (int i = 1; i < 8; i++) {
            Position currentMove = new Position(currentPosition.getRank() - i, currentPosition.getFile());
            if (checkAndAddPosition(currentPosition, theoreticalMoves, i, currentMove)) break;
        }

        for (int i = 1; i < 8; i++) {
            Position currentMove = new Position(currentPosition.getRank(), currentPosition.getFile() + 1);
            if (checkAndAddPosition(currentPosition, theoreticalMoves, i, currentMove)) break;
        }

        for (int i = 1; i < 8; i++) {
            Position currentMove = new Position(currentPosition.getRank(), currentPosition.getFile() - 1);
            if (checkAndAddPosition(currentPosition, theoreticalMoves, i, currentMove)) break;
        }

        theoreticalMoves.removeIf(position -> Position.isOffBoard(position) || chessboard.isOccupiedByColor(position, color));

        return theoreticalMoves;

    }

    private boolean checkAndAddPosition(Position currentPosition, List<Position> theoreticalMoves, int i, Position currentMove) {
        if (Position.isOffBoard(currentMove) || chessboard.isOccupiedByColor(currentMove, color)) {
            return true;
        }

        theoreticalMoves.add(new Position(currentPosition.getRank() + i, currentPosition.getFile()));

        Color opponentColor = color == Color.WHITE ? Color.BLACK : Color.WHITE;

        return chessboard.isOccupiedByColor(currentMove, opponentColor);
    }

    @Override
    public String toString() {
        return "R";
    }
}
