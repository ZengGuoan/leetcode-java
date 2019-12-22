package _46.Permutations;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private List<List<Integer>> result = new ArrayList<>();
    private int[] nums;
    // 一路深入到最后面的元素，一路记录哪些元素使用过了
    private boolean[] used;
    // 一路深入到最后面的元素，一路记录使用了哪些元素，作为最后结果
    private List<Integer> curList = new ArrayList<>();

    /**
     * DFS深度优先搜索
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        this.used = new boolean[nums.length];
        dfs(0);
        return result;
    }

    private void dfs(int curLen) {
        if (curLen == nums.length) {
            result.add(new ArrayList<>(curList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            // 设置状态
            used[i] = true;
            curList.add(nums[i]);
            // 深度优先搜索
            dfs(curLen + 1);
            // 回溯
            used[i] = false;
            curList.remove(curList.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> permute = new Solution().permute(nums);
        System.out.println(permute);
    }
}
