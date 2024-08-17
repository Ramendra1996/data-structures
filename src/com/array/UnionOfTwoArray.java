package com.array;

import java.util.HashSet;

public class UnionOfTwoArray {

    static void union(int a[],int b[]) {
        HashSet<Integer> set= new HashSet<>();
        for(int i=0;i<a.length;i++) {
            set.add(a[i]);
        }
        for(int i=0;i<b.length;i++) {
            if(!set.contains(b[i])) {
                set.add(b[i]);
            }
        }
        System.out.println(set);
    }
    public static void main(String[] args) {
        int a[]={1,2,3,4,6,8};
        int b[]={3,3,4,10};
        union(a,b);
    }
}
