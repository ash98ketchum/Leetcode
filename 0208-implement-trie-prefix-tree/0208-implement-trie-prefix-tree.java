public class TrieNode{
    TrieNode list[] = new TrieNode[26];
    boolean flag = false;
    public TrieNode(){

    }
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
class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();

    }
    
    public void insert(String word) {
        TrieNode dummy = root;
        for(int i = 0; i < word.length(); i++){
            if(!dummy.containKey(word.charAt(i))){
                dummy.put(word.charAt(i), new TrieNode());
            }
            dummy = dummy.next(word.charAt(i));
        }
        dummy.end();
    }
    
    public boolean search(String word) {
        TrieNode dummy = root;
        for(int i = 0; i < word.length(); i++){
            if(!dummy.containKey(word.charAt(i))){
                return false;
            }
            dummy = dummy.next(word.charAt(i));
        }
        if(dummy.isend()){
            return true;
        }
        return false;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode dummy = root;
        for(int i = 0; i < prefix.length(); i++){
            if(!dummy.containKey(prefix.charAt(i))){
                return false;
            }
            dummy = dummy.next(prefix.charAt(i)); 
        }
        return true;
    }
}


/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */