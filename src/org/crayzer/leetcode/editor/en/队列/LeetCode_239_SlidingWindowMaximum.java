package org.crayzer.leetcode.editor.en.队列;

import java.util.ArrayDeque;

public class LeetCode_239_SlidingWindowMaximum {

    class Solution3 {
        public int[] maxSlidingWindow(int[] nums, int k) {
            int n = nums.length;
            if (n * k == 0) return new int[0];
            if (k == 1) return nums;

            int[] res = new int[n - k + 1];
            int index = -1;
            int max = Integer.MIN_VALUE;

            for (int i = 0; i < n - k + 1; i++) {
                if (index < i) {
                    max = nums[i];
                    for (int j = i + 1; j < i + k; j++) {
                        if (nums[j] > max) {
                            max = nums[j];
                            index = j;
                        }
                    }
                } else {
                    if (nums[i + k - 1] >= max) {
                        max = nums[i + k - 1];
                        index = i + k - 1;
                    }
                }
                res[i] = max;
            }
            return res;
        }

        class Solution2 {
            ArrayDeque<Integer> deq = new ArrayDeque<>();
            int[] nums;

            public int[] maxSlidingWindow(int[] nums, int k) {
                int n = nums.length;
                if (n * k == 0) return new int[0];
                if (k == 1) return nums;

                this.nums = nums;
                int maxIdx = 0;
                for (int i = 0; i < k; i++) {
                    cleanDeque(i, k);
                    deq.addLast(i);
                    if (nums[i] > nums[maxIdx]) maxIdx = i;
                }

                int[] res = new int[n - k + 1];
                res[0] = nums[maxIdx];
                for (int i = k; i < n; i++) {
                    cleanDeque(i, k);
                    deq.addLast(i);
                    res[i - k + 1] = nums[deq.getFirst()];
                }
                return res;
            }

            private void cleanDeque(int i, int k) {
                if (!deq.isEmpty() && deq.getFirst() == i - k) deq.removeFirst();
                while (!deq.isEmpty() && nums[i] > nums[deq.getLast()]) deq.removeLast();
            }
        }

        /**
         * O(nk)
         */
        class Solution1 {
            public int[] maxSlidingWindow(int[] nums, int k) {
                int n = nums.length;
                if (n * k == 0) return new int[0];

                int[] slidingWindow = new int[n - k + 1];
                for (int i = 0; i < n - k + 1; i++) {
                    int max = Integer.MIN_VALUE;

                    for (int j = i; j < i + k; j++) {
                        max = Math.max(max, nums[j]);
                    }

                    slidingWindow[i] = max;
                }
                return slidingWindow;
            }
        }
    }
}
