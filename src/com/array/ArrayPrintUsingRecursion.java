package com.array;

public class ArrayPrintUsingRecursion {

     void getPrint(int nums[], int i){

         if(i== nums.length){
             return;
         }
         System.out.println(nums[i]);
         getPrint(nums,i+1);
     }
    public static void main(String[] args) {
        ArrayPrintUsingRecursion ar = new ArrayPrintUsingRecursion();
        int nums[]={5,6,9,7,1,2,4,3,12};
        int i=0;
        ar.getPrint(nums,i);

    }
}
