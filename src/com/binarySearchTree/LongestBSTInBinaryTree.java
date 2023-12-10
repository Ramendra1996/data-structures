package com.binarySearchTree;

public class LongestBSTInBinaryTree {

    static class  Node{
        int data;
         Node left;
         Node right;
         Node(int data){
             this.data= data;
             left = null;
              right=null;
         }
    }
    static class NodeData{
        int size;
        int minVal;
        int maxVal;
        boolean validBST;
        NodeData(){
            
        }
        NodeData(int size, int minVal,int maxVal,boolean validBST){
           this.size =size;
           this.minVal=minVal;
           this.maxVal=maxVal;
           this.validBST=validBST;
        }
    }
    public  static NodeData findBST(Node root,int ans){
        if (root==null){
            NodeData temp = new NodeData(0,Integer.MIN_VALUE,Integer.MAX_VALUE,true);
            return temp;
        }
        NodeData leftAns = findBST(root.left,ans);
        NodeData rightAns = findBST(root.right,ans);
        //cheching start here
        NodeData currentNodeAns = new NodeData();
        currentNodeAns.size=leftAns.size+ rightAns.size+1;
        currentNodeAns.maxVal=Math.max(root.data, rightAns.maxVal);
        currentNodeAns.minVal=Math.min(root.data, leftAns.minVal);
        if(leftAns.validBST && rightAns.validBST && (root.data> leftAns.maxVal && root.data< rightAns.minVal)){
         currentNodeAns.validBST=true;
        }else {
            currentNodeAns.validBST=false;
        }
        if(currentNodeAns.validBST){
            ans = Math.max(ans,currentNodeAns.size);
        }
        return currentNodeAns;
    }
    public static void main(String[] args) {

    }
}
