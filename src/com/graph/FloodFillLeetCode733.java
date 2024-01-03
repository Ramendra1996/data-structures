package com.graph;

import java.util.HashMap;
import java.util.Map;

public class FloodFillLeetCode733 {
/*
    class Pair{
         int first ;
         int second;
         Pair(int first, int second){
             this.first=first;
             this.second=second;
         }
    }
    private void dfs(int x, int y, int oldColor, int newColor, Map<Pair, Boolean> vis, int[][] arr) {
        vis.put(new Pair(x, y), true);
        arr[x][y] = newColor;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if (newX >= 0 && newX < arr.length && newY >= 0 && newY < arr[0].length &&
                    !vis.getOrDefault(new Pair(newX, newY), false) && arr[newX][newY] == oldColor) {
                dfs(newX, newY, oldColor, newColor, vis, arr);
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        Map<Pair, Boolean> vis = new HashMap<>();
        int[][] ans = new int[image.length][image[0].length];

        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                ans[i][j] = image[i][j];
            }
        }

        dfs(sr, sc, oldColor, newColor, vis, ans);
        return ans;
    }*/
private void dfs(int x, int y, int oldColor, int newColor, int[][] arr) {
    if (x < 0 || x >= arr.length || y < 0 || y >= arr[0].length || arr[x][y] != oldColor) {
        return;
    }
    arr[x][y] = newColor;
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    for (int i = 0; i < 4; i++) {
        int newX = x + dx[i];
        int newY = y + dy[i];
        dfs(newX, newY, oldColor, newColor, arr);
    }
}
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        if (oldColor != newColor) {
            dfs(sr, sc, oldColor, newColor, image);
        }
        return image;
    }

    public static void main(String[] args) {
        int[][]image = {{1,1,1},{1,1,0},{1,0,1}};
        int sr = 1;
        int sc = 1;
        int color = 2;
        FloodFillLeetCode733 fd = new FloodFillLeetCode733();
        int[][] result = fd.floodFill(image, sr, sc, color);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
