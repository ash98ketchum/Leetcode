class Solution {
public:
    bool checkch(char ch){
        return ch >= 'a' && ch <= 'z';
    }

    vector<int> countWordOccurrences(vector<string>& chunks, vector<string>& queries) {
        
        map<string, int> mp;

        string s = "";
        for(auto it : chunks) s += it;

        int n = s.size();

        string word = "";
        int i = 0;

        while(i < n){

            if(checkch(s[i])){
                word += s[i];
            }

            else if(s[i] == '-'){

                if(i > 0 && i < n - 1 && checkch(s[i - 1]) && checkch(s[i + 1])){
                    word += s[i];
                }
                else{
                    if(word != ""){
                        mp[word]++;
                        word = "";
                    }
                }
            }

            else{
                if(word != ""){
                    mp[word]++;
                    word = "";
                }
            }

            i++;
        }

        if(word != "") mp[word]++;

        int q = queries.size();
        vector<int> ans(q);

        while(q--){
            if(mp.find(queries[q]) == mp.end()) ans[q] = 0;
            else ans[q] = mp[queries[q]];
        }

        return ans;
    }
};