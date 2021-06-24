package org.crayzer.leetcode.editor.en.sort.primary_sort;

public class InsertionSort {
    public static void main(String[] args) {
        int[] nums = {3, 6, 2, 4, 6, 1};
        insertionSort(nums);

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    private static void insertionSort(int[] nums) {
        int n = nums.length;

        for (int i = 1; i < n; i++) {
            int preIndex = i - 1;
            int current = nums[i];

            while (preIndex >= 0 && nums[preIndex] > current) {
                nums[preIndex + 1] = nums[preIndex];
                preIndex--;
            }
            nums[preIndex + 1] = current;
        }
    }
}
