package com.practies;

import java.util.Set;

public class Demo2 {

    public static  int getDuplicate(int nums[]){
        for(int i=0;i< nums.length-1;i++){
            int index = Math.abs(nums[nums[i]]);
            System.out.println("index="+index);

            if(nums[index]<0){
                return index;
            }
            nums[index]*=-1;
        }
        return -1;
    }
    public static void main(String[] args) {
        int nums[]= {1,3,4,2,2};
        int duplicate = getDuplicate(nums);
        System.out.println(duplicate);


    }
}
