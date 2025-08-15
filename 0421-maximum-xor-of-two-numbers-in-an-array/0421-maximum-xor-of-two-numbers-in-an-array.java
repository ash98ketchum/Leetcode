class TrieNode{
    TrieNode list[] = new TrieNode[2];
    public boolean contains(char ch){
        return list[ch-'0'] != null;
    }
    public void put (char ch, TrieNode node){
         list[ch-'0'] = node;
    }
    public TrieNode next(char ch){
        return list[ch-'0'];
    }
}
class Solution {
    class Trie{
        TrieNode root;
        int L;
        Trie(){
            root = new TrieNode();
            L = 31;
            //max number of bits kitni ho sakti h 
            
        }

        private String pad(String s){
            StringBuilder sb = new StringBuilder();
            for (int k = s.length(); k < L; k++) sb.append('0');
            sb.append(s);
            return sb.toString();
        }

        public void insert(String word){
            word = pad(word);
            TrieNode dummy = root;
            for(int i = 0; i < word.length(); i++){
                if(!dummy.contains(word.charAt(i))){
                    dummy.put(word.charAt(i), new TrieNode());
                }
                dummy = dummy.next(word.charAt(i));
            }
        }

        public int getXor(int n){
            String binary = pad(Integer.toBinaryString(n));
            //padding becuz inbuilt function sirf string ki length tk karta h 32 bit mei nhi karta isiliye starting me 0 add karne padenge 
            TrieNode dummy = root;
            ArrayList<Character> res = new ArrayList<>();
            for(int i = 0; i < binary.length() && dummy != null; i++){
                char ch = binary.charAt(i);
                char need = (ch == '0') ? '1' : '0';
                if(dummy.contains(need)){
                    dummy = dummy.next(need);
                    res.add('1');  // XOR bit
                } else {
                    res.add('0');  // XOR bit
                    dummy = dummy.next(ch);
                }
            }
            while(res.size() < binary.length()) res.add('0');
            int ans = 0;
            for(int i = 0; i < res.size(); i++){
                ans = (ans << 1) | (res.get(i) == '1' ? 1 : 0);
            }
            return ans;
        }
    }

    public int findMaximumXOR(int[] nums) {
        Trie t = new Trie();
        for(int i = 0; i < nums.length; i++){
            String binary = Integer.toBinaryString(nums[i]);
            t.insert(binary);
        }
        int max = 0;
        for(int it: nums){
            int val = t.getXor(it);
            if(val > max){
                max = val;
            }
        }
        return max;
    }
}
