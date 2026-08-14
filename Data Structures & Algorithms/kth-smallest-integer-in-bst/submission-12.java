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

        if(root == null)
            return -1;
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
            (a, b) -> b - a
        );

        dfs(root, k, maxHeap);

        return maxHeap.peek();

    }

    public void dfs(TreeNode root, int k, PriorityQueue<Integer> maxHeap) {

        if(root == null)
            return;

        maxHeap.offer(root.val);
        if(maxHeap.size() > k) {
            maxHeap.poll();
        }

        dfs(root.left, k, maxHeap);
        dfs(root.right, k, maxHeap);
    }
}
