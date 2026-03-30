class Solution {
public:
    bool checkStrings(string s1, string s2) {
        map<char, int> eve, odd;
        for(int i = 0; i < s1.size(); i++){
            if(i & 1){
                odd[s1[i]]++;
                odd[s2[i]]--;
            }
            else{
                eve[s1[i]]++;
                eve[s2[i]]--;
            }
            
        }
        for(auto it : odd) if(it.second != 0) return false;
        for(auto it : eve) if(it.second != 0) return false;
        return true;
    }
};