package org.crayzer.leetcode.editor.en.linkedlist;

import org.crayzer.leetcode.editor.en.ListNode;

public class LeetCode_23_MergeKSortedLists {
    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            int len = lists.length;
            if (len == 0) return null;
            return mergeKLists(lists, 0, len - 1);
        }

        private ListNode mergeKLists(ListNode[] lists, int left, int right) {
            if (left == right) return lists[left];
            int mid = (left + right) >>> 1;
            ListNode l1 = mergeKLists(lists, left, mid);
            ListNode l2 = mergeKLists(lists, mid + 1, right);
            return mergeTwoSortedLists(l1, l2);
        }

        private ListNode mergeTwoSortedLists(ListNode l1, ListNode l2) {
            if (l1 == null) return l2;
            if (l2 == null) return l1;
            if (l1.val < l2.val) {
                l1.next = mergeTwoSortedLists(l1.next, l2);
                return l1;
            } else {
                l2.next = mergeTwoSortedLists(l1, l2.next);
                return l2;
            }
        }
    }

    class Solution2 {
        public ListNode mergeKLists(ListNode[] lists) {
            int len = lists.length;
            if (len == 0) return null;

            ListNode res = lists[0];
            for (int i = 1; i < len; i++) {
                if (lists != null) {
                    res = mergeTwoSortedLists(res, lists[i]);
                }
            }
            return res;
        }

        private ListNode mergeTwoSortedLists(ListNode l1, ListNode l2) {
            ListNode soldier = new ListNode(0);
            ListNode p = soldier;

            while (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    p.next = l1;
                    l1 = l1.next;
                } else {
                    p.next = l2;
                    l2 = l2.next;
                }
                p = p.next;
            }
            if (l1 != null) p.next = l1;
            if (l2 != null) p.next = l2;
            return soldier.next;
        }
    }
}
