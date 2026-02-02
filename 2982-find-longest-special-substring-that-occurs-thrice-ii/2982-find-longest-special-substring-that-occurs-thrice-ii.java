class Solution {
    public boolean myfunc(int mid, String s, int n){
        int[] cnt = new int[26];
        int i = 0;
        while (i < n) {
            int j = i;
            while (j < n && s.charAt(j) == s.charAt(i)) {
                j++;
            }
            int len = j - i;
            if (len >= mid) {
                cnt[s.charAt(i) - 'a'] += (len - mid + 1);
                if (cnt[s.charAt(i) - 'a'] >= 3) {
                    return true;
                }
            }
            i = j;
        }
        return false;
    }
    public int maximumLength(String s) {
        int n = s.length();
        int start = 1;
        int end = n;
        int ans = -1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(myfunc(mid, s, n)){
                ans = mid;
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        return ans;
    }
}