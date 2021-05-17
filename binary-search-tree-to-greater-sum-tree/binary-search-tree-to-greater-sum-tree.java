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
    int total = 0;
    public TreeNode bstToGst(TreeNode root) {
        //Reverse inOrder traversal
        reverse(root);
        return root;
    }
    
    public void reverse(TreeNode node){
        //Right -> Mid -> Left
        if(node.right != null)
            reverse(node.right);
        node.val = node.val + total;
        total = node.val;
        if(node.left != null)
            reverse(node.left);
    }
}