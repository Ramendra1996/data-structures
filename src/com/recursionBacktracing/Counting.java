package com.recursionBacktracing;

import java.util.Scanner;

public class Counting {

    public static void getCounting(int n){
         if(n==0){
             return;
         }
        System.out.println(n);
         getCounting(n-1);
    }
    public static void main(String[] args) {
        System.out.println("Enter the number:");
        Scanner  scanner = new Scanner(System.in);
        int n = scanner.nextInt();
            getCounting(n);
    }
}
