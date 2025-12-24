class Solution {
public:
    bool closeStrings(string word1, string word2) {
        if(word1.size() != word2.size()) return false;

        map<char,int> mp1, mp2;

        for(char c : word1) mp1[c]++;
        for(char c : word2) mp2[c]++;
        for(auto &p : mp1) {
            if(mp2.find(p.first) == mp2.end()) return false;
        }
        map<int,int> freq1, freq2;
        for (auto &p : mp1) freq1[p.second]++;
        for (auto &p : mp2) freq2[p.second]++;

        return freq1 == freq2;
    }
};
