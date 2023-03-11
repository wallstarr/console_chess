package model;

import model.pieces.*;

public class ChessBoard {

    private final ChessPiece[][] boardRepresentation;

    public ChessBoard() {
        this.boardRepresentation = new ChessPiece[8][8];
        initializeDefaultStartingPieces();
    }

    public Position getPosition(ChessPiece piece) {
        for (int i = 0; i < boardRepresentation.length; i++) {
            for (int j = 0; j < boardRepresentation[i].length; j++) {
                if (boardRepresentation[i][j] == piece) {
                    return new Position(i, j);
                }
            }
        }
        return null;
    }

    public ChessPiece getPiece(Position position) {
        ChessPiece piece = boardRepresentation[position.getRank()][position.getFile()];
        if (piece == null) {
            throw new IllegalArgumentException("No piece at position " + position);
        }
        return boardRepresentation[position.getRank()][position.getFile()];
    }
    public void removePieceAtPosition(Position previousPosition) {
        boardRepresentation[previousPosition.getRank()][previousPosition.getFile()] = null;
    }

    public void setPieceAtPosition(ChessPiece piece, Position position) {
        boardRepresentation[position.getRank()][position.getFile()] = piece;
    }

    public boolean isOccupied(Position position) {
        return boardRepresentation[position.getRank()][position.getFile()] != null;
    }

    // Returns true if the position is occupied by a piece of the specified color
    public boolean isOccupiedByColor(Position position, ChessPiece.Color color) {
        return isOccupied(position) && getPiece(position).getColor() == color;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (int RANK = 7; RANK >= 0; RANK--) {
            builder.append(RANK + 1).append("   ");
            for (int FILE = 0; FILE < 8; FILE++) {
                if (boardRepresentation[RANK][FILE] != null) {
                    builder.append(String.format(" %s ", boardRepresentation[RANK][FILE]));
                } else {
                    if ((RANK + FILE) % 2 == 0) {
                        builder.append(" - ");
                    } else {
                        builder.append(" . ");
                    }
                }
            }
            builder.append("\n");
        }
        builder.append("\n     a  b  c  d  e  f  g  h");
        return builder.toString();
    }

    public String toStringBlack() {
        StringBuilder builder = new StringBuilder();

        for (int RANK = 0; RANK < 8; RANK++) {
            builder.append(RANK + 1).append("   ");
            for (int FILE = 7; FILE >= 0; FILE--) {
                if (boardRepresentation[RANK][FILE] != null) {
                    builder.append(String.format(" %s ", boardRepresentation[RANK][FILE]));
                } else {
                    if ((RANK + FILE) % 2 == 0) {
                        builder.append(" - ");
                    } else {
                        builder.append(" . ");
                    }
                }
            }
            builder.append("\n");
        }
        builder.append("\n     h  g  f  e  d  c  b  a");
        return builder.toString();
    }

    private void initializeDefaultStartingPieces() {
        boardRepresentation[1][0] = new Pawn(this, ChessPiece.Color.WHITE);
        boardRepresentation[1][1] = new Pawn(this, ChessPiece.Color.WHITE);
        boardRepresentation[1][2] = new Pawn(this, ChessPiece.Color.WHITE);
        boardRepresentation[1][3] = new Pawn(this, ChessPiece.Color.WHITE);
        boardRepresentation[1][4] = new Pawn(this, ChessPiece.Color.WHITE);
        boardRepresentation[1][5] = new Pawn(this, ChessPiece.Color.WHITE);
        boardRepresentation[1][6] = new Pawn(this, ChessPiece.Color.WHITE);
        boardRepresentation[1][7] = new Pawn(this, ChessPiece.Color.WHITE);

        boardRepresentation[6][0] = new Pawn(this, ChessPiece.Color.BLACK);
        boardRepresentation[6][1] = new Pawn(this, ChessPiece.Color.BLACK);
        boardRepresentation[6][2] = new Pawn(this, ChessPiece.Color.BLACK);
        boardRepresentation[6][3] = new Pawn(this, ChessPiece.Color.BLACK);
        boardRepresentation[6][4] = new Pawn(this, ChessPiece.Color.BLACK);
        boardRepresentation[6][5] = new Pawn(this, ChessPiece.Color.BLACK);
        boardRepresentation[6][6] = new Pawn(this, ChessPiece.Color.BLACK);
        boardRepresentation[6][7] = new Pawn(this, ChessPiece.Color.BLACK);

        boardRepresentation[0][0] = new Rook(this, ChessPiece.Color.WHITE);
        boardRepresentation[7][0] = new Rook(this, ChessPiece.Color.BLACK);
        boardRepresentation[0][7] = new Rook(this, ChessPiece.Color.WHITE);
        boardRepresentation[7][7] = new Rook(this, ChessPiece.Color.BLACK);

//        boardRepresentation[0][1] = new Knight(this, ChessPiece.Color.WHITE);
//        boardRepresentation[0][6] = new Knight(this, ChessPiece.Color.WHITE);
        boardRepresentation[7][1] = new Knight(this, ChessPiece.Color.BLACK);
        boardRepresentation[7][6] = new Knight(this, ChessPiece.Color.BLACK);

//        boardRepresentation[0][2] = new Bishop(this, ChessPiece.Color.WHITE);
//        boardRepresentation[0][5] = new Bishop(this, ChessPiece.Color.WHITE);
        boardRepresentation[7][2] = new Bishop(this, ChessPiece.Color.BLACK);
        boardRepresentation[7][5] = new Bishop(this, ChessPiece.Color.BLACK);

//        boardRepresentation[0][3] = new Queen(this, ChessPiece.Color.WHITE);
        boardRepresentation[7][3] = new Queen(this, ChessPiece.Color.BLACK);

        boardRepresentation[0][4] = new King(this, ChessPiece.Color.WHITE);
        boardRepresentation[7][4] = new King(this, ChessPiece.Color.BLACK);
    }
}
