package com.search;

import java.util.Scanner;

public class SearchNearlySortedArray {
    public static int getSearch(int arr[], int key){
        int start =0;
         int end = arr.length-1;
         while (start<=end){
             int mid = start+(end-start)/2;
             if(arr[mid]==key){
                 return mid;
             } else if ( mid-1>=start &&arr[mid-1]==key) {
                 return mid-1;
             } else if (mid+1<end &&arr[mid+1]==key) {
                 return mid+1;
             } else if (arr[mid]<key) {
                 start=mid+2;
             }else {
                 end=mid-2;
             }
         }
        return -1;
    }
    public static void main(String[] args) {
        System.out.println("Enter the key");
        Scanner scanner = new Scanner(System.in);
        int key =scanner.nextInt();
        System.out.println("Enter the size of Array");
        int n = scanner.nextInt();
        int arr[]= new int[n];
        for (int i=0;i<arr.length;i++){
            arr[i]= scanner.nextInt();
        }
        int search = getSearch(arr, key);
        System.out.println("index="+search);
    }
}
