package model.pieces;

import model.ChessBoard;
import model.Position;

import java.util.ArrayList;
import java.util.List;

public abstract class CastlablePiece extends ChessPiece {

    public CastlablePiece(ChessBoard chessboard, Color color) {
        super(chessboard, color);
    }

    protected List<Position> getLegalCastlingMoves() {
        List<Position> legalCastlingMoves = new ArrayList<>();

        if (canCastleKingSide()) {
            legalCastlingMoves.add(new Position(chessboard.getPosition(this).getRank(), chessboard.getPosition(this).getFile() + 2));
        }

        if (canCastleQueenSide()) {
            legalCastlingMoves.add(new Position(chessboard.getPosition(this).getRank(), chessboard.getPosition(this).getFile() - 2));
        }

        return legalCastlingMoves;
    }

    public boolean canCastleKingSide() {

        // Todo: Check if opposing piece threatening square for castling

        if (hasMoved()) return false;

        Position positionOfKingSideRook;

        positionOfKingSideRook = color == Color.WHITE ? new Position(0, 7) : new Position(7, 7);

        ChessPiece piece = chessboard.getPiece(positionOfKingSideRook);

        if (!(piece instanceof Rook) || piece.hasMoved()) return false;

        return checkIfPathIsClearForKingSideCastling();

    }

    public boolean canCastleQueenSide() {

        // Todo: Check if opposing piece threatening square for castling

        if (hasMoved()) return false;

        Position positionOfQueenSideRook;

        positionOfQueenSideRook = color == Color.WHITE ? new Position(0, 0) : new Position(7, 0);

        ChessPiece piece = chessboard.getPiece(positionOfQueenSideRook);

        if (!(piece instanceof Rook) || piece.hasMoved() || color != piece.color) return false;

        return checkIfPathIsClearForQueenSideCastling();

    }

    private boolean checkIfPathIsClearForKingSideCastling() {
        // Check the two squares between the king and the rook
        Position positionOfFirstSquareBetweenKingAndRook = color == Color.WHITE ? new Position(0, 5) : new Position(7, 5);
        Position positionOfSecondSquareBetweenKingAndRook = color == Color.WHITE ? new Position(0, 6) : new Position(7, 6);

        return !chessboard.isOccupied(positionOfFirstSquareBetweenKingAndRook) &&
                !chessboard.isOccupied(positionOfSecondSquareBetweenKingAndRook);
    }

    private boolean checkIfPathIsClearForQueenSideCastling() {
        // Check the three squares between the king and the rook
        Position positionOfFirstSquareBetweenKingAndRook = color == Color.WHITE ? new Position(0, 3) : new Position(7, 3);
        Position positionOfSecondSquareBetweenKingAndRook = color == Color.WHITE ? new Position(0, 2) : new Position(7, 2);
        Position positionOfThirdSquareBetweenKingAndRook = color == Color.WHITE ? new Position(0, 1) : new Position(7, 1);

        return !chessboard.isOccupied(positionOfFirstSquareBetweenKingAndRook) &&
                !chessboard.isOccupied(positionOfSecondSquareBetweenKingAndRook) &&
                !chessboard.isOccupied(positionOfThirdSquareBetweenKingAndRook);
    }


}
