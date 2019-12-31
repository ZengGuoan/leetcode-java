package _0005.Merge_Sort;

public class Solution {
    private int[] nums;

    /**
     * 归并排序，将数组一分为二分别进行排序，然后进行合并，递归调用
     *
     * 时间复杂度O(N*logN)
     *
     * @param nums
     */
    public void mergeSort(int[] nums) {
        this.nums = nums;
        mergeSort(0, nums.length - 1);
    }

    private void mergeSort(int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        // 递归，将左半部分进行归并排序
        mergeSort(start, mid);
        // 递归，将右半部分进行归并排序
        mergeSort(mid + 1, end);
        // 将已经有序的左右部分进行合并
        merge(start, mid, end);
    }

    /**
     * 合并分别有序的左右两部分
     *
     * @param start
     * @param mid
     * @param end
     */
    private void merge(int start, int mid, int end) {
        int[] tmp = new int[end - start + 1];
        int tmpEnd = end - start;
        int end1 = mid, end2 = end;
        while (end1 >= start && end2 > mid) {
            tmp[tmpEnd --] = nums[end1] > nums[end2] ? nums[end1 --] : nums[end2 --];
        }
        while (end1 >= start) {
            tmp[tmpEnd --] = nums[end1 --];
        }
        while (end2 > mid) {
            tmp[tmpEnd --] = nums[end2 --];
        }
        System.arraycopy(tmp, 0, nums, start, tmp.length);
    }
}
