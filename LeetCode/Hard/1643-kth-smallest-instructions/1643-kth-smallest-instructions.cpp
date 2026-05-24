class Solution {
public:
    long long ncr(int n, int r){
        if(r < 0 || r > n) return 0;
        if(r == 0 || r == n) return 1;
        if(r > n/2) r = n - r;

        long long ans = 1;
        for(int i = 1; i <= r; i++){
            ans = ans * (n - i + 1)/i;
        }
        return ans;
    }
    string kthSmallestPath(vector<int>& destination, int k) {
        int v = destination[0];
        int h = destination[1];

        int totlen = v + h;
        string res = "";
        for(int i = 0; i < totlen; i++){
            if(h > 0){
                long long comb = ncr(v + h - 1, v);
                if(k <= comb){
                    res += 'H';
                    h--;
                }
                else{
                    res += 'V';
                    v--;
                    k -= comb;
                }
            }else{
                res += 'V';
                v--;
            }
        }
        return res;
    }
};