package org.crayzer.leetcode.editor.en.array;

public class LeetCode_1248_统计优美子数组 {

    class Solution {
        public int numberOfSubarrays(int[] nums, int k) {
            int len = nums.length, res = 0, cnt = 0, arr[] = new int[len + 2];
            for (int i = 0; i < len; i++) {
                if ((nums[i] & 1) == 1) {
                    arr[++cnt] = i;
                }
            }
            arr[0] = -1;
            arr[cnt + 1] = len;
            for (int i = 1; i + k < cnt + 2; i++) {
                res += (arr[i] - arr[ i - 1]) * (arr[i + k] - arr[i + k - 1]);
            }
            return res;
        }
    }
}