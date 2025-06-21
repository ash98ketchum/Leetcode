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
class Tuple{
    TreeNode node;
    int index;
    public Tuple(TreeNode node, int index){
        this.node = node;
        this.index = index;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        int ans = 1;
        if(root == null) return 0;

        Queue<Tuple> q = new LinkedList<>();
        q.offer(new Tuple(root, 0));

        while(!q.isEmpty()){
            int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
            int n = q.size();
            for(int i = 0; i < n; i++){
                Tuple t = q.poll();
                TreeNode node = t.node;

                int idx = t.index;

                if(idx < min){
                    min = idx;
                }
                if(idx > max){
                    max = idx;
                }

                if(node.left != null) q.offer(new Tuple(node.left, 2 * idx + 1));
                if(node.right != null) q.offer(new Tuple(node.right, 2 * idx + 2));

                
            }
            ans = Math.max(ans, max - min + 1);
        }
         return ans;
    }
}