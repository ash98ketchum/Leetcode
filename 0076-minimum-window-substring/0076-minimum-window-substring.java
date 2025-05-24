class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) return "";

        int start = 0, end = 0, cnt = 0;
        int minLen = Integer.MAX_VALUE;

        HashMap<Character, Integer> mapT = new HashMap<>();
        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            mapT.put(ch, mapT.getOrDefault(ch, 0) + 1);
        }

        int required = mapT.size();

        while (end < s.length()) {
            char ch = s.charAt(end);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            if (mapT.containsKey(ch) && map.get(ch).intValue() == mapT.get(ch).intValue()) {
                cnt++;
            }
            while (start <= end && cnt == required) {
                if (end - start + 1 < minLen) {
                    minLen = end - start + 1;
                    result.setLength(0);
                    result.append(s.substring(start, end + 1));
                }

                char startChar = s.charAt(start);
                map.put(startChar, map.get(startChar) - 1);

                if (mapT.containsKey(startChar) && map.get(startChar) < mapT.get(startChar)) {
                    cnt--;
                }

                start++;
            }

            end++;
        }

        return result.toString();
    }
}
