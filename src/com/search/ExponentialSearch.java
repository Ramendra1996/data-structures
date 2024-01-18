package com.search;

public class ExponentialSearch {
    static  int binarySearch(int arr[],int start , int end , int x){
        while (start<=end){
            int mid = start+(end-start)/2;
            if(arr[mid]==x){
                return mid;
            } else if (arr[mid]>x) {
                end=mid-1;
            }else {
                start=mid+1;
            }
        }
        return -1;
    }
    static  int getSearch(int arr[], int n , int x){
        if(arr[0]==x){
            return 0;
        }
        int i=1;
        while (i<n && arr[i]<=x){
          i=i*2;
          //i=i<<1;
        }
        return  binarySearch(arr,i/2,Math.min(i,n-1),x);
    }
    public static void main(String[] args) {
        int arr[]={3,4,5,6,11,13,14,15,56,70};
        int n = arr.length;
        int x =13;
        int ans = getSearch(arr,n,x);
        System.out.println(ans);
    }
}
 //Tc->log(2^log m-1)
// search in infinite  array
//better than bsc when target near to start