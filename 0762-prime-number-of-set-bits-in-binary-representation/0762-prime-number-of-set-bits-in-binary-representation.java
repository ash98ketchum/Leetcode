class Solution {
    public int countPrimeSetBits(int left, int right) {
        Set<Integer> primeSet = Set.of(2, 3, 5, 7, 11, 13, 17, 19);
        
        int count = 0;
        
        for (int num = left; num <= right; num++) {
            int setBits = Integer.bitCount(num);
            if (primeSet.contains(setBits)) {
                count++;
            }
        }
        
        return count;
    }
}