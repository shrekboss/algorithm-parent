package org.crayzer.leetcode.editor.en.dynamic_programming;

import java.util.Arrays;

public class LeetCode_300_最长上升子序列 {
    class Solution2 {
        public int lengthOfLIS(int[] nums) {
            int[] dp = new int[nums.length];
            int len = 0;
            for (int num : nums) {
                int i = Arrays.binarySearch(dp, 0, len, num);
                if (i < 0) {
                    i = -(i + 1);
                }
                dp[i] = num;
                if (i == len) {
                    len++;
                }
            }
           return len;
        }
    }

    static class Solution {
        public int lengthOfLIS(int[] nums) {
            int len = nums.length;
            if (len <= 1) return len;

            int[] tail = new int[len];
            tail[0] = nums[0];
            int end = 0;

            for (int i = 1; i < len; i++) {
                if (nums[i] > tail[end]) {
                    end++;
                    tail[end] = nums[i];
                } else {
                    int left = 0, right = end;
                    while (left < right) {
                        int mid = (left + right) >>> 1;
                        if (tail[mid] < nums[i]) left = mid + 1;
                        else right = mid;
                    }
                    tail[left] = nums[i];
                }
                // 调试方法
                printArray(nums[i], tail);
            }
            end++;
            return end;
        }

        // 调试方法，以观察是否运行正确
        private void printArray(int num, int[] tail) {
            System.out.print("当前数字：" + num);
            System.out.print("\t当前 tail 数组：");
            int len = tail.length;
            for (int i = 0; i < len; i++) {
                if (tail[i] == 0) {
                    break;
                }
                System.out.print(tail[i] + ", ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 5, 6, 2, 5, 4, 19, 5, 6, 7, 12};
        Solution solution = new Solution();
        int lengthOfLIS = solution.lengthOfLIS(nums);
        System.out.println("最长上升子序列的长度：" + lengthOfLIS);
    }
}
