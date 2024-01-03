package com.graph;


import java.util.*;
//kosharaju Algorithm
public class StronglyConnectedComponents {
    HashMap<Integer, LinkedList<Integer>> adjList = new HashMap<>();
    void addEdge(int u, int v, boolean direction) {
        // Add edge from u to v
        adjList.computeIfAbsent(u, k -> new LinkedList<>()).add(v);
        // If the graph is undirected, add the reverse edge from v to u
        if (!direction) {
            adjList.computeIfAbsent(v, k -> new LinkedList<>()).add(u);
        }
    }
    void dfs(int src, Stack<Integer> st, HashMap<Integer, Boolean> visited) {
        visited.put(src, true);
        for (int nbr : adjList.getOrDefault(src, new LinkedList<>())) {
            if (!visited.getOrDefault(nbr, false)) {
                dfs(nbr, st, visited);
            }
        }
        st.add(src);
    }
    void dfs2(int src, HashMap<Integer, Boolean> visited2, HashMap<Integer, LinkedList<Integer>> adjNew) {
        visited2.put(src, true);
       // System.out.println(src);
        if (adjNew.containsKey(src)) {
            for (int nbr : adjNew.get(src)) {
                if (!visited2.containsKey(nbr)) {
                    dfs2(nbr, visited2, adjNew);
                }
            }
        }
    }
    int countSSC(int n) {
        Stack<Integer> st = new Stack<>();
        HashMap<Integer, Boolean> visited = new HashMap<>();
        // find topo ordering
        for (int i = 0; i < n; i++) {
            if (!visited.getOrDefault(i, false)) {
                dfs(i, st, visited);
            }
        }
        // reverse all edges
        HashMap<Integer, LinkedList<Integer>> adjNew = new HashMap<>();
        for (Map.Entry<Integer, LinkedList<Integer>> entry : adjList.entrySet()) {
            int u = entry.getKey();
            for (int v : entry.getValue()) {
                // v -> u insert
                if (!adjNew.containsKey(v)) {
                    adjNew.put(v, new LinkedList<>());
                }
                adjNew.get(v).add(u);
            }
        }
        // traverse using dfs
        int count = 0;
        HashMap<Integer, Boolean> visited2 = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!visited2.getOrDefault(i, false)) {
              //  System.out.println(count+1);
                dfs2(i, visited2, adjNew);
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        StronglyConnectedComponents sc = new StronglyConnectedComponents();
        sc.addEdge(0, 1, true);
        sc.addEdge(1, 2, true);
        sc.addEdge(2, 3, true);
        sc.addEdge(3, 0, true);
        sc.addEdge(2, 4, true);
        sc.addEdge(4, 5, true);
        sc.addEdge(5, 6, true);
        sc.addEdge(6, 4, true);
        sc.addEdge(6, 7, true);
        int n = 8;
        int count = sc.countSSC(n);
        System.out.println(count);
    }
}
