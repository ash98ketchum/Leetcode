class Solution{
public :
    bool isValidCode(const string& code) {
        if (code.empty()) return false;
        for (char c : code) {
            if (!isalnum(c) && c != '_') return false;
        }
        return true;
    }

    vector<string> validateCoupons(vector<string>& code, vector<string>&businessLine, vector<bool>& isActive) {
        set<string> validBusiness = {
            "electronics", "grocery", "pharmacy", "restaurant"
        };

        map<string, vector<string>> mp;

        int n = code.size();
        for (int i = 0; i < n; i++) {
            if (
                isActive[i] &&
                validBusiness.count(businessLine[i]) &&
                isValidCode(code[i])
            ) {
                mp[businessLine[i]].push_back(code[i]);
            }
        }

        vector<string> order = {
            "electronics", "grocery", "pharmacy", "restaurant"
        };

        vector<string> result;
        for (auto& b : order) {
            auto& v = mp[b];
            sort(v.begin(), v.end());
            result.insert(result.end(), v.begin(), v.end());
        }

        return result;
    }
};
