package model.pieces;

import model.ChessBoard;
import model.Position;

import java.util.Collection;

public class Bishop extends ChessPiece {
    public Bishop(ChessBoard chessboard, Color color) {
        super(chessboard, color);
    }

    @Override
    public Collection<Position> getLegalMoves() {
        return null;
    }

    @Override
    public String toString() {
        return "B";
    }
}
