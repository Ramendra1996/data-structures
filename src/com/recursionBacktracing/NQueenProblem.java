package com.recursionBacktracing;


import java.util.HashMap;
import java.util.Map;

public class NQueenProblem {

    static Map<Integer, Boolean> rowCheck =new HashMap<>();
    static Map<Integer,Boolean> upperLeftDiagonalCheck = new HashMap<>();
    static Map<Integer,Boolean> bottomLeftDiagonalCheck = new HashMap<>();


    public static boolean isSafe(int row, int col, char board[][], int n) {
        // Check the row on the left side
        /*for (int j = 0; j < col; j++) {
            if (board[row][j] == 'Q') {
                return false;
            }
        }

        // Check the upper diagonal on the left side
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // Check the lower diagonal on the left side
        for (int i = row, j = col; i < n && j >= 0; i++, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;*/
        if (rowCheck.getOrDefault(row, Boolean.FALSE)) {
            return false;
        }
        if (upperLeftDiagonalCheck.getOrDefault(n - 1 + col - row, Boolean.FALSE)) {
            return false;
        }
        if (bottomLeftDiagonalCheck.getOrDefault(row + col, Boolean.FALSE)) {
            return false;
        }
        return true;
    }

    public static void printSolution(char board[][], int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean solve(char board[][], int col, int n) {
        // Base case: If all queens are placed
        if (col >= n) {
            printSolution(board, n);
            return true;
        }

        boolean res = false;
        // Try placing the queen in all rows one by one
        for (int row = 0; row < n; row++) {
            if (isSafe(row, col, board, n)) {
                // Place the queen
                board[row][col] = 'Q';
                rowCheck.put(row,Boolean.TRUE);
                upperLeftDiagonalCheck.put((n-1+col-row),Boolean.TRUE);
                bottomLeftDiagonalCheck.put((row+col),Boolean.TRUE);

                // Recur to place rest of the queens
                res = solve(board, col + 1, n) || res;

                // If placing queen in board[row][col] doesn't lead to a solution,
                // then remove queen from board[row][col]
                board[row][col] = '.'; // Backtrack
                rowCheck.put(row,Boolean.FALSE);
                upperLeftDiagonalCheck.put((n-1+col-row),Boolean.FALSE);
                bottomLeftDiagonalCheck.put((row+col),Boolean.FALSE);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int n = 4;
        char board[][] = new char[n][n];

        // Initialize the board with '.'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        if (!solve(board, 0, n)) {
            System.out.println("Solution does not exist");
        }
    }
}
