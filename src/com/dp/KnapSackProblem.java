package com.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KnapSackProblem {
    static int spaceOptimization1(int weight[],int value[], int n,int capacity){

        List<Integer>curr = new ArrayList<>(Collections.nCopies(capacity+1,0));
        for(int w=weight[0];w<=capacity;w++){
            if(weight[0]<=capacity){
                curr.set(w,value[0]);
            }else {
                return curr.set(w,0);
            }
            for(int index=1;index<n;index++){
                for(int wt=capacity;wt>=0;wt--){
                    int exclude = curr.get(wt);

                    // Include the current item if possible
                    int include = 0;
                    if (weight[index] <= wt) {
                        include = value[index] + curr.get(wt - weight[index]);
                    }

                    curr.set(wt, Math.max(include, exclude));

                }

            }

        }
        return curr.get(capacity);
    }

    static int spaceOptimization(int weight[],int value[], int n,int capacity){

        List<Integer>prev = new ArrayList<>(Collections.nCopies(capacity+1,0));
        List<Integer>curr = new ArrayList<>(Collections.nCopies(capacity+1,0));
        for(int w=weight[0];w<=capacity;w++){
            if(weight[0]<=capacity){
                prev.set(w,value[0]);
            }else {
                return prev.set(w,0);
            }
            for(int index=1;index<n;index++){
                for(int wt=0;wt<=capacity;wt++){
                    int exclude = prev.get(wt);

                    // Include the current item if possible
                    int include = 0;
                    if (weight[index] <= wt) {
                        include = value[index] + prev.get(wt - weight[index]);
                    }

                    curr.set(wt, Math.max(include, exclude));

                }
                //shift
                prev = new ArrayList<>(curr);
            }

        }
        return prev.get(capacity);
    }

    static int bottomUpApproach(int weight[],int value[], int n,int capacity){
        List<List<Integer>> dp = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            dp.add(new ArrayList<>(Collections.nCopies(capacity + 1, -1)));
        }
        for(int w=weight[0];w<=capacity;w++){
            if(weight[0]<=capacity){
                dp.get(0).set(w,value[0]);
            }else {
                return dp.get(0).set(w,0);
            }
            for(int index=1;index<n;index++){
                for(int wt=0;wt<=capacity;wt++){
                    int exclude = dp.get(index - 1).get(wt);

                    // Include the current item if possible
                    int include = 0;
                    if (weight[index] <= wt) {
                        include = value[index] + dp.get(index - 1).get(wt - weight[index]);
                    }

                    dp.get(index).set(wt, Math.max(include, exclude));
                }
            }

        }
        return dp.get(n - 1).get(capacity);
    }

    static int topDownApproach(int weight[],int value[], int index,int capacity,List<List<Integer>> dp){
        //base case ->only one item
        if(index==0){
            if(weight[0]<=capacity){
                return value[0];
            }else {
                return 0;
            }
        }
        if (dp.get(index).get(capacity) != -1) {
            return dp.get(index).get(capacity);
        }
        //include
        int include =0;
        if(weight[include]<=capacity){
            include=value[index]+topDownApproach(weight, value, index-1, capacity-weight[index],dp);
        }
        //exclude
        int exclude= topDownApproach(weight,value,index-1,capacity,dp);


        dp.get(index).set(capacity, Math.max(include, exclude));
        return dp.get(index).get(capacity);
    }


    //index here last index of last element
    static int solveRecursion(int weight[],int value[], int index,int capacity){
     //base case ->only one item
        if(index==0){
            if(weight[0]<=capacity){
                return value[0];
            }else {
                return 0;
            }
        }
        //include
        int include =0;
        if(weight[include]<=capacity){
            include=value[index]+solveRecursion(weight, value, index-1, capacity-weight[index]);
        }

        //exclude
        int exclude= solveRecursion(weight,value,index-1,capacity);

        return Math.max(include,exclude);

    }

    public static void main(String[] args) {
        int weight[]={4,5,1};
        int value[]={1,2,3};
        int n =3;
        int capacity=4;
        System.out.println(solveRecursion(weight,value,n-1,capacity));
        List<List<Integer>> dp = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            dp.add(new ArrayList<>(Collections.nCopies(capacity + 1, -1)));
        }
        System.out.println(topDownApproach(weight,value,n-1,capacity,dp));
        System.out.println(bottomUpApproach(weight,value,n,capacity));
        System.out.println(spaceOptimization(weight,value,n,capacity));
        System.out.println(spaceOptimization1(weight,value,n,capacity));
    }
}
