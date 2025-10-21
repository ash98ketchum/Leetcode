class Solution {
public:
    int maxFrequency(vector<int>& nums, int k, int numOperations) {
        const int MAX = 2000005;
        vector<int> range(MAX, 0);
        map<int,int> cnt;

        for (int x : nums) {
            cnt[x]++;
            int l = max(0, x - k);
            int r = min(MAX - 1, x + k + 1);
            range[l]++;
            range[r]--;
        }

        for (int i = 1; i < MAX; i++)
            range[i] += range[i - 1];

        int ans = 1;
        for (int i = 0; i < MAX; i++) {
            if (range[i] == 0) continue;
            int already = cnt.count(i) ? cnt[i] : 0;
            int total = range[i];
            int freq = already + min(numOperations, total - already);
            ans = max(ans, freq);
        }
        return ans;
    }
};
