package org.crayzer.leetcode.editor.en.list;

import org.crayzer.leetcode.editor.en.ListNode;

/**
 * class_name: LeetCode_143_ReorderList
 * package: org.crayzer.leetcode.editor.en.list
 * describe:
 * <p>
 * 首先重新排列后，链表的中心节点会变为最后一个节点。所以需要先找到链表的中心节点：876. 链表的中间结点
 * 可以按照中心节点将原始链表划分为左右两个链表。
 * 2.1. 按照中心节点将原始链表划分为左右两个链表，左链表：1->2->3 右链表：4->5。
 * 2.2. 将右链表反转，就正好是重排链表交换的顺序，右链表反转：5->4。反转链表：206. 反转链表
 * 合并两个链表，将右链表插入到左链表，即可重新排列成：1->5->2->4->3.
 **/
public class LeetCode_143_ReorderList {
    class Solution {
        public void reorderList(ListNode head) {
            if (head == null) return;

            ListNode middleNode = middleNode(head);
            ListNode left = head;
            ListNode right = middleNode.next;
            middleNode.next = null;
            right = reverse(right);
            merge(left, right);
        }

        private void merge(ListNode left, ListNode right) {
            ListNode leftTemp;
            ListNode rightTemp;

            while (left != null && right != null) {
                leftTemp = left.next;
                rightTemp = right.next;

                left.next = right;
                right.next = leftTemp;

                left = leftTemp;
                right = rightTemp;
            }
        }

        private ListNode reverse(ListNode head) {
            if (head == null || head.next == null) return head;
            ListNode cur = reverse(head.next);
            head.next.next = head;
            head.next = null;

            return cur;
        }

        private ListNode middleNode(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;

            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }
    }
}
