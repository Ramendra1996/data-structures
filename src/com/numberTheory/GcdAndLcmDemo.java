package com.numberTheory;

//Euclid's algorithm
public class GcdAndLcmDemo {

    public  static  int gcd(int a , int b){
        if(b==0){
            return b;
        }
        if(a==0){
            return a;
        }
        return gcd(b,a%b);
        //tc=>0(logn)
    }

    public static  int lcm(int a , int b){
        int ans = a*b/gcd(a,b);
        return ans;
    }
    public static void main(String[] args) {
       int a =12;
       int b=18;
        System.out.println(gcd(a,b));
        System.out.println(lcm(a,b));
    }
}
