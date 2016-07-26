package com.company.jigsaw;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by vnagpurkar on 7/23/16.
 */
/*
Chaper 8 - 8.6 in cracking-the-coding-interview-5th-edition.pdf
Implement a jigsaw puzzle. Design the data structures and explain an algorithm
to solve the puzzle. You can assume that you have a fitsWith method which, when
passed two puzzle pieces, returns true if the two pieces belong together.
 */
public class Puzzle {

    // At begining of puzzle all pieces, will be remaining,
    // at the end of the puzzle only pieces which do not fit will remain
    private Set<Piece> remaining;
    private List<ArrayList<Piece>> solution;
    private Set<Piece> corners;
    private Set<Edge> inners;
    private Set<Edge> outers;

    public Puzzle(){

        remaining = new HashSet<Piece>();
        solution = new ArrayList<ArrayList<Piece>>();
        corners = new HashSet<Piece>();
        inners = new HashSet<Edge>();
        outers = new HashSet<Edge>();

    }

    // Sort all the edges in two groups, inners and outers
    // Sort corner pieces i.e pieces with two flat edges
    public void sort() {

        for(Piece p: remaining){

            if(p.isCorner()) {
                corners.add(p);
            }

            Edge[] edges = p.getEdges();
            for(Edge e: edges){
                if(e.getType() == EdgeType.INNER){
                    inners.add(e);
                } else if(e.getType() == EdgeType.OUTER){
                    outers.add(e);
                }
            }
        }

    }

    // start with corner pieces
    public void solve() {

        for(Piece p: corners) {

            Edge currentEdge = getExposedEdge(p);
            while(currentEdge != null) {

                Set<Edge> oppositeEdges = currentEdge.getType() == EdgeType.INNER ? outers : inners;
                for(Edge fittingEdge: oppositeEdges){

                    if(currentEdge.fitsWith(fittingEdge)){
                        currentEdge.setAttachedTo(fittingEdge);
                        oppositeEdges.remove(currentEdge);
                        oppositeEdges.remove(fittingEdge);
                    }
                    currentEdge = getNextExposedEdge(currentEdge);
                }
            }
        }
    }

    private Edge getExposedEdge(Piece p) {

        Edge[] edges = p.getEdges();
        for(Edge e: edges){
            if(e.getType() != EdgeType.FLAT && e.getAttachedTo() == null) {
                return e;
            }
        }
        return null;
    }

    // To find next exposed egde, first get opposite edge
    // For a piece with 4 edges if current egde is at index i then opposite edge will be at index = (i+2)%4
    // If that edge is exposed/available then we should return that
    // Else, we need to check for next exposed/available edge
    private Edge getNextExposedEdge(Edge currentEdge) {

        Edge[] edges  = currentEdge.getParent().getEdges();
        int nextEdgeIndex = (currentEdge.getIndex() + 2) % 4;

        if(edges[nextEdgeIndex].getAttachedTo() == null) {
            return edges[nextEdgeIndex];
        }
        return getExposedEdge(currentEdge.getParent());
    }
}

// for simpliciy Let's assume a piece has 4 edges,
// for corner piece, there will be two flat edges
class Piece {

    private Edge[] edges;
    private boolean isCorner = false;
    private Position absolutePosition;

    public Piece (Edge[] edges){

        this.edges = edges;
        int count = 0;
        for(Edge e: edges){

            if(count == 2) {
                isCorner = true;
            }
            else if(e.getType() == EdgeType.FLAT){
                count++;
            }
        }
    }

    public Edge[] getEdges(){

        return this.edges;
    }

    public boolean isCorner(){
        return this.isCorner;
    }

    public Position getAbsolutePosition() {
        return absolutePosition;
    }

    public void setAbsolutePosition(Position absolutePosition) {
        this.absolutePosition = absolutePosition;
    }
}

class Edge {

    private int index;
    private Piece parent;
    private EdgeType type;
    private Edge attachedTo = null; // position relative to a piece

    public Edge(int index, Piece parent, EdgeType type) {
        this.index = index;
        this.parent = parent;
        this.type = type;
    }

    public int getIndex() {
        return index;
    }

    public Piece getParent() {
        return parent;
    }

    public EdgeType getType() {
        return type;
    }

    public Edge getAttachedTo() {
        return attachedTo;
    }

    public void setAttachedTo(Edge attachedTo){

        this.attachedTo = attachedTo;
    }

    // returns true if the two pieces belong together, checks if this edge matches with secondEdge
    public boolean fitsWith(Edge secondEdge) {

        return true;
    }
}

enum EdgeType {

    FLAT,
    INNER,
    OUTER
}

class Position {

    private int x;
    private int y;

    public Position(int x, int y){

        this.x = x;
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }
}