package _0004.Quick_Sort;

public class Solution {
    private int[] nums;

    /**
     * 快速排序，在任意个坐标选中pivot（这里选中末尾元素），
     * 将小于pivot的元素全部（元素与元素之间无序）转移到pivot左侧，
     * 反之则到右侧，然后左右子串分别递归
     *
     * 时间复杂度O(N*logN)
     *
     * @param nums
     */
    public void quickSort(int[] nums) {
        this.nums = nums;
        quickSort(0, nums.length - 1);
    }

    private void quickSort(int start, int end) {
        if (start >= end) {
            return;
        }
        int pivot = partition(start, end);
        quickSort(start, pivot - 1);
        quickSort(pivot + 1, end);
    }

    /**
     * 返回pivot的位置，并且移动元素保证pivot左侧的元素小于pivot，右侧的元素大于pivot
     *
     * @param start
     * @param end
     * @return
     */
    private int partition(int start, int end) {
        int pivot = end; // 用于比较的元素
        int counter = start; // 记录小于pivot值的最新坐标位置，之前的元素都是小于pivot元素的
        for (int i = start; i < end; i++) {
            // 只有比pivot的元素才需要交换到counter位置
            if (nums[i] < nums[pivot]) {
                int tmp = nums[i];
                nums[i] = nums[counter];
                nums[counter] = tmp;
                counter ++;
            }
        }
        int tmp = nums[counter];
        nums[counter] = nums[pivot];
        nums[pivot] = tmp;
        return counter;
    }
}
