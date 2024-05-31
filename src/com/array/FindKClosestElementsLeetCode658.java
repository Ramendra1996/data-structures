package com.array;

import java.util.ArrayList;
import java.util.List;

public class FindKClosestElementsLeetCode658 {
    static List<Integer> twoPointerApproach(int[] arr, int k, int x) {
        List<Integer> ans = new ArrayList<>();
        int low = 0;
        int high = arr.length - 1;
        while (high - low >= k) {
            if (x - arr[low] > arr[high] - x) {
                low++;
            } else {
                high--;
            }
        }
        for (int i = low; i <= high; i++) {
            ans.add(arr[i]);
        }
        return ans;
    }

    static int lowerBound(int arr[], int x) {
        int start=0;
        int end=arr.length-1;
        int ans=end;
        while(start<=end){
            int mid =start+(end-start)/2;
            if(arr[mid]>=x){
                ans=mid;
                end=mid-1;
            }else if(x>arr[mid]){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return ans;
    }

    public static List<Integer>bs_method(int arr[], int x, int k){
        ArrayList<Integer> list = new ArrayList<>();
        int h= lowerBound(arr, x);
        int l=h-1;
        while(k!=0){
            if(l<0){
                h++;
            }else if(h>=arr.length){
                l--;
            }else if(x-arr[l]>arr[h]-x){
                h++;
            }else{
                l--;
            }
            k--;
        }
        for(int i=l+1;i<h;i++){
            list.add(arr[i]);
        }
        return list;
    }

   /* public List<Integer> findClosestElements(int[] arr, int k, int x) {
      return
    }*/

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        int k = 4;// muje sirf list me 4 element chahiye
        int x = 3;
        int i = lowerBound(arr, x);
        System.out.println(i);
        List<Integer> integers = twoPointerApproach(arr, k, x);
        System.out.println(integers);
        List<Integer> integers1 = bs_method(arr, x, k);
        System.out.println(integers1);

    }
}
