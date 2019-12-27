package _42.Trapping_Rain_Water.v1;

public class Solution {
    /**
     * 双指针，前后指针往中间夹逼
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {
        // 头尾指针
        int start = 0, end = height.length - 1;
        // 每个位置最终可以达到的最高高度
        int[] maxHeight = new int[height.length];
        // 结果值
        int total = 0;
        int curMaxHeight;
        while (start <= end) {
            curMaxHeight = Math.min(height[start], height[end]);
            for (int i = start; i <= end; i++) {
                maxHeight[i] = curMaxHeight;
            }
            while (start <= end && height[start] <= curMaxHeight) {
                start ++;
            }
            while (start <= end && height[end] <= curMaxHeight) {
                end --;
            }
        }
        // 将允许的最高值与当前的差值累加
        for (int i = 0; i < height.length; i++) {
            if (height[i] < maxHeight[i]) {
                total += maxHeight[i] - height[i];
            }
        }
        return total;
    }

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int trap = new Solution().trap(height);
        System.out.println(trap);
    }
}
