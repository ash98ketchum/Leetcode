class Solution {
public:
    void myrec(vector<int>& candidates, int target, vector<vector<int>>& ans, vector<int>& combination, int start) {
        if (target == 0) {
            ans.push_back(combination);
            return;
        }
        
        for (int i = start; i < candidates.size(); i++) {
            if (candidates[i] > target) continue;
            
            combination.push_back(candidates[i]);
            myrec(candidates, target - candidates[i], ans, combination, i); 
            combination.pop_back(); 
        }
    }
    
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        vector<vector<int>> ans;
        vector<int> combination;
        sort(candidates.begin(), candidates.end());
        myrec(candidates, target, ans, combination, 0);
        return ans;
    }
};
