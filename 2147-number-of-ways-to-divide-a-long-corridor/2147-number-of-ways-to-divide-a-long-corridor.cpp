class Solution {
public:
    static const int MOD = 1e9 + 7;

    int numberOfWays(string corridor) {
        vector<int> seats;
        for (int i = 0; i < corridor.size(); i++) {
            if (corridor[i] == 'S') seats.push_back(i);
        }

        int m = seats.size();
        if (m == 0 || m % 2 == 1) return 0;

        long long ans = 1;

        for (int i = 2; i < m; i += 2) {
            int plantsBetween = seats[i] - seats[i - 1] - 1;
            ans = (ans * (plantsBetween + 1)) % MOD;
        }

        return ans;
    }
};
