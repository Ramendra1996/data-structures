package com.graph;

import java.util.Scanner;

public class AdjacencyMatrixGraph {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of nodes: ");
        int n = scanner.nextInt();
        System.out.println("Enter the number of edges: ");
        int e = scanner.nextInt();
        System.out.println("Enter edges (u v): ");
        int[][] adj = new int[n][n];
        for (int i = 0; i < e; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            // mark 1
            adj[u][v] = 1;
        }
        //print
        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(adj[i][j] + " ");
            }
            System.out.println();
        }
    }
}



/*
Enter the number of nodes:
        3
Enter the number of edges:
        6
Enter edges (u v):
        0 1
        1 0
        1 2
        2 1
        0 2
        2 0
Adjacency Matrix:
        0 1 1
        1 0 1
        1 1 0
*/
// sc->0(n2),(v2)(avg case and worstcase both)
