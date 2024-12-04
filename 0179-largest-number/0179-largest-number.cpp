class Solution {
public:
    string largestNumber(vector<int>& nums) {
        int n=nums.size();
        std::vector<std::string> numStrs;
        for (int num : nums) {
            numStrs.push_back(std::to_string(num));
        }
        int i=0;
        while(i<n){
            int j=i+1;
            while(j<n){
                string ab=numStrs[i]+numStrs[j];
                string ba=numStrs[j]+numStrs[i];
                if(ba>ab){
                    swap(numStrs[i],numStrs[j]);
                }
                j++;
            }
            i++;
        }
        if (numStrs[0] == "0") {
            return "0";
        }
        string res="";
        for(auto i:numStrs){
            res+=i;
        }
        return res;

    }
};