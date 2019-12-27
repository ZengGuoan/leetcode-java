package _42.Trapping_Rain_Water.v2;

public class Solution {
    /**
     * 动态规划
     * 思路：每次只求当前左边的雨水量（即可达高度），等于左边最大高度和右边最大高度取小，高度值和当前坐标的高度值差就是雨水量
     *
     * 1. 状态定义：
     *  min_height = min(left_max_height[i], right_max_height[i])
     *      f(i) = min_height - height[i] > 0 ? min_height - height[i] : 0
     * 2. 状态转移方程：
     *  1) 左边最高的列
     *      left_max_height[i] = max(left_max_height[i - 1], height[i - 1])
     *  2) 右边最高的列
     *      right_max_height[i] = max(right_max_height[i + 1], height[i + 1])
     *
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        // 记录每个坐标的右边最大高度
        int[] rightMaxHeight = new int[height.length];
        rightMaxHeight[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            rightMaxHeight[i] = Math.max(rightMaxHeight[i + 1], height[i + 1]);
        }
        int leftMaxHeight = height[0];
        int total = 0;
        for (int i = 1; i < height.length; i++) {
            leftMaxHeight = Math.max(leftMaxHeight, height[i - 1]);
            int curMinHeight = Math.min(leftMaxHeight, rightMaxHeight[i]);
            if (curMinHeight > height[i]) {
                total += curMinHeight - height[i];
            }
        }
        return total;
    }
}
