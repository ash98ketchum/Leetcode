class Solution {
public:
    vector<int> ans;
    void myrec(int k, int idx, int cnt, int temp){
        if(idx > 10) return;
        if(cnt == k){
            ans.push_back(temp);
            return;
        }

        myrec(k, idx + 1, cnt, temp);
        temp |= (1 << idx);
        myrec(k, idx + 1, cnt + 1, temp);
    }
    vector<string> readBinaryWatch(int turnedOn) {
        myrec(turnedOn, 0, 0, 0);
        vector<string> res;
        for(auto it : ans){
            int t = it;
            int hours = 0;
            int mins = 0;
            for(int i = 0; i < 6; i++) if((t >> i)&1) mins |= (1 << i);
            for(int i = 6; i < 10; i++) if((t >> i) & 1) hours |= (1 << (i - 6));
            if(mins >= 60 || hours >= 13) continue;
            string s = to_string(hours) + ":";
            if(mins < 10) s += "0";
            s += to_string(mins);
            res.push_back(s);
        }
        return res;

    }

};