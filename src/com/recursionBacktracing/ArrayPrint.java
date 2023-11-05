package com.recursionBacktracing;

import java.util.Scanner;

public class ArrayPrint {

    public static void print(int arr[], int i){
        if(i>= arr.length){
            return;
        }
        System.out.println(arr[i]);
        print(arr,i+1);
    }

    public static void main(String[] args) {
        System.out.println("Enter the size of array:");
        Scanner scanner= new Scanner(System.in);
        int n = scanner.nextInt();
        int arr[]= new int[n];
        System.out.println("Enter the value of array");
        for (int i=0;i< arr.length;i++){
            arr[i]= scanner.nextInt();
        }
        System.out.println("print array");
           print(arr,0);
    }
}
