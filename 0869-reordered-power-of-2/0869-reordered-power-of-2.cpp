class Solution {
public:
    bool reorderedPowerOf2(int n) {
        set<string> st;
        st.insert("1");
        long long x = 1;
        for(int i = 1;i < 32; i++){
            x *= 2;
            string s = to_string(x);
            sort(s.begin(), s.end());
            st.insert(s);
        }

        string n2 = to_string(n);
        sort(n2.begin(), n2.end());
        if(st.find(n2) != st.end()){
            return true;
        }
        return false;
    }
};