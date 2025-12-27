class Solution {
public:
    void myfunc(string &s, int &maxx, int mode){
        map<pair<int, int>, int> mp;
        mp[{0,0}] = -1;
        int ca= 0, cb = 0, cc = 0;
        for(int i = 0; i < s.size(); i++){
            if(s[i] == 'a') ca++;
            else if(s[i] == 'b') cb++;
            else cc++;

            int x = 0, y = 0;
            if(mode == 0){
                x = ca - cb;
                y = cb - cc;
            }
            else if(mode == 1){
                x = ca - cb;
                y = cc;
            }
            else if(mode == 2){
                x = ca - cc;
                y = cb;
            }
            else if(mode == 3){
                x = cb - cc;
                y = ca;
            }
            else if(mode == 4){
                x = cb;
                y = cc;
            }
            else if(mode == 5){
                x = ca;
                y = cc;
            }
            else if(mode == 6){
                x = ca;
                y = cb;
            }
            pair<int, int> p = {x,y};
            if(mp.count(p)){
                int len = i - mp[p];
                if(len > maxx) maxx = len;
            }
            else{
                mp[p] = i;
            }
        }
    }
    int longestBalanced(string s) {
        // a, b, c, ab, ac, bc, abc
        int maxx = 0;
        for(int i = 0; i <= 6; i++){
            myfunc(s, maxx, i);
        }
        return maxx;
    }
};