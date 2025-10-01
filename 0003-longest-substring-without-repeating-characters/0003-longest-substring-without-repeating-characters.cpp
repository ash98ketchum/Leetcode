class Solution {
public:
    int lengthOfLongestSubstring(string s) 
    {
        set<char>seen;
        int left=0;
        int maxLen=0;
        int n=s.length();
        for(int right=0;right<n;right++)
        {
            while(seen.count(s[right]))
            {
                seen.erase(s[left]);
                left++;
            }
            seen.insert(s[right]);
            maxLen=max(maxLen,right-left+1);
        }
        return maxLen;
    }
};