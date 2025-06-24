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
    // public TreeNode res;

    // public TreeNode myrec(TreeNode divyanshi) {
    //     if (divyanshi == null) return null;
    //     TreeNode node = new TreeNode(divyanshi.val);
    //     node.left = myrec(divyanshi.right);
    //     node.right = myrec(divyanshi.left);

    //     return node;
    // }

    public TreeNode invertTree(TreeNode root) {
        // if (root == null) return null;

        // res = myrec(root);
        // return res;
        if(root == null) return root;
        
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
