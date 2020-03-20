package org.crayzer.leetcode.editor.en.sort;

/**
 * 0 <= k <= arr.length <= 10000
 * 0 <= arr[i] <= 10000
 */
public class LeetCode_40_最小的k个数 {
    class Solution {
        public int[] getLeastNumbers(int[] arr, int k) {
            if (k == 0 || arr.length == 0) {
                return new int[0];
            }
            int[] counter = new int[10001];
            for (int num: arr) {
                counter[num]++;
            }
            int[] res = new int[k];
            int idx = 0;
            for (int num = 0; num < counter.length; num++) {
                while (counter[num]-- > 0 && idx < k) {
                    res[idx++] = num;
                }
                if (idx == k) {
                    break;
                }
            }
            return res;
        }
    }
}
