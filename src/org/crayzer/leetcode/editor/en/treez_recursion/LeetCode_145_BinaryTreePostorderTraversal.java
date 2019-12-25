package org.crayzer.leetcode.editor.en.treez_recursion;

import java.util.*;

public class LeetCode_145_BinaryTreePostorderTraversal {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    class Solution5 {
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> res = new LinkedList<>();
            Stack<TreeNode> stack = new Stack<>();

            if (root == null) return res;
            stack.push(root);

            while (!stack.isEmpty()) {
                TreeNode cur = stack.pop();
                res.add(cur.val);

                if (cur.left != null) stack.push(cur.left);
                if (cur.right != null) stack.push(cur.right);
            }
            Collections.reverse(res);
            return res;
        }
    }

    class Solution4 {
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> res = new LinkedList<>();
            Stack<TreeNode> stack = new Stack<>();

            TreeNode cur = root;
            TreeNode last = null;

            while (cur != null || !stack.isEmpty()) {
                if (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                } else {
                    TreeNode temp = stack.peek();
                    if (temp.right != null && temp.right != last) {
                        cur = temp.right;
                    } else {
                        res.add(temp.val);
                        last = temp;
                        stack.pop();
                    }
                }
            }
            return res;
        }
    }

    class Solution3 {
        public List<Integer> postorderTraversal(TreeNode root) {
            LinkedList<Integer> res = new LinkedList<>();
            LinkedList<TreeNode> stack = new LinkedList<>();

            if (root == null) return res;
            stack.addLast(root);
            while (!stack.isEmpty()) {
                TreeNode cur = stack.pollLast();
                res.addFirst(cur.val);

                if (cur.left != null) stack.addLast(cur.left);
                if (cur.right != null) stack.addLast(cur.right);
            }
            return res;
        }
    }

    /**
     * 反人类，但是理解之后感觉很爽@！
     */
    class Solution2 {
        public List<Integer> postorderTraversal(TreeNode root) {
            LinkedList<Integer> res = new LinkedList<>();
            LinkedList<TreeNode> stack = new LinkedList<>();
            Set<TreeNode> set = new HashSet<>();

            TreeNode curr = root;
            while (curr != null && !stack.isEmpty()) {
                while (curr != null || !set.contains(curr)) {
                    stack.addLast(curr);
                    curr = curr.left;
                }

                curr = stack.getLast();
                if (curr.right == null || set.contains(curr)) {
                    res.addLast(curr.val);
                    set.add(curr);
                    stack.pollLast();

                    if (stack.isEmpty()) return res;
                    curr = stack.getLast();
                    curr = curr.right;
                } else {
                    set.add(curr);
                    curr = curr.right;
                }
            }

            return res;
        }
    }

    /**
     * 递归，必须掌握
     */
    class Solution1 {
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> res = new LinkedList<>();
            doPostorderTraversal(root, res);
            return res;
        }

        private void doPostorderTraversal(TreeNode root, List<Integer> res) {
            if (root == null) return;

            doPostorderTraversal(root.left, res);
            doPostorderTraversal(root.right, res);
            res.add(root.val);
        }
    }
}
