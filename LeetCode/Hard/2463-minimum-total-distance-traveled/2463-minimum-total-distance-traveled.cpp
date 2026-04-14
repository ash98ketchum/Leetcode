class Solution {
public:
    long long minimumTotalDistance(vector<int>& robot,vector<vector<int>>& factory) {
        sort(robot.begin(), robot.end());
        sort(factory.begin(), factory.end());

        vector<int> fact;
        for (auto& f : factory) for (int i = 0; i < f[1]; i++) fact.push_back(f[0]);

        int n = robot.size(), m = fact.size();
        vector<vector<long long>> dp(n,vector<long long>(m, -1));
        return myrec(0, 0, robot, fact, dp);
    }

    long long myrec(int i, int j,vector<int>& robot, vector<int>& fact,vector<vector<long long>>& dp) {
        if (i == robot.size()) return 0;
        if (j == fact.size()) return 1e12;
        if (dp[i][j] != -1) return dp[i][j];

        long long take = abs(robot[i] - fact[j]) + myrec(i + 1, j + 1,robot, fact,dp);
        long long skip = myrec(i, j + 1,robot, fact, dp);

        return dp[i][j] = min(take, skip);
    }
};