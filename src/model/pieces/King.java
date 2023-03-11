package model.pieces;

import model.ChessBoard;
import model.Position;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class King extends CastlablePiece {
    public King(ChessBoard chessboard, Color color) {
        super(chessboard, color);
    }

    // Acts like the move() in ChessPiece but with castling
    @Override
    public void move(Position position) {

        if (this.getLegalMoves().contains(position)) {

            // If the king is moving two spaces to the right, it is castling
            Position currentPosition = chessboard.getPosition(this);

            // following code assumes that castling is legal
            boolean castling = Math.abs(position.getFile() - currentPosition.getFile()) == 2;

            if (castling) {
                // Move the rook to the correct position

                // Check if castling king side or queen side
                boolean castlingKingSide = position.getFile() > currentPosition.getFile();

                int rookRank = color == Color.WHITE ? 0 : 7;
                int rookFile = castlingKingSide ? 7 : 0;

                Position rookPosition = new Position(rookRank, rookFile);
                Rook rook = (Rook) chessboard.getPiece(rookPosition);

                int newRookFile = castlingKingSide ? 5 : 3;

                Position newRookPosition = new Position(rookRank, newRookFile);

                rook.move(newRookPosition);
            }

            this.setPosition(position);
            this.moved = true;
        } else {
            throw new IllegalArgumentException("Illegal move.");
        }
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

        if (!hasMoved()) {
            theoreticalMoves.addAll(getLegalCastlingMoves());
        }

        return theoreticalMoves;
    }



    @Override
    public String toString() {
        return color == Color.WHITE ? "♚" : "♔";
    }
}
