class Solution {
public:
    vector<int> findOriginalArray(vector<int>& changed) {
        int n = changed.size();
        if (n % 2) return {};

        sort(changed.begin(), changed.end());

        map<int, int> freq;
        for (int x : changed) freq[x]++;

        vector<int> ans;

        for (int x : changed) {
            if (freq[x] == 0) continue;

            if (freq[2 * x] == 0) return {};

            freq[x]--;
            freq[2 * x]--;

            ans.push_back(x);
        }

        return ans;
    }
};
