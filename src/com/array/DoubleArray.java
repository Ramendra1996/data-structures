package com.array;

import java.util.Scanner;

public class DoubleArray {

    public static  void getDoubleArray(int arr[]){

        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]*2+" ");
        }
    }
    public static void main(String[] args) {
        System.out.println("Enter the size of array");
        Scanner scanner = new Scanner(System.in);
        int n =scanner.nextInt();
        int arr[]= new int[n];
        for(int i=0;i<n;i++){
            arr[i]=scanner.nextInt();
        }
        getDoubleArray(arr);
    }
}
