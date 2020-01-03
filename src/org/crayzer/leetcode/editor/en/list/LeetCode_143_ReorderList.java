package org.crayzer.leetcode.editor.en.list;

/**
 * class_name: LeetCode_143_ReorderList
 * package: org.crayzer.leetcode.editor.en.list
 * describe:
 * <p>
 *      首先重新排列后，链表的中心节点会变为最后一个节点。所以需要先找到链表的中心节点：876. 链表的中间结点
 *      可以按照中心节点将原始链表划分为左右两个链表。
 *      2.1. 按照中心节点将原始链表划分为左右两个链表，左链表：1->2->3 右链表：4->5。
 *      2.2. 将右链表反转，就正好是重排链表交换的顺序，右链表反转：5->4。反转链表：206. 反转链表
 *      合并两个链表，将右链表插入到左链表，即可重新排列成：1->5->2->4->3.
 **/
public class LeetCode_143_ReorderList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public void reorderList(ListNode head) {
            if (head == null) return;

            ListNode middleNode = middleNode(head);

            ListNode left = head;
            ListNode right = middleNode.next;
            middleNode.next = null;

            right = reverseLinkedList(right);
            merge(left, right);
        }

        private void merge(ListNode left, ListNode right) {
            ListNode leftTemp;
            ListNode rightTemp;

            while (left.next != null && right != null) {
                leftTemp = left.next;
                rightTemp = right.next;

                left.next = right;
                right.next = leftTemp;

                left = leftTemp;
                right = rightTemp;
            }
        }

        private ListNode reverseLinkedList(ListNode right) {
            ListNode prev = null;
            ListNode curr = right;
            ListNode temp;

            while (curr != null) {
                temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }

            return prev;
        }

        private ListNode middleNode(ListNode head) {
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
