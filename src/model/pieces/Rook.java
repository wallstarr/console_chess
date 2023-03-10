package model.pieces;

import model.ChessBoard;
import model.Position;

import java.util.Collection;

public class Rook extends ChessPiece {
    public Rook(ChessBoard chessboard, Color color) {
        super(chessboard, color);
    }

    @Override
    public void move(Position position) {

    }

    @Override
    public Collection<Position> getLegalMoves() {
        return null;
    }

    @Override
    protected void setPosition(Position position) {

    }

    @Override
    public String toString() {
        return "R";
    }
}
