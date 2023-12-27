package com.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaximumHeightByStackingCuboidsLeetCode1691 {
    static boolean check(int[]a, int[]b){
       if(b[0]<=a[0] && b[1]<=a[1]&& b[2]<=a[2]){
          return true;
       }else {
           return false;
       }
    }
    static int spaceOptimization(int[][] cuboids){
        int n = cuboids.length;
        List<Integer> currRow =new ArrayList<>(Collections.nCopies(n+1,0));
        List<Integer>nextRow =new ArrayList<>(Collections.nCopies(n+1,0));

        for ( int curr =n-1;curr>=0;curr--){
            for ( int prev=curr-1;prev>=-1;prev--){
                //include
                int include =0;
                if(prev==-1 || check(cuboids[curr],cuboids[prev])){
                    include=cuboids[curr][2]+nextRow.get(curr+1);
                }
                //exclude
                int exclude =0+nextRow.get(prev+1);
                int ans = Math.max(include,exclude);
                currRow.set(prev+1,ans);
            }
            //shift
            nextRow = new ArrayList<>(currRow);
        }
        return nextRow.get(0);

    }
    public static void main(String[] args) {
        int[][] cuboids = {{50, 45, 20}, {95, 37, 53}, {45, 23, 12}};
        // Sort every array
        for (int[] a : cuboids) {
            Arrays.sort(a);
        }

        // Sort the 2D array
        Arrays.sort(cuboids, (a, b) -> {
            for (int i = 0; i < a.length; i++) {
                int cmp = Integer.compare(a[i], b[i]);
                if (cmp != 0) {
                    return cmp;
                }
            }
            return 0;
        });
      /*  for (int[] a : cuboids) {
            System.out.println(Arrays.toString(a));
        }*/
        System.out.println(spaceOptimization(cuboids));
    }
}
