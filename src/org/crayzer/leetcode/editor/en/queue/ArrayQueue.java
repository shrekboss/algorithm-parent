package org.crayzer.leetcode.editor.en.queue;

public class ArrayQueue {

    private String[] items;
    private int n = 0;
    private int head = 0;
    private int tail = 0;

    public ArrayQueue(int capacity) {
        items = new String[capacity];
        this.n = capacity;
    }

    public boolean enqueue(String item) {
        if (tail == n) return false;

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

        arrayQueue.dequeue();
        String ret = arrayQueue.dequeue();
        System.out.println(ret);

        for (int i = arrayQueue.head; i < arrayQueue.tail; i++) {
            System.out.print(arrayQueue.items[i] + " ");
        }
    }
}
