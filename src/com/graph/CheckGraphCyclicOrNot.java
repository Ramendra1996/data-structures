package com.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class CheckGraphCyclicOrNot {
    HashMap<Integer, LinkedList<Integer>> adjList = new HashMap<>();
    void addEdge(int u, int v, boolean direction) {
        // Add edge from u to v
        adjList.computeIfAbsent(u, k -> new LinkedList<>()).add(v);

        // If the graph is undirected, add the reverse edge from v to u
        if (!direction) {
            adjList.computeIfAbsent(v, k -> new LinkedList<>()).add(u);
        }
    }
    void printAdjacencyList() {
        for (Map.Entry<Integer, LinkedList<Integer>> entry : adjList.entrySet()) {
            System.out.print(entry.getKey() + "-> ");
            for (Integer neighbour : entry.getValue()) {
                System.out.print(neighbour + ", ");
            }
            System.out.println();
        }
    }

    boolean checkCyclicUsingBfs(int src,HashMap<Integer, Boolean> visitedBFS){
        Queue<Integer> q = new LinkedList<>();
        HashMap<Integer, Integer> parent = new HashMap<>();
        q.add(src);
        visitedBFS.put(src, true);
        parent.put(src,-1);
        while (!q.isEmpty()){
            int frontNode = q.poll();
            for (Integer nbr:adjList.get(frontNode)){
                if(!visitedBFS.getOrDefault(nbr,false)){
                    q.add(nbr);
                    visitedBFS.put(nbr,true);
                    parent.put(nbr,frontNode);
                }else {
                    //already visited
                    if(nbr!=parent.getOrDefault(frontNode,-1)){
                        //cyclic present
                        return true;
                    }
                }
            }
        }
        return false;
    }

    boolean checkCyclicUsingDfs(int src,HashMap<Integer, Boolean> visitedDFS, int parent){
       visitedDFS.put(src,true);

        for (Integer nbr:adjList.getOrDefault(src,new LinkedList<>())){
            if(!visitedDFS.getOrDefault(nbr,false)){
               boolean checkAageKaAns = checkCyclicUsingDfs(nbr,visitedDFS,src);
               if(checkAageKaAns){
                   return true;
               }
            }
            if(visitedDFS.getOrDefault(nbr,true) && nbr !=parent){
                //cyclic present
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CheckGraphCyclicOrNot g = new CheckGraphCyclicOrNot();
        int n = 5;
        // Adding edges to the graph
        g.addEdge(0, 1, false);
        g.addEdge(1, 3, false);
        g.addEdge(0, 2, false);
        g.addEdge(2, 4, false);
        g.addEdge(3,4,false);

        boolean ans = false;
        HashMap<Integer, Boolean> visitedBFS = new HashMap<>();
        for (int i=0;i<n;i++){
         if(!visitedBFS.containsKey(i)){
               ans = g.checkCyclicUsingBfs(i,visitedBFS);
               if(ans==true){
                   break;
               }
         }
        }
        if(ans){
            System.out.println("cyclic");
        }else {
            System.out.println("non cyclic");
        }


        boolean ansDfs = false;
        HashMap<Integer, Boolean> visitedDFS = new HashMap<>();
        for (int i=0;i<n;i++){
            if(!visitedDFS.containsKey(i)){
                ansDfs = g.checkCyclicUsingDfs(i,visitedDFS,-1);
                if(ansDfs==true){
                    break;
                }
            }
        }
        if(ansDfs){
            System.out.println("cyclic");
        }else {
            System.out.println("non cyclic");
        }

    }
}
