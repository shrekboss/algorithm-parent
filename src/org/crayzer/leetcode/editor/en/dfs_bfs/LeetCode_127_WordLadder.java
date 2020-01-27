package org.crayzer.leetcode.editor.en.dfs_bfs;

import javafx.util.Pair;

import java.util.*;

public class LeetCode_127_WordLadder {

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        // String[] wordList = {"hot", "dot", "dog", "lot", "log", "cog"};
        String[] wordList = {"hot", "dot", "dog", "lot", "log"};
        Solution solution = new Solution();
        System.out.println(solution.ladderLength(beginWord, endWord, Arrays.asList(wordList)));
    }

    static class Solution {
        private int len;
        private HashMap<String, LinkedList<String>> allComboDict;

        public Solution() {
            this.len = 0;
            this.allComboDict = new HashMap<>();
        }

        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            if (!wordList.contains(endWord)) {
                return 0;
            }

            this.len = beginWord.length();

            wordList.forEach(
                    word -> {
                        for (int i = 0; i < len; i++) {
                            String newWord = word.substring(0, i) + "*" + word.substring(i + 1, len);
                            LinkedList<String> transformations = this.allComboDict.getOrDefault(newWord, new LinkedList<>());
                            transformations.add(word);
                            this.allComboDict.put(newWord, transformations);
                        }
                    }
            );

            Queue<Pair<String, Integer>> beginQueue = new LinkedList<>();
            Queue<Pair<String, Integer>> endQueue = new LinkedList<>();
            beginQueue.add(new Pair<>(beginWord, 1));
            endQueue.add(new Pair<>(endWord, 1));

            HashMap<String, Integer> beginVisited = new HashMap<>();
            HashMap<String, Integer> endVisited = new HashMap<>();
            beginVisited.put(beginWord, 1);
            endVisited.put(endWord, 1);

            while (!beginQueue.isEmpty() && !endQueue.isEmpty()) {
                int ans = visitedWordNode(beginQueue, beginVisited, endVisited);
                if (ans > -1) return ans;

                ans = visitedWordNode(endQueue, endVisited, beginVisited);
                if (ans > -1) return ans;
            }

            return 0;
        }

        private int visitedWordNode(Queue<Pair<String, Integer>> queue,
                                    HashMap<String, Integer> visited,
                                    HashMap<String, Integer> otherVisited) {
            Pair<String, Integer> node = queue.remove();
            String word = node.getKey();
            int level = node.getValue();

            for (int i = 0; i < len; i++) {
                String newWord = word.substring(0, i) + "*" + word.substring(i + 1, len);
                for (String adjacentWord : this.allComboDict.getOrDefault(newWord, new LinkedList<>())) {
                    if (otherVisited.containsKey(adjacentWord)) return level + otherVisited.get(adjacentWord);
                    if (!visited.containsKey(adjacentWord)) {
                        visited.put(adjacentWord, level + 1);
                        queue.add(new Pair<>(adjacentWord, level + 1));
                    }
                }
            }
            return -1;
        }

    }

    class Solution1 {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            if (!wordList.contains(endWord)) return 0;
            int len = beginWord.length();
            Map<String, List<String>> allComboDict = new HashMap<>();

            wordList.forEach(
                    word -> {
                        for (int i = 0; i < len; i++) {
                            String newWord = word.substring(0, i) + "*" + word.substring(i + 1, len);
                            List<String> transformations = allComboDict.getOrDefault(newWord, new LinkedList<>());
                            transformations.add(word);
                            allComboDict.put(newWord, transformations);
                        }
                    }
            );

            Queue<Pair<String, Integer>> queue = new LinkedList<>();
            queue.add(new Pair<>(beginWord, 1));

            Map<String, Boolean> visited = new HashMap<>();
            visited.put(beginWord, true);

            while (!queue.isEmpty()) {
                Pair<String, Integer> node = queue.remove();
                String word = node.getKey();
                int level = node.getValue();

                for (int i = 0; i < len; i++) {
                    String newWord = word.substring(0, i) + "*" + word.substring(i + 1, len);
                    for (String adjacentWord : allComboDict.getOrDefault(newWord, new LinkedList<>())) {
                        if (adjacentWord.equals(endWord)) return level + 1;
                        if (!visited.containsKey(adjacentWord)) {
                            visited.put(adjacentWord, true);
                            queue.add(new Pair<>(adjacentWord, level + 1));
                        }
                    }
                }
            }

            return 0;
        }
    }
}
