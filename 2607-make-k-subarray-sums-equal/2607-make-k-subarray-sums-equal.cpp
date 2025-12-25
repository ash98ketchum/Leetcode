class Solution {
public:
    long long makeSubKSumEqual(vector<int>& arr, int k) {
        int n = arr.size();
        long long ans = 0;

        for (int i = 0; i < k; i++) {
            vector<int> group;
            for (int j = i; j < n; j += k) {
                group.push_back(arr[j]);
            }

            sort(group.begin(), group.end());

            int median = group[group.size() / 2];

            for (int x : group) {
                ans += abs(x - median);
            }
        }

        return ans;
    }
};
