package com.array;

import java.util.Scanner;

public class MinimumMaximumNumber {
    public static void getMaximum(int arr[]){
        int maxi=Integer.MIN_VALUE;
        int mini = Integer.MAX_VALUE;
        for (int i=0;i< arr.length;i++){
            if(maxi<arr[i]){
                maxi=arr[i];
            }
        }
        for (int i=0;i< arr.length;i++){
            if(mini>arr[i]){
                mini=arr[i];
            }
        }
        System.out.println("maximumNumber="+maxi);
        System.out.println("minimumNumber="+mini);
    }
    public static void main(String[] args) {
        System.out.println("Enter the size of array");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int arr[]= new int[n];
        for (int i=0;i<arr.length;i++){
            arr[i]= scanner.nextInt();
        }
        getMaximum(arr);
    }
}
