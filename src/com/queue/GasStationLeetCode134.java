package com.queue;

//another name  circular tour

public class GasStationLeetCode134 {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        //kitna petrol km pd gya
        int deficit =0;
        //kitna petrol bacha hua h
        int balance=0;
        //circuit kha se start krte ho
        int start =0;

        for(int i=0;i<gas.length;i++){
            balance +=gas[i]-cost[i];
            if(balance<0){
                //yha pr galti hoti h
                deficit  = balance + deficit;
                start=i+1;
                balance=0;
            }
        }
        if(deficit+balance>=0){
            return start;
        }else{
            return -1;
        }

    }
    public static void main(String[] args) {
     int  gas[] ={1,2,3,4,5};
     int cost[] ={3,4,5,1,2};

        int ans = canCompleteCircuit(gas, cost);
        System.out.println("ans=>"+ans);
    }
}
//Tc->0(n)
//sc->0(n)