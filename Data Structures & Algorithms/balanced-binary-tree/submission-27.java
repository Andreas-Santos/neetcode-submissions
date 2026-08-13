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
    public boolean isBalanced(TreeNode root) {
        return heightDiff(root) != -1;
    }

    public int heightDiff(TreeNode root) {

        if(root == null)
            return 0;
        
        int heightLeft = heightDiff(root.left);
        if(heightLeft == -1)
            return -1;
        
        int heightRight = heightDiff(root.right);
        if(heightRight == -1)
            return -1;

        if(Math.abs(heightLeft - heightRight) > 1) {
            return -1;
        }

        return Math.max(heightLeft, heightRight) + 1;
    }
}
