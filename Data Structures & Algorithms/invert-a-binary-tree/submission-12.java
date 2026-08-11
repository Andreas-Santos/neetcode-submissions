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
    public TreeNode invertTree(TreeNode root) {
        
        // BFS implementation

        if(root == null) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {

            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode current = queue.poll();

                if(current.right != null) queue.offer(current.right);
                
                if(current.left != null) queue.offer(current.left);

                TreeNode temp = current.right;
                current.right = current.left;
                current.left = temp;
            }
        }

        return root;
    }
}
