package com.sorting;

import java.util.Scanner;

public class SelectionSort {
    public static void getSearch(int arr[]){
        for (int i=0;i<arr.length-1;i++){
            int minIndex=i;
            for (int j=i+1;j< arr.length;j++){
                if(arr[j]<arr[minIndex]){
                    minIndex=j;
                }
            }
            int temp =arr[i];
            arr[i]=arr[minIndex];
            arr[minIndex]=temp;
        }
        System.out.println("sorted array printed");
        for (int i=0;i< arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void main(String[] args) {
        System.out.println("Enter the size of array");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println("Enter the value of array");
        int arr[]= new int[n];
        for(int i=0;i<arr.length;i++){
            arr[i]=scanner.nextInt();
        }
         getSearch(arr);
    }
}

//TC->0(n^2) worst case and  avg case
//SC->0(1)
// Does not preserve the relative order of items with equal keys which means it is not stable.

/*Q2. Is Selection Sort Algorithm in-place?

Yes, Selection Sort Algorithm is an in-place algorithm, as it does not require extra space.*/
