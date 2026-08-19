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
        
        if(preorder.length == 0)
            return null;

        // preorder -> find the rootnode preorder[0]
        // inorder -> find out the left and right nodes of the rootnode
        preorderIndex = 0;
        inorderMap = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return arrayToTree(preorder, 0, preorder.length - 1);
    }

    public TreeNode arrayToTree(int[] preorder, int left, int right) {

        if(left > right)
            return null;

        int value = preorder[preorderIndex];
        preorderIndex++;

        TreeNode root = new TreeNode(value);
        int middle = inorderMap.get(value);

        root.left = arrayToTree(
            preorder,
            left,
            middle - 1
        );
        
        root.right = arrayToTree(
            preorder,
            middle + 1,
            right
        );

        return root;
    }
}
