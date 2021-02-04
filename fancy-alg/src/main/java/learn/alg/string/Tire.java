package learn.alg.string;

/**
 * 单词查找树 (都是小写字符)
 */
public class Tire {

    private TrieNode root;

    public Tire() {
        this.root = new TrieNode();
    }

    /**
     * 插入
     * @param word
     */
    private void insert(String word) {
        if (word == null || word.isEmpty()) {
            return;
        }
        TrieNode node = root;
        // 每次都经过根节点
        node.path++;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.map[index]  == null) {
                node.map[index] = new TrieNode();
            }
            node = node.map[index];
            node.path++;
        }
        node.end++;
    }

    /**
     * 删除一个节点
     */
    private void delete(String word) {
        if (word == null || word.isEmpty()) {
            return;
        }
        if (!search(word)) {
            return;
        }
        TrieNode node = root;
        node.path--;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (node.map[idx].path-- == 1) {
                node.map[idx] = null;
                return;
            } else {
                node = node.map[idx];
            }
        }
        node.end--;
    }

    private boolean search(String word) {
        if (word == null || word.isEmpty()) {
            return false;
        }
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            node = node.map[idx];
            if (node == null) {
                return false;
            }
        }
        return node.end != 0;
    }

    private int prefixNumber(String prefix) {
        TrieNode node = root;
        int idx;
        for (char c : prefix.toCharArray()) {
            idx = c - 'a';
            node = node.map[idx];
            if (node == null) {
                return 0;
            }
        }
        return node.path;
    }

    private static class TrieNode {
        /**
         * 有path个单词经过了这个节点
         */
        private int path;

        /**
         * 有end个单词以这个节点结尾
         */
        private int end;

        /**
         * 下一个节点
         */
        private TrieNode[] map;

        TrieNode() {
            this.path = 0;
            this.end = 0;
            this.map = new TrieNode[26];
        }
    }
}
