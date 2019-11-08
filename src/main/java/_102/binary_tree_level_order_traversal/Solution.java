package _102.binary_tree_level_order_traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    /**
     * 广度优先遍历
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (root == null) {
            return resultList;
        }
        Queue<TreeNode> queue= new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> levelList = new ArrayList<>();
            List<TreeNode> nextLeveNode = new ArrayList<>();
            while (!queue.isEmpty()) { // 每次把一个层级的节点全部遍历出来
                TreeNode node = queue.poll();
                // 存储当前层级的值
                levelList.add(node.val);
                if (node.left != null) {
                    nextLeveNode.add(node.left);
                }
                if (node.right != null) {
                    nextLeveNode.add(node.right);
                }
            }
            resultList.add(levelList);
            queue.addAll(nextLeveNode);
        }
        return resultList;
    }
}
