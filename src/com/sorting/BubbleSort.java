package com.sorting;

import java.util.Scanner;

public class BubbleSort {
    public static  void getSorted(int arr[]){
        for (int round=1;round< arr.length;round++){
            boolean swapped = false;
            for (int j=0;j< arr.length-round;j++){
                if(arr[j]>arr[j+1]){
                    swapped=true;
                  int temp = arr[j];
                  arr[j]=arr[j+1];
                  arr[j+1]=temp;
                }
            }
            if (swapped==false){
                break;
            }
        }

        System.out.println("sorted array printed");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void main(String[] args) {
        System.out.println("Enter the array size");
        Scanner  scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println("Enter the array value");
        int arr[]= new int[n];
         for(int i=0;i<arr.length;i++){
             arr[i]= scanner.nextInt();
         }
         getSorted(arr);
    }
}
//TC->0(n^2)
//SC->0(1)
//optimize kro
//sinkingsort bi bolte h
//check stable or unstable