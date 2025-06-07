class Solution {
   
    public int minPatches(int[] nums, int n) {
        // n = 6 - > 1 2 3 4 5 6 
        //greedically -> 1 sum exist 
        // target = 1 - > n 
        //check if that sum exist or not 
        // add kar dunga 
        // Input: nums = [1,3], n = 6
        // //1 exist 2 exist nhi 2 add kar dunga 
        // Input: nums = [1,2,4,5,10], n = 20
        
        // 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20
        // target -> 1
         //check target -> 2 exist nhi karta 
         // add 2
         // check 3 
         // add 4
         //output -> 2
        int cnt = 0;
        // ArrayList<Integer> temp = new ArrayList<>();
        // for(int i = 0; i < nums.length; i++){
        //     temp.add(nums[i]);
        // }
        long target = 1;
        int i = 0;
        while(target <= n){
            if(i < nums.length && nums[i] <= target){
                target += nums[i];
                i++;
            }
            else{
                target += target;
                cnt++;
            }
        }
        return cnt;
    }
}
// pretty little baby i m so in love with u
//sahi bolte h ladkiya padh jati h ladke pagal ho jate h