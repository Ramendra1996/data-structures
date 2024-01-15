package com.array;

public class FindUniqueElement {

    int getUniqueElement(int nums[]){
        int ans =0;
     for (int i=0;i<nums.length;i++){
       ans= ans^nums[i];
     }
     return ans;
    }
    public static void main(String[] args) {
        FindUniqueElement fe = new FindUniqueElement();
        //each element two time only one element one time
        int nums[]={1,2,4,2,1,3,6,5,5,6,4};
        int uniqueElement = fe.getUniqueElement(nums);
        System.out.println(uniqueElement);
    }
}
