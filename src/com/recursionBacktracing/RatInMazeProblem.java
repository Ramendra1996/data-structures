package com.recursionBacktracing;

import java.util.ArrayList;

public class RatInMazeProblem {

    public static boolean  isSafe(int srcX, int srcY,int row, int col,int arr[][],boolean visited[][]){

        if((srcX>=0 && srcX<row)&&(srcY>=0 && srcY<col)&&(arr[srcX][srcY]==1)&& visited[srcX][srcY]==false){
               return true ;
        }else {
            return false;
        }
    }

    public static  void  solveMaze(int arr[][] , int row,int col, int srcX, int srcY,boolean visited[][],ArrayList<String>path,String output){
         //base case
        if(srcX==row-1 && srcY==row-1){
            //ans found
            path.add(output);
            return;
        }

        if(arr[0][0]==0){
            System.out.println("No Path Exists");
        }
//        if(srcX>=arr.length || srcY>=arr[0].length || srcX<0 || srcY<0 || arr[srcX][srcY]==0 || visited[srcX][srcY]==true){
//            return ;
//        }

        //down ->i+1,j
         if(isSafe(srcX+1,srcY,row,col,arr,visited)){
            visited[srcX+1][srcY]=true;
            solveMaze(arr, row, col, srcX+1, srcY, visited, path, output+"D");
             visited[srcX+1][srcY]=false;
         }
        //left ->i,j-1
        if(isSafe(srcX,srcY-1,row,col,arr,visited)){
            visited[srcX+1][srcY-1]=true;
            solveMaze(arr, row, col, srcX, srcY-1, visited, path, output+"L");
            visited[srcX][srcY-1]=false;
        }
        //right-> i,j+1
        if(isSafe(srcX,srcY+1,row,col,arr,visited)){
            visited[srcX][srcY+1]=true;
            solveMaze(arr, row, col, srcX, srcY+1, visited, path, output+"R");
            visited[srcX][srcY+1]=false;
        }
        //up-> i-1,j

        if(isSafe(srcX-1,srcY,row,col,arr,visited)){
            visited[srcX-1][srcY]=true;
            solveMaze(arr, row, col, srcX-1, srcY, visited, path, output+"U");
            visited[srcX-1][srcY]=false;
        }


    }
    public static void main(String[] args) {
        int arr[][]= {{1,0,0,0},{1,1,0,1},{1,1,0,0},{0,1,1,1}};
        int row =arr.length;
        int col = arr[0].length;
        boolean visited[][]=new boolean[row][col];
        ArrayList<String>path=new ArrayList<>();
        String output = "";
        solveMaze(arr,row,col,0,0,visited,path,output);

        for(String str:path){
            System.out.println(str);
        }
        if(path.size()==0){
            System.out.println("No Path Exists");
        }

    }
}
