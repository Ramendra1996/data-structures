package com.graph;

import java.util.HashMap;
import java.util.Map;

public class FindCircleNumLeetCode547 {
    private void dfs(Map<Integer, Boolean> vis, int src, int[][] isConnected) {
        vis.put(src, true);
        int size = isConnected[src].length;
        for (int col = 0; col < size; col++) {
            if (src != col && isConnected[src][col] == 1) {
                if (!vis.getOrDefault(col, false)) {
                    dfs(vis, col, isConnected);
                }
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        Map<Integer, Boolean> visited = new HashMap<>();
        int count = 0;
        int n = isConnected.length;
        for (int i = 0; i < n; i++) {
            if (!visited.getOrDefault(i, false)) {
                dfs(visited, i, isConnected);
                count++;
            }
        }
        return count;

    }
    public static void main(String[] args) {

      int [][] isConnected = {{1,1,0},{1,1,0},{0,0,1}};
        FindCircleNumLeetCode547 fc = new FindCircleNumLeetCode547();
        int circleNum = fc.findCircleNum(isConnected);
        System.out.println(circleNum);
    }
}
