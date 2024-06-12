package com.search;

/**
 * lowerBound -> if element present  hai array to us element ko find karega aager ni h to uske
 * next element ko find karega(uski badi value find karega)
 *
 * UpperBound -> upperBound always next element ko hi find karega
 */

public class LowerBoundAndUpperBound {

    public static int lowerBound(int arr[], int key){
        int start= 0;
        int end = arr.length-1;

        while (start<end) {
            int mid = (start+end)>>1;
            if (arr[mid] < key) {
                start = mid+1;
            } else {
                end = mid;
            }
        }
        return start;
    }
    public static int upperBound(int arr[], int key){
        int start = 0;
        int end = arr.length-1;

        while (start<end) {
            int mid = (start+end)>>1;
            if (arr[mid] <= key) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        int arr[]={4,5,5,7,8,25};
        int key = 5;
         int lb = lowerBound(arr, key);
        int ub = upperBound(arr, key);

        System.out.println("Lower bound of " + key + " is at index: " + lb);
        System.out.println("Upper bound of " + key + " is at index: " + ub);

    }
}
