package com.numberTheory;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactorisation {

    public  static List<Integer> fact(int n){
        List<Integer> primeFactor= new ArrayList<>();
        for(int i=2;i*i<=n;i++){
            while (n%i==0){
                primeFactor.add(i);
                n/=i;
            }
        }
        if (n>1){
            primeFactor.add(n);
        }
        return primeFactor;
    }
    public static void main(String[] args) {
        int n =24;
        List<Integer> fact = fact(n);
        System.out.println(fact);

    }
}
