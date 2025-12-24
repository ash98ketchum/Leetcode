class Solution {
public:
    int findMinimumOperations(string s1, string s2, string s3) {
        int cnt = 0;
        for(int i = 0; i < min({s1.size(), s2.size(), s3.size()}); i++){
            if(s1[i] == s2[i] && s2[i] == s3[i]){
                cnt += 3;
            }
            else{
                break;
            }
        }
        if(cnt == 0) return -1;
        return s1.size() + s2.size() + s3.size() - cnt;

    }
};