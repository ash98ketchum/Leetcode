class Solution {
public:
    int maxBalancedShipments(vector<int>& weight) {
        stack<int> st;
        int maxx = -1;
        int ans = 0;
        int n = weight.size();
        for(int i = 0; i < n; i++){
            if(st.empty()){
                st.push(weight[i]);
                maxx = max(maxx, weight[i]);
            }
            else{
                if(weight[i] < maxx){
                    ans++;
                    st= stack<int>(); 
                    maxx = -1;
                }
                else{
                    st.push(weight[i]);
                     maxx = max(maxx, weight[i]);
                }
            }
        }
        return ans;
    }
};