package com.basic;

import java.util.Scanner;

import static java.lang.Math.pow;

public class BinaryToDecimalConversion {

    public  static  int getConversion(int n){
       int decimal =0;
        int i=0;
       while (n>0){
           int bit = n%10;
           decimal= (int) (decimal+bit*pow(2,i++));
           n/=10;
       }
       return decimal;
    }
    public static void main(String[] args) {
        System.out.println("Enter the number:");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int result = getConversion(n);
        System.out.println(result);

    }
}
