package com.recursionBacktracing;

public class CheckPalindrome {
    static boolean getPalindrome(String str,int start, int end){
        //base case
         if(start>=end){
             return true;
         }
        //one case soln
        if(str.charAt(start)!=str.charAt(end)){
            return false;
        }
        return  getPalindrome(str,start+1,end-1);
    }
    public static void main(String[] args) {
     String str ="racecar";

        boolean palindrome = getPalindrome(str, 0, str.length() - 1);
        System.out.println(palindrome);
    }
}
