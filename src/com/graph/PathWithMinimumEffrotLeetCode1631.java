package com.graph;


import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PathWithMinimumEffrotLeetCode1631 {
    class Pair<K, V> {
        private final K key;
        private final V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
        public K getKey() {
            return key;
        }
        public V getValue() {
            return value;
        }
    }



    public int minimumEffortPath(int[][] heights) {
        // Creating a priority queue with reverse order based on the effort
        PriorityQueue<Pair<Integer, Pair<Integer, Integer>>> pq =
                new PriorityQueue<>(Comparator.comparingInt(Pair::getKey));
        int rows = heights.length;
        int cols = heights[0].length;
        // Matrix to store the minimum effort required to reach each cell
        int[][] dist = new int[rows][cols];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        // Starting from the top-left corner
        pq.offer(new Pair<>(0, new Pair<>(0, 0)));
        dist[0][0] = 0;
        while (!pq.isEmpty()){
            Pair<Integer, Pair<Integer, Integer>> fNode = pq.poll();
            int frontNodeDifference = fNode.getKey();
            int x = fNode.getValue().getKey();
            int y = fNode.getValue().getValue();
            // Check if we reached the destination
            if (x == rows - 1 && y == cols - 1) {
                return dist[x][y];
            }
            int[] dx = {-1, 0, 1, 0};
            int[] dy = {0, 1, 0, -1};
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                if (newX >= 0 && newY >= 0 && newX < rows && newY < cols) {
                    int currDifference = Math.abs(heights[x][y] - heights[newX][newY]);
                    int newMax = Math.max(frontNodeDifference, currDifference);

                    if (newMax < dist[newX][newY]) {
                        dist[newX][newY] = newMax;
                        pq.offer(new Pair<>(newMax, new Pair<>(newX, newY)));
                    }
                }
            }
        }
        return 0;

    }

    public static void main(String[] args) {
    int [][] heights = {{1,2,2},{3,8,2},{5,3,5}};
        PathWithMinimumEffrotLeetCode1631 pe = new PathWithMinimumEffrotLeetCode1631();
        int diff = pe.minimumEffortPath(heights);
        System.out.println(diff);
    }
}
