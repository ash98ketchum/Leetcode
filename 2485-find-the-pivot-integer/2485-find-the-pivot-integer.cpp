class Solution {
public:
    int pivotInteger(int n) {
        int ans = -1;
        int tot = (n * (n + 1))/2;
        for(int i = 1; i <= n; i++){
            int s1 = (i * (i - 1))/2;
            int s2 = (i * (i + 1))/2;
            if(tot - s2 == s1){
                ans = i;
                break;
            }
        }
        return ans;
    }
};