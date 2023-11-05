package com.search;

import java.util.Scanner;

public class LinearSearch {

    public static boolean getSearch(int arr[], int key){

        for(int i=0;i<arr.length;i++){
            if(arr[i]==key){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println("Enter the size of array");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int arr[]= new int[n];
        for (int i=0;i<arr.length;i++){
            arr[i]=scanner.nextInt();
        }
        System.out.println("Enter the key");
        int key = scanner.nextInt();

        if(getSearch(arr, key)){
            System.out.println("Present");
        }else {
            System.out.println("Not present");
        }
    }
}
//T.C->0(n)
//S.C->(1)