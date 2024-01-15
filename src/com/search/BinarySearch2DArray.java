package com.search;

import java.util.Scanner;

public class BinarySearch2DArray {

    public static  boolean getSearch(int arr[][], int key){
      int start=0;
      int end = (arr.length*arr[0].length)-1;

      while (start<=end){
          int mid = start+(end-start)/2;
          int rowIndex=mid/arr[0].length;
          int colIndex= mid%arr[0].length;

          if (arr[rowIndex][colIndex]==key){
              return true;
          } else if (arr[rowIndex][colIndex]<key) {
              start=mid+1;
          }else {
              end=mid-1;
          }
      }
      return false;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the key");
        int key = scanner.nextInt();
        System.out.println("Enter the row:");
        int row = scanner.nextInt();
        System.out.println("Enter the column:");
        int col = scanner.nextInt();
        int arr[][]= new int[row][col];
        for (int i=0;i<arr.length;i++){
            for (int j=0;j<arr[0].length;j++){
                arr[i][j]= scanner.nextInt();
            }
        }
        if(getSearch(arr, key)){
            System.out.println("Found");
        }else {
            System.out.println("NotFound");
        }

    }
}
