class Solution {
public:
    long long calculateScore(string s) {
        vector<vector<int>> ind(26);
        long long ans = 0;
        for(int i = 0; i < s.size(); i++){
            int ch = s[i] - 'a';
            int next = 25 - ch;
            if(ind[next].size() > 0){
                int idx = ind[next].back();
                ind[next].pop_back();
                ans += (i - idx);
            }
            else{
                ind[ch].push_back(i);
            }
        }
        return ans;
    }
};