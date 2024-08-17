package com.search;

import java.util.Scanner;

public class FindMissingNumber {
    public static int getMissingNumber(int arr[]){
        int start=0;
         int end = arr.length-1;
         while (start<=end){
             int mid = (start+end)>>1;
             if(arr[mid]==mid+1){
                 start = mid+1;
             }else {
                 end = mid-1;
             }
         }
         return  start+1;
    }
    public static void main(String[] args) {
      /*  System.out.println("Enter the size of array:");
        Scanner scanner = new Scanner(System.in);
        int n =scanner.nextInt();
        int arr[]= new int[n];
        for (int i=0;i<arr.length;i++){
            arr[i]=scanner.nextInt();
        }*/
        int arr[] = {1,2,3,4,6,7,8};
        int missingNumber = getMissingNumber(arr);
        System.out.println(missingNumber);
    }
}
