package com.array;

import java.util.Scanner;

public class Count0and1 {
    public static void getCount(int arr[]){
        int zeroCount =0;
        int oneCount=0;
        for (int i=0;i<arr.length;i++){
            if(arr[i]==0){
                zeroCount++;
            } else if (arr[i]==1) {
                oneCount++;
            }
        }
        System.out.println("zeroCount="+zeroCount);
        System.out.println("oneCount="+oneCount);
    }
    public static void main(String[] args) {
        System.out.println("Enter the size of array");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int arr[]= new int[n];
        for (int i=0;i<arr.length;i++){
            arr[i]=scanner.nextInt();
        }
        getCount(arr);

    }
}
