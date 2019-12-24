package _88.Merge_Sorted_Array.v2;

public class Solution {
    /**
     * 使用三个指针，分别制定三个目标数组的最尾部
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 合并后的nums1的尾指针
        int index = m + n - 1;
        // 未合并nums1的尾指针
        int mEnd = m - 1;
        // nums2的尾指针
        int nEnd = n -1;
        for (; index >= 0 && mEnd >= 0 && nEnd >= 0; index--) {
            // 将num1和nums2中尾部最大的防盗合并后nums1中，然后指针向前移动
            if (nums1[mEnd] > nums2[nEnd]) {
                nums1[index] = nums1[mEnd --];
            } else {
                nums1[index] = nums2[nEnd --];
            }
        }
        // 可能合并前nums1先移动到最开头了，剩下的nums2要全部直接合并到nums1中
        while (nEnd >= 0) {
            nums1[index --] = nums2[nEnd --];
        }
    }
}
