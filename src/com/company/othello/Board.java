package com.company.othello;

/**
 * Created by vnagpurkar on 7/24/16.
 */
public class Board {

    private int rows;
    private int columns;
    private Piece[][] pieces;
    private int blackCount;
    private int whiteCount;

    public Board(int rows, int columns) {

        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
        blackCount = 0;
        whiteCount = 0;
    }

    public void intialiseBoard(){


    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public Piece[][] getPieces() {
        return pieces;
    }

    public int getBlackCount(){
        return blackCount;
    }

    public int getWhiteCount(){
        return whiteCount;
    }

}
