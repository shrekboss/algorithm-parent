package org.crayzer.leetcode.editor.en.list;

import org.crayzer.leetcode.editor.en.ListNode;

public class LeetCode_24_SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        ListNode soldier = new ListNode(0);
        soldier.next = head;
        ListNode tmp = soldier;

        while (tmp.next != null && tmp.next.next != null) {
            ListNode start = tmp.next;
            ListNode end = tmp.next.next;
            tmp.next = end;
            start.next = end.next;
            end.next = start;
            tmp = start;
        }

        return soldier.next;
    }
}
