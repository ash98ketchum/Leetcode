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
    static const int MOD = 1e9 + 7;
    long long tot = 0;
    long long ans = 0;
    long long sum(TreeNode* root) {
        if (!root) return 0;
        return root->val + sum(root->left) + sum(root->right);
    }
    long long dfs(TreeNode* root) {
        if (!root) return 0;
        long long left = dfs(root->left);
        long long right = dfs(root->right);
        long long subtreeSum = root->val + left + right;
        long long product = subtreeSum * (tot - subtreeSum);
        ans = max(ans, product);

        return subtreeSum;
    }

    int maxProduct(TreeNode* root) {
        tot = sum(root);
        dfs(root);
        return ans % MOD;
    }
};
