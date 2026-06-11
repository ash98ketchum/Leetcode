class Solution {
public:
    int dp[105][105][105];
    int myrec(int i, int j, int k, vector<int>&boxes){
        
        if(i > j) return 0;
        
        if(dp[i][j][k] != -1) return dp[i][j][k];
        
        int a = k;
        int b = j;
        while(i < j && boxes[j - 1] == boxes[j]){
            k++;
            j--;
        }
        
        int burst = (k + 1) * (k + 1) + myrec(i, j - 1, 0, boxes);
        
        //wait
        int wait = 0;
        for(int x = i; x < j; x++){
            if(boxes[x] == boxes[j]){
                wait = max(wait, myrec(i, x, k + 1, boxes) + myrec(x + 1, j - 1, 0, boxes));
            }
        }
        return dp[i][b][a] = max(burst, wait);
    }
    int removeBoxes(vector<int>& boxes) {
        int n = boxes.size();
        memset(dp, -1, sizeof(dp));
        return myrec(0, n - 1, 0, boxes);
    }
};