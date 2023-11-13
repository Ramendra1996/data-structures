package com.binaryTree;

import java.util.*;
public class BinaryTree {
    static Node root;
    static Node p;
    static Node q;
   private static class Node {
        int data;
        Node left;
        Node right;
        private Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
    private static Node buildTree() {
        Node root = null;
        System.out.println("Enter data:");
        int data = scanner.nextInt();
        if (data == -1) {
            return null;
        }
        root = new Node(data);
        System.out.println("Enter data for left part=>" + data);
        root.left = buildTree();
        System.out.println("Enter data for right part=>" + data);
        root.right = buildTree();
        return root;
    }

    //level order traversal
    private static void  levelOrderTraversal(Node root){
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()){
            Node tempNode = queue.poll();
            if (tempNode==null){
                System.out.println();
                if(!queue.isEmpty()){
                    queue.add(null);
                }
            }else {
                System.out.print(tempNode.data + " ");
                // Enqueue left child
                if (tempNode.left != null) {
                    queue.add(tempNode.left);
                }
                // Enqueue right child
                if (tempNode.right != null) {
                    queue.add(tempNode.right);
                }
            }

        }
    }

    //InOrder Traversal
    private static void InOrderTraversal(Node root){
        //basecase
        if (root==null){
            return;
        }
        //LNR
        InOrderTraversal(root.left);
        System.out.print(root.data+" ");
        InOrderTraversal(root.right);
    }
    //PreOrder Traversal
    private static void preOrderTraversal(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }
    //postOrder traversal
    private static void postorderTraversal(Node root){
      if (root==null){
          return;
      }
      postorderTraversal(root.left);
      postorderTraversal(root.right);
        System.out.print(root.data+" ");
    }
  //height of a tree LeetCode 104
    private static int height(Node root){
        if (root==null){
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight=height(root.right);
        int ans = Math.max(leftHeight,rightHeight)+1;
        return ans;
    }
    //diameter of a tree LeetCode543
     private static  int diameter(Node root){
        if(root==null){
            return 0;
        }
        int op1 = diameter(root.left);
        int op2 = diameter(root.right);
        int op3= height(root.left)+height(root.right);
        int ans = Math.max(op1,Math.max(op2,op3));
        return ans;
     }
     //balanced binary tree LeetCode 110
     private static boolean isBalanced(Node root) {
        if(root==null){
            return true;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        int diff = Math.abs(leftHeight-rightHeight);
        boolean ans1 =( diff<=1);
        boolean leftAns= isBalanced(root.left);
        boolean rightAns = isBalanced(root.right);

        if(ans1 && leftAns && rightAns){
            return true;
        }else {
            return false;
        }

     }
/*    public static boolean isBalanced(Node root) {
        return checkBalance(root) != -1;
    }
    private  static int checkBalance(Node node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = checkBalance(node.left);
        if (leftHeight == -1) {
            return -1; // Left subtree is unbalanced, no need to check the right subtree
        }
        int rightHeight = checkBalance(node.right);
        if (rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1; // Right subtree is unbalanced or tree is unbalanced
        }
        return Math.max(leftHeight, rightHeight) + 1; // Height of the current node
    }*/

    private static  int convertInToSumTreeSum(Node root){
        if(root==null){
            return 0;
        }
        int leftSum = convertInToSumTreeSum(root.left);
        int rightSum = convertInToSumTreeSum(root.right);
        root.data = root.data +leftSum+rightSum;
        return root.data;
    }

    //Lowest common Ancestor LeetCode 236
    private   static  Node lowestCommonAncestor(Node root, Node p, Node q) {
        if(root==null){
            return null;
        }
        //check p and q
        if(root.data==p.data){
            return p;
        }
        if(root.data==q.data){
            return q;
        }
        Node leftAns = lowestCommonAncestor(root.left, p,q);
        Node rightAns= lowestCommonAncestor(root.right,p,q);

        if(leftAns==null && rightAns ==null){
            return null;
        }
        else if(leftAns!=null && rightAns==null){
            return leftAns;
        }
        else if(leftAns==null && rightAns!=null){
            return rightAns;
        }
        else{
            return root;
        }
    }
    //kth Ancestor
    private static boolean kthAncestor(Node root , int k, Node p){
      if(root==null){
          return false;
      }

      boolean lefAns = kthAncestor(root.left,k,p);
      boolean rightAns = kthAncestor(root.right,k,p);
      //wapas aate time//
      //check left ya right me ans mila ya ni
      if(lefAns||rightAns)
          k--;
      if (k==0){
          System.out.println(root.data);
          k=-1;
      }

      return lefAns||rightAns;
    }

    //pathSum LeetCode 113

    private static void solve(Node root, int targetSum,int sum,List<List<Integer>>ans,List<Integer>temp){
        //base case
        if(root==null){
            return;
        }
        //include current sum
        temp.add(root.data);
        sum+=root.data;
        //leafnode
        if(root.left==null && root.right==null){

            if(sum==targetSum){
                ans.add(new ArrayList<>(temp));
            }
        }

        solve(root.left,targetSum,sum,ans,temp);
        solve(root.right,targetSum,sum,ans,temp);
        // Remove the current node from the path when backtracking
        temp.remove(temp.size() - 1);
    }
    private static List<List<Integer>> pathSum(Node root, int targetSum) {
        List<List<Integer>>ans =new ArrayList<>();
        List<Integer>temp = new ArrayList<>();
        int sum=0;
        solve(root,targetSum,sum,ans,temp);
        return ans;
    }

    static Scanner scanner = null;
    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        root=buildTree();
        System.out.println("level order traversal");
        levelOrderTraversal(root);
        int height = height(root);
        System.out.println("height="+height);
        System.out.println("Inorder traversal");
        InOrderTraversal(root);
        System.out.println("\npre order traversal  ");
        preOrderTraversal(root);
        System.out.println("\npost order traversal\n");
        postorderTraversal(root);
        int diameter = diameter(root);
        System.out.println("diameter="+diameter);
        boolean balanced = isBalanced(root);
        System.out.println("check="+balanced);
        int sum = convertInToSumTreeSum(root);
        System.out.println("sum="+sum);
        Node node = lowestCommonAncestor(root, p, q);
        System.out.println(node);
        int targetSum =22;
        List<List<Integer>> lists = pathSum(root, targetSum);
        System.out.println(lists);

    }
}


//Tc->0(n)
//SC->0(n)
//ip-> 20,40,60,-1,80,-1,-1,-1,-1