class Solution {
public:
    bool isPerfectSquare(int num) 
    {
        int low = 0, high = num;
        while(low <= high)
        {
            long long mid = low + (high - low)/2;
            long long sqrt = (mid*mid);

            if(sqrt == num) return true;
            if(sqrt < num){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return false;
    }
};