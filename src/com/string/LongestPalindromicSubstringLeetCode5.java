package com.string;

public class LongestPalindromicSubstringLeetCode5 {

    static boolean isPalindrome(String str, int start, int end){
        while (start<end){
            if(str.charAt(start)!=str.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    static String longestPalindrome(String s) {
        String ans ="";
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                if(isPalindrome(s,i,j)){
                   String t = s.substring(i,j+1);
                   ans =t.length()>ans.length() ?t:ans;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s));
    }
}
