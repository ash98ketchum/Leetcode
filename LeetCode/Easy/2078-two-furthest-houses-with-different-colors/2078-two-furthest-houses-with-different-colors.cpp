class Solution {
public:
    int maxDistance(vector<int>& colors) {
        int n = colors.size();
        int j = n;
        for(int i = 0; i < j; i++){
            if((colors[i] != colors[n - 1]) || (colors[j - i - 1] != colors[0])){
                return j - i - 1;
            }
        }
        return 0;
    }
};