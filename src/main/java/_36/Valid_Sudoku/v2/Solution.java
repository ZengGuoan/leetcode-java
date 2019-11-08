package _36.Valid_Sudoku.v2;

public class Solution {
    private int targetN = 9;// 大宫格的n
    private int blockN = 3; // 小宫格的n
    private int curRowBit; // 用一个数字表示当前行的情况，相当于 010100000 9个比特位表示，1表示已经选过
    private int[] columnBit;
    private int[] blockBit;

    /**
     * 给定数独序列只包含数字 1-9 和字符 '.' 。
     * 给定数独永远是 9x9 形式的。
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        columnBit = new int[targetN];
        blockBit = new int[targetN];
        for (int i = 0; i < targetN; i++) {
            curRowBit = 0; // 存储当前行的bit位数
            for (int j = 0; j < targetN; j++) {
                // '.'不需要进行判断
                if ('.' == board[i][j]) {
                    continue;
                }
                // board[i][j] - '0' - 1 => 将字符转化为数字1-9，然后再-1，存储数字0-8
                if (!curValid(i, j, board[i][j] - '1')) {
                    return false;
                }
                recordNum(i, j, board[i][j] - '1');
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
        if ((curRowBit >> num) % 2 == 1) {
            return false;
        }
        // 列是否已经包括
        if ((columnBit[column] >> num) % 2 == 1) {
            return false;
        }
        // 3*3宫格是否已经包括
        int cnt = row / blockN * blockN + column / blockN;
        if ((blockBit[cnt] >> num) % 2 == 1) {
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
        curRowBit += 1 << num;
        columnBit[column] += 1 << num;
        int cnt = row / blockN * blockN + column / blockN;
        blockBit[cnt] += 1 << num;
    }
}

