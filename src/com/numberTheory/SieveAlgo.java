package com.numberTheory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SieveAlgo {

    public static  void  getDivisor(int n){
        List<Integer> divisors = new ArrayList<>(n);
        for (int i=2;i<n;i++){
            for (int j=i;j<n;j+=i){
             divisors.set(j,i);
            }
        }
    }

    public static  void  getLowAndHighPrime(int n){
        List<Boolean> isPrime = new ArrayList<>(Collections.nCopies(n, true));
        List<Integer> lowestPrime = new ArrayList<>(Collections.nCopies(n,0));
        List<Integer> highestPrime = new ArrayList<>(Collections.nCopies(n,0));
        isPrime.set(0,false);
        isPrime.set(1,false);
        for (int i=2;i<n;i++){
            if(isPrime.get(i)==true){
                lowestPrime.set(i,i);
                highestPrime.set(i,i);
                for (int j=2*i;j<n;j=j+i){
                    isPrime.set(j,false);
                    highestPrime.set(j,i);
                    if(lowestPrime.get(j)==0){
                        lowestPrime.set(j,i);
                    }
                }
            }
        }

        List<Integer>primeFactor = new ArrayList<>();
        while (n>1){
            int pFactor = highestPrime.get(n);
            while (n %pFactor ==0){
                n/=pFactor;
                primeFactor.add(pFactor);
            }
        }
    }

    public static void getPrime(int n){
     List<Boolean> isPrime = new ArrayList<>(Collections.nCopies(n, true));
     isPrime.set(0,false);
     isPrime.set(1,false);

     for (int i=2;i<n;i++){
         if(isPrime.get(i)==true){
             for (int j=2*i;j<n;j=j+i){
                 isPrime.set(j,false);
             }
         }
     }

     for (int i=2;i<n;i++){
         if(isPrime.get(i)==true){
             System.out.println("primeNumber="+i);
         }

     }

    }
    public static void main(String[] args) {
         int n = 50;
         getPrime(n);
    }
}
