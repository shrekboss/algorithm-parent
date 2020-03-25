package org.crayzer.leetcode.editor.en.list;

import org.crayzer.leetcode.editor.en.ListNode;

public class LeetCode_160_相交链表 {
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if (headA == null || headB == null) return null;
            ListNode pA = headA, pB = headB;
            while (pA != pB) {
                pA = pA == null ? headB : pA.next;
                pB = pB == null ? headA : pB.next;
            }
            return pA;
        }
    }
}
