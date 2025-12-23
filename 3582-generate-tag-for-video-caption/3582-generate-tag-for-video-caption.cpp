class Solution {
public:
    string generateTag(string caption) {
        string ans = "#";
        bool capitalize = false;

        for (int i = 0; i < caption.size() && ans.size() < 100; i++) {
            if (isalpha(caption[i])) {
                if (ans.size() == 1) {
                    ans += tolower(caption[i]);
                } 
                else if (capitalize) {
                    ans += toupper(caption[i]);
                    capitalize = false;
                } 
                else {
                    ans += tolower(caption[i]);
                }
            } 
            else if (caption[i] == ' ') {
                capitalize = true;
            }
        }

        return ans;
    }
};
