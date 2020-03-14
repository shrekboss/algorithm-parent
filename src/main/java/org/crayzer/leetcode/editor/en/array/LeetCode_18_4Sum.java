package org.crayzer.leetcode.editor.en.array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LeetCode_18_4Sum {

    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> res = new LinkedList<>();
            if (nums == null || nums.length < 4) return res;

            Arrays.sort(nums);
            int length = nums.length;

            for (int k = 0; k < length - 3; k++) {
                if (k > 0 && nums[k] == nums[k - 1]) continue;

                int min = nums[k] + nums[k + 1] + nums[k + 2] + nums[k + 3];
                if (min > target) continue;

                int max = nums[k] + nums[length - 3] + nums[length - 2] + nums[length - 1];
                if (max < target) continue;

                for (int i = k + 1; i < length - 2; i++) {
                    if (i > k + 1 && nums[i] == nums[i - 1]) continue;

                    int j = i + 1;
                    int h = length - 1;

                    min = nums[k] + nums[i] + nums[j] + nums[j + 1];
                    if (min > target) continue;

                    max = nums[k] + nums[i] + nums[h - 1] + nums[h];
                    if (max < target) continue;

                    while (j < h) {
                        int curr = nums[k] + nums[i] + nums[j] + nums[h];
                        if (curr < target) {
                            while (j < h && nums[j] == nums[++j]);
                        } else if (curr > target) {
                            while (j < h && nums[h] == nums[--h]);
                        } else {
                            res.add(Arrays.asList(nums[k], nums[i], nums[j], nums[h]));
                            while (j < h && nums[j] == nums[++j]);
                            while (j < h && nums[h] == nums[--h]);
                        }
                    }
                }
            }
            return res;
        }
    }
}
