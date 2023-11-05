package com.recursionBacktracing;

public class MaxSumOfNoAdjacentElement {
    public static int   getSolve(int arr[], int i,int sum, int maxi){
      if(i>=arr.length){
          maxi=Math.max(sum,maxi);
          return maxi;
      }
      //include
        int include = getSolve(arr, i + 2, sum + arr[i], maxi);
        //exclude
     int exclude =getSolve(arr,i+1,sum,maxi);

     return Math.max(include,exclude);
    }
    public static void main(String[] args) {
        int arr[]= {2,1,4,9};
        int maxi =Integer.MIN_VALUE;
        int sum=0;
        int i=0;
        int solve = getSolve(arr, i, sum, maxi);
        System.out.println("max="+solve);
    }
}
