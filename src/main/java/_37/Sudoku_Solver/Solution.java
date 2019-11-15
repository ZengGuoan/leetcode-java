package _37.Sudoku_Solver;

public class Solution {
    private final char WAIT = '.';
    private int targetN = 9;
    private int blockN = 3;
    private char[][] board;
    private int[] rowBit = new int[targetN];
    private int[] columnBit = new int[targetN];
    private int[] blockBit = new int[targetN];

    /**
     * 给定的数独序列只包含数字 1-9 和字符 '.' 。
     * 你可以假设给定的数独只有唯一解。
     * 给定数独永远是 9x9 形式的。
     * @param board
     */
    public void solveSudoku(char[][] board) {
        this.board = board;
        initBit();
        solveNext(0, 0);
    }

    private boolean solveNext(int curRow, int curColumn) {
        if (curRow == targetN) {
            return true;
        }
        // 计算下一个坐标的位置，可能是右边的坐标，也可能是下一行第一个元素
        boolean endColumn = curColumn + 1 == targetN;
        int nextRow = endColumn ? curRow + 1 : curRow;
        int nextColumn = endColumn ? 0 : curColumn + 1;
        // 如果这个位置上有值，不需要填，直接下一个
        if (board[curRow][curColumn] != WAIT) {
            return solveNext(nextRow, nextColumn);
        }
        // 分别从 1-9 进行尝试
        for (int i = 0; i < targetN; i++) {
            if (!canAdd(curRow, curColumn, i)) {
                continue;
            }
            // 当前尝试的值可以，记录下来
            recordNum(curRow, curColumn, i + '1');
            // 进行下一个位置尝试
            if (solveNext(nextRow, nextColumn)) {
                return true;
            }
            // 这个位置不行，需要回退记录
            rollbackNum(curRow, curColumn, i + '1');
        }
        return false;
    }

    /**
     * 判断num是否可以放置在这个位置上
     * @param row
     * @param column
     * @param num
     * @return
     */
    private boolean canAdd(int row, int column, int num) {
        if ((rowBit[row] >> num) % 2 == 1) {
            return false;
        }
        if ((columnBit[column] >> num) % 2 == 1) {
            return false;
        }
        int blockIndex = row / blockN * blockN + column / blockN;
        if ((blockBit[blockIndex] >> num) % 2 == 1) {
            return false;
        }
        return true;
    }

    /**
     * 在开始算法前，先记录题目给的值，并记录下来
     */
    private void initBit() {
        for (int i = 0; i < targetN; i++) {
            for (int j = 0; j < targetN; j++) {
                if (board[i][j] == WAIT) {
                    continue;
                }
                recordNum(i, j, board[i][j]);
            }
        }
    }

    /**
     * 记录这个这个坐标值
     * @param row
     * @param column
     */
    private void recordNum(int row, int column, int num) {
        // 用一个int类型存储9位数字
        int resultNum = 1 << num - '1';
        rowBit[row] += resultNum;
        columnBit[column] += resultNum;
        int blockIndex = row / blockN * blockN + column / blockN;
        blockBit[blockIndex] += resultNum;
        board[row][column] = (char) num;
    }

    /**
     * 将记录的位置置0
     * @param row
     * @param column
     * @param num
     */
    private void rollbackNum(int row, int column, int num) {
        int resultNum = 1 << num - '1';
        rowBit[row] -= resultNum;
        columnBit[column] -= resultNum;
        int blockIndex = row / blockN * blockN + column / blockN;
        blockBit[blockIndex] -= resultNum;
        board[row][column] = WAIT;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        new Solution().solveSudoku(board);
        System.out.println(board);
    }
}
