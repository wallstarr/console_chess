package model.pieces;

import model.ChessBoard;
import model.Position;

import java.util.Collection;

public abstract class ChessPiece {

    public enum Color {
        WHITE, BLACK;

        public Color getOppositeColor() {
            return this == WHITE ? BLACK : WHITE;
        }
    }

    protected final Color color;

    protected final ChessBoard chessboard;

    protected boolean moved = false;

    public ChessPiece(ChessBoard chessboard, Color color) {
        this.chessboard = chessboard;
        this.color = color;
    }

    public void move(Position position) {
        if (this.getLegalMoves().contains(position)) {
            this.setPosition(position);
            this.moved = true;
        } else {
            throw new IllegalArgumentException("Illegal move.");
        }
    }

    abstract public Collection<Position> getLegalMoves();
    protected void setPosition(Position position) {
        Position previousPosition = chessboard.getPosition(this);
        chessboard.removePieceAtPosition(previousPosition);
        chessboard.setPieceAtPosition(this, position);
    }

    protected boolean checkIfValidMove(Position currentMove) {
        return !Position.isOffBoard(currentMove) && !chessboard.isOccupiedByColor(currentMove, color);
    }

    abstract public String toString();

    public Color getColor() {
        return color;
    }

    public boolean hasMoved() {
        return moved;
    }

}
