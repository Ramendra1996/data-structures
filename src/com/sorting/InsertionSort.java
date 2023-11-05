package com.sorting;

import java.util.Scanner;

public class InsertionSort {
    public static void getSorted(int arr[]){
        for (int round=1;round< arr.length;round++){
            //step1->fetch
            int val = arr[round];
            //step2->compare
            int j=round-1;
            for(;j>=0;j--){
                if(arr[j]>val){
                  //shift krna h
                    arr[j+1]=arr[j];
                }else {
                    //rukna h
                }
            }
            //step3-> copy krna
            arr[j+1]=val;

        }

        System.out.println("sorted array ");
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void main(String[] args) {
        System.out.println("Enter the size of array");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println("Enter the array value");
        int arr[]= new int[n];
        for(int i=0;i<arr.length;i++){
            arr[i]=scanner.nextInt();
        }
        getSorted(arr);
    }
}
