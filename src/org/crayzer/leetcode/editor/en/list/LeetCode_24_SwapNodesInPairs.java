package org.crayzer.leetcode.editor.en.list;

import org.crayzer.leetcode.editor.en.ListNode;

public class LeetCode_24_SwapNodesInPairs {

    class Solution {
        public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null) return head;
            ListNode next = head.next;
            head.next = swapPairs(next.next);
            next.next = head;
            return next;
        }
    }

    class Solution2 {
        public ListNode swapPairs(ListNode head) {
            ListNode soldier = new ListNode(0);
            soldier.next = head;
            ListNode temp = soldier;

            while (temp.next != null && temp.next.next != null) {
                ListNode start = temp.next;
                ListNode end = temp.next.next;
                temp.next = end;
                start.next = end.next;
                end.next = start;
                temp = start;
            }
            return soldier.next;
        }
    }
}
