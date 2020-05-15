package org.crayzer.leetcode.editor.en.array;

import sun.util.resources.cldr.ta.CurrencyNames_ta;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_560_和为K的子数组 {

    class Solution {
        public int subarraySum(int[] nums, int k) {
            int cnt = 0, pre = 0;
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, 1);
            for (int i = 0; i < nums.length; i++) {
                pre += nums[i];
                if (map.containsKey(pre - k)) cnt += map.get(pre - k);
                map.put(pre, map.getOrDefault(pre, 0) + 1);
            }
            return cnt;
        }
    }

    class Solution1 {
        public int subarraySum(int[] nums, int k) {
            int cnt = 0;
            for (int i = 0; i < nums.length; i++) {
                int sum = 0;
                for (int j = i; j >= 0; j--) {
                    sum += nums[j];
                    if (sum == k) cnt++;
                }
            }
            return cnt;
        }
    }
}
