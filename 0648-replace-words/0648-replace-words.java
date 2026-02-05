class TrieNode{
    TrieNode list[] = new TrieNode[26];
    boolean flag = false;
    public TrieNode(){}
    boolean containKey(char ch){
        return list[ch - 'a'] != null;
    }
    void put(char ch, TrieNode node){
        list[ch - 'a'] = node;
    }
    TrieNode next(char ch){
        return list[ch - 'a'];
    }
    void end(){
        flag = true;
    }
    boolean isend(){
        return flag;
    }
}
class Trie{
    TrieNode root;
    Trie(){
        root = new TrieNode();
    }

    public void insert(String word){
        TrieNode dummy = root;
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            if(!dummy.containKey(ch)){
                dummy.put(ch, new TrieNode());
            }
            dummy = dummy.next(ch);
        }
        dummy.end();
    }

    public String search(String word){
        TrieNode dummy = root;
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            if(!dummy.containKey(ch)){
                return "";
            }
            dummy = dummy.next(ch);
            ans.append(ch);
            if(dummy.isend()){
                return ans.toString();
            }
        }
        return "";
    }
}
class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        String arr[] = sentence.split(" ");
        String ans = "";
        Trie trie = new Trie();
        for(String s : dictionary){
            trie.insert(s);
        }

        for(int i = 0; i < arr.length; i++){
            String check = trie.search(arr[i]);
            if(check == ""){
                ans += arr[i];
            }
            else ans += check;
            if(i != arr.length - 1) ans += ' ';
        }
        return ans;
    }
}