package model.pieces;

import model.ChessBoard;
import model.Position;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Bishop extends UnlimitedMovementPiece {
    public Bishop(ChessBoard chessboard, Color color) {
        super(chessboard, color);
    }

    @Override
    public Collection<Position> getLegalMoves() {
        Position currentPosition = chessboard.getPosition(this);

        // Rooks can only move in a straight line
        List<Position> theoreticalMoves = new ArrayList<>();

        getLegalMovesForBishop(currentPosition, theoreticalMoves);

        return theoreticalMoves;
    }

    @Override
    public String toString() {
        return "B";
    }
}
