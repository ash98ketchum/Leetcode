class Solution {
public:
    vector<vector<int>> generate(int numRows) {
        vector<vector<int>> ans;
        ans.push_back({1});
        numRows--;
        int cnt = 0;
        while(numRows--){
            vector<int> temp;
            temp.push_back(1);
            for(int i = 0; i < cnt; i++){
                temp.push_back(ans.back()[i] + ans.back()[i + 1]);
            }
            temp.push_back(1);
            ans.push_back(temp);
            cnt++;
        }
        return ans;
    }
};