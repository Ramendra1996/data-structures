package com.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FraCtionalKnapshak {
    static class Pair {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
    static class PairComparator implements Comparator<Pair> {
        @Override
        public int compare(Pair a, Pair b) {
            // Compare based on the ratio (value/weight)
            double ratioA = (double) a.first / a.second;
            double ratioB = (double) b.first / b.second;
            return Double.compare(ratioB, ratioA);
        }
    }
    public static void main(String[] args) {
        int val[] = {60, 100, 120};
        int wt[] = {10, 20, 30};
        int n =3;
        int capacity = 50;

        List<Pair> list = new ArrayList<>();

        for(int i=0;i<n;i++){
            list.add(new Pair(val[i],wt[i]));
        }
        Collections.sort(list,new PairComparator());

        //check each item k entire lena h ya fraction
        int totalValue =0;
        for(int i=0;i<n;i++){
            Pair item = list.get(i);
            int itemValue = item.first;
            int itemWeight = item.second;
            //entire inclusion wala case
            if(itemWeight<=capacity){
                //add value
               totalValue+=itemValue;
               //update capacity
                capacity=capacity-itemWeight;
            }else {
                //fraction include kro
                //update value
                double ratio= (double) itemValue/itemWeight;
                int valueToAdd =(int) ratio*capacity;
                totalValue+=valueToAdd;
                //update capacity
                capacity=0;
                break;
            }
        }
        System.out.println("Maximum value in Knapsack is: " + totalValue);
    }
}
