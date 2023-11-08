package com.array2D;

import java.util.Scanner;

public class TransposeMatrix {

    public static void  getTranse(int arr[][],int transpose[][]){
        for (int i=0;i<arr.length;i++){
            for (int j=0;j<arr[0].length;j++){
                transpose[j][i]=arr[i][j];
            }
        }
        for (int i=0;i<transpose.length;i++){
            for (int j=0;j<transpose[0].length;j++){
                System.out.print(transpose[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        System.out.println("Enter the number of rows in the array:");
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        System.out.println("Enter the number of columns in the array:");
        int col = scanner.nextInt();
        int arr[][] = new int[row][col];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        int transpose[][]= new int[row][col];
        getTranse(arr,transpose);
    }
}


/* transepose 2nd method
public class MatrixTranspose {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] transpose = transposeMatrix(matrix);

        // Print the original matrix
        System.out.println("Original Matrix:");
        printMatrix(matrix);

        // Print the transposed matrix
        System.out.println("Transposed Matrix:");
        printMatrix(transpose);
    }

    public static int[][] transposeMatrix(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        int[][] transpose = new int[columns][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }

        return transpose;
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}*/
