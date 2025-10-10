class Solution {
public:
    int maximumEnergy(vector<int>& energy, int k) {
        int n = energy.size();
        int res = -1e9;
        for(int i = k; i < n; i++) energy[i] = max(energy[i] + energy[i - k], energy[i]);
        for(int i = n - k; i < n; i++) res = max(res, energy[i]);
        return res;
    }
};