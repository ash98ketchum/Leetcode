class Solution {
public:
    int minDeletionSize(vector<string>& strs) {
        int n = strs.size();
        int m = strs[0].size();

        vector<bool> sorted(n - 1, false);
        int cnt = 0;
        for(int i = 0; i < m; i++){
            bool flag = false;
            for(int j = 0; j < n - 1; j++){
                if(!sorted[j] && strs[j][i] > strs[j + 1][i]){
                    flag = true;
                    break;
                }
            }
            if(flag){
                cnt++;
            }
            else{
                for(int j = 0; j < n - 1; j++){
                    if(!sorted[j] && strs[j][i] < strs[j + 1][i]) sorted[j] = true;
                }
            }


        }
        return cnt;
    }
};