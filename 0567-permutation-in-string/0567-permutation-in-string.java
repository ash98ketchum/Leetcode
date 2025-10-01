class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length()>s2.length()){
            return false;
        }
        HashMap<Character,Integer> mp= new HashMap<>();
        HashMap<Character, Integer> mp2= new HashMap<>();
        int l=s1.length();
        for (char c : s1.toCharArray()) {
            mp.put(c, mp.getOrDefault(c, 0) + 1);
        }
        for(int i=0;i<s2.length();i++){
            char c = s2.charAt(i);
            mp2.put(c, mp2.getOrDefault(c, 0) + 1);
            if(i>=l){
                char c2=s2.charAt(i-l);
                if(mp2.get(c2)==1){
                    mp2.remove(c2);
                }
                else{
                    mp2.put(c2,mp2.get(c2) - 1);
                }

            }
            if(mp.equals(mp2)) {
                return true;
            }
        }
        return false;
    }
}