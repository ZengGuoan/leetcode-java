package _111.minimum_depth_of_binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public int minDepth(TreeNode root) {
        int minDep = 0;
        if (root == null) {
            return minDep;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<TreeNode> nextLevelList = new ArrayList<>();
            minDep ++;
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) {
                    return minDep;
                }
                if (node.left != null) {
                    nextLevelList.add(node.left);
                }
                if (node.right != null) {
                    nextLevelList.add(node.right);
                }
            }
            queue.addAll(nextLevelList);
        }
        return -1;
    }

    public int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = minDepth2(root.left);
        int right = minDepth2(root.right);
        if (root.left == null || root.right == null) {
            return left + right + 1;
        }
        return Math.min(left, right) + 1;
    }
}
