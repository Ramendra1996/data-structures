package com.search;

import java.util.Scanner;

public class FindMissingNumber {
    public static int getMissingNumber(int arr[]){
        int n = arr.length;

        return 0;
    }
    public static void main(String[] args) {
        System.out.println("Enter the size of array:");
        Scanner scanner = new Scanner(System.in);
        int n =scanner.nextInt();
        int arr[]= new int[n];
        for (int i=0;i<arr.length;i++){
            arr[i]=scanner.nextInt();
        }
        getMissingNumber(arr);
    }
}
