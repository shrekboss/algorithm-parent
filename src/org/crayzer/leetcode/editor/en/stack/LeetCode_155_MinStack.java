package org.crayzer.leetcode.editor.en.stack;

import java.util.Stack;

public class LeetCode_155_MinStack {

    class MinStack2 {

        private Stack<Integer> data;
        private Stack<Integer> helper;

        public MinStack2() {
            this.data = new Stack<>();
            this.helper = new Stack<>();
        }

        public void push(int x) {
            data.add(x);

            if (helper.isEmpty() || helper.peek() >= x) {
                helper.add(x);
            }
        }

        public void pop() {
            if (!data.isEmpty()) {
                int top = data.pop();
                if (top == helper.peek()) {
                    helper.pop();
                }
            }
        }

        public int top() {
            if (!data.isEmpty()) {
                return data.peek();
            }

            throw new RuntimeException("非法操作");
        }

        public int getMin() {
            if (!helper.isEmpty()) {
                return helper.peek();
            }

            throw new RuntimeException("非法操作");
        }
    }


    /**
    * class_name: LeetCode_155_MinStack
    * package: org.crayzer.leetcode.editor.en.stack
    * describe: 数据栈和辅助栈同步
    **/
    class MinStack1 {

        private Stack<Integer> data;
        private Stack<Integer> helper;

        /** initialize your data structure here. */
        public MinStack1() {
            this.data = new Stack<>();
            this.helper = new Stack<>();
        }

        public void push(int x) {
            data.add(x);

            if (helper.isEmpty() || helper.peek() >= x) {
                helper.add(x);
            } else {
                helper.add(helper.peek());
            }
        }

        public void pop() {
            if (!data.isEmpty()) {
                data.pop();
                helper.pop();
            }
        }

        public int top() {
            if (!data.isEmpty()) {
                return data.peek();
            }

            throw new RuntimeException("非法操作");
        }

        public int getMin() {
            if (!helper.isEmpty()) {
                return helper.peek();
            }

            throw new RuntimeException("非法操作");
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

}
