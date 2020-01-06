package org.crayzer.leetcode.editor.en.list;

import org.crayzer.leetcode.editor.en.ListNode;

public class LeetCode_2_AddTwoNumbers {
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode soldier = new ListNode(0);
            ListNode cur = soldier;
            ListNode p = l1;
            ListNode q = l2;
            int carray = 0;

            while (p != null || q != null) {
                int x = p != null ? p.val : 0;
                int y = q != null ? q.val : 0;
                int sum = carray + x + y;
                carray = sum / 10;
                cur.next = new ListNode(sum % 10);
                cur = cur.next;

                if (p != null) p = p.next;
                if (q != null) q = q.next;
            }
            if (carray > 0) cur.next = new ListNode(carray);
            return soldier.next;
        }
    }
}
