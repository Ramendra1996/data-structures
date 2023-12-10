package com.slidingWindow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TwoSumLeetCode1 {
    static class Pair{
        int first;
        int second;
        Pair(int first, int second){
            this.first=first;
            this.second=second;
        }
    }
    static class PairComparator implements Comparator<Pair> {
        @Override
        public int compare(Pair a, Pair b) {
            return Integer.compare(a.first, b.first);
        }
    }
    public static int[] twoSum(int[] nums, int target) {
        List<Integer> ans = new ArrayList<>();
        List<Pair> list = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            list.add(new Pair(nums[i],i));
        }
        Collections.sort(list, new PairComparator());
        int start=0;
        int end = list.size()-1;

        while(start<end){
            if(list.get(start).first+list.get(end).first==target){
                ans.add(list.get(start).second);
                ans.add(list.get(end).second);
                break;
            }else if(list.get(start).first+list.get(end).first>target){
                end--;
            }else{
                start++;
            }
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int nums []= {3,2,4};
        int target =6;
        int[] arr = twoSum(nums, target);

        for(int i=0;i<arr.length;i++){
            System.out.print( arr[i]+" ");
        }

    }
}
