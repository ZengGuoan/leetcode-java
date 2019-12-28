package _0002.Insert_Sort;

public class Solution {
    /**
     * 插入排序，遍历到当前元素i时，将i元素插入到比i元素小和比i元素大的元素中间，插入后会造成批量元素后移
     *
     * 时间复杂度O(n^2)
     *
     * @param nums
     */
    public void insertSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int j = i;
            while (j > 0 && nums[j] < nums[j - 1]) {
                int tmp = nums[j];
                nums[j] = nums[j - 1];
                nums[j - 1] = tmp;
                j --;
            }
        }
    }
}
