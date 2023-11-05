package com.recursionBacktracing;

public class QuickShort {

    public  static  int partition(int arr[],int s,int e){
        int pivotIndex=s;
        int pivotElement=arr[s];

        //step2 find right position  for pivot element
        int count=0;
        for(int i=s+1;i<=e;i++){
            if(arr[i]<=pivotElement){
                count++;
            }
        }
        //jb oop se bhar aaya,to pivot ki right position present h
        int rightIndex=s+count;
        int temp=arr[pivotIndex];
        arr[pivotIndex]=arr[rightIndex];
        arr[rightIndex]=temp;
        pivotIndex=rightIndex;

        //step3 : left me choote right me bade
        int i=s;
        int j=e;
        while (i<pivotIndex && j>pivotIndex){
            while (arr[i]<pivotElement){
                i++;
            }
            while (arr[j]>pivotElement){
                j--;
            }
            //2 case ho skte h
            //A-> you find the right element to swap
            //B-> no need to swap
            if(i<pivotIndex && j>pivotIndex){
                 temp =arr[i];
                 arr[i]=arr[j];
                 arr[j]=temp;

            }
        }
       return  pivotIndex;
    }
    public static  void getQuickSort(int arr[],int s, int e){
        //base case
        if(s>=e){
            return;
        }
        //partition logic
        int p=partition(arr,s,e);

        //recursive call
        //leftcall
          getQuickSort(arr,s,p-1);
        //rightcall
         getQuickSort(arr,p+1,e);
    }
    public static void main(String[] args) {
        int arr[]={8,1,3,4,20,50,30};
         int s=0;
         int e=arr.length-1;
        getQuickSort(arr,s,e);

        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}

//Tc->0(nlogn)
//Sc->0(n)