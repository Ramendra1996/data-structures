package com.array2D;

import java.util.Arrays;

public class S0rtTheGivenMatrix {
    void swap(int mat[][],int i ,int j){
        int temp = mat[i][j];
        mat[i][j]=mat[i][j+1];
        mat[i][j+1]=temp;
    }

   void  sortMatrixStrictOrder(int mat[][]){
        int row = mat.length;
        int col =mat[0].length;
        int arr[]= new int[row*col];
        int index=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                arr[index++]=mat[i][j];
            }
        }
       Arrays.sort(arr);
        index=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                mat[i][j]=arr[index++];
            }
        }
    }
    //row wise sort
    void sortMatrix(int mat[][]){
        int row =mat.length;
        int col = mat[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col-1;j++){
                if(mat[i][j]>mat[i][j+1]){
                     swap(mat,i,j);
                }
            }
        }
    }
    public static void main(String[] args) {
        S0rtTheGivenMatrix sort = new S0rtTheGivenMatrix();
        int  mat[][] = { {5, 4, 7}, {1, 3, 8}, {2, 9, 6} };
        //  sort.sortMatrix(mat);
        sort.sortMatrixStrictOrder(mat);
         for(int i=0;i<mat.length;i++){
             for(int j=0;j<mat[0].length;j++){
                 System.out.print(mat[i][j]+" ");
             }
             System.out.println(" ");
         }

    }

}
