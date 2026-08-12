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
    public int diameterOfBinaryTree(TreeNode root) {
        
        if(root == null)
            return 0;

        int[] res = new int[1];

        getHeight(root, res);

        return res[0];
    }

    public int getHeight(TreeNode root, int[] res) {

        if(root == null)
            return 0;

        int leftHeight = getHeight(root.left, res);
        int rightHeight = getHeight(root.right, res);

        res[0] = Math.max(res[0], leftHeight + rightHeight);
        
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
