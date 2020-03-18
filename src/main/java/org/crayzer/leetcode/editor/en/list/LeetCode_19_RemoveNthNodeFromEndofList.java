package org.crayzer.leetcode.editor.en.list;

import org.crayzer.leetcode.editor.en.ListNode;

public class LeetCode_19_RemoveNthNodeFromEndofList {
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode soldier = new ListNode(-1);
            soldier.next = head;
            ListNode p = soldier;
            ListNode q = soldier;

            for (int i = 0; i < n; i++) {
                p = p.next;
            }

            while (p.next != null) {
                p = p.next;
                q = q.next;
            }

            ListNode delNode = q.next;
            q.next = delNode.next;
            delNode = null;

            return soldier.next;
        }
    }
}
