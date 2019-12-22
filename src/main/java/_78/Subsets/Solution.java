package _78.Subsets;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private int[] nums;
    private List<Integer> curList = new ArrayList<>();
    private List<List<Integer>> result = new ArrayList<>();

    /**
     * DFS+回溯
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        dfs(0);
        return result;
    }

    private void dfs(int startIndex) {
        result.add(new ArrayList<>(curList));
        for (int i = startIndex; i < nums.length; i++) {
            curList.add(nums[i]);
            dfs(i + 1);
            // 回溯
            curList.remove(curList.size() - 1);
        }
    }
}
