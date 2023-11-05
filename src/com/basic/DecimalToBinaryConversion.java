package com.basic;

import java.util.Scanner;

import static java.lang.Math.pow;

public class DecimalToBinaryConversion {

    public  static  int getConversion(int n){
   /*  int binary =0;
     int i=0;
        while (n>0){
            int bit = n%2;
            binary= (int) (bit*pow(10,i++) +binary);
            n=n/2;
        }
        return binary;*/
        int binaryNo=0;
        int i=0;
        while (n>0){
           int bit =n&1;
           binaryNo=(int)(bit*pow(10,i++)+binaryNo);
           n=n>>1;
        }
        return binaryNo;
    }
    public static void main(String[] args) {
        System.out.println("Enter the number");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
            int result = getConversion(n);
        System.out.println(result);


    }
}
