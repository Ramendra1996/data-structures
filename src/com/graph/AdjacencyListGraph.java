package com.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;


public class AdjacencyListGraph {

    // Adjacency list representation using HashMap
    HashMap<Integer, LinkedList<Integer>> adjList = new HashMap<>();

    // Method to add an edge to the graph
    void addEdge(int u, int v, boolean direction) {
        // Add edge from u to v
        adjList.computeIfAbsent(u, k -> new LinkedList<>()).add(v);

        // If the graph is undirected, add the reverse edge from v to u
        if (!direction) {
            adjList.computeIfAbsent(v, k -> new LinkedList<>()).add(u);
        }
    }

    // Method to print the adjacency list
    void printAdjacencyList() {
        for (Map.Entry<Integer, LinkedList<Integer>> entry : adjList.entrySet()) {
            System.out.print(entry.getKey() + "-> ");
            for (Integer neighbour : entry.getValue()) {
                System.out.print(neighbour + ", ");
            }
            System.out.println();
        }
    }

    // Breadth-First Search (BFS) traversal of the graph
    void bfs(Integer src, HashMap<Integer, Boolean> visited) {
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        visited.put(src, true);
        while (!q.isEmpty()) {
            Integer frontNode = q.poll();
            System.out.print(frontNode + ", ");
            // Check if the current node has neighbors before iterating
            if (adjList.containsKey(frontNode)) {
                for (Integer neighbour : adjList.get(frontNode)) {
                    if (!visited.getOrDefault(neighbour, false)) {
                        q.add(neighbour);
                        visited.put(neighbour, true);
                    }
                }
            }
        }
    }

    // Depth-First Search (DFS) traversal of the graph
    void dfs(Integer src, HashMap<Integer, Boolean> visited) {
        visited.put(src, true);

        // Check if the current node has neighbors before iterating
        if (adjList.containsKey(src)) {
            for (Integer neighbour : adjList.get(src)) {
                if (!visited.getOrDefault(neighbour, false)) {
                    dfs(neighbour, visited);
                }
            }
        }

        System.out.print(src + ", ");
    }

    public static void main(String[] args) {
        AdjacencyListGraph g = new AdjacencyListGraph();

        // Number of nodes in the graph
        int n = 5;

        // Adding edges to the graph
        g.addEdge(0, 1, false);
        g.addEdge(1, 3, false);
        g.addEdge(0, 2, false);
        g.addEdge(2, 4, false);

        // Printing the adjacency list
        System.out.println("Adjacency List:");
        g.printAdjacencyList();
        System.out.println();

        // Breadth-First Search (BFS) traversal
        HashMap<Integer, Boolean> visitedBFS = new HashMap<>();
        System.out.println("Printing BFS Traversal:");
        for (int i = 0; i < n; i++) {
            if (!visitedBFS.containsKey(i)) {
                g.bfs(i, visitedBFS);
            }
        }

        // Depth-First Search (DFS) traversal
        System.out.println("\nPrinting DFS Traversal:");
        HashMap<Integer, Boolean> visitedDFS = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!visitedDFS.containsKey(i)) {
                g.dfs(i, visitedDFS);
            }
        }
    }
}


//sc->0(n2),0(v2)(worst case)
//sc->0(v+e)(avg case)


/*
  T ki jagha bo likh dege jis type ka data dalna ho
class Graph<T> {
    HashMap<T, LinkedList<T>> adjList = new HashMap<>();

    void addEdge(T u, T v, boolean direction) {
        adjList.computeIfAbsent(u, k -> new LinkedList<>()).add(v);
        if (!direction) {
            adjList.computeIfAbsent(v, k -> new LinkedList<>()).add(u);
        }
    }

    void printAdjacencyList() {
        for (Map.Entry<T, LinkedList<T>> entry : adjList.entrySet()) {
            System.out.print(entry.getKey() + "-> ");
            for (T neighbour : entry.getValue()) {
                System.out.print(neighbour + ", ");
            }
            System.out.println();
        }
    }

    void bfs(T src, HashMap<T, Boolean> visited) {
        Queue<T> q = new LinkedList<>();

        q.add(src);
        visited.put(src, true);

        while (!q.isEmpty()) {
            T frontNode = q.poll();
            System.out.print(frontNode + ", ");

            for (T neighbour : adjList.get(frontNode)) {
                if (!visited.get(neighbour)) {
                    q.add(neighbour);
                    visited.put(neighbour, true);
                }
            }
        }
    }

    void dfs(T src, HashMap<T, Boolean> visited) {
        System.out.print(src + ", ");
        visited.put(src, true);

        for (T neighbour : adjList.get(src)) {
            if (!visited.get(neighbour)) {
                dfs(neighbour, visited);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Graph<Integer> g = new Graph<>();
        int n = 5;
        g.addEdge(0, 1, false);
        g.addEdge(1, 3, false);
        g.addEdge(0, 2, false);
        g.addEdge(2, 4, false);

        g.printAdjacencyList();
        System.out.println();

        HashMap<Integer, Boolean> visited = new HashMap<>();
        System.out.println("Printing BFS Traversal: ");
        for (int i = 0; i < n; i++) {
            if (!visited.containsKey(i)) {
                g.bfs(i, visited);
            }
        }
        System.out.println("\nPrinting DFS Traversal: ");
        HashMap<Integer, Boolean> visited2 = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!visited2.containsKey(i)) {
                g.dfs(i, visited2);
            }
        }
    }
}*/

