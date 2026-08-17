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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root == null)
            return null;

        TreeNode current = root;
        while(current != null) {
            
            if(current.val > Math.max(p.val, q.val)) {
                current = current.left;
            }
            else if(current.val < Math.min(p.val, q.val)) {
                current = current.right;
            }
            else {
                return current;
            }
        }
        
        return null;
    }
}
