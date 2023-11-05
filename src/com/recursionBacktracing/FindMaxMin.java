package com.recursionBacktracing;

import java.util.Scanner;

public class FindMaxMin {
    public static  int getMax(int arr[], int i, int maxi){
        if(i>= arr.length){
            return maxi;
        }
        // 1case solve krna h
        if(arr[i]>maxi){
            maxi=arr[i];
        }
        //getMax(arr,i+1,maxi);
        return getMax(arr,i+1,maxi);
    }

    public static  int getMin(int arr[], int i, int mini){
        if(i>= arr.length){
            return mini;
        }
        if(arr[i]<mini){
            mini=arr[i];
        }
        return  getMin(arr, i+1, mini);
    }
    public static void main(String[] args) {
        System.out.println("enter the size of array");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int arr[]= new int[n];
        System.out.println("Enter the value of array");
        for(int i=0;i<arr.length;i++){
            arr[i]=scanner.nextInt();
        }
        int i=0;
        int maxi=Integer.MIN_VALUE;
        int mini =Integer.MAX_VALUE;
        int max = getMax(arr, i, maxi);
        System.out.println("max="+max);
        int min = getMin(arr, i, mini);
        System.out.println("mini="+min);

    }
}
