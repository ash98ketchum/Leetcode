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
class FindElements {
    private HashSet<Integer> val;
    public FindElements(TreeNode root) {
        val=new HashSet<>();
        myfunc(root,0);
    }
    private void myfunc(TreeNode node,int n){
        if(node==null) return;
        node.val=n;
        val.add(n);
        myfunc(node.left, 2 * n + 1);
        myfunc(node.right, 2 * n + 2);
    }
    public boolean find(int target) {
        return val.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */