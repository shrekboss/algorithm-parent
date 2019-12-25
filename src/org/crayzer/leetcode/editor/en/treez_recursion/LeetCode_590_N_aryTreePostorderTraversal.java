package org.crayzer.leetcode.editor.en.treez_recursion;

import java.util.LinkedList;
import java.util.List;

public class LeetCode_590_N_aryTreePostorderTraversal {

    class Solution2 {
        public List<Integer> postorder(Node root) {
            List<Integer> res = new LinkedList<>();
            LinkedList<Node> stack = new LinkedList<>();

            if (root == null) return res;

            stack.add(root);
            while (!stack.isEmpty()) {
                Node curr = stack.pollLast();
                ((LinkedList<Integer>) res).addFirst(curr.val);

                stack.addAll(curr.children);
            }

            return res;
        }
    }

    class Solution1 {
        private List<Integer> res = new LinkedList<>();

        public List<Integer> postorder(Node root) {
            return doPostorder(root);
        }

        private List<Integer> doPostorder(Node root) {
            if (root == null) return res;

            for (Node n : root.children) {
                doPostorder(n);
            }
            res.add(root.val);

            return res;
        }
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
