package org.crayzer.leetcode.editor.en.list;

import org.crayzer.leetcode.editor.en.ListNode;

public class LeetCode_445_两数相加2 {

    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode rev1 = reverseList(l1);
            ListNode rev2 = reverseList(l2);

            ListNode res = null;
            ListNode pre = null;
            int carry = 0;
            while (rev1 != null || rev2 != null) {
                int num1 = rev1 != null ? rev1.val : 0;
                int num2 = rev2 != null ? rev2.val : 0;
                int temp = num1 + num2 + carry;
                carry = temp / 10;
                pre = res;
                res = new ListNode(temp % 10);
                res.next = pre;
                rev1 = rev1 != null ? rev1.next : null;
                rev2 = rev2 != null ? rev2.next : null;
            }
            if (carry == 1) {
                pre = res;
                res = new ListNode(1);
                res.next = pre;
            }
            return res;
        }

        public ListNode reverseList(ListNode cur) {
            ListNode rev = null;
            while (cur != null) {
                ListNode temp = cur.next;
                cur.next = rev;
                rev = cur;
                cur = temp;
            }
            return rev;
        }
    }
}
