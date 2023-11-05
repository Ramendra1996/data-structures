package com.string;

import java.util.Scanner;

public class ReverseString {
    public static String getReverse(String str) {
         char ch[]= str.toCharArray();
         int n = ch.length;
         for(int i=0;i<n/2;i++){
             char temp = ch[i];
             ch[i]=ch[n-1-i];
             ch[n-1-i]=temp;
         }
         return String.valueOf(ch);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the String");
        String str = scanner.next();

        String reverse = getReverse(str);
        System.out.println("reverse String=" + reverse);
    }
}
