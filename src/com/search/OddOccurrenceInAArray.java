package com.search;

public class OddOccurrenceInAArray {

    static int getOddOccurrence(int arr[]){
        int start =0;
        int end =arr.length-1;
        while (start<=end){
            int mid = start+(end-start)/2;
            if(start==end){
                //single element
                return start;
            }
            //2 case mid even and mid odd
            if((mid&1)==0){
              if(arr[mid]==arr[mid+1]){
                  start=mid+2;
              }else {
                  end=mid;
                }
            }else {
               if(arr[mid]==arr[mid-1]){
                   start=mid+1;
               }else {
                   end=mid-1;
               }
            }

        }
        return -1;
    }
    public static void main(String[] args) {
        int arr[]={1,1,2,2,3,3,4,4,3,600,600,4,4};
        int oddOccurrence = getOddOccurrence(arr);
        System.out.println("index=>"+oddOccurrence);
        System.out.println("value=>"+arr[oddOccurrence]);

    }
}
