package com.string;

import java.util.Scanner;

public class Palindrome {
    public static  boolean getCheck(String str){
      char ch[]= str.toCharArray();
      int n = ch.length;
      for(int i=0;i<n;i++){
          if(ch[i]!=ch[n-1-i]){
              return false;
          }
      }
      return true;
    }
    public static void main(String[] args) {
        System.out.println("Enter the String");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        if(getCheck(str)){
            System.out.println("palindrome");
        }else {
            System.out.println("not palindrome");
        }
    }
}

//Tc->0(n)
//SC->0(1)