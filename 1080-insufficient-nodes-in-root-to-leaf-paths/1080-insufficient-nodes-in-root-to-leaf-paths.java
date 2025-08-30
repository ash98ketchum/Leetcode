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
    public boolean dfs(TreeNode root, int limit, int sum){
        if(root == null){
            return true;
        }
        sum += root.val;
        
        if(root.left == null && root.right == null){
            if(sum < limit){
                return true;
            }
            else{
                return false;
            }
        }
        
        boolean left = dfs(root.left, limit, sum);
        boolean right = dfs(root.right, limit, sum);
        
        if(left){
            // agar left true h matlb left se limit se km sum bn rha h
            // left ko null
            root.left = null;
        }
        if(right){
            // agar right true h matlb right se limit se km sum bn rha h
            // right ko null
            root.right = null;
        }
        
        return left && right;
        
    }
    
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        if(dfs(root, limit, 0)){
            return null;
        }
        return root;
    }
}