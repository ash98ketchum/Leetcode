class Solution {
public:
    TreeNode* reverseOddLevels(TreeNode* root) {
        if (!root) return root;
        deque<TreeNode*> dq;
        dq.push_back(root);
        int level = 0;
        while (!dq.empty()) {
            int sz = dq.size();
            vector<TreeNode*> nodes;
            for (int i = 0; i < sz; i++) {
                TreeNode* node = dq.front();
                dq.pop_front();
                nodes.push_back(node);
                if(node->left) dq.push_back(node->left);
                if(node->right) dq.push_back(node->right);
            }
            if(level % 2 == 1) {
                int i = 0, j = nodes.size() - 1;
                while (i < j) {
                    swap(nodes[i]->val, nodes[j]->val);
                    i++;
                    j--;
                }
            }
            level++;
        }
        return root;
    }
};
