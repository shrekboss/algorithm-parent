package org.crayzer.leetcode.editor.en.队列;

public class CircularQueue {

    private String[] items;
    private int n;
    private int head;
    private int tail;

    public CircularQueue(int capacity) {
        items = new String[capacity];
        this.n = capacity;
    }

    public boolean enqueue(String item) {
        /** 队列满了 */
        if ((tail + 1) % n == head) return false;

        items[tail] = item;
        tail = (tail + 1) % n;

        return true;
    }

    public String dequeue() {
        /** 如果head == tail 表示队列为空 */
        if (head == tail) return null;

        String rtn = items[head];
        head = (head + 1) % n;

        return rtn;
    }
}
