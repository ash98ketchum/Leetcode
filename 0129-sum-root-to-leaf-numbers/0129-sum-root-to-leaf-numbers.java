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
    public void myrec(String s, TreeNode node, List<String> l){
        if(node == null) return;

        if(node.left != null){
            myrec(s + node.val, node.left, l);
        }
        if(node.right != null){
            myrec(s + node.val, node.right, l);
        }
        if(node.left == null && node.right == null){
            s += node.val;
            l.add(s);
        }
    }
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;

        String s = "";
        List<String> l = new ArrayList<>();
        myrec(s, root, l);
        
        int sum = 0;
        for(String st: l){
            int digit = Integer.parseInt(st);
            sum += digit;
        }
        return sum;
    }
}