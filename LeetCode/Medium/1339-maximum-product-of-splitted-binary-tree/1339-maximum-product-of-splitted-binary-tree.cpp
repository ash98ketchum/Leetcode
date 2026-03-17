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
public:
    long long totsum = 0;
    long long ans = 0;
    const int MOD = 1e9 + 7;

    long long get(TreeNode* root) {
        if(!root) return 0;
        return root->val + get(root->left) + get(root->right);
    }

    long long dfs(TreeNode* root) {
        if (!root) return 0;

        long long left = dfs(root->left);
        long long right = dfs(root->right);

        long long curr = root->val + left + right;
        long long mul = curr * (totsum - curr);
        ans = max(ans, mul);

        return curr;
    }
    int maxProduct(TreeNode* root) {
        totsum = get(root);
        dfs(root);
        return ans % MOD;
    }
};