class Solution {
public:
    int minDeletions(string s) {
        vector<int> freq(26, 0); // contains the freq
        for(auto it : s) freq[it - 'a']++;
        //sort in non increasing order

        sort(freq.begin(), freq.end(), greater<int>());

        int cnt = 0;
        int maxx = freq[0];

        //iterate over the map
        for(int i = 0; i < 26; i++){
            if(freq[i] == 0) break;
            if(freq[i] > maxx){
                cnt += (freq[i] - maxx);
                freq[i] = maxx;
            }
            maxx = max(0, freq[i] - 1);

        }
        return cnt;
    }
};