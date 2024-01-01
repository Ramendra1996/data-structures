package com.graph;

import java.util.*;
public class ShortestPathInGraphDijkstra {
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

    void shortestPathBFS(int src, int dest) {
        Queue<Integer> q = new LinkedList<>();
        HashMap<Integer, Boolean> visited = new HashMap<>();
        HashMap<Integer, Integer> parent = new HashMap<>();

        // initial step
        q.add(src);
        visited.put(src, true);
        parent.put(src, -1);
        while (!q.isEmpty()) {
            int frontNode = q.poll();
            for (Pair nbr : adjList.get(frontNode)) {
                if (!visited.getOrDefault(nbr.first, false)) {
                    q.add(nbr.first);
                    visited.put(nbr.first, true);
                    parent.put(nbr.first, frontNode);
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        int node = dest;
        while (node != -1) {
            ans.add(node);
            node = parent.get(node);
        }

        // Reverse the list to print in correct order
        Collections.reverse(ans);

        System.out.println("Shortest path from " + src + " to " + dest + ":");
        for (Integer i : ans) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    void toPoSortDFS(Integer src, HashMap<Integer, Boolean> visited, Stack<Integer>ans){
        visited.put(src, true);
        // Check if the current node has neighbors before iterating
        if (adjList.containsKey(src)) {
            for (Pair neighbour : adjList.get(src)) {
                if (!visited.getOrDefault(neighbour.first, false)) {
                    toPoSortDFS(neighbour.first, visited,ans);
                }
            }
        }
        //while returning ,store the node in stack
        ans.add(src);
    }

    void  shortestPathDFS(int dest,Stack<Integer>topoOrder , int n ){
         List<Integer>dist = new ArrayList<>(Collections.nCopies(n,Integer.MAX_VALUE));
         int src =topoOrder.pop();
         dist.set(src,0);
        if (adjList.containsKey(0)) {
            for (Pair nbr : adjList.get(0)) {
                if (dist.get(0) + nbr.second < dist.get(nbr.first)) {
                    dist.set(nbr.first, dist.get(0) + nbr.second);
                }
            }
        }
        while (!topoOrder.isEmpty()) {
            int topElement = topoOrder.pop();
            if (dist.get(topElement) != Integer.MAX_VALUE && adjList.containsKey(topElement)) {
                for (Pair nbr : adjList.get(topElement)) {
                    if (dist.get(topElement) + nbr.second < dist.get(nbr.first)) {
                        dist.set(nbr.first, dist.get(topElement) + nbr.second);
                    }
                }
            }
        }
        System.out.println("printing ans:");
         for (int i=0;i<n;i++){
             System.out.print(dist.get(i)+" ");
         }

    }

    void  shortestPathDijkstra(int src , int n){
        List<Integer> dist = new ArrayList<>(Collections.nCopies(n,Integer.MAX_VALUE));
        Set<Pair> st = new HashSet<>();
        dist.set(src,0);
        st.add(new Pair(0,src));
        while (!st.isEmpty()){
             Pair topElement =st.iterator().next();
             int nodeDistance = topElement.first;
             int node = topElement.second;
             //remove from set
            st.remove(topElement);
           // neighbour travers
            for (Pair nbr :adjList.getOrDefault(node,new LinkedList<>())){
                if(nodeDistance+ nbr.second< dist.get(nbr.first)){
                    //muje distace update krna h
                    // Finding entry in set
                    Pair updatedPair = new Pair(dist.get(nbr.first), nbr.first);
                    //if found
                    if (st.contains(updatedPair)) {
                        st.remove(updatedPair);
                    }
                    // Updation in dist array and set
                    dist.set(nbr.first, nodeDistance + nbr.second);
                    st.add(new Pair(dist.get(nbr.first), nbr.first));
                }
            }

        }
        System.out.println("Printing ans:");
        for (int i = 0; i < n; i++) {
            System.out.print(dist.get(i) + ", ");
        }
        System.out.println();
        //TC->0(elogv)
    }

    public static void main(String[] args) {
        ShortestPathInGraphDijkstra sg = new ShortestPathInGraphDijkstra();
       /* bfs ke liye
        sg.addEdge(0, 1, 1, false);
        sg.addEdge(1, 2, 1, false);
        sg.addEdge(2, 3, 1, false);
        sg.addEdge(3, 4, 1, false);
        sg.addEdge(0, 5, 1, false);
        sg.addEdge(5, 4, 1, false);
        sg.addEdge(0, 6, 1, false);
        sg.addEdge(6, 7, 1, false);
        sg.addEdge(7, 8, 1, false);
        sg.addEdge(8, 4, 1, false);*/
      /*  //dfs ke liye
        sg.addEdge(0,1,5,true);
        sg.addEdge(0,2,3,true);
        sg.addEdge(2,1,2,true);
        sg.addEdge(1,3,3,true);
        sg.addEdge(2,3,5,true);
        sg.addEdge(2,4,6,true);
        sg.addEdge(4,3,1,true);
*/
        sg.addEdge(6, 3, 2, false);
        sg.addEdge(6, 1, 14, false);
        sg.addEdge(3, 1, 9, false);
        sg.addEdge(3, 2, 10, false);
        sg.addEdge(1, 2, 7, false);
        sg.addEdge(2, 4, 15, false);
        sg.addEdge(4, 3, 11, false);
        sg.addEdge(6, 5, 9, false);
        sg.addEdge(4, 5, 6, false);

         sg.printAdjacencyList();
/*
        int src = 0;
        int dest = 4;
        sg.shortestPathBFS(src, dest);*/

     //   Stack<Integer>topoOrder = new Stack<>();
    //    HashMap<Integer,Boolean>visited = new HashMap<>();
    //    sg.toPoSortDFS(0,visited,topoOrder);
    //    sg.shortestPathDFS(3,topoOrder,5);
        sg.shortestPathDijkstra(6,7);
    }
}


/*
void shortestDistDijkstra(int src, int n) {
    PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.first));
    int[] dist = new int[n];
    Arrays.fill(dist, Integer.MAX_VALUE);

    // Initial steps
    dist[src] = 0;
    pq.offer(new Pair(0, src));

    while (!pq.isEmpty()) {
        Pair topElement = pq.poll();
        int nodeDistance = topElement.first;
        int node = topElement.second;

        // Neighbor traverse
        for (Pair nbr : adjList.getOrDefault(node, new ArrayList<>())) {
            if (nodeDistance + nbr.second < dist[nbr.first]) {
                // Mujhe distance update karna hai
                // Finding entry in priority queue
                Pair updatedPair = new Pair(dist[nbr.first], nbr.first);
                if (pq.contains(updatedPair)) {
                    pq.remove(updatedPair);
                }
                // Updation in dist array and priority queue
                dist[nbr.first] = nodeDistance + nbr.second;
                pq.offer(new Pair(dist[nbr.first], nbr.first));
            }
        }
    }*/

/*void shortestDistDijkstra(int src, int n) {
    TreeSet<Pair> set = new TreeSet<>(Comparator.comparingInt(a -> a.first));
    int[] dist = new int[n];
    Arrays.fill(dist, Integer.MAX_VALUE);

    // Initial steps
    dist[src] = 0;
    set.add(new Pair(0, src));

    while (!set.isEmpty()) {
        Pair topElement = set.pollFirst();
        int nodeDistance = topElement.first;
        int node = topElement.second;

        // Neighbor traverse
        for (Pair nbr : adjList.getOrDefault(node, new ArrayList<>())) {
            if (nodeDistance + nbr.second < dist[nbr.first]) {
                // Mujhe distance update karna hai
                // Finding entry in set
                Pair updatedPair = new Pair(dist[nbr.first], nbr.first);
                if (set.contains(updatedPair)) {
                    set.remove(updatedPair);
                }
                // Updation in dist array and set
                dist[nbr.first] = nodeDistance + nbr.second;
                set.add(new Pair(dist[nbr.first], nbr.first));
            }
        }
    }*/
