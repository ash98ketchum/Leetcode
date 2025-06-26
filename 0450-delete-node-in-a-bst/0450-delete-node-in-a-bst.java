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
    public TreeNode myrec(TreeNode root){
        if(root.left == null){
            return root.right;
        }else if(root.right == null){
            return root.left;
        }else{
            TreeNode r = root.right;
            TreeNode l = root.left;
            while(l.right != null){
                l = l.right;
            }
            l.right = r;
            return root.left;
        }
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        if(root.val == key) return myrec(root);
        TreeNode node = root;
        while(true){
            if(root == null) break;
            if(key < root.val){
                if(root.left != null && root.left.val == key){
                    root.left = myrec(root.left);
                    break;
                }else{
                    root = root.left;
                }
            }else{
                if(root.right != null && root.right.val == key){
                    root.right = myrec(root.right);
                    break;
                }else{
                    root = root.right;
                }
            }
        }
         return node;
    }
}