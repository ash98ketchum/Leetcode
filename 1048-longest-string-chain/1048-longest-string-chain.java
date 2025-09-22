class Solution {
    public int longestStrChain(String[] words) {
        Map<String, Integer> map = new HashMap<>();

        Arrays.sort(words, (a,b)-> Integer.compare(a.length(), b.length()));
        int ans = 1;
        for(int i= 0; i < words.length; i++){
            String curr = words[i];
            map.put(curr, 1);
            for(int j = 0; j < curr.length(); j++){
                // divyanshi -> 2 -> di + yanshi = > diyanshi
                String next = curr.substring(0, j) + curr.substring(j + 1, curr.length());
                if(map.containsKey(next)){
                    map.put(curr, Math.max(map.get(curr), map.get(next) + 1));
                }
            }
            ans = Math.max(ans, map.get(curr));
            
            
        }
        return ans;
    }
}