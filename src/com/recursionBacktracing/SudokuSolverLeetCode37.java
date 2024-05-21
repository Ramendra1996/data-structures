package com.recursionBacktracing;

public class SudokuSolverLeetCode37 {
    public static boolean isSafe(int value, int board[][], int curr_row, int curr_col){
        //row check
        for(int col=0;col<9;col++){
            if(board[curr_row][col]==value)
                return false;
        }
        //column check
        for (int row =0;row<9;row++){
            if(board[row][curr_col]==value){
                return false;
            }
        }

        //3*3 box

        for (int i=0;i<9;i++){
            if(board[3*(curr_row/3)+(i/3)][3*(curr_col/3)+(i/3)]==value){
                return false;
            }
        }
        return true;

    }

    public static  boolean solve(int board[][], int n){
        for (int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                //check for empty cell
                if(board[i][j]==0){
                    for(int value =1;value<=9;value++){
                        //check for safety
                        if(isSafe(value,board,i,j)){
                            //insert
                            board[i][j]=value;
                            //baki recursion sambhal lega
                            boolean aageKaSolution = solve(board, n);
                            if(aageKaSolution){
                                return true;
                            }
                            board[i][j]=0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {

        int n =9;
        int board [][]= {{4,5,0,0,0,0,0,0,0},
                         {0,0,2,0,7,0,6,3,0},
                         {0,0,0,0,0,0,0,2,8},
                         {0,0,0,9,5,0,0,0,0},
                         {0,8,6,0,0,0,2,0,0},
                         {0,2,0,6,0,0,7,5,0},
                         {0,0,0,0,0,0,4,7,6},
                         {0,7,0,0,4,5,0,0,0},
                         {0,0,8,0,0,9,0,0,0}};
        boolean solve = solve(board, n);
        System.out.println(solve);



    }
}
