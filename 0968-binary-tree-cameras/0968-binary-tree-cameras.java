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
    public int cnt = 0;
    Set<TreeNode> st;
    public int minCameraCover(TreeNode root) {
        st = new HashSet<>();
        st.add(null);
        dfs(root, null);
        return cnt;

    }
    public void dfs(TreeNode root, TreeNode parent){
        if(root != null){
            dfs(root.left, root);
            dfs(root.right, root);

            if((parent == null && !st.contains(root)) || !st.contains(root.left) || !st.contains(root.right)){
                cnt++;
                st.add(parent);
                st.add(root);
                st.add(root.left);
                st.add(root.right);
            }

        }
    }
}