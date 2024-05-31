package com.numberTheory;

public class BinaryExponential {
    static int M = 1000000007;
    public static  int binExRecur(int a , int b) {
        if(b==0){
            return 1;
        }
        if((b&1) !=0){
            return  a* binExRecur(a,b/2) * binExRecur(a,b/2);
        }else {
               return binExRecur(a,b/2) * binExRecur(a,b/2);
        }
    }
    public  static  int binExpo(int a , int b){
        int ans =1;
        while (b>0){
            if((b&1)!=0){
                ans = ans*a;
            }else {
                a=a*a;
                b>>=1;
            }
        }
        return  ans;
    }
    public static  int bitMultiply(long a, long b){
        int ans =0;
        while (b>0){
            if((b&1)!=0){
                ans= (int) ((ans+a)%M);
            }
            a=(a+a)%M;
            b>>=1;
        }
        return ans;
    }
    public static void main(String[] args) {

    }
}

//tc=>0(logn)