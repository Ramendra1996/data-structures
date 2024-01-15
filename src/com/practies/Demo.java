package com.practies;


public class Demo {

    int getKey(int arr[]){
     int start=0;
      int end = arr.length-1;
      while (start<end){
          int mid = start+(end-start)/2;
          if(arr[mid]<arr[mid+1]){
              start=mid+1;
          }else {
              end= mid;
          }
      }
      return start;
    }

    public static void main(String[] args) {
        int arr[]={0,10,5,2};
        Demo demo = new Demo();
        int key = demo.getKey(arr);
        System.out.println(key);
    }
}
