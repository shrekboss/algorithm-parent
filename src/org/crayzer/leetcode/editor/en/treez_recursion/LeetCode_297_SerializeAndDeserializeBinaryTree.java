package org.crayzer.leetcode.editor.en.treez_recursion;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LeetCode_297_SerializeAndDeserializeBinaryTree {

    public class Codec {

        private final static String SEPARATOR = ",";
        private final static String NULL = "#";

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            return doSerialize(root, new StringBuilder()).toString();
        }

        private StringBuilder doSerialize(TreeNode root, StringBuilder builder) {
            if (root == null) builder.append(NULL).append(SEPARATOR);
            else {
                builder.append(root.val).append(SEPARATOR);
                doSerialize(root.left, builder);
                doSerialize(root.right, builder);
            }

            return builder;
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            return doDeserialize(new LinkedList<>(Arrays.asList(data.split(SEPARATOR))));
        }

        private TreeNode doDeserialize(Queue<String> dataList) {
            /* 队列 remove 头出 */
            String root = dataList.remove();
            if (root.equals(NULL)) return null;
            else {
                TreeNode node = new TreeNode(Integer.parseInt(root));
                node.left = doDeserialize(dataList);
                node.right = doDeserialize(dataList);

                return node;
            }
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
