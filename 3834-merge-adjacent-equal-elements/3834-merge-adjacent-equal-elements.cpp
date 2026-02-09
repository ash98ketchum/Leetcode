class Solution {
public:
    vector<long long> mergeAdjacent(vector<int>& nums) {
        stack<long long> st;
        for(int i = 0; i < nums.size(); i++){
            if(!st.empty() && st.top() == nums[i]){
                while(!st.empty() && st.top() == nums[i]){
                    st.pop();
                    st.push(nums[i] * 2);
                }
            }
            else st.push(nums[i]);

        }
        vector<long long> ans;
        while(!st.empty()){
            ans.push_back(st.top());
            st.pop();
        }
        reverse(ans.begin(), ans.end());
        return ans;
    }
};