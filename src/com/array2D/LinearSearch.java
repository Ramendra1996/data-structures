package com.array2D;

import java.util.Scanner;

public class LinearSearch {
    public static boolean getSearch(int arr[][], int key){
        for (int i=0;i<arr.length;i++){
            for (int j=0;j<arr[0].length;j++){
                if (arr[i][j]==key)
                    return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        System.out.println("Enter the key");
        int key = scanner.nextInt();
        System.out.println("Enter the number of rows in the array:");
        int row = scanner.nextInt();
        System.out.println("Enter the number of columns in the array:");
        int col = scanner.nextInt();
        int arr[][]= new int[row][col];
        System.out.println("Enter the elements of the array:");
        for (int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                arr[i][j]=scanner.nextInt();
            }
        }
        if(getSearch(arr,key)){
            System.out.println("present");
        }else {
            System.out.println("Not present");
        }
    }
}
