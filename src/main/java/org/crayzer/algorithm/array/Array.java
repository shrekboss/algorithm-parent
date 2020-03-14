package org.crayzer.algorithm.array;

/**
 * class_name: Array
 * package: org.crayzer.algorithm.array
 * describe:
 *      1) 数组的插入、删除、按照下标随机访问操作；
 *      2）数组中的数据是int类型的；
 **/
public class Array {

    public int[] data;
    private int size;

    public Array(int capacity) {
        this.data = new int[capacity];
        this.size = 0;
    }

    public int find(int index) {
        checkIndex(index);
        return data[index];
    }

    public boolean insert(int index, int value) {

        if (size == data.length) {
            System.out.println("数组已满");
            return false;
        }

        checkIndexForInsert(index);

        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }

        data[index] = value;
        size++;

        return true;
    }

    private int delete(int index) {
        checkIndex(index);

        if (size == 0) {
            System.out.println("数组已空");
            return -1;
        }

        int ret = find(index);
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }

        size--;
        data[size] = 0;

        return ret;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Array size %d, capacity %d \n", size, data.length));
        builder.append("[");

        for (int i = 0; i < data.length; i++) {
            builder.append(data[i]);
            if (i != data.length - 1) {
                builder.append(", ");
            }
        }

        builder.append("]");

        return builder.toString();
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("require index >= 0 and index < size");
        }
    }

    private void checkIndexForInsert(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("require index >= 0 and index <= size");
        }
    }

    public static void main(String[] args) {
        Array array = new Array(5);
        array.insert(0, 3);
        array.insert(0, 4);
        array.insert(1, 5);
        array.insert(3, 9);
        array.insert(3, 10);
        System.out.println(array.toString());
        System.out.println();

        System.out.println("Array#find?index=0:" + array.find(0));
        System.out.println("Array#find?index=3:" + array.find(3));
        System.out.println();

        System.out.println(array.toString());
        System.out.println("Array#delete?index=2:" + array.delete(2));
        System.out.println("Array#delete?index=3:" + array.delete(3));
        System.out.println(array.toString());
    }
}
