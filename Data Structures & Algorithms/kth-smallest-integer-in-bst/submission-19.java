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
        this.k = k;

        return dfs(root);
    }

    public int dfs(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int result = 0;
        result += dfs(root.left);
        
        k--;
        if(k == 0) {
            return root.val;
        }

        result += dfs(root.right);

        return result;
    }
}
