package com.treis;

public class Tries {
    static class TrieNode {
        char data;
        TrieNode[] children;
        boolean isTerminal;

        TrieNode(char data) {
            this.data = data;
            this.children = new TrieNode[26];
            this.isTerminal = false;
        }
    }
    public static void insertWord(TrieNode root, String word) {
        // Base case
        if (word.length() == 0) {
            root.isTerminal = true;
            return;
        }

        char ch = word.charAt(0);
        int index = ch - 'a';
        TrieNode child;

        if (root.children[index] == null) {
            child = new TrieNode(ch);
            root.children[index] = child;
        } else {
            child = root.children[index];
        }

        // Recursion
        insertWord(child, word.substring(1));
    }

    static   boolean searching(TrieNode root, String word){
        if(word.length()==0){
            return  root.isTerminal;
        }
        char ch = word.charAt(0);
        int index = ch-'a';
        TrieNode child;
        //present
        if(root.children[index]!=null){
            child=root.children[index];
        }
        else {
            return false ;
        }
        //rec call
        return   searching(child,word.substring(1));
    }

    public static void main(String[] args) {
        TrieNode root = new TrieNode('-');
        insertWord(root, "ello");
        insertWord(root,"hi");
        // Add more words as needed

        // Your main method logic here
        if( searching(root, "hello")){
            System.out.println("present");
        }else {
            System.out.println("not present");
        }



    }
}
