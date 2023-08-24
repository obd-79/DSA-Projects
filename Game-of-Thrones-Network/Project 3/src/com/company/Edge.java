package com.company;

public class Edge {
    String Source ;
    int weight;
    String target;

    public Edge(String source, String target ,  int weight) {
        Source = source;
        this.weight = weight;
        this.target = target;
    }

    public void setSource(String source) {
        Source = source;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setTarget(String target) {
        this.target = target;
    }
}
