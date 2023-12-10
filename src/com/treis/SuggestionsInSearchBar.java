package com.treis;

import java.util.ArrayList;
import java.util.List;

public class SuggestionsInSearchBar {
    static class TrieNode {
        public char data;
        public TrieNode[] children;
        public boolean isTerminal;

        public TrieNode(char d) {
            this.data = d;
            this.children = new TrieNode[26];
            this.isTerminal = false;
        }
    }

    public static void insertWord(TrieNode root, String word) {
        if (word.length() == 0) {
            root.isTerminal = true;
            return;
        }
        char ch = word.charAt(0);
        int index = ch - 'a';
        TrieNode child;
        if (root.children[index] != null) {
            child = root.children[index];
        } else {
            child = new TrieNode(ch);
            root.children[index] = child;
        }
        insertWord(child, word.substring(1));
    }

    public static boolean searchWord(TrieNode root, String word) {
        if (word.length() == 0) {
            return root.isTerminal;
        }
        char ch = word.charAt(0);
        int index = ch - 'a';
        TrieNode child;
        if (root.children[index] != null) {
            child = root.children[index];
        } else {
            return false;
        }
        return searchWord(child, word.substring(1));
    }

    public static void storeSuggestions(TrieNode curr, List<String> temp, StringBuilder prefix) {
        if (curr.isTerminal) {
            temp.add(prefix.toString());
        }
        for (char ch = 'a'; ch <= 'z'; ch++) {
            int index = ch - 'a';
            TrieNode next = curr.children[index];
            if (next != null) {
                prefix.append(ch);
                storeSuggestions(next, temp, prefix);
                prefix.deleteCharAt(prefix.length() - 1);
            }
        }
    }

    public static List<List<String>> getSuggestions(TrieNode root, String input) {
        TrieNode prev = root;
        List<List<String>> output = new ArrayList<>();
        StringBuilder prefix = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char lastCh = input.charAt(i);
            int index = lastCh - 'a';
            TrieNode curr = prev.children[index];
            if (curr == null) {
                break;
            } else {
                List<String> temp = new ArrayList<>();
                prefix.append(lastCh);
                storeSuggestions(curr, temp, prefix);
                output.add(temp);
                prev = curr;
            }
        }
        return output;
    }

    public static void main(String[] args) {
        List<String> v = new ArrayList<>();
        v.add("love");
        v.add("lover");
        v.add("loving");
        v.add("last");
        v.add("lost");
        v.add("lane");
        v.add("lord");
        String input = "lovi";
        TrieNode root = new TrieNode('-');
        for (String word : v) {
            insertWord(root, word);
        }
        List<List<String>> ans = getSuggestions(root, input);
        System.out.println("Printing the answer:");
        for (List<String> suggestionList : ans) {
            for (String suggestion : suggestionList) {
                System.out.print(suggestion + ", ");
            }
            System.out.println();
        }
    }
}
