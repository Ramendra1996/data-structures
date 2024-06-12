package com.search;

import java.util.Arrays;

public class AggresiveCowProblem {
    static boolean isPossible(int stalls[] , int n, int k, int mid){
        //can we place k cows with at least mid distance cow
        int cow =1;
        int cowPosition=stalls[0];
        for(int i=1;i<stalls.length;i++){
            if(stalls[i]-cowPosition>=mid){
                 cow++;
                 cowPosition=stalls[i];
            }
            if(cow==k){
                return true;
            }
        }
        return false;
    }

    static int getSolve(int stalls[] , int n,int k){
        Arrays.sort(stalls);
        int start=0;
        int ans =-1;
        // cow place at 1st and last index
         int end =stalls[stalls.length-1]-stalls[0];
         while (start<=end){
              int mid = start+(end-start)/2;
              if(isPossible(stalls,n,k,mid)){
                  ans=mid;
                  start=mid+1;
              }else{
                  end=mid-1;
             }
         }
         return ans;
    }
    public static void main(String[] args) {
      int []  stalls = {1, 2, 4, 8, 9};
      int n=5;
       int k=3;
        int solve = getSolve(stalls, n, k);
        System.out.println(solve);
    }
}
