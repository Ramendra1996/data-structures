package com.search;

import java.util.Scanner;

public class FindFirstOccurance {
    public static int getFirstOccurance(int arr[],int element){
        int start = 0;
        int end = arr.length-1;
        int ans =-1;
        while (start<=end){
            int mid = start+(end-start)/2;
            if (arr[mid]==element){
                ans =mid;
                end= mid-1;
            } else if (arr[mid]>element) {
                end=mid-1;
            }else {
                start=mid+1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
      /*  System.out.println("Enter the element");
        Scanner scanner = new Scanner(System.in);
        int element = scanner.nextInt();
        System.out.println("Enter the size of array");
        int n = scanner.nextInt();
        int arr[]= new int[n];
        for (int i=0;i< arr.length;i++){
            arr[i]= scanner.nextInt();
        }*/
        int arr[]={1,2,2,2,2,2,4,5,6,7,8,9};
        int element =2;
        int firstOccurance = getFirstOccurance(arr, element);
        System.out.println("firstOccurance="+firstOccurance);
    }
}
