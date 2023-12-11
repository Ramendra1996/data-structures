package com.queue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class SlidingWindowMaximumLeetcode239 {
    public  static int[] maxSlidingWindow1(int[] nums, int k) {

        Deque<Integer> dq = new ArrayDeque<>();
        List<Integer> ans = new ArrayList<>();
        //first window travers of k size
        for(int i=0;i<k;i++){
            //chote element remove krdo
            while(!dq.isEmpty() && nums[i]>=nums[dq.peekLast()]){
                dq.pollLast();
            }
            //insertingindex ,so that we cancheckout of window element
            dq.offerLast(i);
        }
        //store ans for first window
        ans.add(nums[dq.peekFirst()]);
        //remening window ko process krna
        for(int i=k;i<nums.length;i++){
            //out of window element remove
            if(!dq.isEmpty()&&i-dq.peekFirst()>=k){
                dq.pollFirst();
            }
            //ab fir se current element ke liyec chote elemet ko remove krna h
            while(!dq.isEmpty() && nums[i]>=nums[dq.peekLast()]){
                dq.pollLast();
            }
            //insertingindex ,so that we cancheckout of window element
            dq.offerLast(i);
            //current window ka ans store krna h
            ans.add(nums[dq.peekFirst()]);
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
    public  static int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        List<Integer> ans = new ArrayList<>();

        // Process first k size window
        for (int i = 0; i < k; i++) {
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i])
                dq.pollLast();
            // Insert element
            dq.offerLast(i);
        }

        // Ans store karlo for the 1st window
        ans.add(nums[dq.peekFirst()]);

        // Remaining windows
        for (int i = k; i < nums.length; i++) {
            // Removal
            if (!dq.isEmpty() && i - k >= dq.peekFirst())
                dq.pollFirst();

            // Additional
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i])
                dq.pollLast();
            // Insert element
            dq.offerLast(i);

            // Ans store
            ans.add(nums[dq.peekFirst()]);
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
    public static void main(String[] args) {
       int nums[]= {1,3,-1,-3,5,3,6,7};
       int k=3;
        int[] ints = maxSlidingWindow(nums, k);
        for(int i=0;i<ints.length;i++){
            System.out.print(ints[i]+" ");
        }
    }
}
