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
    public int myrec(TreeNode root, int val){
        if(root==null){
            return 0;
        }

        int l = myrec(root.left, 0);
        int r = myrec(root.right, 0);
        if(l == -1 || r == -1){
            cnt++;
            return 1;
        }
        else if(l == 1 || r == 1){
            return 0;
        }
        else{
            return -1;
        }
    }
    public int minCameraCover(TreeNode root) {
        if(root == null) return cnt;
        if(myrec(root, 0) == -1) cnt++;
        return cnt;
    }
}