class Solution {
public:
    int maxNumberOfFamilies(int n, vector<vector<int>>& reservedSeats) {
        map<int, set<int>> mp;
        for(auto it : reservedSeats){
            mp[it[0]].insert(it[1]);
        }
        int ans = (n - mp.size()) * 2;
        for(auto it : mp){
            bool l = true;
            bool r = true;
            bool m = true;
            for(auto s : it.second){
                if(s>=2 && s<=5) l = false;
                if(s>=4 && s<=7) m = false;
                if(s>=6 && s<=9) r = false;
            }
            if(l) ans++;
            if(r) ans++;
            if(!l && !r && m) ans++;
        }
        return ans;
    }
};