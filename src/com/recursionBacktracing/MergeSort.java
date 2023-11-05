package com.recursionBacktracing;

public class MergeSort {

    public static void getMerge(int arr[], int s, int e) {
        int mid = s + (e - s) / 2;
        int len1 = mid - s + 1;
        int len2 = e - mid;
        int leftArray[] = new int[len1];
        int rightArray[] = new int[len2];
        int k = s;
        for (int i = 0; i < len1; i++) {
            leftArray[i] = arr[k];
            k++;
        }
        k = mid + 1;
        for (int j = 0; j < len2; j++) {
            rightArray[j] = arr[k];
            k++;
        }

        //mergeArray
        int leftIndex = 0;
        int rightIndex = 0;
        int mainIndex = s;
        while (leftIndex < len1 && rightIndex < len2) {
            if (leftArray[leftIndex] < rightArray[rightIndex]) {
                arr[mainIndex++] = leftArray[leftIndex++];

            } else {
                arr[mainIndex++] = rightArray[rightIndex++];
            }
        }
        while (leftIndex < len1) {
            arr[mainIndex++] = leftArray[leftIndex++];
        }
        while (rightIndex < len2) {
            arr[mainIndex++] = rightArray[rightIndex++];
        }
    }

    public static void getMergeSort(int arr[], int s, int e) {
        if (s >= e) {
            return;
        }
        int mid = s + (e - s) / 2;
        //left part sort
        getMergeSort(arr, s, mid);
        //right part
        getMergeSort(arr, mid + 1, e);

        //now merge 2 sorted array
        getMerge(arr, s, e);
    }

    public static void main(String[] args) {
        int arr[] = {4, 5, 13, 2, 12};

        int s = 0;
        int e = arr.length - 1;
        getMergeSort(arr, s, e);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
//TC->0(nlogn)
//SC->0(n)
//inplace margesort
