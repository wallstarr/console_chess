package model.pieces;

import model.ChessBoard;
import model.Position;

import java.util.Collection;

public abstract class ChessPiece {

    public enum Color {
        WHITE, BLACK
    }

    protected final Color color;

    protected final ChessBoard chessboard;

    public ChessPiece(ChessBoard chessboard, Color color) {
        this.chessboard = chessboard;
        this.color = color;
    }

    public void move(Position position) {
        if (this.getLegalMoves().contains(position)) {
            this.setPosition(position);
        }
        // Otherwise throw an exception
        else {
            throw new IllegalArgumentException("Illegal move.");
        }
    }

    abstract public Collection<Position> getLegalMoves();
    protected void setPosition(Position position) {
        Position previousPosition = chessboard.getPosition(this);
        chessboard.removePieceAtPosition(previousPosition);
        chessboard.setPieceAtPosition(this, position);
    }

    abstract public String toString();

    public Color getColor() {
        return color;
    }


}
