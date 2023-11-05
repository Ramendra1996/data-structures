package com.recursionBacktracing;

import java.util.Scanner;

public class BinarySearch {
    public  static  int getCheck(int arr[],int start,int end, int key){
           if(start>end){
               return -1;
           }
           int mid= start+(end-start)/2;
           if(arr[mid]== key){
               return  mid;
           }
           //arr[mid]<key right me search
            if (arr[mid]<key){
               return getCheck(arr,mid+1,end,key);
            }else {    //arr[mid]>key left me search
                return getCheck(arr,start,mid-1,key);
            }
    }
    public static void main(String[] args) {
        System.out.println("Enter the sze of array:");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println("Enter the key");
        int key = scanner.nextInt();
        int arr[]= new  int[n];
        int start=0;
        int end = arr.length-1;
        System.out.println("Enter the array value:");
         for (int i=0;i<arr.length;i++){
             arr[i]=scanner.nextInt();
         }
        int check = getCheck(arr, start, end, key);
        System.out.println("index="+check);
    }
}
