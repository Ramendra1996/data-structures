package com.search;

import java.util.Scanner;

public class SquareRoot {
    public static double getSquareRoot(int n, int precision) {
        double start = 0;
        double end = n;
        double ans = 0;
        double epsilon = Math.pow(10, -precision);

        while (end - start > epsilon) {
            double mid = start + (end - start) / 2;
            if (mid * mid == n) {
                return mid;
            } else if (mid * mid > n) {
                end = mid;
            } else {
                ans = mid;
                start = mid;
            }
        }
        return ans;
    }
    public static int getSquareRoot(int n){
        int start =0;
        int end =n;
        int ans =0;
        while (start<=end){
            int mid = start+(end-start)/2;
            if(mid*mid==n){
                return mid;
            } else if (mid*mid>n) {
                end=mid-1;
            }else {
                ans=mid;
                start=mid+1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println("Enter the number:");
        Scanner scanner= new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println("Enter the presion:");
        int precision=scanner.nextInt();
        int squareRoot = getSquareRoot(n);
        double finalAns=squareRoot;
        double step=0.1;
        for (double i=0;i<precision;i++){
            for (double j=finalAns;j*j<=n;j=j+step){
                finalAns=j;
            }
            step=step/10;
        }
        System.out.println("SquareRoot="+finalAns);
    }
}
//TC->0(log n)
//SC->0(1)
