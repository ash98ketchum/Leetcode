class Solution {
private:
    int bs(vector<int>& nums, int target, bool flag) {
        int start = 0, end = nums.size() - 1;
        int ans = -1;
        
        while (start <= end) {
            int mid = start + (end - start) / 2;
            
            if (nums[mid] == target) {
                ans = mid; 
                if (flag) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            else if (nums[mid] < target) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        return ans;
    }
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        int f = bs(nums, target, true);
        int l = bs(nums, target, false);
        vector<int> v;
        v.push_back(f);
        v.push_back(l);
        return v;
        
    }
};