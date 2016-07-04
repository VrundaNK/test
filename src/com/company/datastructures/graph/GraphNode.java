package com.company.datastructures.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vnagpurkar on 6/19/16.
 */
public class GraphNode {

    int value;
    ArrayList<GraphNode> adj;
    boolean visited;
    boolean isVisiting;

    GraphNode(int value) {
        this.value = value;
        this.adj = new ArrayList<GraphNode>();
        this.visited = false;
    }

    public int getValue() {
        return this.value;
    }

    public List<GraphNode> getAdj(){
        return this.adj;
    }

    public void setVisited(boolean visited){
        this.visited = visited;
    }

    public boolean getVisited() {
        return this.visited;
    }

    public void setVisiting(boolean isVisiting){
        this.isVisiting = isVisiting;
    }

    public boolean getVisiting() {
        return this.isVisiting;
    }

}
