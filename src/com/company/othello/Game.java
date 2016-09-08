package com.company.othello;

/**
 * Created by vnagpurkar on 7/24/16.
 */
public class Game {

    private static Game instance;
    private Player whitePlayer;
    private Player blackPlayer;
    private Board board;
    private Player winner;
    private boolean isDraw;

    // prevents other class from instantiating Game
    private Game(){
        isDraw = false;
    }

    public static Game getInstance() {

        if(instance == null) {
            instance = new Game();
        }
        return instance;
    }

    public void assignPlayers(Player whitePlayer, Player blackPlayer) {
        this.whitePlayer = whitePlayer;
        this.blackPlayer= blackPlayer;
    }

    public void start() {
        if(this.whitePlayer == null || this.blackPlayer == null) {
            System.out.println("Assign players first");
            return;
        }
    }

    public void end(){

    }

    public void setWinner() {

        if(whitePlayer.getScore() > blackPlayer.getScore()) {
            this.winner = whitePlayer;
        } else if (whitePlayer.getScore() < blackPlayer.getScore()) {
            winner = blackPlayer;
        } else {
            winner = null;
            isDraw = true;
        }
    }

}
