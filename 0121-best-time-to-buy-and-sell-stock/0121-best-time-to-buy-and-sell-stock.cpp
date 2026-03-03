class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int minn = INT_MAX;
        int profit = 0;
        for(int it : prices){
            if(it < minn) minn = it;
            profit = max(profit, it - minn);
        }
        return profit;
    }
};