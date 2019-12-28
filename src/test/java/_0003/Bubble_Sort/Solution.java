package _0003.Bubble_Sort;

public class Solution {
    /**
     * 冒泡排序
     *
     * 时间复杂度O(n^2)
     *
     * @param nums
     */
    public void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                }
            }
        }
    }
}
