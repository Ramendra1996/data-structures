package com.binaryTree;

import java.util.ArrayList;
import java.util.List;

public class PathSumLeetCode113 {
    static class  Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            left = null;
            right = null;
        }
    }
  public  static  void  getSolve(Node root,int targetSum,int sum,List<List<Integer>>ans,List<Integer>list){
        if (root==null){
            return;
        }
        list.add(root.data);
        sum+=root.data;
        if (root.left==null && root.right==null){
            if (sum==targetSum){
                ans.add(new ArrayList<>(list));
            }
        }
        getSolve(root.left,targetSum,sum,ans,list);
        getSolve(root.right,targetSum,sum,ans,list);
        list.remove(list.size()-1);
  }
    public static List<List<Integer>> getPathSum(Node root, int targetSum){
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer>list = new ArrayList<>();
        int sum=0;
        getSolve(root,targetSum,sum,ans,list);
        return ans;
    }
    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(4);
        root.left.left = new Node(11);
        root.left.left.left= new Node(5);
        root.left.left.right= new Node(2);
        root.right = new Node(8);
        root.right.left= new Node(13);
        root.right.right= new Node(4);
        root.right.right.left= new Node(5);
        root.right.right.right = new Node(1);
        List<List<Integer>> pathSum = getPathSum(root, 22);
        System.out.println(pathSum);
    }
}
