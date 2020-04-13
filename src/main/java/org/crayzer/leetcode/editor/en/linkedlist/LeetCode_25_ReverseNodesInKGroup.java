package org.crayzer.leetcode.editor.en.linkedlist;

import org.crayzer.leetcode.editor.en.ListNode;

public class LeetCode_25_ReverseNodesInKGroup {
    class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode soldier = new ListNode(0);
            soldier.next = head;

            ListNode pre = soldier;
            ListNode end = soldier;

            while (end.next != null) {
                for (int i = 0; i < k && end != null; i++) {
                    end = end.next;
                }

                if (end == null) break;
                ListNode start = pre.next;
                ListNode next = end.next;
                end.next = null;

                pre.next = reverse(start);
                start.next = next;

                pre = start;
                end = pre;
            }
            return soldier.next;
        }

        private ListNode reverse(ListNode head) {
            ListNode prev = null;
            ListNode cur = head;
            ListNode tmp;

            while (cur != null) {
                tmp = cur.next;
                cur.next = prev;
                prev = cur;
                cur = tmp;
            }

            return prev;
        }
    }
}
