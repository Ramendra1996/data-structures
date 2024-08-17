package com.string;

public class LongestCommonPrefixLeetCode14 {
    static String longestCommonPrefix(String[] strs) {
        String ans="" ;
        int i=0;
        while (true){
            char curr_ch =' ';
            for (String str:strs){
                if(i>=str.length()){
                    //out of bound condtion
                    curr_ch=' ';
                    break;
                }
                //just start
                if(curr_ch==' '){
                    curr_ch=str.charAt(i);
                } else if (str.charAt(i)!=curr_ch) {
                    curr_ch=' ';
                    break;
                }
            }
            if (curr_ch==' '){
                break;
            }
            ans+=curr_ch;
            i++;
        }
       return ans;
    }
    public static void main(String[] args) {
        String[] strs={"flower","flow","flight"};
        String s = longestCommonPrefix(strs);
        System.out.println(s);
    }
}
//the time complexity is O(N * M),
// the overall space complexity is O(M).