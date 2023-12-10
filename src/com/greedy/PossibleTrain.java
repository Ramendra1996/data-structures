package com.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PossibleTrain {
    static class  Pair{
        int first;
        int second;
        Pair(int first, int second){
            this.first=first;
            this.second=second;
        }
    }
    static class PairComparator implements Comparator<Pair> {
        @Override
        public int compare(Pair a, Pair b) {
            return Integer.compare(a.second, b.second);
        }
    }
 static  int solve(int n, int arr[], int dept[]){
        List<Pair> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new Pair(arr[i],dept[i]));
        }
        Collections.sort(list, new PairComparator());
        int count =1;
        int lastDept =list.get(0).second;
        for(int i=1;i<n;i++){
            if(list.get(i).first>=lastDept){
                //current train ko include kr skte h
                count++;
                lastDept=list.get(i).second;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int n=4;
        int arr[]={5,8,2,4};
        int dept[]={7,11,6,5};
        int solve = solve(n, arr, dept);
        System.out.println("total count="+solve);

    }
}
