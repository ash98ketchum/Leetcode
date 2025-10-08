class Solution {
public:
    int bs(vector<int> &potions, int m, int mul, long success){
        int start = 0;
        int end = m - 1;
        int ans = -1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if((long)potions[mid] * mul >= success){
                ans = mid;
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        return ans;
    }
    vector<int> successfulPairs(vector<int>& spells, vector<int>& potions, long long success) {
        int n = spells.size();
        int m = potions.size();
        vector<int> ans(n);
        sort(potions.begin(), potions.end());
        for(int i = 0 ; i < n; i++){
            int x = bs(potions, m, spells[i], success);
            ans[i] = x == -1 ? 0 : m - x;
        }
        return ans;
    }
};