package com.pack.stonepaprescissor;

public class GameResult {
    private final String result;
    private final int computerPoints;
    private final int playerPoints;

    public GameResult(String result, int computerPoints, int playerPoints) {
        this.result = result;
        this.computerPoints = computerPoints;
        this.playerPoints = playerPoints;
    }

    public String getResult() {
        return result;
    }

    public int getComputerPoints() {
        return computerPoints;
    }

    public int getPlayerPoints() {
        return playerPoints;
    }
}
