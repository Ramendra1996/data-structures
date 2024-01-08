package com.array2D;

import java.util.ArrayList;
import java.util.List;

public class SpiralPrint {

    List<Integer> getPrint(int nums[][]){
        List<Integer>ans = new ArrayList<>();
        int startRow =0;
        int endingRow=nums.length-1;
        int startColum =0;
        int endingColumn=nums[0].length-1;
        int count =0;
        int totalCount =nums.length*nums[0].length;

        while (count<totalCount){
            //print startingRow
            for(int i=startColum;i<=endingColumn &&count<totalCount;i++ ){
                ans.add(nums[startRow][i]);
                count++;
            }
            startRow++;
            //print ending col
            for(int i=startRow;i<=endingRow &&count<totalCount;i++){
                ans.add(nums[i][endingColumn]);
                count++;
            }
            endingColumn--;
            ////ending row
            for (int i=endingColumn;i>=startColum &&count<totalCount;i--){
                ans.add(nums[endingRow][i]);
                count++;
            }
            endingRow--;
            //starting col
            for(int i=endingRow;i>=startRow &&count<totalCount;i--){
                ans.add(nums[i][startColum]);
                count++;
            }
            startColum++;
        }
    return ans;
    }
    public static void main(String[] args) {
        SpiralPrint sp = new SpiralPrint();
        int nums[][]={{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        List<Integer> print = sp.getPrint(nums);
        System.out.println(print);
    }
}
