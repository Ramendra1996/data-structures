package com.recursionBacktracing;

//leetCode 912

//gap method
public class InPlaceMergeSortLeetCode912 {
    static  void  swap(int arr[], int i , int j){
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]= temp;
    }
    static  void  mergeInPlace(int arr[], int start,int mid ,int end){
        int total_len = end-start+1;
        int gap = total_len/2 +total_len%2;
        while (gap>0){
            int i = start, j = start+gap;
            while (j<=end){
                if(arr[i]> arr[j]){
                    swap(arr , i ,j);
                }
                ++i;
                ++j;
            }
            gap= gap<=1 ?0:(gap/2)+(gap%2);
        }

    }
    static void mergeSort(int arr[], int start, int end){
        if(start>=end){
            return;
        }
        int mid = (start+end)>>1;
        mergeSort(arr,start,mid);
        mergeSort(arr,mid+1,end);
        mergeInPlace(arr,start,mid,end);
    }
    public static void main(String[] args) {

       int arr[]={5,2,3,1};
       int start =0;
        int end =arr.length-1;
        mergeSort(arr,start,end);

        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }

    }
}
