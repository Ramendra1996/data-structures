package com.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InterSectionOfTwoArray {
     int [] getIntersection(int a[], int b[]){
         List<Integer> list = new ArrayList<>();

         for(int i=0;i<a.length;i++){
             int element = a[i];
             for (int j=0;j<b.length;j++){
                 if(b[j]==element){
                    b[j]=-1;
                     list.add(element);

                 }

             }
         }
         return list.stream().mapToInt(Integer::valueOf).toArray();
     }
    public static void main(String[] args) {
        int a[]={1,2,3,4,6,8};
        int b[]={3,3,4,10};
        InterSectionOfTwoArray inter = new InterSectionOfTwoArray();
        int[] intersection = inter.getIntersection(a, b);

        for (int i=0;i< intersection.length;i++){
            System.out.print(intersection[i]+" ");
        }
    }
}
