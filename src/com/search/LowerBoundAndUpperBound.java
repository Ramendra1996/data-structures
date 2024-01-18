package com.search;

public class LowerBoundAndUpperBound {


    static   int lowerBound(int arr[],int x){
        int start=0;
        int end=arr.length-1;
        int ans=end;
        while(start<=end){
            int mid =start+(end-start)/2;
            if(arr[mid]>=x){
                ans=mid;
                end=mid-1;
            }else if(x>arr[mid]){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5};
    }
}
