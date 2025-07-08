class Solution {
    class tuple{
        String s;
        int len;
        tuple(String s, int len){
            this.s = s;
            this.len = len;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {  
        HashSet<String> set = new HashSet<>(wordList);
        Queue<tuple> q = new LinkedList<>();
        q.offer(new tuple(beginWord, 1));
        while(!q.isEmpty()){
            String newStr = q.peek().s;
            int newLen = q.peek().len;
            q.poll();
            if(newStr.equals(endWord)){
                return newLen;
            }
            
            for(int i = 0; i < newStr.length(); i++){
                for(char ch = 'a'; ch <= 'z'; ch++){
                    //hot -> aot bot cot.....hot
                    char[] temp = newStr.toCharArray();
                    temp[i] = ch;
                    String temp2 = new String(temp);
                    if(set.contains(temp2) && temp2 != newStr){
                        q.offer(new tuple(temp2, newLen+1));
                        set.remove(temp2);
                    }
                }
            }
        }
        return 0;
    }
}