package com.graph;

import java.util.*;

public class CourseSchedule2Leetcode210 {
    int[] toPoSortBFS(int n, HashMap<Integer, LinkedList<Integer>> adjList){
        List<Integer> ans = new ArrayList<>();
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
        if (ans.size() == n) {
            // Convert List<Integer> to int[]
            int[] result = new int[n];
            for (int i = 0; i < n; i++) {
                result[i] = ans.get(i);
            }
            return result;
        } else {
            // Return an empty array or null based on your preference
            return new int[0];
            // Alternatively, you can return null: return null;
        }

    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, LinkedList<Integer>> adjList = new HashMap<>();

        for (int[] take:prerequisites){
            int u =take[0];
            int v= take[1];
            adjList.computeIfAbsent(v, k -> new LinkedList<>()).add(u);
        }
        int[] poSortBFS = toPoSortBFS(numCourses, adjList);
        return poSortBFS;

    }
    public static void main(String[] args) {
    int  numCourses = 4;
     int[][]  prerequisites = {{1,0},{2,0},{3,1},{3,2}};
        CourseSchedule2Leetcode210 cs = new CourseSchedule2Leetcode210();
        int[] order = cs.findOrder(numCourses, prerequisites);
        System.out.println(Arrays.toString(order));


    }
}
