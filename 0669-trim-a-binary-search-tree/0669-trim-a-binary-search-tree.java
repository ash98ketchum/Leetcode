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
    public TreeNode myrec(TreeNode root, int l, int h){
        if(root == null) return null;

        if(l <= root.val  && root.val <= h){
            // kuch karenge
            root.left = myrec(root.left, l, h);
            root.right = myrec(root.right, l, h);
        }
        else if(root.val < l){
            root = myrec(root.right, l, h);
        }
        else{
            root = myrec(root.left, l, h);
        }
        return root;
    }
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root == null) return null;
        return myrec(root, low, high);
    }
}