package leetcode.editor.cn;

public class ImplementTriePrefixTree {
    public static void main(String[] args) {
        Solution solution = new ImplementTriePrefixTree().new Solution();
        //TODO Test
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Trie {
        private class Node {
            Character c;
            Node[] nodes;
            int count;
            Node() {
                c = null;
                count = 0;
                nodes = new Node[26];
            }
            Node(Character c) {
                this();
                this.c = c;
            }
        }

        private Node rootNode;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            rootNode = new Node();
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            Node indexNode = rootNode;
            for (int i = 0; i < word.length(); i++) {
                if (indexNode.nodes[word.charAt(i) - 'a'] == null) {
                    indexNode.nodes[word.charAt(i) - 'a'] = new Node(word.charAt(i));
                }
                indexNode = indexNode.nodes[word.charAt(i) - 'a'];
            }
            indexNode.count ++;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            Node indexNode = rootNode;
            for (int i = 0; i < word.length(); i++) {
                if (indexNode.nodes[word.charAt(i) - 'a'] == null) return false;
                indexNode = indexNode.nodes[word.charAt(i) - 'a'];
            }
            return indexNode.count > 0;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            Node indexNode = rootNode;
            for (int i = 0; i < prefix.length(); i++) {
                if (indexNode.nodes[prefix.charAt(i) - 'a'] == null) return false;
                indexNode = indexNode.nodes[prefix.charAt(i) - 'a'];
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
//leetcode submit region end(Prohibit modification and deletion)


}