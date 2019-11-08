package _52.N_Queens_II;

public class Solution {
    private int targetN; // n
    private int resultCnt;  // 解决方案的数量
    private boolean[] columnChoice;  // 已经被选择的列
    private boolean[] leftSlant;     // x-y=b,存储b
    private boolean[] rightSlant;    // x+y=b,存储b

    public int totalNQueens(int n) {
        targetN = n;
        resultCnt = 0;
        columnChoice = new boolean[targetN];
        leftSlant = new boolean[targetN * 2];
        rightSlant = new boolean[targetN * 2];
        searchQueen(0);
        return resultCnt;
    }

    private void searchQueen(int curRow) {
        if (curRow == targetN) {
            resultCnt ++;
            return;
        }
        for (int i = 0; i < targetN; i++) {
            // 满足当前列 && 对角线上
            if (!columnChoice[i] && !leftSlant[curRow - i + targetN] && !rightSlant[curRow + i]) {
                columnChoice[i] = true;
                leftSlant[curRow - i + targetN] = true;
                rightSlant[curRow + i] = true;
                searchQueen(curRow + 1);
                // 回退
                columnChoice[i] = false;
                leftSlant[curRow - i + targetN] = false;
                rightSlant[curRow + i] = false;
            }
        }
    }
}
