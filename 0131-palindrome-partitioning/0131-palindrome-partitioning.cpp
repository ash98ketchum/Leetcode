class Solution {
public:
    vector<vector<string>> res;

    bool isPalindrome(string s) {
        string t = s;
        reverse(t.begin(), t.end());
        return s == t;
    }

    void myrec(int idx, int n, string s, vector<string>& palindrome) {
        if (idx == n) {
            res.push_back(palindrome);
            return;
        }
        string temp = "";
        for (int i = idx; i < n; i++) {
            temp += s[i];
            if (isPalindrome(temp)) {
                palindrome.push_back(temp);
                myrec(i + 1, n, s, palindrome);
                palindrome.pop_back();
            }
        }
    }

    vector<vector<string>> partition(string s) {
        vector<string> palindrome;
        myrec(0, s.length(), s, palindrome);
        return res;
    }
};
