package org.crayzer.leetcode.editor.en.list;

public class Leet_206_ReverseLinkedList {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode prev = null;
            ListNode cur = head;
            ListNode tmp;

            while (cur != head) {
                tmp = cur.next;
                cur.next = prev;
                prev = cur;
                cur = tmp;
            }

            return prev;
        }
    }
}
