package com.search;

import java.util.Scanner;

public class BinarySearch {
    public  static  boolean getSearch(int arr[], int key){
      int start=0;
      int end = arr.length-1;
      while (start<=end){
          int mid = start+(end-start)/2;
          if(arr[mid]==key){
              return true;
          } else if (arr[mid]>key) {
              end=mid-1;
          }else {
              start=mid+1;
          }
      }
      return false;
    }
    public static void main(String[] args) {
        System.out.println("Enter the key");
        Scanner scanner = new Scanner(System.in);
        int key = scanner.nextInt();
        System.out.println("Enter the size of array ");
        int n = scanner.nextInt();
        int arr[]= new int[n];
        for (int i=0;i< arr.length;i++){
            arr[i]=scanner.nextInt();
        }
        if (getSearch(arr,key)){
            System.out.println("Present");
        }else {
            System.out.println("not present");
        }
    }
}

//T.C->0(logn)
//S.C->0(1)