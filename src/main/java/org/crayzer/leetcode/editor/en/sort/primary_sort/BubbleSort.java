package org.crayzer.leetcode.editor.en.sort.primary_sort;

public class BubbleSort {

    public static void main(String[] args) {
        int[] nums = {3, 6, 2, 4, 6, 1};
        bubbleSort(nums);

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static void bubbleSort(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {
            boolean flag = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag) break;
        }
    }
}
