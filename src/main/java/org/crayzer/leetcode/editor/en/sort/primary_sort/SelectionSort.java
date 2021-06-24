package org.crayzer.leetcode.editor.en.sort.primary_sort;

public class SelectionSort {

    public static void main(String[] args) {
        int[] nums = {3, 6, 2, 4, 6, 1};
        selectionSort(nums);

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static void selectionSort(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i; j < n; j++) {
                if (nums[minIndex] > nums[j]) minIndex = j;
            }
            int temp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = temp;
        }
    }
}
