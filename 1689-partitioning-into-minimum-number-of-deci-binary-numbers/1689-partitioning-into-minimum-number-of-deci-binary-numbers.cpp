class Solution {
public:
    int minPartitions(string n) {
        int cnt = 0;
        for(auto it : n) cnt = max(cnt, it - '0');
        return cnt;
    }
};