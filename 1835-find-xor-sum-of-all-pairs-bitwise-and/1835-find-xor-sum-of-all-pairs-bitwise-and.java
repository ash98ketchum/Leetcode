class Solution {
    public int getXORSum(int[] arr1, int[] arr2) {
        int xor = 0;
        for(int it : arr1) xor ^= it;
        int ans = 0;
        for(int it : arr2){
            ans ^= (it & xor);
        }
        return ans;
    }
}