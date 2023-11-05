package com.array2D;

import java.util.Scanner;

public class RowAndColumnSum {
public static void getColumnSum(int arr[][]){

    for(int i=0;i< arr.length;i++){
        int sum=0;
        for (int j=0;j<arr[0].length;j++){
            sum+=arr[j][i];
        }
        System.out.println(sum);
    }
}
    public static  void getRowSum(int arr[][]){
        //row wise sum
        for(int i=0;i<arr.length;i++){
            int sum=0;
            for(int j=0;j<arr[0].length;j++){
                sum+=arr[i][j];
            }
            System.out.println(sum);
        }
    }
    public static void main(String[] args) {
        System.out.println("Enter the number of rows in the array:");
        Scanner scanner= new Scanner(System.in);
        int row = scanner.nextInt();
        System.out.println("Enter the number of columns in the array:");
        int col = scanner.nextInt();
        int arr[][]= new int[row][col];
        System.out.println("Enter the elements of the array:");
        for (int i=0;i<arr.length;i++){
            for (int j=0;j<arr[0].length;j++){
                arr[i][j]=scanner.nextInt();
            }
        }
        getRowSum(arr);
        getColumnSum(arr);
    }
}
