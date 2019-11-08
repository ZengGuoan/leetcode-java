package _98.validate_binary_search_tree;

public class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValid(root, null, null);
    }

    private boolean isValid(TreeNode node, Integer low, Integer up) {
        if (node == null) {
            return true;
        }
        if (low != null && node.val <= low) {
            return false;
        }
        if (up != null && node.val >= up) {
            return false;
        }
        return isValid(node.left, low, node.val) && isValid(node.right, node.val, up);
    }
}
