/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
*/
class Solution {
    int ans = Integer.MIN_VALUE;
    public int myrec(TreeNode root){
        if(root == null) return 0;
        
        int s1 = Math.max(myrec(root.left) , 0);
        int s2 = Math.max(myrec(root.right) , 0);
        ans = Math.max(ans , s1 + s2 + root.val);
        return Math.max(s1, s2) + root.val;
    }
    public int maxPathSum(TreeNode root) {
        myrec(root);
        return ans;
    }
}