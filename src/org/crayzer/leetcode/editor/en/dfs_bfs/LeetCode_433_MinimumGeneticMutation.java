package org.crayzer.leetcode.editor.en.dfs_bfs;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 最小基因变化
 * 和 LeetCode_127_WordLadder
 * 解法基本一致@！
 */
public class LeetCode_433_MinimumGeneticMutation {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String start = "AACCGGTT";
        String end = "AACCGGTA";
        String[] bank = {"AACCGGTA"};
        System.out.println(solution.minMutation(start, end, bank));
    }

    static class Solution {
        public int minMutation(String start, String end, String[] bank) {
            int len = start.length();
            HashMap<String, LinkedList<String>> allComboDict = new HashMap<>();

            for (int i = 0; i < bank.length; i++) {
                for (int j = 0; j < len; j++) {
                    String newItem = bank[i].substring(0, j) + "*" + bank[i].substring(j + 1, len);
                    LinkedList<String> transformations = allComboDict.getOrDefault(newItem, new LinkedList<>());
                    transformations.add(bank[i]);
                    allComboDict.put(newItem, transformations);
                }
            }

            Queue<Pair<String, Integer>> queue = new LinkedList<>();
            queue.add(new Pair<>(start, 0));

            HashMap<String, Boolean> visited = new HashMap<>();
            visited.put(start, true);

            while (!queue.isEmpty()) {
                Pair<String, Integer> node = queue.remove();
                String item = node.getKey();
                int level = node.getValue();

                for (int i = 0; i < len; i++) {
                    String newItem = item.substring(0, i) + "*" + item.substring(i + 1, len);
                    for (String adjacentItem : allComboDict.getOrDefault(newItem, new LinkedList<>())) {
                        if (adjacentItem.equals(end)) return level + 1;

                        if (!visited.containsKey(adjacentItem)) {
                            visited.put(adjacentItem, true);
                            queue.add(new Pair<>(adjacentItem, level + 1));
                        }
                    }
                }
            }
            return -1;
        }
    }
}
