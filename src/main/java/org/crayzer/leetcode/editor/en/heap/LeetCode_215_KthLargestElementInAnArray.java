package org.crayzer.leetcode.editor.en.heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

public class LeetCode_215_KthLargestElementInAnArray {

    class Solution {
        public int findKthLargest(int[] nums, int k) {
            Arrays.sort(nums);
            return nums[nums.length - k];
        }
    }

    class Solution2 {
        public int findKthLargest(int[] nums, int k) {
            int len = nums.length;
            if (k <= nums.length - k) {
                PriorityQueue<Integer> minHeap = new PriorityQueue<>(k, (a, b) -> a - b);
                for (int i = 0; i < k; i++) {
                    minHeap.add(nums[i]);
                }
                for (int i = k; i < len; i++) {
                    Integer topEle = minHeap.peek();
                    if (nums[i] > topEle) {
                        minHeap.poll();
                        minHeap.add(nums[i]);
                    }
                }
                return minHeap.peek();
            } else {
                assert k > len - k;
                int capacity = len - k + 1;
                PriorityQueue<Integer> maxHeap = new PriorityQueue<>(capacity, (a, b) -> b - a);
                for (int i = 0; i < capacity; i++) {
                    maxHeap.add(nums[i]);
                }
                for (int i = capacity; i < len; i++) {
                    int topEle = maxHeap.peek();
                    if (nums[i] < topEle) {
                        maxHeap.poll();
                        maxHeap.add(nums[i]);
                    }
                }
                return maxHeap.peek();
            }
        }
    }

    private static Random random = new Random(System.currentTimeMillis());

    class Solution3 {
        public int findKthLargest(int[] nums, int k) {
            int len = nums.length;
            int target = len - k;
            int left = 0;
            int right = len - 1;
            while (true) {
                int index = partition(nums, left, right);
                if (index < target) {
                    left = index + 1;
                } else if (index > target) {
                    right = index - 1;
                } else {
                    return nums[index];
                }
            }
        }

        // 在区间 [left, right] 这个区间执行 partition 操作

        private int partition(int[] nums, int left, int right) {
            // 在区间随机选择一个元素作为标定点
            if (right > left) {
                int randomIndex = left + 1 + random.nextInt(right - left);
                swap(nums, left, randomIndex);
            }

            int pivot = nums[left];
            int j = left;
            for (int i = left + 1; i <= right; i++) {
                if (nums[i] < pivot) {
                    j++;
                    swap(nums, j, i);
                }
            }
            swap(nums, left, j);
            return j;
        }

        private void swap(int[] nums, int index1, int index2) {
            int temp = nums[index1];
            nums[index1] = nums[index2];
            nums[index2] = temp;
        }
    }
}
