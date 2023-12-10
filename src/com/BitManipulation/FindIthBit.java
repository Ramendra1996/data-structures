package com.BitManipulation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindIthBit {

    public static int getithBit(int n,int i){
        int mask =1<<i;
        int ans = n &mask;
        if(ans==0){
            return 0;
        }else {
            return 1;
        }
    }
    static  void setiThBit(int n , int i){
      int mask = 1<<i;
      int ans = n| mask;
        System.out.println("setithBit=>"+ans);
    }

    static void cleariThBit(int n , int i){
        int mask = ~(1<<i);
        int ans = n & mask;
        System.out.println("clearithbit=>"+ans);
    }
    static void updateiThBit(int n ,int i, int target){
        cleariThBit(n,i);
        int mask = target<<i;
        n=n | mask;
        System.out.println("updateithBit=>"+n);

    }
    static void clearLastiThBit(int n , int i){
     int mask = (-1<<i);
     n= n & mask;
        System.out.println("clearLastIthBit=>"+n);
    }
    static boolean checkPowerOfTwo(int n){

         if((n & (n-1))==0){
           return true;
         }else {
             return false;
         }
    }
    static int countSetBit(int n){
    int count =0;
    while (n!=0){
        int lastBit =n &1;
        if(lastBit==1){
            count++;
        }
        //rightShift
        n= n>>1;
    }
    return count;
    //TC_>0(logn)
    }
    static int countSetBitFast(int n){
        int count =0;
        while (n!=0){
            //remove last set bit
            n=(n &(n-1));
            count++;
        }
        return count;
    }
    static void getSubSequence(String str){
        List<String> list = new ArrayList<>();
        int n =str.length();
        for(int num =0;num<(1<<n);num++) {
            StringBuffer temp = new StringBuffer();
            for (int i = 0; i < n; i++) {
                char ch = str.charAt(i);
                if ((num & (1 << i)) != 0) {
                    //non - zero value ke liye
                    temp.append(ch);
                }
            }
            if (temp.length() >= 0) {
                list.add(temp.toString());
            }
        }
            for(String s: list){
                System.out.println(s);
            }

    }
    static void clearBitInRange(int n , int i, int j){
        int a = (-1<<(i+1));
        int b= (1<<j)-1;
        int mask =a |b;
        n= n & mask;
        System.out.println("after clearing =>"+n);
    }

    public static void main(String[] args) {
     int n =10;
     int i=1;
        int ans = getithBit(n, i);
        System.out.println("ans=>"+ans);
        setiThBit(n,i);
        cleariThBit(10,1);
        updateiThBit(10,0,1);
        clearLastiThBit(7,2);
        if(checkPowerOfTwo(16)){
            System.out.println("yes");
        }else {
            System.out.println("Not");
        }
        int count = countSetBit(10);
        System.out.println("count=>"+count);
        int fastCount = countSetBitFast(10);
        System.out.println("fastCount=>"+fastCount);

        clearBitInRange(15,2,1);
        getSubSequence("abc");
    }

}
