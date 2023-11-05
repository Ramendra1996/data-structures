package com.string;

public class PalindromicSubstrings647LeetCode {

    public static int expandAroundIndex(String s,int i, int j){
        int count=0;
        while(i>=0 && j<s.length() && s.charAt(i)==s.charAt(j)){
            count++;
            i--;
            j++;
        }
        return count;
    }
    public static int countSubstrings(String s) {
        int count=0;
        int n = s.length();

        for(int i=0;i<n;i++){
            //odd
            int oddKaAns =expandAroundIndex(s,i,i);
            count=count+oddKaAns;
            //even
            int evenKaAns=expandAroundIndex(s,i,i+1);
            count=count+evenKaAns;
        }
        return count;
    }

    public static void main(String[] args) {
        String str = "abc";

        int count = countSubstrings(str);

        System.out.println("count="+count);
    }
}
//Tc->0(n^2)
