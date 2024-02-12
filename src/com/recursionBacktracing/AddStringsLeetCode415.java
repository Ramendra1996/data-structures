package com.recursionBacktracing;

public class AddStringsLeetCode415 {

   static String addStringsHelper(String num1, String num2, int i, int j, int carry){

       if(i<0 &&j<0){
           if(carry!=0){
               return String.valueOf(carry);
           }
           return "";
       }

       int n1 = (i >= 0) ? num1.charAt(i) - '0' : 0;
       int n2 = (j >= 0) ? num2.charAt(j) - '0' : 0;

       int csum = n1 + n2 + carry;
       int digit = csum %10;
       carry = csum/10;
       String ans ="";
       ans = String.valueOf(digit);
       ans += addStringsHelper(num1, num2, i-1, j-1, carry);
       return ans;
   }
   static  String addString1(String num1, String num2){
       String s = addStringsHelper(num1, num2, num1.length() - 1, num2.length() - 1, 0);
       return new StringBuilder(s).reverse().toString();
   }
    static String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int carry = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        while (i >= 0 || j >= 0 || carry > 0) {
            int digit1 = (i >= 0) ? num1.charAt(i--) - '0' : 0;
            int digit2 = (j >= 0) ? num2.charAt(j--) - '0' : 0;
            int sum = digit1 + digit2 + carry;
            carry = sum / 10;
            result.insert(0, sum % 10);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String num1="11";
        String num2="123";
        String s = addStrings(num1, num2);
        System.out.println(s);
        String s1 = addString1(num1, num2);
        System.out.println(s1);
    }
}
