package org.crayzer.leetcode.editor.en.linkedlist;

import org.crayzer.leetcode.editor.en.ListNode;

public class LeetCode_2_两数相加 {
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode soldier = new ListNode(0);
            ListNode cur = soldier;
            int carray = 0;

            while (l1 != null || l2 != null) {
                int x = l1 != null ? l1.val : 0;
                int y = l2 != null ? l2.val : 0;
                int sum = carray + x + y;
                carray = sum / 10;
                cur.next = new ListNode(sum % 10);
                cur = cur.next;

                if (l1 != null) l1 = l1.next;
                if (l2 != null) l2 = l2.next;
            }
            if (carray > 0) cur.next = new ListNode(carray);
            return soldier.next;
        }
    }
}
