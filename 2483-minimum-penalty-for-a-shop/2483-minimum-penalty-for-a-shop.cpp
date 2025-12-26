class Solution {
public:
    int bestClosingTime(string customers) {
        int cnt = 0;
        for(auto it: customers){
            if(it == 'Y') cnt++;
        }

        int ans = 0;
        int curr = cnt;
        for(int i = 0; i < customers.size(); i++){
            if(customers[i] == 'N'){
                cnt++;
            }else{
                cnt--;
            }
            if(cnt < curr){
                ans = i + 1;
                curr = cnt;
            }
        }
        return ans;
    }
};