package com.string;

public class FirstOccurrenceInAStringLeetcode28 {
    static int strStr(String haystack, String needle) {
        int n = haystack.length();
         int m = needle.length();

         for(int i=0;i<=n-m;i++){
             for (int j=0;j<m;j++){
                 if(needle.charAt(j)!=haystack.charAt(i+j)){
                     break;
                 }
                 if(j==m-1){
                     return i;
                 }
             }
         }
       return -1;

    }

    public static void main(String[] args) {
       String haystack = "sadbutsad";
       String needle = "sad";
        int i = strStr(haystack, needle);
        System.out.println(i);
    }
}
