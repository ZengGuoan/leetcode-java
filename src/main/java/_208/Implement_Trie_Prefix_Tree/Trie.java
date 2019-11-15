package _208.Implement_Trie_Prefix_Tree;

public class Trie {
    private TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode node = root;
        int charIndex;
        for (int i = 0; i < word.length(); i++) {
            charIndex = word.charAt(i) - 'a';
            if (node.childrens[charIndex] == null) {
                node.childrens[charIndex] = new TrieNode();
            }
            node = node.childrens[charIndex];
        }
        node.endOfWord = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            node = node.childrens[word.charAt(i) - 'a'];
            if (node == null) {
                return false;
            }
        }
        return node.endOfWord;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            node = node.childrens[prefix.charAt(i) - 'a'];
            if (node == null) {
                return false;
            }
        }
        return true;
    }

    private class TrieNode {
        // index代表路径值
        public TrieNode[] childrens = new TrieNode[26];
        // 到当前节点，之前的路径能否组成一个完整的代词
        public boolean endOfWord;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
