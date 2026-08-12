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
        
        int[] result = new int[2];
        result = getHeight(root);

        return result[0] == 1;
    }

    public int[] getHeight(TreeNode root) {

        if(root == null)
            return new int[]{1, 0};

        int[] left = getHeight(root.left);
        int[] right = getHeight(root.right);

        boolean balanced = 
            (left[0] == 1 && right[0] == 1) &&
            (Math.abs(left[1] - right[1]) <= 1);

        int height = 1 + Math.max(left[1], right[1]);

        return balanced ? new int[]{1, height} : new int[]{0, height};
    }
}
