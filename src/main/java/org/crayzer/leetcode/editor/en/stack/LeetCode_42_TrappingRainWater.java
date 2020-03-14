package org.crayzer.leetcode.editor.en.stack;

import java.util.Stack;

public class LeetCode_42_TrappingRainWater {

    class Solution3 {
        public int trap(int[] height) {
            int sum = 0;
            int[] maxLeft = new int[height.length];
            int[] maxRight = new int[height.length];
            for (int i = 1; i < height.length - 1; i++) {
                maxLeft[i] = Math.max(maxLeft[i - 1], height[i - 1]);
            }
            for (int i = height.length - 2; i >= 0; i--) {
                maxRight[i] = Math.max(maxRight[i + 1], height[i + 1]);
            }
            for (int i = 1; i < height.length - 1; i++) {
                int min = Math.min(maxLeft[i], maxRight[i]);
                if (min > height[i])
                    sum = sum + min - height[i];
            }
            return sum;
        }
    }

    class Solution2 {
        public int trap(int[] height) {
            Stack<Integer> stack = new Stack<>();
            int current = 0;
            int sum = 0;

            while (current < height.length) {
                while (!stack.isEmpty() && height[current] > height[stack.peek()]) {
                    int h = height[stack.peek()];
                    stack.pop();
                    if (stack.isEmpty()) break;;
                    int distance = current - stack.peek() - 1;
                    int min = Math.min(height[current], height[stack.peek()]);
                    sum = sum + distance * (min - h);
                }
                stack.push(current);
                current++;
            }
            return sum;
        }
    }

    // O(n²）
    class Solution1 {
        public int trap(int[] height) {
            int sum = 0;
            //最两端的列不用考虑，因为一定不会有水。所以下标从 1 到 length - 2
            for (int i = 1; i < height.length - 1; i++) {
                int max_left = 0;
                //找出左边最高
                for (int j = i - 1; j >= 0; j--) {
                    if (height[j] > max_left) {
                        max_left = height[j];
                    }
                }
                int max_right = 0;
                //找出右边最高
                for (int j = i + 1; j < height.length; j++) {
                    if (height[j] > max_right) {
                        max_right = height[j];
                    }
                }
                //找出两端较小的
                int min = Math.min(max_left, max_right);
                //只有较小的一段大于当前列的高度才会有水，其他情况不会有水
                if (min > height[i]) {
                    sum = sum + (min - height[i]);
                }
            }
            return sum;
        }
    }

    // O(max * n)
    class Solution {
        public int trap(int[] height) {
            int sum = 0;
            int max = getMax(height);

            for (int i = 1; i <= max; i++) {
                boolean isStart = false;
                int temp_sum = 0;

                for (int j = 0; j < height.length; j++) {
                    if (isStart && height[j] < i)
                        temp_sum++;
                    if (height[j] >= i) {
                        sum = sum + temp_sum;
                        temp_sum = 0;
                        isStart = true;
                    }
                }
            }
            return sum;
        }

        private int getMax(int[] height) {
            int max = 0;
            for (int i = 0; i < height.length; i++) {
                if (height[i] > max) {
                    max = height[i];
                }
            }
            return max;
        }
    }
}
