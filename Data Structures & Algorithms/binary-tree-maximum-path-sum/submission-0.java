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

    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        pathSum(root);

        return maxSum;
    }

    public int pathSum(TreeNode root) {

        if(root == null)
            return 0;

        int left = Math.max(pathSum(root.left), 0);
        int right = Math.max(pathSum(root.right), 0);

        int path = root.val + left + right;
        maxSum = Math.max(maxSum, path);

        return Math.max(left, right) + root.val;
    }
}
