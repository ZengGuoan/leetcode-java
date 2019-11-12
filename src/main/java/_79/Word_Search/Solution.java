package _79.Word_Search;

public class Solution {
    private char[][] board;
    private boolean[][] used; // 记录哪些格子已经使用过
    private String word;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        if (word == null || word.length() == 0) {
            return false;
        }
        used = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != word.charAt(0)) {
                    continue;
                }
                // 寻找到单词第一个字母在board中的位置
                // 可能找到多个，但是只要有一个满足就结束
                if (exist(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * DFS深度搜索是否存在
     *
     * @param row
     * @param column
     * @param charIndex
     * @return
     */
    private boolean exist(int row, int column, int charIndex) {
        // 判断是否被使用过
        if (used[row][column]) {
            return false;
        }
        // 当前字符满足，且是最后一个字符
        if (board[row][column] == word.charAt(charIndex) && charIndex == word.length() - 1) {
            return true;
        }
        // 当前字符不匹配
        if (board[row][column] != word.charAt(charIndex)) {
            return false;
        }
        // 当前空格被使用
        used[row][column] = true;
        // 向右方向
        if (column + 1 < board[0].length && exist(row, column + 1, charIndex + 1)) {
            return true;
        }
        // 向左方向
        if (column - 1 >= 0 && exist(row, column - 1, charIndex + 1)) {
            return true;
        }
        // 向下
        if (row + 1 < board.length && exist(row + 1, column, charIndex + 1)) {
            return true;
        }
        // 向上
        if (row - 1 >= 0 && exist(row - 1, column, charIndex + 1)) {
            return true;
        }
        // 回溯，当前空格置为未使用
        used[row][column] = false;
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'a', 'a'}
        };
        new Solution().exist(board, "aa");
    }
}
