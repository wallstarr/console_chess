package model.pieces;

import model.ChessBoard;
import model.Position;

import java.util.Collection;

public class Pawn extends ChessPiece {
    public Pawn(ChessBoard chessboard, Color color) {
        super(chessboard, color);
    }

    @Override
    public void move(Position position) {
        // Get legal moves for this piece
        if (this.getLegalMoves().contains(position)) {
            this.setPosition(position);
        }

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
        return "p";
    }
}
