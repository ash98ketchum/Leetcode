class Solution {
public:
    int maxOperations(string s) {
        int cnt = 0;
        int ans = 0;
        bool flag = false;
        for(int i = 0; i < s.length(); i++){
            if(s[i] =='1'){
                cnt++;
                flag = true;
            }
            else{
                if(flag){
                    ans += cnt;
                    flag = false;
                }
            }
        }
        return ans;
    }
};