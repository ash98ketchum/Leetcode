class Solution {
    public String triangleType(int[] nums) {
        int a = nums[0], b = nums[1], c = nums[2];
        if(a == b && b == c){
            return "equilateral";
        }
        else if(a == b || b == c || a == c){
            if(a + b > c && a + c > b && b + c > a) return "isosceles";
            else{
                return "none";
            }
        }
        else{
            if(a + b > c && a + c > b && b + c > a){
                return "scalene";
            }
            else{
                return "none";
            }
        }
    }
}