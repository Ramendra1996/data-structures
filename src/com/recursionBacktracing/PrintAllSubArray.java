package com.recursionBacktracing;

public class PrintAllSubArray {

  static  void printSubArray(int arr[], int start, int end){
        //base case
    if(end>=arr.length){
        return;
    }
        //1case
        for(int i=start; i<=end;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        printSubArray(arr,start,end+1);
    }
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5};
        int start=0;
         int end= start;
        printSubArray(arr,start,end);
    }
}
