package org.crayzer.leetcode.editor.en.linkedlist;

public class LeetCode_622_DesignCircularQueue {
    class MyCircularQueue {

        private int[] arr;
        private int capacity;
        private int front, rear;

        /**
         * Initialize your data structure here. Set the size of the queue to be k.
         */
        public MyCircularQueue(int k) {
            this.capacity = k + 1;
            this.arr = new int[capacity];
            this.front = 0;
            this.rear = 0;
        }

        /**
         * Insert an element into the circular queue. Return true if the operation is successful.
         */
        public boolean enQueue(int value) {
            if (isFull()) return false;
            this.arr[rear] = value;
            this.rear = (rear + 1) % capacity;
            return true;
        }

        /**
         * Delete an element from the circular queue. Return true if the operation is successful.
         */
        public boolean deQueue() {
            if (isEmpty()) return false;
            front = (front + 1) % capacity;
            return true;
        }

        /**
         * Get the front item from the queue.
         */
        public int Front() {
            if (isEmpty()) return -1;
            return this.arr[front];
        }

        /**
         * Get the last item from the queue.
         */
        public int Rear() {
            if (isEmpty()) return -1;
            return this.arr[(rear - 1 + capacity) % capacity];
        }

        /**
         * Checks whether the circular queue is empty or not.
         */
        public boolean isEmpty() {
            return front == rear;
        }

        /**
         * Checks whether the circular queue is full or not.
         */
        public boolean isFull() {
            return (rear + 1) % capacity == front;
        }
    }

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
}
