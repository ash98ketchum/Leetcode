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
    public static void myrec(TreeNode root, int sum, List<List<Integer>> res,   List<Integer> l){
        if(root == null){
            return;
        }
        l.add(root.val);
        sum = sum - root.val;
        if(root.left == null && root.right == null){
            if(sum == 0){
                res.add(new ArrayList<>(l));
            }
        }
        if(root.left != null) myrec(root.left, sum, res, l);
        if(root.right != null) myrec(root.right, sum, res, l);

        l.remove(l.size() - 1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> l = new ArrayList<>();

        myrec(root, targetSum, res, l);
        return res;
    }
}