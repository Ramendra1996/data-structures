package com.basic;

import java.util.Scanner;

public class ReverseIntegerLeetCode7 {
    public static int getReverse(int n) {

        int ans =0;
        int rem =0;
        boolean isNeg =false;
        if(n<0){
            isNeg =true;
            n=-n;
        }
        if(n<=Integer.MIN_VALUE){
            return 0;
        }
        while(n>0){
            if(ans>Integer.MAX_VALUE/10){
                return 0;
            }
            int digit = n%10;
            ans = ans*10+digit;
            n= n/10;
        }
        return isNeg? -ans:ans;
    }

    public static void main(String[] args) {

        System.out.println("Enter the number:");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int result = getReverse(n);
        System.out.println(result);

    }

}
