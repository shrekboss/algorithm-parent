package org.crayzer.leetcode.editor.en.binary_search;

public class LeetCode_154_寻找旋转排序数组中的最小值2 {
    class Solution {
        public int findMin(int[] arr) {
            if (arr == null || arr.length == 0) return -1;
            int left = 0, right = arr.length - 1;
            while (left < right) {
                int mid = (left + right) >>> 1;
                if (arr[mid] > arr[right]) {
                    left = mid + 1;
                } else if (arr[mid] < arr[right]) {
                    right = mid;
                } else {
                    right--;
                }
            }
            return arr[left];
        }
    }
}
