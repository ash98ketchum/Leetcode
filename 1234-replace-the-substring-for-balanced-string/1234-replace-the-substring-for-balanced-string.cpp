class Solution {
public:
    int balancedString(string s) {
        int n = s.size();
        int target = n / 4;
        
        map<char, int> count;
        for (char c : s) count[c]++;
        if (count['Q'] == target && count['W'] == target &&
            count['E'] == target && count['R'] == target) {
            return 0;
        }
        
        int ans = n;
        int start = 0;
        int end = 0;
        while(end < n){
            count[s[end]]--;
            while (start <= end && count['Q'] <= target && count['W'] <= target && count['E'] <= target && count['R'] <= target) {
                ans = min(ans, end - start + 1);
                count[s[start]]++;
                start++;
            }
            end++;
        }
        
        return ans;
    }
};
