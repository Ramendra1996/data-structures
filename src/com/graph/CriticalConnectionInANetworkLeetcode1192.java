package com.graph;

import java.util.*;

public class CriticalConnectionInANetworkLeetcode1192 {
    void findBridge(int src, int parent, int timer, List<Integer> tin, List<Integer> low, Map<Integer, Boolean> vis, List<List<Integer>> ans, Map<Integer, List<Integer>> adjList) {
        vis.put(src, true);
        tin.set(src, timer);
        low.set(src, timer);
        timer++;

        for (Integer nbr : adjList.getOrDefault(src, new LinkedList<>())) {
            if (nbr == parent) {
                continue;
            }
            if (!vis.getOrDefault(nbr, false)) {
                // dfs call
                findBridge(nbr, src, timer, tin, low, vis, ans, adjList);
                // low update
                low.set(src, Math.min(low.get(src), low.get(nbr)));
                // check for bridge
                if (low.get(nbr) > tin.get(src)) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nbr);
                    temp.add(src);
                    ans.add(temp);
                }
            } else {
                // node is visited and not a parent
                // low update
                low.set(src, Math.min(low.get(src), tin.get(nbr)));
            }
        }
    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (List<Integer> connection : connections) {
            int u = connection.get(0);
            int v = connection.get(1);
            graph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            graph.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }
        int timer = 1;
        List<Integer> tin = new ArrayList<>(Collections.nCopies(n, 0));
        List<Integer> low = new ArrayList<>(Collections.nCopies(n, 0));
        Map<Integer, Boolean> vis = new HashMap<>();
        List<List<Integer>> ans = new ArrayList<>();
        findBridge(0, -1, timer, tin, low, vis, ans, graph);
        return ans;
    }
    public static void main(String[] args) {
        int n =4;
        List<List<Integer>> connections = new ArrayList<>(Arrays.asList(
                Arrays.asList(0, 1),
                Arrays.asList(1, 2),
                Arrays.asList(2, 0),
                Arrays.asList(1, 3)
        ));
        CriticalConnectionInANetworkLeetcode1192 cc = new CriticalConnectionInANetworkLeetcode1192();
        List<List<Integer>> lists = cc.criticalConnections(n, connections);
        System.out.println(lists);

    }
}
