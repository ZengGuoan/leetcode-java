package _0001.Select_Sort;

public class Solution {
    /**
     * 选择排序，在当前元素i位置时，遍历i后最小的元素，如果比i位置的元素小，则进行交换位置
     *
     * 复杂度O(n^2)
     *
     * @param nums
     */
    public void selectSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            int tmp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = tmp;
        }
    }
}
