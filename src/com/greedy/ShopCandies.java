package com.greedy;

import java.util.Arrays;
import java.util.Collections;

public class ShopCandies {
    public static void main(String[] args) {
      int prices[]={2,8,6,9,4,7};
      int n=6;
      Arrays.sort(prices);
      int amount =0;
      int buy =0;
      int free=n-1;

      while (buy<=free){
          amount+=prices[buy];
          buy++;
          free--;
          free--;
      }
        System.out.println("ans=>"+amount);
    }
}
