package com.search;

import java.util.Scanner;

public class OddOccuraningElement {
    public static int getSolve(int arr[]){
        int start=0;
         int end=arr.length-1;
         while (start<=end){
             int mid= start+(end-start)/2;
             if(start==end){
                 return start;
             }
             //2 cases mid even or mid odd
             if(mid%2==0){
                 if(arr[mid]==arr[mid+1]){
                     start=mid+2;
                 }else {
                     end=mid;
                 }
             }
             else {
                 if (arr[mid]==arr[mid-1]){
                     start=mid+1;
                 }else {
                     end=mid-1;
                 }
             }
         }
        return -1;
    }
    public static void main(String[] args) {
        System.out.println("Enter the size of array:");
        Scanner scanner= new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println("Enter the array value");
        int arr[]= new int[n];
        for (int i=0;i< arr.length;i++){
            arr[i]=scanner.nextInt();
        }
        int solve = getSolve(arr);
        System.out.println("Ans="+solve);
    }
}
//arr={1,1,2,2,3,3,4,4,3,600,600,4,4}