class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int xor = 0;
        for (int it:derived) xor^=it;
        return xor==0;
    }
}