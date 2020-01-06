package org.crayzer.leetcode.editor.en.list;

import org.crayzer.leetcode.editor.en.ListNode;

public class LeetCode_876_MiddleOfTheLinkedList {
    class Solution {
        public ListNode middleNode(ListNode head) {
            ListNode p = head;
            ListNode q = head;

            while (p.next != null && p.next.next != null) {
                q = q.next;
                p = p.next.next;
            }

            if (p.next == null) return q;
            else return q.next;
        }
    }
}
