package com.recursionBacktracing;

import java.util.Scanner;

public class ArraySortedOrNot {
    public static  boolean getCheck(int arr[], int j){
        if(j==arr.length-1){
            return true;
        }
        if(arr[j+1]<arr[j]){
            return false;
        }
        return  getCheck(arr,j+1);
    }
    public static void main(String[] args) {
        System.out.println("Enter the size of array");
        Scanner scanner= new Scanner(System.in);
        int n = scanner.nextInt();
        int arr[]= new int[n];
        System.out.println("Enter the array value:");
        for (int i=0;i< arr.length;i++){
            arr[i]=scanner.nextInt();
        }
        int j=0;
        boolean check = getCheck(arr, j);
        if(check){
            System.out.println("sorted");
        }else {
            System.out.println("not sorted");
        }
    }
}
