package org.crayzer.leetcode.editor.en.dfs_bfs;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode_127_WordLadder {
    class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            int len = beginWord.length();
            HashMap<String, LinkedList<String>> allComboDict = new HashMap<>();

            wordList.forEach(
                    word -> {
                        for (int i = 0; i < len; i++) {
                            String newWord = word.substring(0, i) + "*" + word.substring(i + 1, len);
                            LinkedList<String> transformations = allComboDict.getOrDefault(newWord, new LinkedList<>());
                            transformations.add(word);
                            allComboDict.put(newWord, transformations);
                        }
                    }
            );

            Queue<Pair<String, Integer>> queue = new LinkedList<>();
            queue.add(new Pair<>(beginWord, 1));

            HashMap<String, Boolean> visited = new HashMap<>();
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
