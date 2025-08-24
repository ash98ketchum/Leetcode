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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> set = new HashSet<>();
        for(int it : to_delete){
            set.add(it);
        }
        
        List<TreeNode> res = new ArrayList<>();     
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node.left != null){
                q.offer(node.left);
                if(set.contains(node.left.val)){
                    node.left = null;
                }
            }
            if(node.right != null){
                q.offer(node.right);
                if(set.contains(node.right.val)){
                    node.right = null;
                }
            }
            if(set.contains(node.val)){
                if(node.left != null){
                    res.add(node.left);
                }
                if(node.right != null){
                    res.add(node.right);
                }
            }
        }
        if(!set.contains(root.val)) res.add(root);
        return res;
    }
}