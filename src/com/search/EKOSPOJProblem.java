package com.search;

public class EKOSPOJProblem {
    static boolean isPossible(int trees[], int m ,int mid){
        int woodCollect =0;
        for(int i=0;i< trees.length;i++){
            if(trees[i]>mid){
                woodCollect+=trees[i]-mid;
            }
        }
        return woodCollect>=m;
    }

    static  int getSolve(int trees[], int n, int m){
        int maxi = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(trees[i]>maxi){
                maxi=trees[i];
            }
        }
        int start =0;
        int end = maxi;
        int ans=-1;
        while (start<=end){
            int mid = start+(end-start)/2;
            if(isPossible(trees,m, mid)){
            ans = mid;
            start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int trees[]={20,15,10,17};
        int n = 4;
        int m = 7;
        int solve = getSolve(trees, n, m);
        System.out.println(solve);
    }
}
