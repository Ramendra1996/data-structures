package com.graph;

import java.util.*;

public class BridgeInAGraph {
    HashMap<Integer, LinkedList<Integer>> adjList = new HashMap<>();
    void addEdge(int u, int v, boolean direction) {
        // Add edge from u to v
        adjList.computeIfAbsent(u, k -> new LinkedList<>()).add(v);
        // If the graph is undirected, add the reverse edge from v to u
        if (!direction) {
            adjList.computeIfAbsent(v, k -> new LinkedList<>()).add(u);
        }
    }
    void  findBridge(int src, int parent, int timer, List<Integer> tin, List<Integer>low, Map<Integer,Boolean> vis){
        vis.put(src, true);
        tin.set(src, timer);
        low.set(src, timer);
        timer++;

        for (Integer nbr:adjList.getOrDefault(src , new LinkedList<>())){
            if(nbr==parent){
               continue;
            }
            if(!vis.getOrDefault(nbr,false)){
                //dfs call
                findBridge(nbr, src, timer, tin, low, vis);
                // low update
                low.set(src, Math.min(low.get(src), low.get(nbr)));
                // check for bridge
                if (low.get(nbr) > tin.get(src)) {
                    System.out.println(nbr + "--" + src + " is a bridge");
                }else {
                    // node is visited and not a parent
                    // low update
                    low.set(src, Math.min(low.get(src), low.get(nbr)));
                }
            }
        }

    }
    public static void main(String[] args) {
        BridgeInAGraph bg = new BridgeInAGraph();
        bg.addEdge(0,1,false);
        bg.addEdge(1,2,false);
        bg.addEdge(2,0,false);
        bg.addEdge(1,6,false);
        bg.addEdge(3,1,false);
        bg.addEdge(1,4,false);
        bg.addEdge(3,5,false);
        bg.addEdge(4,5,false);
        int n = 7;
        int timer = 1;
        List<Integer> tin = new ArrayList<>(Collections.nCopies(n, 0));
        List<Integer> low = new ArrayList<>(Collections.nCopies(n, 0));
        Map<Integer, Boolean> vis = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (!vis.containsKey(i)) {
                bg.findBridge(i, -1, timer, tin, low, vis);
            }
        }
    }

}
