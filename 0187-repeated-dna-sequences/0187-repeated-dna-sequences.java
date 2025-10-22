class Solution {
    private int encode(char ch){
        if(ch == 'A') return 0;
        else if(ch == 'C') return 1;
        else if(ch == 'G') return 2;
        else return 3;
    }
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> repeatedSequences = new HashSet<>(); 
        
        Set<Integer> st = new HashSet<>();
        if(s.length() <= 10) {
            return new ArrayList<>(); 
        }

        int hash = 0;
        int mask = (1 << 20) - 1;
        for(int i = 0; i < 10; i++){
            hash = (hash << 2) | encode(s.charAt(i));
        }
        st.add(hash);

        for(int i = 10; i < s.length(); i++){
            hash = ((hash << 2) | encode(s.charAt(i))) & mask;
            
            if(st.contains(hash)){
                repeatedSequences.add(s.substring(i - 9, i + 1));
            }
            else {
                st.add(hash);
            }
        }
    
        return new ArrayList<>(repeatedSequences);
    }
}