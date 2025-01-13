class Solution {
    public int minimumLength(String s) {
        int freq[]=new int[26];
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)-'a']++;
        }
        int cnt=0;
        for(int i=0;i<26;i++){
            if(freq[i]>=3){
                if(freq[i]%2==0) cnt+=2;
                else cnt+=1;
            }
            else cnt+=freq[i];
        }
        return cnt;
    }
}