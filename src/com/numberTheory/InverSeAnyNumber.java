package com.numberTheory;

public class InverSeAnyNumber {
    static int M = 1000000007;
    public static  int binExp(int a , int b, int m){
        int result = 1;
        while (b > 0) {
            if ((b & 1) == 1) { // check if the least significant bit is 1
                result = (result * a) % m;
            }
            a = (a * a) % m; // square the base
            b >>= 1; // right shift the exponent
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(binExp(3,M-2,M));
    }
}
