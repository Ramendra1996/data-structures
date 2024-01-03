package com.graph;

import java.util.*;

public class CourseScheduleLeetCode207 {
    boolean toPoSortBFS(int n, HashMap<Integer, LinkedList<Integer>> adjList){
        List<Integer>ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
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
        if(ans.size()==n){
            return true;
        }else {
            return false;
        }

    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, LinkedList<Integer>> adjList = new HashMap<>();

        for (int[] take:prerequisites){
            int u =take[0];
            int v= take[1];
            adjList.computeIfAbsent(v, k -> new LinkedList<>()).add(u);
        }
        boolean poSortBFS = toPoSortBFS(numCourses, adjList);
        return poSortBFS;
    }

    public static void main(String[] args) {
        CourseScheduleLeetCode207 cs = new CourseScheduleLeetCode207();

        int numCourses =2;
        int[][] prerequisites = {{1,0},{0,1}};

        boolean b = cs.canFinish(numCourses, prerequisites);
        System.out.println(b);
    }
}
