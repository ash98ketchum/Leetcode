class Solution {
    public boolean doesAliceWin(String s) {
        int cnt = 0;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' ||ch == 'u'){
                cnt++;
            }
        }
        if(cnt > 0) return true;
        return false;
    }
}