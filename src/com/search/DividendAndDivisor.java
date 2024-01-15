package com.search;

public class DividendAndDivisor {

    ///correct krna h ans
    static int getFinalAns(int dividend,int divisor){

          int start =0;
          int end = Math.abs(dividend);
          int ans =0;
          while (start<=end){
              int mid = start+(end-start)/2;
              if(Math.abs(divisor*mid)==Math.abs(dividend)){
                  ans = mid;
                  break;
              } else if (Math.abs(divisor * mid)>Math.abs(dividend)) {
                  end=mid-1;
              }else {
                  ans =mid;
                  start= mid+1;
              }
          }
       if((dividend<0 && divisor<0) ||(dividend>0 && divisor>0)){
           return ans;
       }else {
           return -ans;
       }
    }
    public static void main(String[] args) {
        int dividend = -2147483648;
        int divisor =-1;
        int finalAns = getFinalAns(dividend, divisor);
        System.out.println(finalAns);

    }
}
