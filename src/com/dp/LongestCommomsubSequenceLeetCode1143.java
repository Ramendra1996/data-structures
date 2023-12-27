package com.dp;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LongestCommomsubSequenceLeetCode1143 {

    static  int bottomUpApproach(String a,String b){
        List<List<Integer>>dp = new ArrayList<>(a.length()+2);
        for (int k = 0; k <a.length()+1; k++) {
            dp.add(new ArrayList<>(Collections.nCopies(b.length()+2, 0)));
        }
        for (int i=a.length()-1;i>=0;i--){
            for (int j=b.length()-1;j>=0;j--){
                int ans =0;
                if(a.charAt(i)==b.charAt(j)){
                    ans =1+dp.get(i+1).get(j+1);
                }else {
                    ans =0+Math.max(dp.get(i).get(j+1),dp.get(i+1).get(j));
                }
                dp.get(i).set(j, ans);
            }

        }
        return dp.get(0).get(0);
    }
    static int topDownApproach(String a, String b,int i, int j,List<List<Integer>>dp){
        if (i == a.length() || j == b.length()) {
            return 0;
        }
        if(dp.get(i).get(j)!=-1){
            return dp.get(i).get(j);
        }
       int ans =0;
        if (a.charAt(i) == b.charAt(j)) {
            ans = 1 + topDownApproach(a, b, i + 1, j + 1,dp);
        } else {
            ans = Math.max(topDownApproach(a, b, i, j + 1,dp), topDownApproach(a, b, i + 1, j,dp));
        }
        dp.get(i).set(j,ans);
        return dp.get(i).get(j);
    }
    static int solveRecursion(String a, String b, int i, int j) {
        if (i == a.length() || j == b.length()) {
            return 0;
        }

        int ans = 0;
        if (a.charAt(i) == b.charAt(j)) {
            ans = 1 + solveRecursion(a, b, i + 1, j + 1);
        } else {
            ans = Math.max(solveRecursion(a, b, i, j + 1), solveRecursion(a, b, i + 1, j));
        }
        return ans;
    }

    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";
        int i = 0;
        int j = 0;

        System.out.println(solveRecursion(text1, text2, i, j));
        List<List<Integer>>dp = new ArrayList<>(text1.length());
        for (int k = 0; k <text1.length(); k++) {
            dp.add(new ArrayList<>(Collections.nCopies(text2.length(), -1)));
        }
        System.out.println(topDownApproach(text1,text2,i,j,dp));
        System.out.println(bottomUpApproach(text1,text2));
    }
}
