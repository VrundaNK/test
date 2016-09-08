package com.company.othello;

import com.company.othello.COLOR;
/**
 * Created by vnagpurkar on 7/24/16.
 */
public class Player {

    private String userID;
    private String name;
    private Game[] games;

    private Game currentGame;
    private COLOR color;
    private int Score;

    public Player(String userID) {

        this.userID = userID;
    }

    public String getUserID() {
        return userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Game[] getGames() {
        return games;
    }

    public void setGames(Game[] games) {
        this.games = games;
    }

    public Game getCurrentGame() {
        return currentGame;
    }

    public void setCurrentGame(Game currentGame) {
        this.currentGame = currentGame;
    }

    public COLOR getColor() { return color;}

    public void setColor(COLOR color) {
        this.color = color;
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int score) {
        Score = score;
    }
}
