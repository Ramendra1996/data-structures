package com.string;

public class VaildPalindrome680LeetCode {
    public  static boolean checkPalindrome(String str, int i, int j){
        while (i<=j){
           if(str.charAt(i)!=str.charAt(j)){
               return false;
           }else {
               i++;
               j--;
           }
        }
        return true;
    }
    public  static boolean getcheck(String str){
        int i=0;
         int j=str.length()-1;
         while (i<=j){
             if(str.charAt(i)!=str.charAt(j)){
                return  checkPalindrome(str,i+1,j)|| checkPalindrome(str,i,j+1);
             }else {
              i++;
              j--;
             }
         }
         return true;
    }
    public static void main(String[] args) {

        String str = "abca";

        if (getcheck(str)){
            System.out.println("validpalindrome");
        }else {
            System.out.println("not a validpalindrome");
        }
    }
}
