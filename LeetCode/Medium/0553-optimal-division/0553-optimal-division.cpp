class Solution {
public:
    // int rec(){
        
    // }
    
    // A / (b/ c/d/e)...
    
    string optimalDivision(vector<int>& nums) {

        string str="";
        int n=nums.size();
        if(n == 1) return to_string(nums[0]);
        if(n == 2) return to_string(nums[0]) + "/" + to_string(nums[1]);
        str += to_string(nums[0]) + "/";
        str +="(";
        for(int i=1;i<n;i++){
            string ele = to_string(nums[i]);
            str += ele;
            if(i < n - 1) str += "/";
        }
        str += ")";
        return str;
        // A/(B/C/D/E....)
    }
};