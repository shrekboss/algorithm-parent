package org.crayzer.algorithm.array;

import java.util.HashMap;
import java.util.Map;

/**
 * class_name: LRUBasedArray
 * package: org.crayzer.algorithm.array
 * describe: 基于数组实现的LRU缓存
 * 1. 空间复杂度为O(n)
 * 2. 时间复杂度为O(n)
 * 3. 不支持null的缓存
 **/
public class LRUBasedArray<T> {

    private Map<T, Integer> holder;

    private static final int DEFAULT_CAPACITY = (1 << 3);

    private int capacity;
    private int count;
    private T[] value;

    public LRUBasedArray() {
        this(DEFAULT_CAPACITY);
    }

    public LRUBasedArray(int capacity) {
        this.capacity = capacity;
        this.value = (T[]) new Object[capacity];
        this.count = 0;
        holder = new HashMap<>(capacity);
    }

    public void offer(T object) {
        if (null == object) {
            throw new IllegalArgumentException("缓存容器不支持null!");
        }

        Integer index = holder.get(object);

        if (index == null) {
            if (isFull()) {
                removeAndCache(object);
            } else {
                cache(object, count);
            }
        } else {
            update(index);
        }
    }

    public void update(int end) {
        T target = value[end];
        rightShift(end);
        value[0] = target;
        holder.put(target, 0);
    }

    public void cache(T target, int end) {
        rightShift(end);
        value[0] = target;
        holder.put(target, 0);
        count++;
    }

    public void removeAndCache(T object) {
        T key = value[--count];
        holder.remove(key);
        cache(object, count);
    }

    private void rightShift(int end) {
        for (int i = end - 1; i >= 0; i--) {
            value[i + 1] = value[i];
            holder.put(value[i], i + 1);
        }
    }

    private boolean isFull() {
        return count == capacity;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(value[i]);
            sb.append(" ");
        }
        return sb.toString();
    }

    static class TestLRUBasedArray {

        public static void main(String[] args) {
            // testDefaultConstructor();
            // testSpecifiedConstructor(4);
            testWithException();
        }

        private static void testWithException() {
            LRUBasedArray<Integer> lru = new LRUBasedArray<Integer>();
            lru.offer(1);
            lru.offer(null);
            lru.offer(2);
            lru.offer(null);
            System.out.println(lru);
        }

        public static void testDefaultConstructor() {
            System.out.println("======无参测试========");
            LRUBasedArray<Integer> lru = new LRUBasedArray<Integer>();
            lru.offer(1);
            lru.offer(2);
            lru.offer(3);
            lru.offer(4);
            lru.offer(5);
            System.out.println(lru);
            lru.offer(6);
            lru.offer(7);
            lru.offer(8);
            lru.offer(9);
            System.out.println(lru);
        }

        public static void testSpecifiedConstructor(int capacity) {
            System.out.println("======有参测试========");
            LRUBasedArray<Integer> lru = new LRUBasedArray<Integer>(capacity);
            lru.offer(1);
            System.out.println(lru);
            lru.offer(2);
            System.out.println(lru);
            lru.offer(3);
            System.out.println(lru);
            lru.offer(4);
            System.out.println(lru);
            lru.offer(2);
            System.out.println(lru);
            lru.offer(4);
            System.out.println(lru);
            lru.offer(7);
            System.out.println(lru);
            lru.offer(1);
            System.out.println(lru);
            lru.offer(2);
            System.out.println(lru);
        }
    }
}
