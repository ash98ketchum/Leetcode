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
    public void myrec(TreeNode root, List<Integer> arr){
        if(root == null){
            return;
        }
        
        myrec(root.left, arr);
        arr.add(root.val);
        myrec(root.right, arr);
        
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> arr = new ArrayList<>();
        myrec(root, arr);
        return arr;
    }
}