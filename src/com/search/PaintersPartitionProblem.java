package com.search;

public class PaintersPartitionProblem {
 static boolean isPossible(int arr[], int n,int k,int mid){
     int boardSum=0;
     int painterCount=1;
     for(int i=0;i<n;i++){
         if(arr[i]>mid){
             return  false;
         }
         if(boardSum+arr[i]>mid){
          painterCount++;
           boardSum=arr[i];
          if(painterCount>k){
              return false;
          }
         }else{
          boardSum+=arr[i];
         }
     }
     return true;
 }
    static long getSolve(int arr[], int n, int k){
        int start=0;
         int sum=0;
         int ans =-1;
         for(int i=0;i<n;i++){
             sum+=arr[i];
         }
         int end =sum;
         while (start<=end){
      int mid = start+(end-start)/2;
             if(isPossible(arr,n,k,mid)){
                   ans=mid;
                   end=mid-1;
             }else{
              start=mid+1;
             }
         }
          return(long) ans;
    }
    public static void main(String[] args) {
        int arr[]={5,10,30,20,15};
        int n = arr.length;
         int k =3;
        long solve = getSolve(arr, n, k);
        System.out.println(solve);
    }
}
