package org.crayzer.leetcode.editor.en.deque;

public class ArrayQueue {
    private String[] items;
    private int n;
    private int head = 0;
    private int tail = 0;

    public ArrayQueue(int capacity) {
        items = new String[capacity];
        this.n = capacity;
    }

    public boolean enqueue(String item) {
        if (tail == n) {
            if (head == 0) return false;

            for (int i = head; i < tail; i++) {
                items[i - head] = items[i];
            }

            tail -= head;
            head = 0;
        }

        items[tail++] = item;
        return true;
    }

    public String dequeue() {
        if (head == tail) return null;
        return items[head++];
    }


    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(5);
        arrayQueue.enqueue("1");
        arrayQueue.enqueue("2");
        arrayQueue.enqueue("3");
        arrayQueue.enqueue("4");
        arrayQueue.enqueue("5");

        arrayQueue.dequeue();
        String ret = arrayQueue.dequeue();
        System.out.println(ret);

        arrayQueue.enqueue("1");
        arrayQueue.enqueue("6");

        for (int i = arrayQueue.head; i < arrayQueue.tail; i++) {
            System.out.print(arrayQueue.items[i] + " ");
        }

        arrayQueue.enqueue("0");
    }
}
