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
    int cnt = 0;
    public int myrec(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = myrec(root.left);
        int right = myrec(root.right);
        int move = root.val + left + right -1;
        cnt += Math.abs(left) + Math.abs(right);
        
        return move;
        
    }
    public int distributeCoins(TreeNode root) {
        myrec(root);
        return cnt;
    }
}