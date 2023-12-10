package com.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedArray {

    static class Info{
        int data;
        int row;
        int column;

        Info(int data, int row, int column){
            this.data=data;
            this.row=row;
            this.column=column;
        }
    }

    static class Compare  implements Comparator<Info> {
        @Override
        public int compare(Info a, Info b) {
            return Integer.compare(a.data, b.data);
        }

    }


   static List<Integer> getMergeKSortedArray(int arr[][], int k ,int n){
       PriorityQueue<Info> minHeap = new PriorityQueue<Info>(new Compare());

       // hr array ka first element store kro

       for(int i=0;i<k;i++){
           Info info= new Info(arr[i][0],i,0);
           minHeap.add(info);
       }
       List<Integer> list = new ArrayList<>();
       while (!minHeap.isEmpty()){
           Info info= minHeap.peek();
           int topElement =info.data;
           int row = info.row;
           int column=info.column;
           minHeap.poll();
           list.add(topElement);

           if(column+1 <n){
               Info info1 =new Info(arr[row][column+1],row,column+1);
               minHeap.add(info1);
           }
       }
       return list;
    }
    public static void main(String[] args) {
        int arr[][]= {{2,4,6,8},{1,3,5,7},{0,9,10,11}};
        int k=3;
        int n=4;
        List<Integer> list = getMergeKSortedArray(arr, k, n);

        for(Integer i:list){
            System.out.print(i+" ");
        }


    }
}
//TC->0(nklogk)