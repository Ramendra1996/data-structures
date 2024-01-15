package com.search;

public class TotalNumberOfOccurrence {
     static  int firstOccurrence(int arr[] , int target){
        int start =0;
         int end = arr.length-1;
         int ans =0;
         while (start<=end){
             int mid =start+(end-start)/2;
             if(arr[mid]==target){
                 ans=mid;
                 end=mid-1;
             } else if (arr[mid]>target) {
                 end=mid-1;
             }else {
                 start = mid+1;
             }
         }
         return ans;
    }
   static int lastOccurrence(int arr[], int target){
        int start =0;
        int end=arr.length-1;
        int ans =0;
        while (start<=end){
            int mid = start+(end-start)/2;
            if(arr[mid]==target){
                ans=mid;
                start=mid+1;
            } else if (arr[mid]>target) {
                end=mid-1;
            }else {
                start= mid+1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int arr[] = {2,4,4,4,4,4,4,6,8,10};
        int target = 4;
         int totalOccurrence = lastOccurrence(arr,target)-firstOccurrence(arr,target)+1;
        System.out.println("totalOccurrence=>"+totalOccurrence);
    }
}
