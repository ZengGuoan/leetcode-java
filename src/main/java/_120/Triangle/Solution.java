package _120.Triangle;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * 动态规划：
     * 1. 从底向上，记录底部到当前的最短距离f(row, column)
     * 2. f(row, column) = min(f(row + 1, column), f(row + 1, column + 1)) + triangle[row, column]
     *
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        // 数组重复使用
        int[] minSum = new int[triangle.size() + 1];
        for (int row = triangle.size() - 1; row >= 0; row--) {
            for (int column = 0; column < triangle.get(row).size(); column++) {
                minSum[column] = Math.min(minSum[column], minSum[column + 1]) + triangle.get(row).get(column);
            }
        }
        return minSum[0];
    }
}
