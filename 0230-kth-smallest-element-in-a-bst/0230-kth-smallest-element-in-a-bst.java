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
    public int cnt = 0;
    public int ans = -1;
    public void myrec(TreeNode root, int k){
        if(root == null) return;
        if(root.left != null){
            myrec(root.left, k);
        }
        cnt++;
        if(cnt == k) ans = root.val;
        if(root.right != null){
            myrec(root.right, k); 
        }
    }
    public int kthSmallest(TreeNode root, int k) {
       
        myrec(root, k);
        return ans;
    }
}