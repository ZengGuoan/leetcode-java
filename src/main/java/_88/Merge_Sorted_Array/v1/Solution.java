package _88.Merge_Sorted_Array.v1;

import java.util.Arrays;

public class Solution {
    /**
     * 合并后再排序，浪费了两个数组已经分别有序的前提
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);
    }
}
