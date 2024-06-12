package com.array;

public class MissingElementWithDupliacteArray {

    void swap(int nums[], int i, int j){
        int temp = nums[i];
         nums[i]=nums[j];
         nums[j]=temp;
    }
  /*  void getMissingNumber(int nums[]) {
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]);
            if (nums[index - 1] > 0) {
                nums[index - 1] *= -1;
            }
        }
        //print array after negative number
        for (int i=0;i<nums.length;i++){
            System.out.println(nums[i]);
        }
        for (int i = 0; i < nums.length; i++){
            if(nums[i]>0){
                System.out.println(i+1);
            }
        }
    }*/

    void getMissingNumber(int nums[]){
        int i=0;
        while (i< nums.length){
            int index = nums[i]-1;
            if(nums[i]!=nums[index]){
               swap(nums,i, index);
            }else {
                i++;
            }
        }
        for ( i=0;i<nums.length;i++){
            if(nums[i]!=i+1){
                System.out.println(i+1);
            }

        }
    }


    public static void main(String[] args) {
        MissingElementWithDupliacteArray ma = new MissingElementWithDupliacteArray();
        int nums[] = {1,3,5,3,4};
        ma.getMissingNumber(nums);
    }
}
