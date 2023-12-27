package com.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class AdjacencyListGraphWithWeight {
    class Pair{
        int first ;
        int second;
        Pair(int first, int second){
            this.first=first;
            this.second =second;
        }
    }
    HashMap<Integer, LinkedList<Pair>> adjList = new HashMap<>();
    void addEdge(int u, int  v, int weight,boolean direction) {
        adjList.computeIfAbsent(u, k -> new LinkedList<>()).add(new Pair(v,weight));
        if (!direction) {
            //undirected ke liye
            adjList.computeIfAbsent(v, k -> new LinkedList<>()).add(new Pair(u,weight));
        }
    }
    void printAdjacencyList() {
        for (Map.Entry<Integer, LinkedList<Pair>> entry : adjList.entrySet()) {
            System.out.print(entry.getKey() + "-> ");
            for (Pair neighbour : entry.getValue()) {
                System.out.print("("+neighbour.first + ", "+neighbour.second+")");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        AdjacencyListGraphWithWeight g = new AdjacencyListGraphWithWeight();
        g.addEdge(0, 1, 5,false);
        g.addEdge(1, 3, 4,false);
        g.addEdge(0, 2, 7,false);
        g.addEdge(2, 4, 3,false);
        g.printAdjacencyList();
        System.out.println();
    }
}
