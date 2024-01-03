package com.graph;

import java.util.*;

public class WordLadderLeetCode127 {
    class Pair{
        String first;
        int second;
        Pair(String first, int second){
            this.first=first;
            this.second=second;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord,1));
        HashSet<String>st = new HashSet<>(wordList);
        //jo bi word queue me insert karuga , toh usko set me se remove kr dunga
        st.remove(beginWord);
        while (!q.isEmpty()){
            Pair front= q.poll();
            String currString = front.first;
            int currCount = front.second;
            //cheeck kahi destination tk to ni pahuch gye
            if(currString.equals(endWord)){
                return currCount;
            }
            // Generate all possible words by changing one character at a time
            for (int index=0;index<currString.length();index++){
                //hr index pe jo value h, usko main 'a'to 'z' se replace karuga
                char[] charArray = currString.toCharArray();
                for (char ch ='a';ch<='z';ch++){
                    charArray[index] = ch;
                    String newWord = new String(charArray);
                    // Check if the new word is in the wordList and has not been visited
                    if (st.contains(newWord)) {
                        st.remove(newWord);  // Mark the word as visited to avoid cycles
                        q.add(new Pair(newWord, currCount + 1));
                    }
                }

            }
        }
        return 0;

    }
    public static void main(String[] args) {
       String beginWord = "hit";
       String endWord = "cog";
       List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
        WordLadderLeetCode127 wc = new WordLadderLeetCode127();
        int length = wc.ladderLength(beginWord, endWord, wordList);

        System.out.println(length);


    }
}
