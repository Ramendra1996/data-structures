package com.array;

public class FindDuplicateNumberLeetCode287 {

    void swap(int nums[], int i, int j){
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    /*int getDuplicate(int nums[]){
        int ans = 0;
        for (int i =0;i<nums.length;i++){
             ans= ans^nums[i];
        }
        for (int i=0;i< nums.length;i++){
            ans=ans^i;
        }
        return ans;
    }*/
    //negtive indexing se
   /* int getDuplicate(int nums[]){
        int ans =-1;
        for(int i=0;i< nums.length;i++){
            int index =Math.abs(nums[i]);
            if(nums[index]<0){
                ans=index;
                break;
            }
            nums[index]*=-1;
        }
        return ans;
    }*/
    //her element ko us ki right position pr pahucha do

     int getDuplicate(int nums[]){
        while (nums[0]!=nums[nums[0]]){
            swap(nums,0,nums[0]);
        }
        return nums[0];
     }
    public static void main(String[] args) {
        FindDuplicateNumberLeetCode287 fd = new FindDuplicateNumberLeetCode287();
        int nums []={1,3,4,2,2};
        int duplicate = fd.getDuplicate(nums);
        System.out.println(duplicate);
    }
}
