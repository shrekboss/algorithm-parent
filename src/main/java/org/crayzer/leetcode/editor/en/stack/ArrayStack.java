package org.crayzer.leetcode.editor.en.stack;

public class ArrayStack {
    private String[] items;
    private int n;
    private int count;

    public ArrayStack(int n) {
        this.items = new String[n];
        this.n = n;
        this.count = 0;
    }

    public boolean push(String item) {
        if (count == n) return false;

        items[count++] = item;
        return true;
    }

    public String pop() {
        if (count == 0) return null;
        String rtn = items[count - 1];
        count--;
        return rtn;
    }
}
