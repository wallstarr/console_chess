package ui;

public class ChessApp {

    public static void main(String[] args) {
        runChessGame();
    }

    private static void runChessGame() {

        ChessGame chessGame = new ChessGame();
        System.out.println("Let's play!");
        boolean gameNotFinished;

        do {
            gameNotFinished = chessGame.playerTakeTurn();
        } while (gameNotFinished);

    }

}