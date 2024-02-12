package com.recursionBacktracing;

public class CountInversion {

    static int merge(int arr[], int temp[], int start, int mid, int end){
        int count = 0;
        int i = start;
        int j = mid + 1; // Change here: start from mid + 1
        int k = start;

        while (i <= mid && j <= end) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                count += mid - i + 1;
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= end) {
            temp[k++] = arr[j++];
        }

        // Copy elements from temp[] back to arr[]
        while (start <= end) {
            arr[start] = temp[start];
            ++start;
        }

        return count;
    }

    static int mergeSort(int[] arr, int[] temp, int start, int end) {
        int count = 0;
        if (start < end) {
            int mid = start + (end - start) / 2;
            count += mergeSort(arr, temp, start, mid);
            count += mergeSort(arr, temp, mid + 1, end);
            count += merge(arr, temp, start, mid, end);
        }
        return count;
    }

    static int getInverstionCount1(int arr[]) {
        int count = 0;
        int[] temp = new int[arr.length];
        count = mergeSort(arr, temp, 0, arr.length - 1);
        return count;
    }

   static int getInverstionCount(int arr[]){
        int count =0;
         for(int i =0;i<arr.length;i++){
             for(int j=i+1;j<arr.length;j++){
                count=arr[i]>arr[j]?count+1:count;
             }
         }
         return count;
       //TC+>0(n^2)
    }
    public static void main(String[] args) {
        int arr[]={8,4,2,1};
        int inverstionCount = getInverstionCount(arr);
        System.out.println(inverstionCount);
        int inverstionCount1 = getInverstionCount1(arr);
        System.out.println(inverstionCount1);
    }
}
