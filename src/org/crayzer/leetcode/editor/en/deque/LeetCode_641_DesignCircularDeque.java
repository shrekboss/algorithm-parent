package org.crayzer.leetcode.editor.en.deque;

/**
 * describe: 设计循环双端队列
 *
 * MyCircularDeque(k)：构造函数,双端队列的大小为k。
 * insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true。
 * insertLast()：将一个元素添加到双端队列尾部。如果操作成功返回 true。
 * deleteFront()：从双端队列头部删除一个元素。 如果操作成功返回 true。
 * deleteLast()：从双端队列尾部删除一个元素。如果操作成功返回 true。
 * getFront()：从双端队列头部获得一个元素。如果双端队列为空，返回 -1。
 * getRear()：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1。
 * isEmpty()：检查双端队列是否为空。
 * isFull()：检查双端队列是否满了。
 **/
public class LeetCode_641_DesignCircularDeque {

    class DoubleListNode {
        DoubleListNode pre;
        DoubleListNode next;
        int val;
        public DoubleListNode(int val) {
            this.val = val;
        }
    }

    class MyCircularDeque {
        private int size;
        private int k;

        private DoubleListNode head;
        private DoubleListNode tail;

        /**
         * Initialize your data structure here. Set the size of the deque to be k.
         */
        public MyCircularDeque(int k) {
            this.head = new DoubleListNode(-1);
            this.tail = new DoubleListNode(-1);
            head.pre = tail;
            tail.next = head;
            this.k = k;
            this.size = 0;
        }

        /**
         * Adds an item at the front of Deque. Return true if the operation is successful.
         */
        public boolean insertFront(int value) {
            if (k == size) return false;

            DoubleListNode node = new DoubleListNode(value);
            node.next = head;
            node.pre = head.pre;
            head.pre.next = node;
            head.pre = node;
            size++;
            return true;
        }

        /**
         * Adds an item at the rear of Deque. Return true if the operation is successful.
         */
        public boolean insertLast(int value) {
            if ( k == size) return false;

            DoubleListNode node = new DoubleListNode(value);
            node.pre = tail;
            node.next = tail.next;
            tail.next.pre = node;
            tail.next = node;
            size++;
            return true;
        }

        /**
         * Deletes an item from the front of Deque. Return true if the operation is successful.
         */
        public boolean deleteFront() {
            if (size == 0) return false;

            head.pre.pre.next = head;
            head.pre = head.pre.pre;
            size--;
            return true;
        }

        /**
         * Deletes an item from the rear of Deque. Return true if the operation is successful.
         */
        public boolean deleteLast() {
            return false;
        }

        /**
         * Get the front item from the deque.
         */
        public int getFront() {
            return 0;
        }

        /**
         * Get the last item from the deque.
         */
        public int getRear() {
            return 0;
        }

        /**
         * Checks whether the circular deque is empty or not.
         */
        public boolean isEmpty() {
            return false;
        }

        /**
         * Checks whether the circular deque is full or not.
         */
        public boolean isFull() {
            return false;
        }
    }

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
}
