package com.graph;

import java.util.*;

public class TopologicalSort {
    HashMap<Integer, LinkedList<Integer>> adjList = new HashMap<>();

    void addEdge(int u, int v, boolean direction) {
        // Add edge from u to v
        adjList.computeIfAbsent(u, k -> new LinkedList<>()).add(v);

        // If the graph is undirected, add the reverse edge from v to u
        if (!direction) {
            adjList.computeIfAbsent(v, k -> new LinkedList<>()).add(u);
        }
    }

    void toPoSortDFS(Integer src, HashMap<Integer, Boolean> visited, Stack<Integer>ans){
        visited.put(src, true);
        // Check if the current node has neighbors before iterating
        if (adjList.containsKey(src)) {
            for (Integer neighbour : adjList.get(src)) {
                if (!visited.getOrDefault(neighbour, false)) {
                    toPoSortDFS(neighbour, visited,ans);
                }
            }
        }
        //while returning ,store the node in stack
        ans.add(src);
    }
    void toPoSortBFS(int n,List<Integer> ans){
        Queue<Integer>q = new LinkedList<>();
        Map<Integer, Integer> indegree = new HashMap<>();
        // Indegree calculation
        for (Map.Entry<Integer, LinkedList<Integer>> entry : adjList.entrySet()) {
            int src = entry.getKey();
            for (int nbr : entry.getValue()) {
                indegree.put(nbr, indegree.getOrDefault(nbr, 0) + 1);
            }
        }
        // Put all nodes inside the queue, which has indegree=0
        for (int i = 0; i < n; i++) {
            if (!indegree.containsKey(i) || indegree.get(i) == 0) {
                q.add(i);
            }
        }
        // BFS logic
        while (!q.isEmpty()) {
            int fNode = q.poll();
            ans.add(fNode);
           //or we can do count++
            for (int nbr : adjList.getOrDefault(fNode,new LinkedList<>())) {
                indegree.put(nbr, indegree.get(nbr) - 1);
                // Check for zero again
                if (indegree.get(nbr) == 0) {
                    q.add(nbr);
                }
            }
        }

    }
    public static void main(String[] args) {
        TopologicalSort ts = new TopologicalSort();
        int n = 8;
        ts.addEdge(0,1,true);
        ts.addEdge(1,2,true);
        ts.addEdge(2,3,true);
        ts.addEdge(3,4,true);
        ts.addEdge(3,5,true);
        ts.addEdge(4,6,true);
        ts.addEdge(5,6,true);
        ts.addEdge(6,7,true);

        HashMap<Integer,Boolean>visited = new HashMap<>();
        Stack<Integer> ans = new Stack<>();
        for (int i =0;i<n;i++){
            if(!visited.containsKey(i)){
                ts.toPoSortDFS(i,visited,ans);
            }
        }
        System.out.println("Topology sort");
        while (!ans.isEmpty()){
            System.out.print(ans.pop()+" ");

        }

        System.out.println("\n_________________________");
        List<Integer>bfsAns = new ArrayList<>();
        //connected ke liye or disconnected
            ts.toPoSortBFS(n,bfsAns);

            if(bfsAns.size()==n){
                System.out.println("valid toposort ,cyclic not present");
            }else {
                System.out.println("cyclic present");
            }

        
        for (int i:bfsAns){
            System.out.print(i+" ");
        }
    }
}
