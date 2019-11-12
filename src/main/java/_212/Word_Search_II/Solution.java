package _212.Word_Search_II;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    private char[][] board;
    private TrieNdoe root = new TrieNdoe();
    private Set<String> result = new HashSet<>();
    private int[][] dir = { // 上下左右
            {0, 1}, {0, -1}, {1, 0}, {-1, 0}
    };
    private boolean[][] used;

    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
        this.used = new boolean[board.length][board[0].length];
        for (String word : words) {
            insert(word);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                findWord(i, j, root);
            }
        }
        return new ArrayList<>(result);
    }

    /**
     * DFS深度优先搜索
     *
     * @param row
     * @param column
     * @param node
     */
    private void findWord(int row, int column, TrieNdoe node) {
        char ch = board[row][column];
        int chIndex = ch - 'a';
        // 没找到 或者 已经使用过了
        if (node.nextNode[chIndex] == null || used[row][column]) {
            return;
        }
        // 如果找到一个word就记录下来
        if (node.nextNode[chIndex].endOfWord) {
            result.add(node.nextNode[chIndex].word);
        }
        // 记录当前位置已经使用过了
        used[row][column] = true;
        // 上下左右深度搜索
        for (int[] d : dir) {
            if (row + d[0] < 0 || row + d[0] >= board.length || column + d[1] < 0 || column + d[1] >= board[0].length) {
                continue;
            }
            findWord(row + d[0], column + d[1], node.nextNode[chIndex]);
        }
        // 回溯，将当前位置置为未使用过
        used[row][column] = false;
    }

    /**
     * 构建字典树
     */
    private void insert(String word) {
        TrieNdoe node = root;
        int chIndex;
        for (int i = 0; i < word.length(); i++) {
            chIndex = word.charAt(i) - 'a';
            if (node.nextNode[chIndex] == null) {
                node.nextNode[chIndex] = new TrieNdoe();
            }
            node = node.nextNode[chIndex];
        }
        node.endOfWord = true;
        node.word = word;
    }

    private class TrieNdoe {
        // 假设所有输入都由小写字母 a-z 组成
        public TrieNdoe[] nextNode = new TrieNdoe['z' - 'a' + 1];
        // 如果是最后的节点，才存
        public String word;
        public boolean endOfWord;
    }

    public static void main(String[] args) {
        char[][] board = {{'a', 'b'}};
        new Solution().findWords(board, new String[]{"ba"});
    }
}
