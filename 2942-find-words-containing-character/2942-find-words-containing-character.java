class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> res = new ArrayList<>();
        int i = 0;
        for(String st : words){
            if (st.contains(String.valueOf(x))){
                res.add(i);
            }
            i++;
        }
        return res;
    }
}