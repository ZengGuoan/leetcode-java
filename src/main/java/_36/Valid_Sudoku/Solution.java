package _36.Valid_Sudoku;

public class Solution {
    private int targetN = 9;// 大宫格的n
    private int blockN = 3; // 小宫格的n
    private boolean[][] columnNumExist; // 列序号-数字:是否存在
    private boolean[][] rowNumExist;    // 行序号-数字：是否存在
    private boolean[][][] blockNumExist;  // 第几个3*3宫-数字：是否存在

    /**
     * 给定数独序列只包含数字 1-9 和字符 '.' 。
     * 给定数独永远是 9x9 形式的。
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        columnNumExist = new boolean[targetN][targetN];
        rowNumExist = new boolean[targetN][targetN];
        blockNumExist = new boolean[blockN][blockN][targetN];
        for (int i = 0; i < targetN; i++) {
            for (int j = 0; j < targetN; j++) {
                // '.'不需要进行判断
                if ('.' == board[i][j]) {
                    continue;
                }
                // board[i][j] - '0' - 1 => 将字符转化为数字1-9，然后再-1，存储数字0-8
                if (curValid(i, j, board[i][j] - '0' - 1)) {
                    recordNum(i, j, board[i][j] - '0' - 1);
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 判断当前值在这个坐标上是否满足
     * @param row 行
     * @param column 列
     * @param num 数字
     * @return
     */
    private boolean curValid(int row, int column, int num) {
        // 行是否已经包括
        if (rowNumExist[row][num]) {
            return false;
        }
        // 列是否已经包括
        if (columnNumExist[column][num]) {
            return false;
        }
        // 3*3宫格是否已经包括
        if (blockNumExist[row / 3][column / 3][num]) {
            return false;
        }
        return true;
    }

    /**
     * 记录当前坐标的值
     * @param row 行
     * @param column 列
     * @param num 数字
     * @return
     */
    private void recordNum(int row, int column, int num) {
        rowNumExist[row][num] = true;
        columnNumExist[column][num] = true;
        blockNumExist[row / 3][column / 3][num] = true;
    }
}
