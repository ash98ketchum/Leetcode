class Solution {
public:
    int leastInterval(vector<char>& tasks, int n) {
        int m = tasks.size(); // total task
        map<char, int> mp;
        int cnt = 0; // cnt the max tasks
        int maxx = 0; // max freq
        for(auto it : tasks){
            mp[it]++;
            if(mp[it] > maxx){
                maxx = mp[it];
                cnt = 0;
            }
            if(mp[it] == maxx) cnt++;
        }

        // length of each gap
        int len = n - (cnt - 1);
        // need of elements in that gaps
        int need = (maxx - 1) * len;
        // how many elements i have in total
        int have = m - maxx*cnt;
        //idleness
        int idle = max(0, need - have);
        return m + idle;
    }
};