class Solution {
    public boolean isVow(char ch){
        return ch == 'a' || ch == 'u' || ch == 'e' || ch == 'i' || ch =='o';
    }
    public String myfunc(String s){
        char ch[] = s.toLowerCase().toCharArray();
        for(int i = 0; i < ch.length; i++){
            if(isVow(ch[i])){
                ch[i] = '*';
            }
        }
        return new String(ch);
    }
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> set = new HashSet<>();
        HashMap<String, String> cons = new HashMap<>();
        HashMap<String, String> vow = new HashMap<>();
        
        for(int i = 0; i < wordlist.length; i++){
            set.add(wordlist[i]);
            cons.putIfAbsent(wordlist[i].toLowerCase(), wordlist[i]);
            vow.putIfAbsent(myfunc(wordlist[i]), wordlist[i]);
        }
        String[] res = new String[queries.length];
        for(int i = 0; i < queries.length; i++){
            String q = queries[i];
            // check if common
            if(set.contains(q)){
                res[i] = q;
                continue;
            }
            //lowercase
            String s1 = q.toLowerCase();
            if(cons.containsKey(s1)){
                res[i] = cons.get(s1);
                continue;
            }
            //vowel 
            String s2 = myfunc(q);
            if(vow.containsKey(s2)){
                res[i] = vow.get(s2);
                continue;
            }
            // else empty
            
            res[i] = "";
            
        }
        return res;
    }
}