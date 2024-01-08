package com.array;

import java.util.HashMap;

public class FirstRepetingNumber {

   /* int firstRepeatingOccurrence(int nums[]) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }
        for (int i=0;i< nums.length;i++){
            if(map.get(nums[i])>1){
                return nums[i];
            }
        }
        return -1;
    }*/
    int firstRepeatingOccurrence(int nums[]){
        int arr[]= new int[20];
        int ans =-1;
        for(int i=0;i<nums.length;i++){
            arr[nums[i]]++;
            if(arr[i]>1){
                ans = i;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        FirstRepetingNumber fn = new FirstRepetingNumber();
        int nums[]= {1,5,3,4,3,5,6};
        int i = fn.firstRepeatingOccurrence(nums);
        System.out.println(i);
    }
}
