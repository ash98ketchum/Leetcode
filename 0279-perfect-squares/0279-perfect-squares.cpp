class Solution {
public:
    vector<vector<int>> dp;
    int myrec(int idx, int sum, vector<int> &sqs){
        if(idx == sqs.size()){
            if(sum == 0)return 0;
            else return 1e9;
        }
        if(dp[idx][sum] != -1) return dp[idx][sum];
        int take = 1e9;
        if(sum - sqs[idx] >= 0){
            take = 1 + myrec(idx, sum - sqs[idx], sqs);
        }
        int notake = myrec(idx + 1, sum, sqs);
        return dp[idx][sum] = min(take, notake);
    }
    int numSquares(int n) {
        dp.resize(101, vector<int>(n + 1, -1));
        vector<int>sqs;

        for(int i = 1; i <= 100; i++){
            sqs.push_back(i * i);
        }
        reverse(sqs.begin(), sqs.end());
        return myrec(0, n, sqs);

    }
};