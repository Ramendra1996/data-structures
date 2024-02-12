package com.recursionBacktracing;

//it's a dp question
public class PerfectSquaresLeetCode279 {
 static    int numSquaresHelper(int n){
        if(n==0){
            return 1;
        }
        if(n<0){
            return 0;
        }
        int i=1;
        int ans = Integer.MAX_VALUE;
        int end = (int) Math.sqrt(n);
        while(i<=end){
            int perfectSqare = i*i;
            int numOfPerfectSqaure = 1+numSquaresHelper(n-perfectSqare);
            if(numOfPerfectSqaure<ans){
                ans=numOfPerfectSqaure;
            }
            ++i;
        }
        return ans;
    }
    //Tc_>0(sqrt(n)^n)
    //sc->0(n)

    static int numSquares(int n) {
        return numSquaresHelper(n)-1;
    }

    public static void main(String[] args) {
     int n =12;
        int i = numSquares(n);
        System.out.println(i);
    }
}
