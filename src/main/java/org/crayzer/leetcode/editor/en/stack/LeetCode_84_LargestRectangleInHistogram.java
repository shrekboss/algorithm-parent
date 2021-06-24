package org.crayzer.leetcode.editor.en.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class LeetCode_84_LargestRectangleInHistogram {

//    static class Solution {
//        public int largestRectangleArea(int[] heights) {
//            int len = heights.length;
//            if (len == 0) return 0;
//            if (len == 1) return heights[0];
//
//            int[] newHeights = new int[len + 2];
//            newHeights[0] = 0;
//            System.arraycopy(heights, 0, newHeights, 1, len);
//            newHeights[len + 1] = 0;
//            len += 2;
//
//            Deque<Integer> stack = new ArrayDeque<>();
//            stack.addLast(0);
//            int max = 0;
//
//            for (int i = 1; i < len; i++) {
//                while (newHeights[i] < newHeights[stack.peekLast()]) {
//                    int curHeight = newHeights[stack.pollLast()];
//                    int curWidth = i - stack.peekLast() - 1;
//                    max = Math.max(max, curHeight * curWidth);
//                }
//                stack.addLast(i);
//            }
//            return max;
//        }
//    }

    static class Solution {
        public int largestRectangleArea(int[] heights) {
            int len = heights.length;
            if (len == 0) return 0;
            if (len == 1) return heights[0];

            Deque<Integer> stack = new ArrayDeque<>();
            int max = 0;

            for (int i = 0; i < len; i++) {
                while (!stack.isEmpty() && heights[stack.peekLast()] > heights[i]) {
                    int curHeight = heights[stack.pollLast()];

                    while (!stack.isEmpty() && heights[stack.peekLast()] == curHeight) {
                        stack.pollLast();
                    }

                    int curWidth;
                    if (stack.isEmpty()) {
                        curWidth = i;
                    } else {
                        curWidth = i - stack.peekLast() - 1;
                    }
                    max = Math.max(max, curHeight * curWidth);
                }
                stack.addLast(i);
            }

            while (!stack.isEmpty()) {
                int curHeight = heights[stack.pollLast()];
                while (!stack.isEmpty() && heights[stack.peekLast()] == curHeight) {
                    stack.pollLast();
                }

                int curWidth;
                if (stack.isEmpty()) {
                    curWidth = len;
                } else {
                    curWidth = len - stack.peekLast() - 1;
                }
                max = Math.max(max, curHeight * curWidth);
            }
            return max;
        }
    }

    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        Solution solution = new Solution();
        System.out.println(solution.largestRectangleArea(heights));
    }

    /**
     * 通过栈实现
     */
//    class Solution3 {
//        public int largestRectangleArea(int[] heights) {
//            Stack<Integer> stack = new Stack<>();
//            stack.push(-1);
//
//            int maxArea = 0;
//            for (int i = 0; i < heights.length; i++) {
//                while (stack.peek() != -1 && heights[stack.peek()] >= heights[i])
//                    maxArea = Math.max(maxArea, heights[stack.pop()] * (i - stack.peek() - 1));
//                stack.push(i);
//            }
//
//            while (stack.peek() != -1) {
//                maxArea = Math.max(maxArea, heights[stack.pop()] * (heights.length - stack.peek()- 1));
//            }
//            return maxArea;
//        }
//    }

    /**
     * O(n^2)
     **/
//    class Solution2 {
//        public int largestRectangleArea(int[] heights) {
//            int maxArea = 0;
//
//            for (int i = 0; i < heights.length; i++) {
//                int minHeight = Integer.MAX_VALUE;
//                for (int j = i; j < heights.length; j++) {
//                    minHeight = Math.min(minHeight, heights[j]);
//                    maxArea = Math.max(maxArea, (j - i + 1) * minHeight);
//                }
//            }
//
//            return maxArea;
//        }
//    }

    /**
     * describe: 枚举所有的柱子
     * O(n^3)
     **/
//    class Solution1 {
//        public int largestRectangleArea(int[] heights) {
//            int maxArea = 0;
//
//            for (int i = 0; i < heights.length; i++) {
//                for (int j = i; j < heights.length; j++) {
//                    int minHeight = Integer.MAX_VALUE;
//                    for (int k = i; k <= j; k++) {
//                        minHeight = Math.min(minHeight, heights[k]);
//                    }
//                    maxArea = Math.max(maxArea, (j - i + 1) * minHeight);
//                }
//            }
//
//            return maxArea;
//        }
//    }
}
