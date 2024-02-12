package com.recursionBacktracing;

// it's a dp question
public class HouseRobberLeetCode198 {

    static int rob(int[] nums ,int i) {
       //base case
          if(i>=nums.length){
              return 0;
          }
        //1 case
        int rob1 = nums[i]+rob(nums,i+2);
        int rob2 = 0 +rob(nums,i+1);
        return  Math.max(rob1,rob2);
    }
    public static void main(String[] args) {
        int nums [] = {1,2,3,1};
        int rob = rob(nums, 0);
        System.out.println(rob);
    }
}
