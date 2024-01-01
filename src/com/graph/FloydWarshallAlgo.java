package com.graph;

import java.util.*;

public class FloydWarshallAlgo {

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
    void shortestPath(int n) {
        List<List<Integer>> dist = new ArrayList<>(n);
        for (int i = 0; i <= n; i++) {
            dist.add(new ArrayList<>(Collections.nCopies(n, Integer.MAX_VALUE)));
        }

        //diagonal pr zero mark kr do
        for (int i=0;i<n;i++){
            dist.get(i).set(i, 0);
        }
        //graph ke accroding dist insert kr diya
        for (Map.Entry<Integer, LinkedList<Pair>> entry : adjList.entrySet()){
            int u = entry.getKey();
            for (Pair neighbour : entry.getValue()){
                int v = neighbour.first;
                int wt = neighbour.second;
                dist.get(u).set(v,wt);
            }
        }
        // Floyd-Warshall algorithm
        for (int helper = 0; helper < n; helper++) {
            for (int src = 0; src < n; src++) {
                for (int dest = 0; dest < n; dest++) {
                    if (dist.get(src).get(helper) != Integer.MAX_VALUE &&
                            dist.get(helper).get(dest) != Integer.MAX_VALUE) {
                        dist.get(src).set(dest, Math.min(
                                dist.get(src).get(dest),
                                dist.get(src).get(helper) + dist.get(helper).get(dest)
                        ));
                    }
                }
            }
        }

        // Print the distance array
        System.out.println("Printing dist array:");
        for (List<Integer> row : dist) {
            for (int value : row) {
                System.out.print((value == Integer.MAX_VALUE ? "INF" : value) + ", ");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        FloydWarshallAlgo fa = new FloydWarshallAlgo();
        fa.addEdge(0,1,3,true);
        fa.addEdge(0,3,5,true);
        fa.addEdge(1,0,2,true);

        fa.addEdge(1,3,4,true);
        fa.addEdge(2,1,1,true);
        fa.addEdge(3,2,2,true);
        fa.printAdjacencyList();
        fa.shortestPath(5);

    }
}
