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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        int sum = 0;
        if(root != null){
            sum = root.val;
        }
        else{
            return false;
        }
        return myrec(root, targetSum, sum);
    }
    public boolean myrec(TreeNode root, int target, int sum){
        if(root.left == null && root.right == null){
            if(target == sum){
                return true;
            }
            else{
                return false;
            }
        }
        boolean left = false;
        boolean right = false;
        if(root.left != null){
            left = myrec(root.left, target, sum +root.left.val);
        }
        if(root.right != null){
            right = myrec(root.right, target, sum + root.right.val);
        }
        return left || right;

    }
}