package com.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class NumberOfIslandsLeetCode200 {
    class Pair {
        int key;
        int value;

        Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    private void bfs(int row, int col, char[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{row, col});
        grid[row][col] = '0'; // Mark the cell as visited

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int x = current[0];
            int y = current[1];

            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length &&
                        grid[newX][newY] == '1') {
                    q.add(new int[]{newX, newY});
                    grid[newX][newY] = '0'; // Mark the new cell as visited
                }
            }
        }
    }

    /* void bfs(Map<Pair, Boolean> visited, int row, int col, char[][] grid) {
        Queue<Pair> q = new LinkedList<>();  // Initialize Queue
        // Initial steps
        q.add(new Pair(row, col));
        visited.put(new Pair(row, col), true);

        while (!q.isEmpty()) {
            Pair fNode = q.poll();
            int x = fNode.key;
            int y = fNode.value;

            // I can move in 4 directions
            int[] dx = {-1, 0, 1, 0};
            int[] dy = {0, 1, 0, -1};
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length &&
                        !visited.getOrDefault(new Pair(newX, newY), false) && grid[newX][newY] == '1') {
                    q.add(new Pair(newX, newY));
                    visited.put(new Pair(newX, newY), true);
                }
            }
        }
    }*/

    public int numIslands(char[][] grid) {
        int count = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == '1') {
                    bfs(row, col, grid);
                    count++;
                }
            }
        }
        return count;
    }
    /* int numIslands(char[][] grid) {
        Map<Pair, Boolean> visited = new HashMap<>();
        int count = 0;

        for (int row = 0; row < grid.length; row++) {
            int n = grid[row].length;
            for (int col = 0; col < n; col++) {
                if (!visited.getOrDefault(new Pair(row, col), false) && grid[row][col] == '1') {
                    bfs(visited, row, col, grid);
                    count++;
                }
            }
        }
        return count;
    }*/
    public static void main(String[] args) {
        NumberOfIslandsLeetCode200 nl = new NumberOfIslandsLeetCode200();
        char[][] grid = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        int islands = nl.numIslands(grid);
        System.out.println(islands);
    }
}
