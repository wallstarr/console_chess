package model;

public class Position {

    private final int rank;
    private final int file;

    public Position(String input) {
        if (input.length() != 2) {
            throw new IllegalArgumentException("Invalid position (Must be typed like 'A1')");
        }

        input = input.toUpperCase();

        char fileChar = input.charAt(0);
        char rankChar = input.substring(1).charAt(0);

        if (fileChar < 'A' || fileChar > 'H' || rankChar < '1' || rankChar > '8') {
            throw new IllegalArgumentException("Invalid position (Must be like 'A1')");
        }

        this.file = getFileFromChar(fileChar);
        this.rank = getRankFromChar(rankChar);
    }

    public Position(int rank, int file) {
        this.rank = rank;
        this.file = file;
    }

    public static boolean isOffBoard(Position position) {
        return position.getRank() < 0 || position.getRank() > 7 || position.getFile() < 0 || position.getFile() > 7;
    }

    private int getFileFromChar(char fileChar) {
        return fileChar - 'A';
    }

    private int getRankFromChar(char rankChar) {
        return rankChar - '1';
    }

    public int getFile() {
        return file;
    }

    public int getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return String.format("%c%d", (char) (file + 'A'), rank + 1);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Position other = (Position) obj;
        if (this.rank != other.rank) {
            return false;
        }
        return this.file == other.file;
    }
}
