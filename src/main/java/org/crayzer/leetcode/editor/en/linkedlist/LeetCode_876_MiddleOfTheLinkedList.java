package org.crayzer.leetcode.editor.en.linkedlist;

import org.crayzer.leetcode.editor.en.ListNode;

public class LeetCode_876_MiddleOfTheLinkedList {

    class Solution {
        public ListNode middleNode(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;

            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }
    }

    class Solution1 {
        public ListNode middleNode(ListNode head) {
            if (head == null || head.next == null) return head;

            ListNode slow = head;
            ListNode fast = head;

            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            if (fast.next == null) return slow;
            else return slow.next;
        }
    }
}
