package com.search;



public class BookAllocationProblem {

    static boolean isPossible(int arr[], int n, int m, int mid){
        int pageSum=0;
        int studentCount=1;
        for(int i=0;i<n;i++){
            if(arr[i]>mid){
                return false;
            }
            if(pageSum+arr[i]>mid){
                studentCount++;
                pageSum=arr[i];
                if(studentCount>m){
                    return false;
                }
            }else{
                pageSum+=arr[i];
            }
        }
        return true;
    }

    static  int getAllocation(int arr[], int n , int m){
       int start=0;
        int ans =-1;
        int sum=0;
         for(int i=0;i<arr.length;i++){
             sum+=arr[i];
         }
         int end =sum;
         while (start<=end){
             int mid = start+(end-start)/2;
             if(isPossible(arr,n,m,mid)){
                 ans=mid;
                 end=mid-1;
             }else {
                 start=mid+1;
             }
         }
         return ans;
    }
    public static void main(String[] args) {
        int arr[] = {12, 34, 67, 90};
        int n = arr.length;
        int m = 2;
        int allocation = getAllocation(arr, n, m);
        System.out.println(allocation);
    }
}
