class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        int n = strs.length;

        for(int i = 0; i < n; i++){
            int[] freq = new int[26];
            for(int j = 0; j < strs[i].length(); j++){
                freq[strs[i].charAt(j) - 'a']++;
            }
            String key = Arrays.toString(freq);
            if(!map.containsKey(key)){
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(key, list);
            }
            else{
                map.get(key).add(strs[i]);
            }
        }
        return new ArrayList<>(map.values());
    }
}