package com.array;

import java.util.HashMap;
import java.util.HashSet;

public class UniqueNumberOccurence {
    static void  occurence(int arr[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<arr.length;i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }
        for(int i:map.values()) {
            if(!set.contains(i)) {
                set.add(i);
            }
        }
        System.out.println("set="+set);
    }
    public static void main(String[] args) {
        int arr[]= {1,2,2,1,1,3};
        occurence(arr);
    }
}
