package org.crayzer.leetcode.editor.en.trie;

public class LeetCode_208_ImplementTrie {

    class TrieNode {
        private TrieNode[] links;
        private final int R = 26;
        private boolean isLeaf;

        public TrieNode() {
            this.links = new TrieNode[R];
        }

        public boolean containsKey(char ch) {
            return this.links[ch - 'a'] != null;
        }

        public void put(char ch, TrieNode node) {
            this.links[ch - 'a'] = node;
        }

        public TrieNode get(char ch) {
            return this.links[ch - 'a'];
        }

        public void setLeaf() {
            this.isLeaf = true;
        }

        public boolean isLeaf() {
            return this.isLeaf;
        }
    }

    class Trie {

        private TrieNode root;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            this.root = new TrieNode();
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char currentChar = word.charAt(i);
                if (!node.containsKey(currentChar)) node.put(currentChar, new TrieNode());
                node = node.get(currentChar);
            }
            node.setLeaf();
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            TrieNode node = searchPrefix(word);
            return node != null && node.isLeaf();
        }

        private TrieNode searchPrefix(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char currentChar = word.charAt(i);
                if (node.containsKey(currentChar)) node = node.get(currentChar);
                else return null;
            }
            return node;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            TrieNode node = root;
            for (int i = 0; i < prefix.length(); i++) {
                char currentChar = prefix.charAt(i);
                if (node.containsKey(currentChar)) node = node.get(currentChar);
                else return false;
            }
            return true;
        }
    }
/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
}

