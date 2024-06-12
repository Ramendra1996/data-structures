package com.search;

import java.util.Scanner;

public class PeekElement852LeetCode {
    public static int getSearchPeekElement(int arr[]){
        int start = 0;
        int end = arr.length-1;
        while (start<end){
            int mid =start+(end-start)/2;
            if (arr[mid]<arr[mid+1]){
                   start=mid+1;
            }else {
                end=mid;
            }
        }
        return start;
    }
    public static void main(String[] args) {
    /*    System.out.println("Enter the size of array:");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int arr[]= new int[n];
        for(int i=0;i<arr.length;i++){
            arr[i]= scanner.nextInt();
        }*/
        int arr[]={0,10,5,2};
        int searchPeekElement = getSearchPeekElement(arr);
        System.out.println("peekElement="+searchPeekElement);
    }
}
//arr ={0,10,5,2}