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
    unordered_map<int, TreeNode*> mp;
    unordered_set<int> leaves;

    bool isValid(TreeNode* root, long mn, long mx) {
        if (!root) return true;

        if (root->val <= mn || root->val >= mx) return false;

        return isValid(root->left, mn, root->val) && isValid(root->right, root->val, mx);
    }

    void collectLeaves(TreeNode* root) {
        if (!root) return;

        if (!root->left && !root->right) leaves.insert(root->val);

        collectLeaves(root->left);
        collectLeaves(root->right);
    }

    TreeNode* dfs(TreeNode* root) {
        if (!root) return nullptr;
        if (!root->left && !root->right && mp.count(root->val)) {
            TreeNode* t = mp[root->val];
            mp.erase(root->val);
            root->left = t->left;
            root->right = t->right;
        }

        dfs(root->left);
        dfs(root->right);

        return root;
    }

    TreeNode* canMerge(vector<TreeNode*>& trees) {
        for (auto t : trees) mp[t->val] = t;
        for (auto t : trees) collectLeaves(t);

        TreeNode* root = nullptr;
        for (auto t : trees) {
            if (!leaves.count(t->val)) {
                root = t;
                break;
            }
        }

        if (!root) return nullptr;
        mp.erase(root->val);
        dfs(root);
        if (!mp.empty()) return nullptr;
        if (!isValid(root, LONG_MIN, LONG_MAX))
            return nullptr;

        return root;
    }
};
