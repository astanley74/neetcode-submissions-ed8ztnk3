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
    public int kthSmallest(TreeNode root, int k) {
        int[] temp = new int[2];
        temp[0] = 0;
        dfs(root, temp, k);
        return temp[1];
    }

    private void dfs(TreeNode node, int[] temp, int k) {
        if (node == null) {
            return;
        }
        dfs(node.left, temp, k);
        temp[0] += 1;
        if (temp[0] == k) {
            temp[1] = node.val;
            return;
        }
        dfs(node.right, temp, k);
    }
}
