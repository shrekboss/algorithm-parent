package org.crayzer.leetcode.editor.en.dfs_bfs;

import java.util.*;

public class LeetCode_127_WordLadder {

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        String[] wordList = {"hot", "dot", "dog", "lot", "log", "cog"};
//        String[] wordList = {"hot", "dot", "dog", "lot", "log"};
        Solution1 solution = new Solution1();
        System.out.println(solution.ladderLength(beginWord, endWord, Arrays.asList(wordList)));
    }

    static class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            Set<String> wordSet = new HashSet<>(wordList);
            if (!wordSet.contains(endWord)) return 0;

            wordSet.remove(beginWord);

            Queue<String> queue = new LinkedList<>();
            queue.add(beginWord);
            Set<String> visited = new HashSet<>();
            visited.add(beginWord);

            int step = 1;
            while  (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    String curWord = queue.poll();
                    if (changeWordEveryOneLetter(curWord, endWord, queue, visited, wordSet)) {
                        return step + 1;
                    }
                }
                step++;
            }
            return 0;
        }

        private boolean changeWordEveryOneLetter(String curWord, String endWord, Queue<String> queue, Set<String> visited, Set<String> wordSet) {
            char[] chars = curWord.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char originChar = chars[i];
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    if (originChar == ch) continue;
                    chars[i] = ch;
                    String nextWord = String.valueOf(chars);
                    if (wordSet.contains(nextWord)) {
                        if (endWord.equals(nextWord)) return true;
                        if (!visited.contains(nextWord)) {
                            queue.add(nextWord);
                            visited.add(nextWord);
                        }
                    }
                }
                chars[i] = originChar;
            }
            return false;
        }
    }

    static class Solution1 {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            Set<String> wordSet = new HashSet<>(wordList);
            if (!wordSet.contains(endWord)) return 0;


            Set<String> beginVisited = new HashSet<>();
            Set<String> endVisited = new HashSet<>();
            beginVisited.add(beginWord);
            endVisited.add(endWord);
            Set<String> visited = new HashSet<>();

            int step = 1;
            while  (!beginVisited.isEmpty() && !endVisited.isEmpty()) {
                if (beginVisited.size() > endVisited.size()) {
                    Set<String> temp = beginVisited;
                    beginVisited = endVisited;
                    endVisited = temp;
                }

                Set<String> nextLevelVisited = new HashSet<>();
                for (String word : beginVisited) {
                    if (changeWordEveryOneLetter(word, endVisited, visited, wordSet, nextLevelVisited)) {
                        return step + 1;
                    }
                }
                beginVisited = nextLevelVisited;
                step++;
            }
            return 0;
        }

        private boolean changeWordEveryOneLetter(String curWord, Set<String> endVisited, Set<String> visited, Set<String> wordSet, Set<String> nextLevelVisited) {
            char[] chars = curWord.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char originChar = chars[i];
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    if (originChar == ch) continue;
                    chars[i] = ch;
                    String nextWord = String.valueOf(chars);
                    if (wordSet.contains(nextWord)) {
                        if (endVisited.contains(nextWord)) return true;
                        if (!visited.contains(nextWord)) {
                            nextLevelVisited.add(nextWord);
                            visited.add(nextWord);
                        }
                    }
                }
                chars[i] = originChar;
            }
            return false;
        }
    }
}
