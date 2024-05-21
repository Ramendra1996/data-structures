package com.practies;

public class MergeSortDemo {

    public static void getMerge(int array[], int start, int end) {
        int mid = start + (end - start) / 2;
        int leftArray[] = new int[mid - start + 1];
        int rightArray[] = new int[end - mid];
        int k = start;
        for (int i = 0; i < leftArray.length; i++) {
            leftArray[i] = array[k];
            k++;
        }
        k = mid + 1;
        for (int j = 0; j < rightArray.length; j++) {
            rightArray[j] = array[k];
            k++;
        }

        int leftIndex = 0;
        int rightIndex = 0;
        int mainIndex = start;

        while (leftIndex<leftArray.length && rightIndex<rightArray.length){
            if(leftArray[leftIndex]<rightArray[rightIndex]){
               array[mainIndex++]=leftArray[leftIndex++];
            }else {
                array[mainIndex++]=rightArray[rightIndex++];
            }
        }

        while (leftIndex<leftArray.length){
            array[mainIndex++]=leftArray[leftIndex++];
        }
        while (rightIndex<rightArray.length){
            array[mainIndex++]=rightArray[rightIndex++];
        }
    }

    public static void getMergeSort(int array[], int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        getMergeSort(array, start, mid);
        getMergeSort(array, mid + 1, end);
        getMerge(array, start, end);
    }

    public static void main(String[] args) {
        int array[] = {7, 3, 2, 16, 24, 4, 11, 9};
        int start = 0;
        int end = array.length - 1;
        getMergeSort(array, start, end);
        for (int arr:array){
            System.out.println(arr);
        }
    }
}
