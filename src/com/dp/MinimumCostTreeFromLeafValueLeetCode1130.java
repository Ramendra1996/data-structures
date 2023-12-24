package com.dp;

import java.util.HashMap;
import java.util.Map;

public class MinimumCostTreeFromLeafValueLeetCode1130 {
    //baad me krna h
   static class Pair{
        int first;
        int second ;
        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
    static  int solveRecursion(int[] arr, Map<Pair, Integer> maxi,int left , int right){
        if(left == right) return 0;
        int ans = Integer.MAX_VALUE;

        for(int i = left; i < right; i++){
            ans = Math.min(ans,
                    maxi.get(new Pair(left, i)) * maxi.get(new Pair(i + 1, right))
                            + solveRecursion(arr, maxi, left, i) + solveRecursion(arr, maxi, i + 1, right)
            );
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = {6, 2, 4};
        int n = arr.length;;
        Map<Pair, Integer> maxi = new HashMap<>();
        for(int i = 0; i < n; i++){
            maxi.put(new Pair(i,i), arr[i]);
            for(int j = i + 1; j < n; j++){
                maxi.put(new Pair(i, j), Math.max(arr[j], maxi.get(new Pair(i, j - 1))));
            }
        }
        System.out.println(solveRecursion(arr,maxi,0,n-1));
    }
}
