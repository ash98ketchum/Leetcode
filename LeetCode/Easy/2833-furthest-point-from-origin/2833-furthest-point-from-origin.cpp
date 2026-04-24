class Solution {
public:
    int furthestDistanceFromOrigin(string moves) {
        int dist = 0;
        int cnt = 0;
        for(auto it : moves){
            if(it == 'L') dist--;
            else if(it == 'R') dist++;
            else cnt++;
        }
        return cnt + abs(dist);
    }
};