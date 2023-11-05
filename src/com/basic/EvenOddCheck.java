package com.basic;

import java.util.Scanner;

public class EvenOddCheck {
    public  static  String  getCheck(int n){
     /*   if(n%2==0){
            return "Even";
        }else {
            return "odd";
        }*/
        if((n&1)==0){
            return "Even";
        }else {
            return "odd";
        }
    }
    public static void main(String[] args) {
        System.out.println("Enter the number:");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String result = getCheck(n);
        System.out.println(result);
    }
}
