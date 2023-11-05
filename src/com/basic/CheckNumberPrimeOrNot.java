package com.basic;

import java.util.Scanner;

import static java.lang.Math.sqrt;

public class CheckNumberPrimeOrNot {
    public  static  boolean getCheck(int n){

        for(int i=2;i<=sqrt(n);i++){
            if(n%i==0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println("Enter the number:");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        if (getCheck(n)){
            System.out.println("prime");
        }else {
            System.out.println("Not prime");
        }
    }
}
