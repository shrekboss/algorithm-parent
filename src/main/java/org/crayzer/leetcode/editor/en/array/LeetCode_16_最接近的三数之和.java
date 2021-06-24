package org.crayzer.leetcode.editor.en.array;

import java.util.Arrays;

/**
 * @author yizhe.chen
 * 给定一个包括n 个整数的数组nums和 一个目标值target。找出nums中的三个整数，使得它们的和与target最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * <p>
 * 示例：
 * <p>
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 * <p>
 * 提示：
 * <p>
 * 3 <= nums.length <= 10^3
 * -10^3<= nums[i]<= 10^3
 * -10^4<= target<= 10^4
 */
public class LeetCode_16_最接近的三数之和 {

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];
        int index = 0;

        while (index <= nums.length - 3) {
            int left = index + 1, right = nums.length - 1;

            while (left < right) {
                int sum = nums[index] + nums[left] + nums[left + 1];
                if (target < sum) {
                    if (Math.abs(target - sum) < Math.abs(target - result)) {
                        result = sum;
                    }
                    break;
                }
                sum = nums[index] + nums[right - 1] + nums[right];
                if (target > sum) {
                    if (Math.abs(target - sum) < Math.abs(target - result)) {
                        result = sum;
                    }
                    break;
                }
                sum = nums[index] + nums[left] + nums[right];
                if (target < sum) {
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    right--;
                } else if (target > sum) {
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    left++;
                } else {
                    return target;
                }
            }
            while (index <= nums.length - 3 && nums[index + 1] == nums[index]) {
                index++;
            }
            index++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        int target = 1;
        System.out.println(LeetCode_16_最接近的三数之和.threeSumClosest(nums, target));
    }
}
