package com.array2D;

public class MatrixPrintUsingRecursion {
    public static void printMatrix(int[][] matrix, int i, int j) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Base case: if we reach the end of the matrix
        if (i == rows) {
            return;
        }

        // Print the current element
        System.out.print(matrix[i][j] + " ");

        // Move to the next row or the next column
        int nextI = i;
        int nextJ = j + 1;
        if (nextJ == cols) {
            nextI++;
            nextJ = 0;
            System.out.println(); // Move to the next line for a new row
        }

        // Recursively call the function for the next element
        printMatrix(matrix, nextI, nextJ);
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int i=0;
        int j=0;
        printMatrix(matrix,i,j);
    }

}
