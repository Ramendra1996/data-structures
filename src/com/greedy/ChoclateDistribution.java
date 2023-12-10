package com.greedy;

import java.util.Arrays;

public class ChoclateDistribution {

    public static void main(String[] args) {
        int n=8;
        int m=5;
        int arr[]={3,4,1,9,56,7,9,12};
        //sort
        Arrays.sort(arr);
        //check difference in m-size window
        int i=0;
        int j=m-1;
        int diff = Integer.MAX_VALUE;
        while (j<n){
           int   newDiff = arr[j]-arr[i];
           diff=Math.min(diff,newDiff);
           j++;
           i++;
        }
        System.out.println("diff=>"+diff);
    }
}
