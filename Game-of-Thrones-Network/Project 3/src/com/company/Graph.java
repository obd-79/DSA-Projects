package com.company;

import java.util.*;

public class Graph {
    int vertices;
    LinkedList<Edge> [] adjacencylist;

    Graph(int vertices) {
        this.vertices = vertices;
        adjacencylist = new LinkedList[vertices];
        for (int i = 0; i <vertices ; i++) {
            adjacencylist[i] = new LinkedList<>();
        }
    }

    public void addEgde(String source, String destination, int weight) {
        Edge edge = new Edge(source.toLowerCase(Locale.ROOT), destination.toLowerCase(Locale.ROOT), weight);
        adjacencylist[Math.abs(source.hashCode()%vertices)].addFirst(edge);
    }

    public void NumberOfCharacterGroups(){
        for (int i = 0; i <vertices ; i++) {
            LinkedList<Edge> list = adjacencylist[i];
            for (int j = 0; j <list.size() ; j++) {
                System.out.println ("vertex-"+ i +" "+" ("+list.get(j).Source+")"+ " is connected to " +
                        list.get(j).target + " with weight " + list.get(j).weight);
            }
        }
    }
    public void PrintWithBFS(String s){
        boolean visited[] = new boolean[vertices];
        LinkedList<String> queue = new LinkedList<String>();
        visited[Math.abs(s.toLowerCase(Locale.ROOT).hashCode() % vertices)] = true;
        queue.add(s.toLowerCase(Locale.ROOT));
        while (queue.size() != 0) {
            s = queue.poll();
            System.out.print(s + " ");
            Iterator<Edge> i = adjacencylist[Math.abs(s.toLowerCase(Locale.ROOT).hashCode() % vertices)].listIterator();
            while (i.hasNext()) {
                String n = i.next().target;
                if (!visited[Math.abs(n.toLowerCase(Locale.ROOT).hashCode() % vertices)]) {
                    visited[Math.abs(n.toLowerCase(Locale.ROOT).hashCode() % vertices)] = true;
                    queue.add(n);
                }
            }
        }
    }

    public void printClosetCharacter(String character , int threshold){
        int hash = Math.abs(character.toLowerCase(Locale.ROOT).hashCode()%vertices);
        LinkedList<Edge> list = adjacencylist[hash];
        int min = Integer.MAX_VALUE;
        Edge edge = list.getFirst();
        for (int i = 0 ; i < list.size() ; i++){
            if (min > list.get(i).weight){
                min = list.get(i).weight;
                edge = list.get(i);
            }
        }
        System.out.println("the closer character for " + character + " is " + edge.target);
    }
    public void printFartherCharacter(String character , int threshold){
        int hash = Math.abs(character.toLowerCase(Locale.ROOT).hashCode()%vertices);
        LinkedList<Edge> list = adjacencylist[hash];
        int max = Integer.MIN_VALUE;
        Edge edge = list.getFirst();
        for (int i = 0 ; i < list.size() ; i++){
            if (max < list.get(i).weight){
                max = list.get(i).weight;
                edge = list.get(i);
            }
        }
        System.out.println("the farthest character for " + character + " is " + edge.target);
    }

    public boolean delete(String character1 , String character2){
        int hashKeyFor1 = Math.abs(character1.toLowerCase(Locale.ROOT).hashCode()%vertices);
        boolean found = false;
        for (int i =0 ; i < adjacencylist[hashKeyFor1].size() ; i ++){
            if (adjacencylist[hashKeyFor1].get(i).Source.equals(character1.toLowerCase(Locale.ROOT)) &&adjacencylist[hashKeyFor1].get(i).target.equals(character2.toLowerCase(Locale.ROOT)) ){
                adjacencylist[hashKeyFor1].remove(i);
                found = true;
                break;
            }
        }
        return found;
    }
    public boolean change(String Source , String target , int weight){
        int hashedKey = Math.abs(Source.toLowerCase(Locale.ROOT).hashCode()%vertices);
        boolean found = false;
        for (int i = 0 ; i < adjacencylist[hashedKey].size() ; i ++){
            if (adjacencylist[hashedKey].get(i).Source.equals(Source.toLowerCase(Locale.ROOT)) &&adjacencylist[hashedKey].get(i).target.equals(target.toLowerCase(Locale.ROOT)) ) {
                adjacencylist[hashedKey].get(i).setSource(Source.toLowerCase(Locale.ROOT));
                adjacencylist[hashedKey].get(i).setTarget(target.toLowerCase(Locale.ROOT));
                adjacencylist[hashedKey].get(i).setWeight(weight);
                found  = true;
                break;
            }
        }
        return found;
    }
           public boolean isConnected(String Character1 , String Character2){
        LinkedList<Edge> temp;
        boolean visited[] = new boolean[vertices];
        LinkedList<String> queue= new LinkedList<>();
        visited[Math.abs(Character1.toLowerCase(Locale.ROOT).hashCode()%vertices)] = true;
        queue.add(Character1.toLowerCase(Locale.ROOT));
        Iterator<Edge>i;
        while (queue.size()!=0){
            Character1 = queue.poll();
            String n;
            i = adjacencylist[Math.abs(Character1.toLowerCase(Locale.ROOT).hashCode()%vertices)].listIterator();
            while (i.hasNext()){
                n = i.next().target.toLowerCase(Locale.ROOT);
                if (n.equals(Character2.toLowerCase(Locale.ROOT))){
                    return true;
                }
                if (!visited[Math.abs(n.toLowerCase(Locale.ROOT).hashCode()%vertices)]){
                    visited[Math.abs(n.toLowerCase(Locale.ROOT).hashCode()%vertices)] = true;
                    queue.add(n.toLowerCase(Locale.ROOT));
                }
            }
        }
        return false;
    }





}
