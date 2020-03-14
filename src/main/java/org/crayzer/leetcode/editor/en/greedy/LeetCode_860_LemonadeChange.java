package org.crayzer.leetcode.editor.en.greedy;

/**
 * class_name: LeetCode_860_LemonadeChange
 * package: org.crayzer.leetcode.editor.en.greedy
 * describe: 2 个 5 元等价于 1 个 10 元。需要尽可能地多留 5 元在手上，防止 10 元的顾客无法找零。
 **/
public class LeetCode_860_LemonadeChange {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] bills = {5, 5, 5, 10, 5, 5, 10, 20, 20, 20};
        // int[] bills = {10};
        System.out.println(solution.lemonadeChange(bills));
    }

    static class Solution {
        public boolean lemonadeChange(int[] bills) {
            int five = 0, ten = 0;

            for (int bill : bills) {
                if (bill == 5) five++;
                else if (bill == 10) {
                    if (five == 0) return false;
                    five--; ten++;
                } else {
                    if (five > 0 && ten > 0) {
                        five--; ten--;
                    }
                    else if (five > 2) five -= 3;
                    else return false;
                }
            }
            return true;
        }
    }
}
