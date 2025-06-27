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
    public long prev = Long.MIN_VALUE;
    public boolean ans = true;
    public void myrec(TreeNode root){
        if(root == null) return;
        if(root.left != null) myrec(root.left);
        
        long curr = root.val;
        if(curr <= prev){
            ans = false;
            
        }
        prev = curr;
        if(root.right != null) myrec(root.right);
    }
    public boolean isValidBST(TreeNode root) {
        myrec(root);
        return ans;
    }
}