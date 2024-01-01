package com.graph;

import java.util.*;

public class BellmanFordAlgo {
    class Pair {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
    HashMap<Integer, LinkedList<Pair>> adjList = new HashMap<>();
    void addEdge(int u, int v, int weight, boolean direction) {
        adjList.computeIfAbsent(u, k -> new LinkedList<>()).add(new Pair(v, weight));
        if (!direction) {
            // undirected ke liye
            adjList.computeIfAbsent(v, k -> new LinkedList<>()).add(new Pair(u, weight));
        }
    }
    void printAdjacencyList() {
        for (Map.Entry<Integer, LinkedList<Pair>> entry : adjList.entrySet()) {
            System.out.print(entry.getKey() + "-> ");
            for (Pair neighbour : entry.getValue()) {
                System.out.print("(" + neighbour.first + ", " + neighbour.second + ")");
            }
            System.out.println();
        }
    }

    void shortestPath(int n ,int src){
        List<Integer>dist = new ArrayList<>(Collections.nCopies(n,Integer.MAX_VALUE));
        dist.set(src,0);
        //n-1 relation step
        for(int i=0;i<n-1;i++){
           //for all edges
            for(Map.Entry<Integer, LinkedList<Pair>> entry : adjList.entrySet()){
                int u = entry.getKey();
                for (Pair neighbour : entry.getValue()) {
                    int v = neighbour.first;
                    int wt = neighbour.second;
                    if (dist.get(u) != Integer.MAX_VALUE && dist.get(u) + wt < dist.get(v)) {
                        dist.set(v, dist.get(u) + wt);
                    }
                }
            }
        }

        //to check for -ve cycle
        boolean negativeCycle = false;
        for(Map.Entry<Integer, LinkedList<Pair>> entry : adjList.entrySet()){
            int u = entry.getKey();
            for (Pair neighbour : entry.getValue()) {
                int v = neighbour.first;
                int wt = neighbour.second;
                if (dist.get(u) != Integer.MAX_VALUE && dist.get(u) + wt < dist.get(v)) {
                    negativeCycle=true;
                    break;
                }
            }
        }
        if(negativeCycle){
            System.out.println("negative cycle present");
        }else {
            System.out.println("negative cycle not present");
        }
        // Print the distance array
        System.out.print("Printing dist array: ");
        for (int i : dist) {
            System.out.print(i + " ");
        }

    }
    public static void main(String[] args) {
        BellmanFordAlgo ba = new BellmanFordAlgo();
        ba.addEdge(0,1,-1,true);
        ba.addEdge(0,2,4,true);
        ba.addEdge(1,2,3,true);
        ba.addEdge(1,3,2,true);
        ba.addEdge(1,4,2,true);
        ba.addEdge(3,1,1,true);
        ba.addEdge(3,2,5,true);
        ba.addEdge(4,3,-3,true);

         ba.printAdjacencyList();
         ba.shortestPath(5,0);
    }
}
