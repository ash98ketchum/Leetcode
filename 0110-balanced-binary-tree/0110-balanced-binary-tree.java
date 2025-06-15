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
    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }
        
        int leftheight = maxDepth(root.left);
        int rightheight = maxDepth(root.right);
        
        if(Math.abs(leftheight - rightheight) > 1) {
            return false;
        }
        
        boolean left = isBalanced(root.left);
        if(!left) {
            return false;
        }
        
        boolean right = isBalanced(root.right);
        if(!right) {
            return false;
        }
        
        return true;
    }
   
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int l = 1 + maxDepth(root.left);
        int r = 1 + maxDepth(root.right);
        return Math.max(l, r);
    }
}