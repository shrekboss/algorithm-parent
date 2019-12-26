package org.crayzer.leetcode.editor.en.treez_recursion;

import java.util.Arrays;
import java.util.LinkedList;

public class LeetCode_297_SerializeAndDeserializeBinaryTree {

    class Solution {
        private final static String SEPARATOR = ",";
        private final static String NULL = "#";

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

        public TreeNode deserialize(String data) {
            return doDeserialize(new LinkedList<>(Arrays.asList(data.split(SEPARATOR))));
        }

        private TreeNode doDeserialize(LinkedList<String> dataList) {
            String val = dataList.remove();
            if (val.equals(NULL)) return null;
            else {
                TreeNode node = new TreeNode(Integer.parseInt(val));
                node.left = doDeserialize(dataList);
                node.right = doDeserialize(dataList);

                return node;
            }
        }
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }

}
