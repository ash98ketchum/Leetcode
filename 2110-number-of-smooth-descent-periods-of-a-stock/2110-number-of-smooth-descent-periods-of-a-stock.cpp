class Solution {
public:
    long long getDescentPeriods(vector<int>& prices) {
        int n = prices.size();
        long long ans = n;
        int cnt = 0;
        for(int i = 1; i < n; i++){
            if(prices[i - 1] - prices[i] == 1){
                cnt++;
                ans += cnt;
            }
            else{
                cnt = 0;
            }
        }
        return ans;
    }
};