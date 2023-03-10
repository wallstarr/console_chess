package model.pieces;

import model.ChessBoard;
import model.Position;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class King extends ChessPiece {
    public King(ChessBoard chessboard, Color color) {
        super(chessboard, color);
    }

    @Override
    public Collection<Position> getLegalMoves() {
        Position currentPosition = chessboard.getPosition(this);

        // Kings can only move one square in any direction
        List<Position> theoreticalMoves = new ArrayList<>(List.of(
                new Position(currentPosition.getRank() + 1, currentPosition.getFile()),
                new Position(currentPosition.getRank() - 1, currentPosition.getFile()),
                new Position(currentPosition.getRank(), currentPosition.getFile() + 1),
                new Position(currentPosition.getRank(), currentPosition.getFile() - 1),
                new Position(currentPosition.getRank() + 1, currentPosition.getFile() + 1),
                new Position(currentPosition.getRank() + 1, currentPosition.getFile() - 1),
                new Position(currentPosition.getRank() - 1, currentPosition.getFile() + 1),
                new Position(currentPosition.getRank() - 1, currentPosition.getFile() - 1)
        ));

        theoreticalMoves.removeIf(position -> !checkIfValidMove(position));

        return theoreticalMoves;
    }

    @Override
    protected void setPosition(Position position) {

    }

    @Override
    public String toString() {
        return "K";
    }
}
