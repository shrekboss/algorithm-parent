package org.crayzer.leetcode.editor.en;

public class RemoveDuplicatesFromSortedArray_26 {

    class Solution12 {
        public int removeDuplicates(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }

            int i = 0;
            for (int j = 1; j < nums.length; j++) {
                if (nums[i] != nums[j]) {
                    /** 细节决定成败 */
                    if (j - i > 1) {
                        nums[i + 1] = nums[j];
                    }
                    i++;
                }
            }
            return i + 1;
        }
    }

    class Solution1 {
        public int removeDuplicates(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }

            int i = 0;
            for (int j = 1; j < nums.length; j++) {
                if (nums[i] != nums[j]) {
                    nums[i++] = nums[j];
                }
            }
            return i + 1;
        }
    }

}
