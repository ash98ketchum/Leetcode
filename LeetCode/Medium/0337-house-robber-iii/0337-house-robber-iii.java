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
class Pair {
    TreeNode node;
    int rob;

    Pair(TreeNode node, int rob){
        this.node = node;
        this.rob = rob;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pair)) return false;
        Pair p = (Pair) o;
        return rob == p.rob && node == p.node;
    }

    @Override
    public int hashCode() {
        return Objects.hash(System.identityHashCode(node), rob);
    }
}
class Solution {
    HashMap<Pair, Integer> dp;
    public int dfs(int rob, TreeNode root){
        if(root == null) return 0;
        
        Pair key = new Pair(root, rob);
        if(dp.containsKey(key)) return dp.get(key);
        
        if(rob == 1){
            int val = root.val + dfs(0, root.left) + dfs(0, root.right);
            dp.put(key, val);
            return val;
        }
        
        int notake = 0;
        notake += Math.max(dfs(1, root.left), dfs(0, root.left))
                + Math.max(dfs(1, root.right), dfs(0, root.right));

        dp.put(key, notake);
        return notake;
    }

    public int rob(TreeNode root) {
        dp = new HashMap<>();
        return Math.max(dfs(1, root), dfs(0, root));
    }
}