package org.crayzer.leetcode.editor.en.queue;


// 用数组实现的队列
public class ArrayQueue {
    private String[] items;
    private int size = 0;
    // head表示队头下标，tail表示队尾下标
    private int head = 0;
    private int tail = 0;

    // 申请一个大小为capacity的数组
    public ArrayQueue(int capacity) {
        items = new String[capacity];
        size = capacity;
    }

    // 入队
    public boolean enqueue(String item) {
        // 如果tail == size 表示队列已经满了
        if (tail == size) return false;
        items[tail] = item;
        ++tail;
        return true;
    }

    // 出队
    public String dequeue() {
        // 如果head == tail 表示队列为空
        if (head == tail) return null;
        // 为了让其他语言的同学看的更加明确，把--操作放到单独一行来写了
        String ret = items[head];
        ++head;
        return ret;
    }

    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(5);
        arrayQueue.enqueue("1");
        arrayQueue.enqueue("2");
        arrayQueue.enqueue("3");

        arrayQueue.dequeue();

        for (int i = arrayQueue.head; i < arrayQueue.tail; i++) {
            System.out.print(arrayQueue.items[i] + " ");
        }
    }
}
