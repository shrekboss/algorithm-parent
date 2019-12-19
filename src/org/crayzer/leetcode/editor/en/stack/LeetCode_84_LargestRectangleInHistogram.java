package org.crayzer.leetcode.editor.en.stack;

public class LeetCode_84_LargestRectangleInHistogram {

    /**
     * 通过栈实现
     */
    class Solution3 {
        public int largestRectangleArea(int[] heights) {
            return 0;
        }
    }

    /**
     * O(n^2)
     **/
    class Solution2 {
        public int largestRectangleArea(int[] heights) {
            int maxArea = 0;

            for (int i = 0; i < heights.length; i++) {
                int minHeight = Integer.MAX_VALUE;
                for (int j = i; j < heights.length; j++) {
                    minHeight = Math.min(minHeight, heights[j]);
                    maxArea = Math.max(maxArea, (j - i + 1) * minHeight);
                }
            }

            return maxArea;
        }
    }

    /**
     * describe: 枚举所有的柱子
     * O(n^3)
     **/
    class Solution1 {
        public int largestRectangleArea(int[] heights) {
            int maxArea = 0;

            for (int i = 0; i < heights.length; i++) {
                for (int j = i; j < heights.length; j++) {
                    int minHeight = Integer.MAX_VALUE;
                    for (int k = i; k <= j; k++) {
                        minHeight = Math.min(minHeight, heights[k]);
                    }
                    maxArea = Math.max(maxArea, (j - i + 1) * minHeight);
                }
            }

            return maxArea;
        }
    }
}
