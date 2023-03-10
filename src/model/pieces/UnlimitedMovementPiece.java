package model.pieces;

import model.ChessBoard;
import model.Position;

import java.util.List;

public abstract class UnlimitedMovementPiece extends ChessPiece {
    public UnlimitedMovementPiece(ChessBoard chessboard, Color color) {
        super(chessboard, color);
    }

    protected void getLegalMovesForBishop(Position currentPosition, List<Position> theoreticalMoves) {
        for (int i = 1; i < 8; i++) {
            Position currentMove = new Position(currentPosition.getRank() + i, currentPosition.getFile() + i);
            if (checkIfPieceCannotKeepMovingLoopHelper(theoreticalMoves, currentMove)) break;
        }

        for (int i = 1; i < 8; i++) {
            Position currentMove = new Position(currentPosition.getRank() - i, currentPosition.getFile() + i);
            if (checkIfPieceCannotKeepMovingLoopHelper(theoreticalMoves, currentMove)) break;
        }

        for (int i = 1; i < 8; i++) {
            Position currentMove = new Position(currentPosition.getRank() + i, currentPosition.getFile() - i);
            if (checkIfPieceCannotKeepMovingLoopHelper(theoreticalMoves, currentMove)) break;
        }

        for (int i = 1; i < 8; i++) {
            Position currentMove = new Position(currentPosition.getRank() - i, currentPosition.getFile() - i);
            if (checkIfPieceCannotKeepMovingLoopHelper(theoreticalMoves, currentMove)) break;
        }
    }

    protected void getLegalMovesForRook(Position currentPosition, List<Position> theoreticalMoves) {
        for (int i = 1; i < 8; i++) {
            Position currentMove = new Position(currentPosition.getRank() + i, currentPosition.getFile());
            if (checkIfPieceCannotKeepMovingLoopHelper(theoreticalMoves, currentMove)) break;
        }

        for (int i = 1; i < 8; i++) {
            Position currentMove = new Position(currentPosition.getRank() - i, currentPosition.getFile());
            if (checkIfPieceCannotKeepMovingLoopHelper(theoreticalMoves, currentMove)) break;
        }

        for (int i = 1; i < 8; i++) {
            Position currentMove = new Position(currentPosition.getRank(), currentPosition.getFile() + i);
            if (checkIfPieceCannotKeepMovingLoopHelper(theoreticalMoves, currentMove)) break;
        }

        for (int i = 1; i < 8; i++) {
            Position currentMove = new Position(currentPosition.getRank(), currentPosition.getFile() - i);
            if (checkIfPieceCannotKeepMovingLoopHelper(theoreticalMoves, currentMove)) break;
        }
    }

    protected boolean checkIfPieceCannotKeepMovingLoopHelper(List<Position> theoreticalMoves, Position positionMovingTo) {
        if (checkIfValidMove(positionMovingTo)) {
            theoreticalMoves.add(positionMovingTo);
            // Check if the move moves to a square occupied by a piece of the opposite color
            return chessboard.isOccupiedByColor(positionMovingTo, color.getOppositeColor());
        } else {
            return true;
        }
    }
}
