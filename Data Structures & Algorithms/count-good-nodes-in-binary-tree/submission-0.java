/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int goodNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int currMax) {
        int sum = 0;
        if (node.val >= currMax) {
            sum += 1;
        }

        if (node.right != null) {
            sum += dfs(node.right, Math.max(node.val, currMax));
        }

        if(node.left != null) {
            sum += dfs(node.left, Math.max(node.val, currMax));
        }
        return sum;
    }
}
