package org.crayzer.leetcode.editor.en.array;

import java.util.Arrays;

public class LeetCode_4_MedianOfTwoSortedArrays {

    class Solution2 {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            return 1.0;
        }
    }

    class Solution {
        // O((M+N)log(M+N))
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int m = nums1.length;
            int n = nums2.length;

            int[] newNums = new int[m + n];
            System.arraycopy(nums1, 0, newNums, 0, m);
            System.arraycopy(nums2, 0, newNums, m, n);

            Arrays.sort(newNums);
            // if ((m+n) % 2 == 1) return (newNums[0] + newNums[m + n -1]) / 2.0;
            // if ((m+n) % 2 == 1) return newNums[(m + n - 1) >>> 1];
            if (((m + n) & 1) == 1) return newNums[(m + n - 1) >>> 1];
                // (m + n - 1) >>> 1 左边 ； (m + n) >>> 1 右边
            else return (newNums[(m + n - 1) >>> 1] + newNums[(m + n) >>> 1]) / 2.0;
        }
    }
}
