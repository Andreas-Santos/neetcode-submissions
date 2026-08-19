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
    private int k;

    public int kthSmallest(TreeNode root, int k) {
        if(root == null)
            return 0;

        this.k = k;

        return inOrderTraversal(root);
    }

    public int inOrderTraversal(TreeNode root) {

        if(root == null)
            return 0;

        int result = 0;
        result += inOrderTraversal(root.left);
        
        k--;
        if(k == 0) {
            return root.val;
        }

        result += inOrderTraversal(root.right);

        return result;
    }
}
