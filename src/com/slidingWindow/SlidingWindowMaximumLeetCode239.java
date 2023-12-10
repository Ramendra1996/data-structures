package com.slidingWindow;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class SlidingWindowMaximumLeetCode239 {
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
        int[] nums = {1,-1};
        //{1,3,-1,-3,5,3,6,7};
        int k = 1;
        int[] arr = maxSlidingWindow(nums, k);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
