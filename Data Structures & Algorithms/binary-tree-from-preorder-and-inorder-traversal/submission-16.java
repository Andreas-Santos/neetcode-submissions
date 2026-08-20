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

    int preorderIndex;
    Map<Integer, Integer> inorderMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        preorderIndex = 0;
        inorderMap = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return build(preorder, 0, inorder.length - 1);
    }

    public TreeNode build(int[] preorder, int left, int right) {

        if(left > right)
            return null;

        int value = preorder[preorderIndex];
        preorderIndex++;

        TreeNode node = new TreeNode(value);
        int middle = inorderMap.get(value);
        node.left = build(preorder, left, middle - 1);
        node.right = build(preorder, middle + 1, right);

        return node;
    }
}
