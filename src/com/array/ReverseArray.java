package com.array;

import java.util.Scanner;

public class ReverseArray {

    public  static void getReverse(int arr[]){
        int start=0;
        int end=arr.length-1;

        while (start<=end){
            int temp = arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void main(String[] args) {
        System.out.println("Enter the size of array");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int arr[]= new int[n];

        for (int i=0;i<arr.length;i++){
            arr[i]=scanner.nextInt();
        }
           getReverse(arr);
    }
}
