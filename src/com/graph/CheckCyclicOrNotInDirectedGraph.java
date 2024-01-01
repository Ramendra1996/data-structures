package com.graph;

import java.util.HashMap;
import java.util.LinkedList;

public class CheckCyclicOrNotInDirectedGraph {
    HashMap<Integer, LinkedList<Integer>> adjList = new HashMap<>();

    void addEdge(int u, int v, boolean direction) {
        // Add edge from u to v
        adjList.computeIfAbsent(u, k -> new LinkedList<>()).add(v);

        // If the graph is undirected, add the reverse edge from v to u
        if (!direction) {
            adjList.computeIfAbsent(v, k -> new LinkedList<>()).add(u);
        }
    }

    boolean checkCyclicUsingDfs(int src, HashMap<Integer, Boolean> visited, HashMap<Integer, Boolean> visitedDFS) {
        visited.put(src, true);
        visitedDFS.put(src, true);
        for (int nbr : adjList.getOrDefault(src, new LinkedList<>())) {
            if (!visited.getOrDefault(nbr, false)) {
                boolean aageKaAnswer = checkCyclicUsingDfs(nbr, visited, visitedDFS);
                if (aageKaAnswer) {
                    return true;
                }
            }
            if (visited.getOrDefault(nbr, false) && visitedDFS.getOrDefault(nbr, false)) {
                return true;
            }
        }

        // Reset the dfsVisited status when backtracking
        visitedDFS.put(src, false);
        return false;
    }

    public static void main(String[] args) {
        CheckCyclicOrNotInDirectedGraph g = new CheckCyclicOrNotInDirectedGraph();
        int n =5;
         g.addEdge(0,1,true);
         g.addEdge(1,2,true);
         g.addEdge(2,3,true);
         g.addEdge(3,4,true);
     //    g.addEdge(4,0,true);

         boolean ans = false;
        HashMap<Integer, Boolean> visited = new HashMap<>();
        HashMap<Integer, Boolean> visitedDFS = new HashMap<>();

        for(int i=0;i<n;i++){
            if(!visited.containsKey(i)){
                ans = g.checkCyclicUsingDfs(i,visited,visitedDFS);
                if(ans==true){
                    break;
                }
            }
        }
        if(ans){
            System.out.println("cyclic");
        }else {
            System.out.println("not cyclic");
        }
    }
}
