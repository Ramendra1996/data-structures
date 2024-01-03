package com.graph;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOrangesLeetCode994 {
    class Pair<A, B> {
        A first;
        B second;
        public Pair(A first, B second) {
            this.first = first;
            this.second = second;
        }
    }
     int orangesRotting(int[][] grid) {
            Queue<Pair<Integer, Integer>> q = new LinkedList<>();
            int freshOranges = 0;
            int ansTime = 0;
            // Count fresh oranges and insert rotten oranges in the queue
            for (int row = 0; row < grid.length; row++) {
                for (int col = 0; col < grid[row].length; col++) {
                    if (grid[row][col] == 2) {
                        // Rotten orange found
                        q.add(new Pair<>(row, col));
                    } else if (grid[row][col] == 1) {
                        // Fresh orange found
                        freshOranges++;
                    }
                }
            }
            int[] dx = {-1, 0, 1, 0};
            int[] dy = {0, 1, 0, -1};
            while (!q.isEmpty()) {
                int size = q.size();
                boolean rottenFound = false;
                for (int i = 0; i < size; i++) {
                    Pair<Integer, Integer> fNode = q.poll();
                    int x = fNode.first;
                    int y = fNode.second;
                    for (int j = 0; j < 4; j++) {
                        int newX = x + dx[j];
                        int newY = y + dy[j];
                        if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length &&
                                grid[newX][newY] == 1) {
                            grid[newX][newY] = 2;
                            q.add(new Pair<>(newX, newY));
                            freshOranges--;
                            rottenFound = true;
                        }
                    }
                }
                if (rottenFound) {
                    ansTime++;
                }
            }
            return freshOranges == 0 ? ansTime : -1;
        }
    public static void main(String[] args) {
        int[][]grid = {{2,1,1},{1,1,0},{0,1,1}};
        RottingOrangesLeetCode994 rl = new RottingOrangesLeetCode994();
        int finalAns = rl.orangesRotting(grid);
        System.out.println("finalAns="+finalAns);
    }
}
