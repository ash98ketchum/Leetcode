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
    public int myrec(TreeNode root){
        if(root == null){
            return 0;
        }
        int cnt1 = 0;
        int cnt2 = 0;
        if(root.left != null){
            cnt1 = myrec(root.left) + 1;
        }
        if(root.right != null){
            cnt2 = myrec(root.right) + 1;
        }
        return Math.max(cnt1,cnt2);
    }
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return myrec(root) + 1;
    }
}