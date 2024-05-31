package com.numberTheory;

public class FactorAndDivisor {
    public static  void getFactDivisor(int n){
        int count =0;
        int sum=0;
        for(int i=1;i *i <=n;i++){
            if(n%i==0){
                System.out.println("divosor="+i +","+n/i);
                count+=1;
                sum+=i;
                if(n/i!=i){
                    sum+=n/i;
                    count+=1;
                }
            }
        }
        System.out.println("count= "+count +" "+"sum= "+sum);
    }
    //TC=>0(sqrt(n))
    public static void main(String[] args) {

        int n =24;
         getFactDivisor(n);
    }
}
