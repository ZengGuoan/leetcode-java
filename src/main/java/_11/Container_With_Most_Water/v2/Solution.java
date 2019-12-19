package _11.Container_With_Most_Water.v2;

public class Solution {
    /**
     * 双指针法：从前后往中间移动
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int start = 0, end = height.length - 1, maxArea = 0;
        while (start < end) {
            int area = (end - start) * Math.min(height[start], height[end]);
            if (area > maxArea) {
                maxArea = area;
            }
            if (height[start] > height[end]) {
                end --;
            } else {
                start ++;
            }
        }
        return maxArea;
    }
}
