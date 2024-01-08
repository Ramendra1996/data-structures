package com.array2D;

public class WavePrint {

    void  getPrint(int nums[][]){
        int row = nums.length;
        int column =nums[0].length;
        for(int startCol=0;startCol<column;startCol++){
            //even number of col->top to bottom
            if((startCol & 1)==0){
                for(int i =0;i<row;i++){
                    System.out.print(nums[i][startCol]+" ");
                }
                System.out.println(" ");

            }
            else {
                for (int i=row-1;i>=0;i--){
                    System.out.print(nums[i][startCol]+" ");
                }
                System.out.println(" ");
            }

        }
    }
    public static void main(String[] args) {
        WavePrint wp = new WavePrint();
        int nums[][]={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16},{17,18,19,20}};
        wp.getPrint(nums);
    }
}
