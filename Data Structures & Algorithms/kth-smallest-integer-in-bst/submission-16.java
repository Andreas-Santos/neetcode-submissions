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

    int k;

    public int kthSmallest(TreeNode root, int k) {
        
        this.k = k;
        int result = dfs(root);

        return result;
    }

    public int dfs(TreeNode node) {

        if(node == null)
            return 0;

        int result = 0;
        result += dfs(node.left);

        k--;
        if(k == 0) {
            return node.val;
        }

        result +=dfs(node.right);
        return result;
    }
}
