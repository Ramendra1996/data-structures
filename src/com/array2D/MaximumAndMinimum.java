package com.array2D;

import java.util.Scanner;

public class MaximumAndMinimum {
    public static void getMaxAndMin(int arr[][]){
        int maxi = Integer.MIN_VALUE;
         int mini = Integer.MAX_VALUE;

         for (int i=0 ;i<arr.length;i++){
             for(int j=0;j<arr[0].length;j++){
                 if(arr[i][j]>maxi){
                     maxi=arr[i][j];
                 }
                 if (arr[i][j]<mini){
                     mini=arr[i][j];
                 }
             }
         }
        System.out.println("Maximum="+maxi);
        System.out.println("Minimum="+mini);
    }
    public static void main(String[] args) {
        System.out.println("Enter the number of rows in the array:");
        Scanner scanner =new Scanner(System.in);
        int row = scanner.nextInt();
        System.out.println("Enter the number of columns in the array:");
        int col = scanner.nextInt();
        int arr[][]= new int[row][col];
        System.out.println("Enter the elements of the array:");
        for (int i=0;i<arr.length;i++){
            for (int j=0;j<arr[0].length;j++){
                arr[i][j]= scanner.nextInt();
            }
        }
        getMaxAndMin(arr);

    }
}
