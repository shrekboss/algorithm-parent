package org.crayzer.leetcode.editor.en.linkedlist;

import org.crayzer.leetcode.editor.en.ListNode;

public class LeetCode_206_ReverseLinkedList {

    class Solution {
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode last = reverseList(head.next);
            head.next.next = head;
            head.next = null;
            return last;
        }
    }

    class Solution1 {
        public ListNode reverseList(ListNode head) {
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
