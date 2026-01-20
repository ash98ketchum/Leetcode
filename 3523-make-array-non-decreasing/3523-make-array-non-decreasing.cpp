class Solution {
public:
    int maximumPossibleSize(vector<int>& nums) {
        int ans = 0;
        int n = nums.size();
        stack<int> st;
        for(int i = 0; i < n; i++){
            if(st.empty()) st.push(nums[i]);
            else{
                if(nums[i] < st.top()){
                continue;
            }
            else{
                st.push(nums[i]);
            }}
            
        }
        return st.size();
    }
};