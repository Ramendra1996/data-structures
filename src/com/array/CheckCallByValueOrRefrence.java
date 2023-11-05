package com.array;

public class CheckCallByValueOrRefrence {
    public static void getPrint(int arr[]){

        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void getIncrement(int arr[]){
            arr[0]=arr[0]+10;
            arr[1]=arr[1]+20;
            getPrint(arr);
    }

    public static void main(String[] args) {
        int arr[]={5,6};
         getPrint(arr);
    }
}
