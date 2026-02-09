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
    vector<int> vals;
    void inorder(TreeNode* root){
        if(root == NULL) return;

        inorder(root->left);
        vals.push_back(root->val);
        inorder(root->right);
    }
    TreeNode* BST(vector<int>& arr, int start, int end) {
        if(start > end) return nullptr;

        int mid = start + (end - start) / 2;
        TreeNode* root = new TreeNode(arr[mid]);

        root->left = BST(arr, start, mid - 1);
        root->right = BST(arr, mid + 1, end);

        return root;
    }
    TreeNode* balanceBST(TreeNode* root) {
        inorder(root);
        return BST(vals, 0, vals.size() - 1);

    }
};