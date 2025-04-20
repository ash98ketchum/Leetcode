class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int ans : answers) {
            map.put(ans, map.getOrDefault(ans, 0) + 1);
        }

        int res = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int x = entry.getKey(), count = entry.getValue();
            int groups = (count + x) / (x + 1);
            res += groups * (x + 1);
        }

        return res;
    
    }
}