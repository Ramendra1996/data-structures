package com.recursionBacktracing;

public class BuyAndSellStockLeetCode121 {
    static int maxProfitFinder(int []prices,int i,int minPrice,int maxProfit){
        //base case
        if(i>=prices.length){
            return maxProfit;
        }
        //1 case
       if(prices[i]<minPrice){
           minPrice=prices[i];
       }
       int toDaysProfit = prices[i]-minPrice;
       if(toDaysProfit>maxProfit){
           maxProfit=toDaysProfit;
       }
       return maxProfitFinder(prices,i+1,minPrice,maxProfit);
    }
    static int maxProfit(int[] prices) {
        int minPrice =Integer.MAX_VALUE;
         int maxProfit =Integer.MIN_VALUE;
        int r= maxProfitFinder(prices,0,minPrice,maxProfit);
        return r;
    }
    static int maxProfit1(int[] prices) {
         int minPrice = prices[0];
         int maxProfit =0;
         for(int i=1;i<prices.length;i++){
             int toDaysProfit = prices[i]-minPrice;

             if(toDaysProfit>maxProfit){
                 maxProfit=toDaysProfit;
             }
             if(minPrice>prices[i]){
                 minPrice=prices[i];
             }
         }
         return maxProfit;
    }
    public static void main(String[] args) {
      int[]  prices = {7,1,5,3,6,4};
        int i = maxProfit(prices);
        System.out.println(i);
        int i1 = maxProfit1(prices);
        System.out.println(i1);

    }
}
