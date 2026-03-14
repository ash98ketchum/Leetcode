class Solution {
private:
    void myrec(int n,string st,vector<string>&res){
        if(st.length()==n){
            res.push_back(st);
            return;
        }
        for(char ch='a';ch<='c';ch++){
            if(st.size()>0 && st.back()==ch){
                continue;
            }
            myrec(n,st+ch,res);
        }
    }
public:
    string getHappyString(int n, int k) {
        vector<string> res;
        myrec(n,"",res);
        if(res.size()<k) return "";
        sort(res.begin(),res.end());
        return res[k-1];
    }
};