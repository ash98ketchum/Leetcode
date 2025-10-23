class Solution {
public:
    string removeKdigits(string num, int k) {
        string st;
        for(auto ch : num){
            while(!st.empty() && k && st.back() > ch){
                st.pop_back();
                k--;
            }
            st.push_back(ch);
        }

        while(k--){
            st.pop_back();
        }
        int i = 0;
        while(st.size() > i && st[i] == '0') i++;
        return st.substr(i) == "" ? "0" : st.substr(i);
    }
};