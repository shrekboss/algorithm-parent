package org.crayzer.algo.template.java;

public class TrieTemplate {
    class TrieNode {
        public TrieNode[] links;
        public boolean isLeaf;
        public final int R = 26;

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
            return links[ch - 'a'];
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
            for (char ch : word.toCharArray()) {
                if (!node.containsKey(ch)) node.put(ch, new TrieNode());
                node = node.get(ch);
            }
            node.isLeaf = true;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            TrieNode node = searchPrefix(word);
            return node != null && node.isLeaf;
        }

        private TrieNode searchPrefix(String word) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                if (node.containsKey(ch)) node = node.get(ch);
                else return null;
            }
            return node;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            TrieNode node = root;
            for (char ch : prefix.toCharArray()) {
                if (node.containsKey(ch)) node = node.get(ch);
                else return false;
            }
            return true;
        }
    }
}
