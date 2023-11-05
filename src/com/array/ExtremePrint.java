package com.array;

import java.util.Scanner;

public class ExtremePrint {

    public static void print(int arr[]){
        int start=0;
        int end = arr.length-1;
        while (start<=end){

            if (start==end){
                System.out.println(arr[start]);
            }else {
                System.out.println(arr[start]);
                System.out.println(arr[end]);
            }

            start++;
            end--;
        }
    }
    public static void main(String[] args) {
        System.out.println("Enter the size of array");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int arr[]= new int[n];
        for (int i=0;i< arr.length;i++){
            arr[i]= scanner.nextInt();
        }
         print(arr);
    }
}
