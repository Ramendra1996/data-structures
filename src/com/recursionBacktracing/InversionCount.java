package com.recursionBacktracing;

public class InversionCount {

    public static int inversionCountBrut(int arr[]){
        int count=0;
        for (int i=0;i<arr.length;i++){
            for (int j=i+1;j<arr.length;j++){
                if(arr[i]>arr[j]){
                    count++;
                }
            }
        }
        return count++;
    }
    public static  int inversionCountByMergeSort(int arr[],int start, int end){
        return 0;
    }
    public static void main(String[] args) {

        int arr[]={1, 20, 6, 4, 5 };
        int i = inversionCountBrut(arr);
        System.out.println(i);


    }
}
