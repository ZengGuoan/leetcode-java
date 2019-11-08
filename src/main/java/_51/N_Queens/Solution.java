package _51.N_Queens;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    private static final char QUEEN = 'Q';
    private static final char BLANK = '.';

    private boolean[] rowChoice; // 记录占据了哪几列
    private boolean[] leftSlant; // 记录 y-x=b,记录b
    private boolean[] rightSlant;// 记录 y+x=b,记录b
    private int targetN; // 记录n，避免参数多次传递，浪费栈空间
    private List<List<String>> result = new ArrayList<>();

    /**
     * 使用DFS深度优先搜索
     *
     * @param n
     * @return
     */
    public List<List<String>> solveNQueens(int n) {
        if (n == 0) {
            return result;
        }
        targetN = n;
        rowChoice = new boolean[targetN];
        leftSlant = new boolean[targetN * 2];
        rightSlant = new boolean[targetN * 2];
        searchQueen(new ArrayList<>(n), 0);
        return result;
    }

    /**
     *
     * @param list 重复使用
     * @param curRow 当前行
     */
    private void searchQueen(List<String> list, int curRow) {
        if (curRow == targetN) { // 超过最后一行说明达到终点了
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < targetN; i++) {
            if (!rowChoice[i] && !leftSlant[curRow - i + targetN] && !rightSlant[curRow + i]) {
                // 创造一行数据
                char[] chars = new char[targetN];
                Arrays.fill(chars, BLANK);
                chars[i] = QUEEN;
                if (list.size() - 1 >= curRow) {
                    list.set(curRow, String.valueOf(chars));
                } else {
                    list.add(String.valueOf(chars));
                }
                rowChoice[i] = true;
                leftSlant[curRow - i + targetN] = true;
                rightSlant[curRow + i] = true;
                // 深入递归下一行，增加一行数据后，继续搜索下一行
                searchQueen(list, curRow + 1);
                // 恢复到不插入下一行的状态
                rowChoice[i] = false;
                leftSlant[curRow - i + targetN] = false;
                rightSlant[curRow + i] = false;
            }
        }
    }

    public static void main(String[] args) {
        List<List<String>> lists = new Solution().solveNQueens(4);
        System.out.println(lists);
    }
}
