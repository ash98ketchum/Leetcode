class Solution {
public:
    string pushDominoes(string dominoes) {
        int n = dominoes.size();
        vector<int> left(n, 0), right(n, 0);
        for(int i = n - 1; i >= 0; i--){
            if(dominoes[i] == 'L'){
                int val = 1e9;
                left[i] = val--;
                int j = i - 1;
                while(j >= 0 && dominoes[j] == '.'){
                    left[j--] = val--;
                }
            }
        }
        for(int i = 0; i < n; i++){
            if(dominoes[i] == 'R'){
                int val = 1e9;
                right[i] = val--;
                int j = i + 1;
                while(j < n && dominoes[j] == '.'){
                    right[j++] = val--;
                }
            }
        }

        string res = "";
        for(int i = 0; i < n; i++){
            int val = right[i] - left[i];
            if(val > 0) res += 'R';
            else if(val < 0) res += 'L';
            else res += '.';
        }

        return res;
    }
};
